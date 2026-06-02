# Начало
1. Запускаем
```shell
docker run --name keycloak -p 127.0.0.1:8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin -d quay.io/keycloak/keycloak:26.6.1 start-dev 
```
2. http://localhost:8080
3. Создаем риалм demo
4. Создаем пользователя evgeniy, устанавливаем ему пароль
5. Создаем роли (Realm roles) ADMIN, USER
6. Создаем группу admins, добавляем в нее пользователя, добавляем роли 
7. Открываем пользователя, смотрим его роли (включаем INHERITED)
8. Можно залогиниться от имени evgeniy - http://localhost:8080/realms/demo/account/ . Пароль меняем на 321
9. Создаем клиента demo-client
   Client authentication: On
   Authorization: Off
   Standard flow: On
   Direct access grants: On
   Client authentication: On
   Service accounts roles: On
   На вкладке Credentials смотрим секрет 


# Логин из приложения

См examples.http, ex1
Вставляем jwt.io access_token из ответа (включив сеть и очистив), по kid из заголовка видим публичный ключ
Этот же ключ можно посмотреть в Realm settings -> Keys

Видим информацию о пользователе, его роли

См examples.http, ex2
Получаем access-токен по refresh-токену

Что такое refresh-токен? Это фактически сессия и мы можем посмотреть, какие сессии есть у пользователя -
http://localhost:8080/realms/demo/account/account-security/device-activity

Можно разлогиниться, теперь при попытке запросить токен по refresh-токену мы получим ошибку

Можно заново запросить новую пару по логину и паролюЧто 

# Токен для клиента (confidental)

См ex2

# Проверка токена в сервисе

* Запустить AuthDemoApplication
* ex3 - /public /admin /profile

#  Межсервисная аутентификация

ex4, ex5




