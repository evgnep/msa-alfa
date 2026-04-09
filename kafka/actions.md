Запуск контейнера
```shell
cd kafka
docker compose start
```

Создать топик
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-topics --create --topic test --partitions 1 --replication-factor 1 --bootstrap-server localhost:9091
```

Получить список топиков
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-topics --list --bootstrap-server localhost:9091
```

Отправить сообщение
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-producer --topic test --bootstrap-server localhost:9091
```
Каждая строка - одно сообщение. Прервать - Ctrl+Z

Получить сообщения
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-consumer --from-beginning --topic test --bootstrap-server localhost:9091 
```

Получить сообщения как consumer1
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-consumer --group consumer1 --topic test --bootstrap-server localhost:9091 
```

Отправить сообщение c ключом через двоеточие (key:value)
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-producer --topic test --property "parse.key=true" --property "key.separator=:" --bootstrap-server localhost:9091
```

# Хранение сообщений

```shell
docker exec -ti kafka-otuskafka sh
```

cat /etc/kafka/server.properties
ls /var/lib/kafka
/usr/bin/kafka-dump-log --files 00000000000000000000.log
/usr/bin/kafka-dump-log --files 00000000000000000000.log --print-data-log