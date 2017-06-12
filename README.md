<link rel="shortcut icon" type="image/png" href="images/favicon.png">
# [![SUPERSEDE](./images/SUPERSEDE-logo.png?raw=true)](https://www.supersede.eu/) project: Integration Framework (IF)
This repository contains code, artefacts, configuration, and so on, developed in SUPERSEDE WP5, that provides the backend integration framework for the SUPERSEDE platform.

See deliverable D5.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, including its functional description, its architecture and its components.

Repository Structure:
- IF/API: It provides an IF Client API, enabling Java client components to send messages to other components of the platform.
- IF/ESB: It provides the configuration of the IF middleware, based on the [WSO2 Suite](http://wso2.com/), which mediates, routes and dispatches incoming messages to remote service endpoints
- IF/PoC: It provides some proof-of-concepts on the usage of message delivery technology, based on [Spring IO Framework](http://projects.spring.io/spring-framework/) and [Spring IO Boot](http://projects.spring.io/spring-boot/) technologies.

SUPERSEDE Integration Framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*
In particular, see [IF Client README.md](https://github.com/supersede-project/integration/blob/master/IF/API/eu.supersede.if.api/README.md) for datails on the configuration and usage of the IF Client API library to send messages to the backend components of the SUPERSEDE Platform

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>

<center>![Project funded by the European Union](https://www.supersede.eu/wp-content/uploads/2015/07/cropped-SupersedeLogo_outline.png)</center>
