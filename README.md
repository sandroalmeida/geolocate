# geolocate
Java / Spark / Swagger API example - Return geo location for an ip address informed to the api

## Tips
This project is a base Java Maven Project, so for the first use all the Maven dependencies need to be updated.

## IPgeolocation
In the resources folder the file CONFIG.PROPERTIES has the apiKey required to access the third party api from https://app.ipgeolocation.io/

## Model
The class LocationProperty is the model for the locations return properties, not all the properties from the ipgeolocation are implemented, but it is easy to implement, just add a new property using the same name from the api return.

## Starting
The Apache Spark is the Rest API framework so for starting it is necessary to execute the main method on the class GeoLocate.

## Endpoints
After starting the endpoint 'geolocate/{ip}' will be enabled.
This main method is also responsible to initialize the swagger-spark for the API documentation.
The swagger documentation can be accessed on the url 'localhost:55555'

## Screenshots

### Accessing API from browser
![api-browser](https://user-images.githubusercontent.com/6804563/102754493-ef239380-4321-11eb-96ce-d4623cf87a7c.png)

### Testing API using Postman
![api-postman](https://user-images.githubusercontent.com/6804563/102754619-15493380-4322-11eb-8971-f3f60e867154.png)

### Swagger Home Page
![swagger-home](https://user-images.githubusercontent.com/6804563/102754641-1da16e80-4322-11eb-8b70-74d2c02bbdd7.png)

### Swagger Execution Test
![swagger-exec](https://user-images.githubusercontent.com/6804563/102754630-19755100-4322-11eb-8334-3a2562ab7dcf.png)




