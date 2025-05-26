# 📦 HerraRent

**HerraRent** es una plataforma para el alquiler de herramientas profesionales, permitiendo a usuarios y proveedores gestionar reservas, pagos y disponibilidad de equipos de manera eficiente y segura.

---

## 🛠 Tecnologías Utilizadas

- **Backend:** Java 21, Spring Boot 3.2
- **Base de datos:** PostgreSQL
- **WebSockets:** Comunicación en tiempo real para notificaciones
- **Autenticación:** JWT (JSON Web Token)
- **Documentación:** Swagger UI

---

## 🚀 Comenzar

### 📋 Requisitos

- JDK 21
- PostgreSQL 15+
- Maven 3.9+

### 🔧 Instalación

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/Stivenco12/Backend_proyecto_spring_boot_java.git
   cd Backend_proyecto_spring_boot_java
   ```

2. **Configura la base de datos:**
   - Crea una base de datos en PostgreSQL (ejemplo: `prueba1`).
   - Actualiza el archivo `src/main/resources/application.properties` con tus credenciales:

     ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/prueba1
     spring.datasource.username=postgres
     spring.datasource.password=campus2023
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.sql.init.encoding=UTF-8
     spring.jpa.show-sql=true
     spring.jpa.hibernate.ddl-auto=create-drop
     ```

3. **Instala dependencias y ejecuta el proyecto:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## 🗄️ Diagrama Relacional de la Base de Datos

![alt text](<modelo base de datos osman.png>)

---

## 📚 Endpoints de la API

> Todos los endpoints requieren autenticación JWT (excepto `/auth/login` y `/auth/register`).

### Autenticación

- **POST /auth/login**
  ```json
  {
    "username": "usuario1",
    "password": "password"
  }
  ```
  **Respuesta:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
  }
  ```

- **POST /auth/register**
  ```json
  {
    "username": "nuevo_usuario",
    "password": "password123",
    "telefono": "123456789",
    "role": "USER"
  }
  ```

### Herramientas

- **GET /api/Tools**
  - Lista todas las herramientas.

- **GET /api/Tools/{id}**
  - Detalle de una herramienta.

- **POST /api/Tools** (multipart/form-data)
  - Crea una herramienta.
  - Ejemplo de campos:
    - `tool`: JSON con datos de la herramienta.
    - `imagen`: archivo de imagen.

- **PUT /api/Tools/{id}**
  - Actualiza una herramienta.

- **DELETE /api/Tools/{id}/{userId}**
  - Elimina una herramienta (solo el dueño puede eliminarla).

- **GET /api/Tools/proveedor/{userId}**
  - Lista herramientas de un proveedor.

### Reservas

- **GET /api/Reservations**
  - Lista todas las reservas.

- **POST /api/Reservations**
  - Crea una reserva.
  - Ejemplo:
    ```json
    {
      "toolsId": 1,
      "userId": 2,
      "fechaReserva": "2025-05-26",
      "fechaDevolucion": "2025-05-30"
    }
    ```

- **DELETE /api/Reservations/{id}**
  - Elimina una reserva.

---

## 🔐 Autenticación y Roles

- **JWT:** Todos los endpoints protegidos requieren un token JWT en el header `Authorization: Bearer <token>`.
- **Roles:**  
  - `USER`: Puede reservar herramientas y ver sus reservas.
  - `PROVEEDOR`: Puede publicar, editar y eliminar sus herramientas.
  - `ADMIN`: Acceso total a la plataforma.

---





---

> Para dudas o mejoras, abre un issue o pull request en el repositorio.