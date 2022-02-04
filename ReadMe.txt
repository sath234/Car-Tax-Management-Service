######### READ ME #########

Please load the sql dump file and restore the database to the your own PgAdmin

Then change the variables in the spring boot application.properties folder within the java file to your username and password.

Run the keycloak server locally on port 8090 and then take the import the realm from the import file within the import folder. Then create the basic user and admin user and assiggn the admin user with the user and admin roles and basic user with the basic user role. 

To run the docker compose file just cd into the docker folder within your terminal and type docker compose up and you'll have the containers for spring and key cloak running however you will not be able to make requests as there is an issue with the authentication token. Therefore to test request I suggest running it locally and not with the docker file.