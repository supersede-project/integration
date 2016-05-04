Supersede IF Client test project
--------------------------------

1- Obtain this project by cloning Supersede integration repository
git clone https://github.com/supersede-project/integration.git
This creates a directory into your filesystem, hereafter referenced as INTEGRATION_HOME
2- Install Gradle in your system
3- Go to $INTEGRATION_HOME/IF/API/eu.supersede.if.api.test
4- Execute: gradle eclipse
5- Launch Eclipse, import eu.supersede.if.api.test project as Gradle project: File/Import/Gradle/Gradle project
6- Execute Test cases in src/test/java/eu.supersede.integration.api.security.test.IFAuthenticationManagerTest.
Follow this order: addUserTest, getUserTest, addRoleTest, getAllRolesForUser, getAllUsersForRole, updateUserTest,
updateRoleTest, deleteRoleTest, deleteUserTest, getAuthorizationTokenTest, authenticateUserTest

