CREATE DATABASE IF NOT EXISTS prueba1;

CREATE TABLE countries (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);
CREATE TABLE regions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    country_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    CONSTRAINT fk_region_country FOREIGN KEY (country_id)
        REFERENCES countries(id)
        ON DELETE CASCADE
);
CREATE TABLE cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    region_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    CONSTRAINT fk_city_region FOREIGN KEY (region_id)
        REFERENCES regions(id)
        ON DELETE CASCADE
);
CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255),
    password VARCHAR(255),
    telefono VARCHAR(255),
    role VARCHAR(50),
    user_id BIGINT,
    city_id BIGINT,
    CONSTRAINT fk_user_self FOREIGN KEY (user_id)
        REFERENCES Users(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_user_city FOREIGN KEY (city_id)
        REFERENCES cities(id)
        ON DELETE SET NULL
);
CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    address VARCHAR(50),
    city_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    CONSTRAINT fk_address_city FOREIGN KEY (city_id)
        REFERENCES cities(id)
        ON DELETE SET NULL
);
CREATE TABLE tools (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    datos_imagen BYTEA NOT NULL,
    descripcion VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    category VARCHAR(50),
    disponibilidad INTEGER NOT NULL,
    costo_diario DOUBLE PRECISION NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_tools_user FOREIGN KEY (user_id)
        REFERENCES Users(id)
        ON DELETE CASCADE
);
CREATE TABLE Reservations (
    id SERIAL PRIMARY KEY,
    tools_id BIGINT,
    user_id BIGINT,
    payment_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    facturas VARCHAR(250),
    factura_pdf BYTEA,
    fecha_reserva DATE,
    fecha_devolucion DATE,
    CONSTRAINT fk_reservation_tool FOREIGN KEY (tools_id)
        REFERENCES tools(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_reservation_user FOREIGN KEY (user_id)
        REFERENCES Users(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_reservation_payment FOREIGN KEY (payment_id)
        REFERENCES payment(id)
        ON DELETE SET NULL
);
CREATE TABLE Returns (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50),
    damage_report_id BIGINT,
    reservation_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    CONSTRAINT fk_return_damage_report FOREIGN KEY (damage_report_id)
        REFERENCES damage_report(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_return_reservation FOREIGN KEY (reservation_id)
        REFERENCES Reservations(id)
        ON DELETE SET NULL
);
CREATE TABLE Damage_reports (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);
CREATE TABLE Payment_types (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);
CREATE TABLE Payments (
    id SERIAL PRIMARY KEY,
    payment_type_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    CONSTRAINT fk_payment_payment_type FOREIGN KEY (payment_type_id)
        REFERENCES Payment_types(id)
        ON DELETE SET NULL
);
