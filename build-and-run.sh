#!/bin/bash
set -e

echo "=== Maven: Clean and Package ==="
mvn clean package

echo "=== Docker Compose: Down (с удалением томов) ==="
docker-compose down -v

echo "=== Docker Compose: Up с пересборкой образов ==="
docker-compose up --build -d

echo "=== Готово! Контейнеры запущены ==="
