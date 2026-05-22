**Architecture & Server Setup**

Two-tier Spring Boot application structure
App 1 (Client) acts as the consumer
App 2 (Server) acts as the REST provider
Communication via synchronous REST API calls
Server Framework: Spring Boot 3.2.5 with spring-boot-starter-web
Server Port configuration: 8082
Server Application name: app2-server


**API Design & Client Setup**

API Endpoints (Base Path: /api/products):
GET /api/products: Returns list of all products
GET /api/products/{id}: Returns specific product by ID
POST /api/products: Creates new product with ID 100

Client Configuration:
Framework: Spring Boot 3.2.5 on Port 8081
Config: app2.base-url=http://localhost:8082
RestTemplate bean initialization in RestTemplateConfig

**Service Logic & Validation**

Service Layer: ProductClientService
Dependency Injection: RestTemplate and app2-base-url
fetchAllProducts: Uses restTemplate.getForObject with Product[].class
fetchProductById: Uses restTemplate.getForObject with Product.class
createProduct: Uses restTemplate.postForObject
Startup Order: App 2 (Server) then App 1 (Client)
Client GET /client/products routes to Server GET /api/products
Client POST /client/products routes to Server POST /api/products
