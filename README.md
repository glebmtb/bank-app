Используется
- Spring Boot
- H2 in-memory
- MyBatis

Запустить
- Собрать проект `./gradlew build`
- Открыть папку c jar `cd build/libs`  
- Запустить приложение `java -jar bank-0.1.jar`

Подключиться к базе 
- url `http://localhost:8080/h2-console`
- jdbc url `jdbc:h2:mem:bankdb`
- User Name `sa`
- Password: без пароля
- Saved Settings `Generic H2 (Embedded)`


API  
- положить деньги `curl --location --request POST 'localhost:8080/getMoney?accountId=1&amount=70'`
- взять деньги `curl --location --request POST 'localhost:8080/putMoney?accountId=2&amount=70'`
- перевести деньги `curl --location --request POST 'localhost:8080/transferMoney?accountIdFrom=1&accountIdTo=2&amount=70'`