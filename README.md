# 📚 Library Management System

Проект представляет собой REST API для управления библиотекой: добавление и обновление книг, регистрация клиентов, учёт взятых и возвращённых книг.

## 🚀 Быстрый старт

### 📦 Сборка проекта

Проект собирается через Maven:

```bash
mvn clean package
```

### 🐳 Запуск базы данных PostgreSQL

В корне проекта находится `docker-compose.yml`, поднимающий PostgreSQL 14:

```bash
docker-compose up -d
```

База будет доступна по следующим параметрам:

- Хост: `localhost`
- Порт: `5432`
- Имя базы данных: `library`
- Пользователь: `postgres`
- Пароль: `password`

> ⚠️ Эти параметры можно изменить в `application.yml`.

### 🧠 Автоматическое создание схемы

При первом запуске:
- Применяются все изменения Liquibase (создание таблиц, индексов и ограничений);
- Схема инициализируется автоматически.

### ☕ Запуск приложения

После сборки выполните:

```bash
java -jar target/library-0.0.1-SNAPSHOT.jar
```

### 📖 Swagger (OpenAPI UI)

После запуска API доступно по адресу:

```
http://localhost:8080/swagger-ui.html
```


## 📂 Структура проекта

```
├── src/main/java/com/yourorganization/testtask
│   ├── feature/book
│   ├── feature/client
│   ├── feature/borrow
│   ├── exception
│   ├── config
│   └── ...
├── src/main/resources
│   ├── application.yml
│   └── db/changelog/
│       └── *.xml  (Liquibase changelogs)
├── docker-compose.yml
└── README.md
```

## ✅ Основной функционал

- 📘 CRUD-операции над книгами (`/api/books`)
- 👤 CRUD-операции над клиентами (`/api/clients`)
- 📚 Учёт взятых и возвращённых книг (`/api/borrow`)
- 📄 Получение списка читающих клиентов с полной информацией (`/api/borrow/reading_list`)

## 🔒 Валидация и обработка ошибок

- Валидация всех входящих DTO через `javax.validation`
- Кастомные исключения с централизованной обработкой в `@ControllerAdvice`

## 💡 Технологии

- Java 8
- Spring Boot 2
- Spring Data JPA
- PostgreSQL 14
- Liquibase
- MapStruct
- Swagger / OpenAPI
- Docker + Docker Compose

---
