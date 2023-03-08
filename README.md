# TestCase-KurCekme-Backend
Mekez bankasından gelen kurları verilen tarihe göre çekme uygulaması
Uygulamanın çalışması için front end tarafına ihtiyaç vardır.Front kullanılmadan

http://localhost:8080/api/currency/{YYYYmm}/{ddmmYYYY} 

postman üzerinden veya benzer programlar üzerindende istek atılıp sonuca bakılabilir.
hibernate.ddl-auto=update olarak bıraktığım için localinizde tb table oluşturur.


kullandığım kütüphaneler:
mapstruct,lombok,gson,spring iodaki bazı starter kitler


Kendi local databaseme bağlanmak için kullandığım değerler.Kendi lokasyonunuz ve şifrenizde değiştirin.

spring.datasource.url=jdbc:postgresql://localhost:5433/postgres

spring.datasource.username=postgres

spring.datasource.password=12345

spring.jpa.hibernate.ddl-auto=update

/
/
/

not:build/run etmek için testcase klasörü içerisinde olmayı unutmayın

