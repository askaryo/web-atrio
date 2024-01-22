#!/bin/bash

# Add 10 people to the database
for ((i=1; i<=10; i++)); do
  curl -X POST -H "Content-Type: application/json" -d '{
    "name": "Person'$i'",
    "dateOfBirth": "1990-01-01"
  }' http://localhost:8080/api/persons
done
