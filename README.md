```text
======================================================================================
                             _                _                               _ 
 _ __   __ _ _ __ __ _ _   _(_)_ __ ___   ___| |_ _ __ ___         __ _ _ __ (_)
| '_ \ / _` | '__/ _` | | | | | '_ ` _ \ / _ \ __| '__/ _ \ _____ / _` | '_ \| |
| |_) | (_| | | | (_| | |_| | | | | | | |  __/ |_| | | (_) |_____| (_| | |_) | |
| .__/ \__,_|_|  \__, |\__,_|_|_| |_| |_|\___|\__|_|  \___/       \__,_| .__/|_|
|_|                 |_|                                                |_|     
======================================================================================
```
Dumentação Swagger em: `/swagger-ui.html`

## 1. Ferramentas utilizadas
* PostgreSQL
* Spring Boot (maven)
* Docker

## 2. Como rodar localmente
Por padrão, a api vai rodar na porta 8080
### 2.1 Rodar com Docker
**2.1.1** Faça o buid do Dockerfile:

`$ docker build -t parquimetro-api .`


**2.1.2** Execute com:

`$ docker-compose up -d` Ou `$ docker compose up -d`


### 2.2 Rodar com Maven
Por padrão, a API se conecta a um banco de dados PostgreSQL na porta 5432, e aceita as seguintes variaveis de ambiente:
* `PARQUIMETRO_PROFILE` (padrão 'dev') - Perfil de execução da API
* `PARQUIMETRO_DB_USER` (padrão 'postgres') - Usuário do banco de dados
* `PARQUIMETRO_DB_PASSWORD` (padrão 'postgres') - Senha do banco de dados
* `PARQUIMETRO_DB_HOST` (padrão 'localhost') - Dominio em que o banco de dados se encontra
* `PARQUIMETRO_DB_PORT` (padrão 5432) - Porta em que se encontra o banco de dados
* `PORT` (padrão 8080) - Define a porta em que a aplicação vai rodar
**2.2.1** Banco de Dados
A aplicação espera
Para rodar com o Maven ou Java siga este passo a passo

Na raiz do projeto:
```
$ mvn clean package
$ mvn spring-boot:run
```
