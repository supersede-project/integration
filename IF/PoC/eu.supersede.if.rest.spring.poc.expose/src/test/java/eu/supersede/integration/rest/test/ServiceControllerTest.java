package eu.supersede.integration.rest.test;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import eu.supersede.integration.rest.Application;
import eu.supersede.integration.rest.service.type.Operation;
import eu.supersede.integration.rest.service.type.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ServiceControllerTest {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    
    
    @Test
    public void testServiceController() throws Exception{
    	String uuid = addService();
    	listServices(1, uuid);
    	getService(uuid);
    	addOperation(uuid);
    	deleteService(uuid);
    	listServices(0, null);
    }
    
    private String addService() throws Exception {
    	Service service = new Service();
    	service.setUri(new URI("http://localhost/supersede/services/dm/dynamicAdaptation"));
    	service.setName("DynamicAdaptationDM");
    	service.setDescription("Dynamic Adaptation Decision Making support");
    	service.setAvailable(true);
        MvcResult result = mockMvc.perform(post("/services/")
                .content(this.json(service))
                .contentType(contentType))
                .andExpect(status().isCreated()).andReturn();
        String uuid = result.getResponse().getContentAsString().replace("\"", ""); //remove surrounding quotes returned in content
        return uuid;
    }
    
    
    private void getService(String uuid) throws Exception {
        mockMvc.perform(get("/services/" + uuid + "/"))
                .andExpect(status().isFound())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.uuid", is (uuid)));
    }
    
    private void deleteService(String uuid) throws Exception {
        mockMvc.perform(delete("/services/" + uuid + "/"))
                .andExpect(status().isAccepted());
    }
    
    private void listServices(int size, String uuid) throws Exception {
    	ResultActions ra = mockMvc.perform(get("/services/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(size)));
        if (uuid != null)
                ra.andExpect(jsonPath("$[0].uuid", is(uuid)));
    }
    
    private String addOperation(String uuid) throws Exception {
    	Operation operation = new Operation();
    	operation.setName("computeDynamicAdaptationActions");
    	operation.setReturnType("Collection<DAAction>");
        MvcResult result = mockMvc.perform(post("/services/" + uuid + "/operations/")
                .content(this.json(operation))
                .contentType(contentType))
                .andExpect(status().isCreated()).andReturn();
        String opUuid = result.getResponse().getContentAsString().replace("\"", ""); //remove surrounding quotes returned in content
        return opUuid;
    }
    
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
