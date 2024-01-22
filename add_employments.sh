#!/bin/bash

# Add 20 employments for the first 10 people in the database
for ((i=1; i<=10; i++)); do
  # Employment 1
  curl -X POST -H "Content-Type: application/json" -d '{
    "companyName": "CompanyA",
    "job": "JobA1",
    "startDate": "2022-01-01",
    "endDate": "2022-06-30"
  }' http://localhost:8080/api/employments/$i

  if (( i % 2 == 0 )); then
    curl -X POST -H "Content-Type: application/json" -d '{
      "companyName": "CompanyB",
      "job": "JobB1",
      "startDate": "2022-02-01"
    }' http://localhost:8080/api/employments/$i
  fi
  # Repeat the pattern for additional employments
done
