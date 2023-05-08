# exp-copilot-api
Pequena API de dois endpoints para um experimento com o Github Copilot

## Execução da aplicação

```
docker build -t copilot-challenge-3.jar .
```

```
docker run --env DB_HOST="127.0.0.1:3306" --env DB_NAME="copilot" --env DB_USERNAME="root" --env DB_PASSWORD="root"  --name copilot-challenge-3 --network="host" -p 8080:8080 -d copilot-challenge-3.jar
```
