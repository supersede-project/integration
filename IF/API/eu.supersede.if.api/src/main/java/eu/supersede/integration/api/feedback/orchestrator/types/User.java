package eu.supersede.integration.api.feedback.orchestrator.types;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import ch.uzh.ifi.feedback.library.rest.validation.Unique;

//@Serialize(UserSerializationService.class)
public class User extends OrchestratorItem<User>{

	@Id
	@DbAttribute("users_id")
	private Integer id;
	
	@Unique
	@NotNull
	private String name;
	
	@DbAttribute("user_groups_id")
	private int groupId;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
