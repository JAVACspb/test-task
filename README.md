# 📚 Library Management System

Это веб-приложение для управления библиотекой. Позволяет работать с книгами, клиентами и их бронированиями. Поддерживает CRUD-операции, фильтрацию, пагинацию и просмотр активных читателей.

---

## 📦 Стек технологий

- Java 8
- Spring Boot 2
- PostgreSQL 14 (в Docker)
- Liquibase
- MapStruct
- Swagger UI
- Maven
- Docker + Docker Compose

---

## 🚀 Запуск приложения

### 📥 1. Клонировать репозиторий

```bash
git clone https://github.com/yourname/library-app.git
cd library-app
```

### ⚙️ 2. Собрать проект

```bash
mvn clean package
```

### 🐳 3. Запустить через Docker Compose

```bash
docker compose down -v         # Остановить и удалить старые контейнеры + volume
docker compose up --build      # Пересобрать образы и запустить проект
```

📌 Приложение автоматически поднимется по адресу:  
`http://localhost:8080`

---

## 🧪 Тестирование API

После запуска доступна документация Swagger UI:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## ⚙️ Особенности деплоймента

1. Все настройки (БД, порты, переменные) описаны в `docker-compose.yml` и `application.properties`
2. Схема базы данных автоматически создаётся при старте с помощью Liquibase
3. Maven компиляция: `mvn package`
4. Запуск: `docker compose up --build`
5. Swagger доступен по ссылке выше

---
