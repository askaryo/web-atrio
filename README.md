# Test Web-atrio - Yousif ASKAR

## Getting Started

1. Clone the repository
2. Build the project with `./mvnw clean install`
3. Run the application with `./mvnw spring-boot:run`


To add people in the database: `./add_people.sh`


To add employments in the database: `./add_employments.sh`

Les differents scenarios: 

1. Save a new person

`
curl -X POST -H "Content-Type: application/json" -d '{
"name": "John Smith",
"dateOfBirth": "1991-01-01"
}' http://localhost:8080/api/persons
`


2. Add an employment to a person

`
curl -X POST -H "Content-Type: application/json" -d '{
"companyName": "CompanyA",
"job": "JobA1",
"startDate": "2012-01-01",
"endDate": "2020-01-01"
}' http://localhost:8080/api/employments/1
`


3. Retrieve all registered individuals in alphabetical order and also indicate their age and current employment.

`curl http://localhost:8080/api/employments/orderedSituations`


4. Retrieve all individuals who have worked for a given company

`curl http://localhost:8080/api/persons/company/CompanyB`


5. Retrieve all jobs of a person between two date ranges

` curl http://localhost:8080/api/employments/byPersonAndDateRange?personId=1&startDate=2022-01-01&endDate=2022-12-31`