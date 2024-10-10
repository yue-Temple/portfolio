DROP TABLE IF EXISTS Ordersdetail;
CREATE TABLE Ordersdetail(
detailid INT NOT NULL,
productid VARCHAR(6) NOT NULL,
ordersid INT NOT NULL,
quentity INT NOT NULL,
note VARCHAR(40),
PRIMARY KEY (detailid),
FOREIGN KEY(productid) REFERENCES Product(id),
FOREIGN KEY(ordersid) REFERENCES Orders(id)
);