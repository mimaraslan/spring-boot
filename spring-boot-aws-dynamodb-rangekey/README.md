AWS DynamoDB range key demo project for Spring Boot

DynamoDB Create Table
![Spring Boot to CreateDynamoDBtable](src/main/resources/static/images/01-CreateDynamoDBtable.png)
![Running Spring Boot Project on CreateDynamoDBtable](src/main/resources/static/images/02-CreateDynamoDBtable.png)

POST
![Running Spring Boot Project on POST](src/main/resources/static/images/03-POST.png)
![Running Spring Boot Project on POST](src/main/resources/static/images/04-POST.png)
![Running Spring Boot Project on POST](src/main/resources/static/images/05-POST.png)

GET
![Running Spring Boot Project on GET](src/main/resources/static/images/06-GET.png)

PUT
![Running Spring Boot Project on PUT](src/main/resources/static/images/07-PUT.png)
![Running Spring Boot Project on PUT](src/main/resources/static/images/08-PUT.png)

DELETE
![Running Spring Boot Project on DELETE](src/main/resources/static/images/09-DELETE.png)
![Running Spring Boot Project on DELETE](src/main/resources/static/images/10-DELETE.png)


###  POST
http://localhost:8085/dynamodb


{
"firstName": "Mimar",
"lastName": "Aslan",
"address": {
"addressLinel": "Street1",
"addressLine2": "Street2",
"state": "AB",
"city": "CD",
"zipCode": "123456"
},
"age": "40"
}



###  GET
http://localhost:8085/dynamodb?studentId=ID_NUMBER&lastName=LAST_NAME


###  PUT
http://localhost:8085/dynamodb

{
"studentId": "ID_NUMBER",
"firstName": "Mimar",
"lastName": "Aslan",
"age": "45",
"address": {
"addressLine1": "LOLO Sokak",
"addressLine2": "ABC Mahallesi",
"state": "Kadikoy",
"city": "Istanbul",
"zipCode": "34752"
}
}



###  DELETE
http://localhost:8085/dynamodb/ID_NUMBER/LAST_NAME

