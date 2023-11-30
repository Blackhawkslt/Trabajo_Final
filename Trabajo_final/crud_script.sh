#!/bin/bash

# URL base de la API
API_URL="http://localhost:8080/api/libros"

# Operación de Crear (POST)
curl -X POST -H "Content-Type: application/json" -d '{"titulo": "Nuevo Libro", "autor": "Autor Nuevo", "precio": 19.99}' $API_URL

# Operación de Leer (GET)
curl $API_URL

# Supongamos que el ID del libro a actualizar o eliminar es 1
LIBRO_ID=1

# Operación de Actualizar (PUT)
curl -X PUT -H "Content-Type: application/json" -d '{"titulo": "Libro Actualizado", "autor": "Autor Actualizado", "precio": 29.99}' $API_URL/$LIBRO_ID

# Operación de Eliminar (DELETE)
curl -X DELETE $API_URL/$LIBRO_ID
