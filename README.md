# product-adviser
Advises products based on demographics

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Java SE JDK 1.8,

GRADLE 5.6

(OPTIONAL) Docker

### Installing (Windows)

1. Download and extract repository

2. Open command line at extracted directory

3. Type:
```
gradle build
```
4. Gradle will generate jar at ../insurance-policies/build/libs/

### Lombok Annotaion Processing

This project uses Lombok. Majority of getters, setters and constructors being created during runtime. In order for IDE to do not show errors during compile time, you would need to enable Annotaion processing. To enable annotation processing in Intellij go to: "Settings > Build > Compiler > Annotation Processors".

### Running with docker
Docker image is avalible publicly at aurrix/proofit:insurance-policies. 

To run image locally you would also need to specify ports:
```
docker run -p 8081:8080 aurrix/seb:product-adviser
```

###CRUD Operations 'Product'

http:\\localhost:8081\products (get) - returns list of all Products

http:\\localhost:8081\products\{id} (get) - returns one Product

http:\\localhost:8081\products (post) - accepts plain JSON Customer object (see below) with Product to be created

http:\\localhost:8081\products\{id} (put) accepts plain JSON updates specified Product

http:\\localhost:8081\products\{id} (delete) deletes if found a specified Product

###Recommendation Endpoint

http:\\localhost:8081\recommendations (post) returns list of all recommended products to customer

### CustomerDto

{
	"age":int,
	"student":boolean,
	"income":double
	
}

### Testing

To run test cases repeat steps 1,2 then type:
```
gradle test
```
## License

This project is licensed under the [Apache License 2](https://www.apache.org/licenses/LICENSE-2.0)
