# Init infinispan/DataGrid

```
./start-datagrid.sh
```

# Init client

```
mvn spring-boot:run
```

# Tests

```
curl -X POST -H 'Content-type: application/json' -d '{"id":"1","name":"Vinicius"}' localhost:8080/pessoas

```

```
curl -X GET localhost:8080/pessoas/1

```

```
curl -X DELETE localhost:8080/pessoas/1
```

