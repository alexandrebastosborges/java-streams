# java-streams
Teste da API de Streams do Java para pesquisar um padrão em um arquivo.

O arquivo usado no teste foi baixado em https://www.stats.govt.nz/assets/Uploads/New-Zealand-business-demography-statistics/New-Zealand-business-demography-statistics-At-February-2020/Download-data/Geographic-units-by-industry-and-statistical-area-2000-2020-descending-order-CSV.zip. Ele está em src/test/resources zipado, é necessário unzipar antes de rodar o teste.

Para rodar com o maven:

mvn spring-boot:run -Dspring-boot.run.arguments="A100600"
