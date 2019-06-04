# NovaTechAdmin
Repo for Administrator

## Setup
1. If you do not have maven installed, you need to install it
2. Import this project as a maven project
3. Set up MySQL schema using the schema in src/test/resources/schema.sql
4. Create a file called `database-config.properties` in src/main/resources. Look at the java properties example down below for reference. *Note:*, you generally need `useSSL=false` in the database url. It is recommended to encrypt the connection (which is a java property file).<br/>
```java-properties
spring.datasource.url = jdbc:mysql://hostname:port/database-name?serverTimezone=UTC
spring.datasource.username = username
spring.datasource.password = password

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update
```
