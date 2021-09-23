# desafio-feira

Esse projeto consiste em uma API Rest Java Spring Boot no qual permite importar,cadastrar, alterar e excluir uma feira livre da prefeitura cidade de São Paulo.

O projeto contém testes unitários automatizados utilizando o framework Junit e suas devidas implementações estão contidas no pacote de testes da aplicação (test/java/com/gms/challengerFeira)

No repositório do projeto contém o postman colection para que possa ser utilizado como cobertra de testes dos recsos da API Rest. (desafio-feira/postman-collection/)

Para que seja possível montar o ambiente de execução da aplicação local com docker, execute os seguintes passos:

1 - Baixe a imagem do MySQL
$ docker pull mysql:latest <br/>
<br/>
2 - Rode o container MySQL
$ docker run --name mysql-docker-container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=desafio -d mysql:latest --secure-file-priv=""
<br/><br/>
3 - Copie o arquivo csv (DEINFO_AB_FEIRASLIVRES_2014.csv) que será importado para o container do banco de dados MySQL
$ docker cp <Path do arquivo> mysql-docker-container:/var/lib/mysql/desafio/ (Ex.: docker cp C:\Users\test\Desktop\DEINFO_AB_FEIRASLIVRES_2014.csv mysql-docker-container:/var/lib/mysql/desafio/)
  <br/><br/>
 4 - Baixe a imagem docker da aplicação 
 $ docker pull guilhermeoliveira1992/desafio-feira:latest
  <br/><br/>
 5 - Execute o container da aplicação
 $ docker run -d --name desafio-feira --link mysql-docker-container:mysql-docker-container -p 9080:9080 guilhermeoliveira1992/desafio-feira:latest <br/><br/>
  
Para que possa ter acesso ao logs da aplicação, execute o seguinte comando:
$  docker cp desafio-feira:/logs.txt <Path destino> (Ex.: cp desafio-feira:/logs.txt C:\Users\test\Desktop\logs)
  
Obs.: O arquivo csv para importar no banco de dados é encontrado através do site da prefeitura da cidade de São Paulo (http://www.prefeitura.sp.gov.br/cidade/secretarias/upload/chamadas/feiras_livres_1429113213.zip) ou no diretório do projeto (desafio-feira/docs/)
 
A aplicação é executada na porta 9080
