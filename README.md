# java-streams
Teste da API de Streams do Java para pesquisar um padrão em um arquivo.

O arquivo usado no teste foi baixado em https://www.stats.govt.nz/assets/Uploads/New-Zealand-business-demography-statistics/New-Zealand-business-demography-statistics-At-February-2020/Download-data/Geographic-units-by-industry-and-statistical-area-2000-2020-descending-order-CSV.zip. Ele está em src/test/resources zipado, é necessário unzipar antes de rodar o teste.

Para rodar com o maven:

time mvn spring-boot:run -Dspring-boot.run.arguments="A100600"

Com o java direto:

time java -jar java-streams-0.0.1-SNAPSHOT.jar A100600

Para comparar com o grep:

 time grep -a -o -E -w 'A100600' ../src/test/resources/Data7602DescendingYearOrder.csv | sort | uniq -c
