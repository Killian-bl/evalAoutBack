-- Table CUSTOMER
CREATE TABLE customer (
    customer_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(150) NOT NULL UNIQUE
);

-- Table PRODUCT
CREATE TABLE product (
    product_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    price INT NOT NULL,
    overview NVARCHAR(MAX),
    stock INT DEFAULT 0,
    quantity INT DEFAULT 0
);

-- Table ORDER (mot réservé → crochets)
CREATE TABLE [order] (
    order_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    [date] INT, -- si tu veux, mieux DATETIME
    cart_price INT,
    product_number INT,
    customerId BIGINT,
    CONSTRAINT fk_order_customer FOREIGN KEY (customerId)
        REFERENCES customer(customer_id)
);

-- Table de jointure ManyToMany entre ORDER et PRODUCT
CREATE TABLE order_product (
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT pk_order_product PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_order_product_order FOREIGN KEY (order_id)
        REFERENCES [order](order_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_order_product_product FOREIGN KEY (product_id)
        REFERENCES product(product_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
