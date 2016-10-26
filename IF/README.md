<link rel="shortcut icon" type="image/png" href="images/favicon.png">
# [![SUPERSEDE](../images/SUPERSEDE-logo.png)](https://www.supersede.eu/) project: Integration Framework (IF)
This repository contains code, artefacts, configuration, and so on, developed in SUPERSEDE WP5, that provides the backend integration framework for the SUPERSEDE platform.

See deliverables D5.5 in [Supersede Portal](https://www.supersede.eu/) for more details about this framework, including its functional description, its architecture and its components.

Repository Structure:
- IF/API: It provides an IF Client API, enabling Java client components to send messages to other components of the platform.
- IF/ESB: It provides the configuration of the IF middleware, based on the [WSO2 Suite](http://wso2.com/), which mediates, routes and dispatches incoming messages to remote service endpoints
- IF/PoC: It provides some proof-of-concepts on the usage of message delivery technology, based on [Spring IO Framework](http://projects.spring.io/spring-framework/) and [Spring IO Boot](http://projects.spring.io/spring-boot/) technologies.

SUPERSEDE Integration Framework is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

*Please check the respective README.md for details.*

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>

<center>![Project funded by the European Union](../images/european.union.logo.png)</center>
