01. Database
    1. Run the below docker command to up the database
    2. docker compose -f Docker-compose-db.yaml up -d
    3. Connect to the database using IntelliJ Idea or PgAdmin (localhost:8888)
    4. db-username = postgres
    5. db-password = password
    6. pgadmin-username=postgres@domain.com
    7. pgadmin-password=password
    8. above credentials are also mentioned in the Docker-compose-db.yaml file
    
02. Run "mvn clean install" command
 
03. Start the application (port: 8080)

04. Need to add configuration data (rules) into the DB.
    Connect to the database (point 01) and run the sql queries thar are mentioned in the init_data.sql file

05. Example
    1. curl --location 'http://localhost:8080/parking-fee-service/calculation/city/1/vehicle/wp-123-456?vehicleType=CAR&startDate=2024-05-01&endDate=2024-06-01' \
    --header 'Content-Type: application/json'
