create table if not exists customer (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  phone VARCHAR(25),
  zipcode VARCHAR(12)
);

create table if not exists customer_transaction (
  id INTEGER PRIMARY KEY,
  transactionType VARCHAR(255),
  transactionDate VARCHAR(255),
  amtPaid DOUBLE
);

create table if not exists vehicle (
  id INTEGER PRIMARY KEY,
  ownerId INTEGER,
  CONSTRAINT FOREIGN KEY (ownerId) REFERENCES customer(id),
  price DOUBLE,
  vin VARCHAR(255),
  vehicleType VARCHAR(255),
  numSeats INTEGER,
  engine VARCHAR(255),
  horsepower VARCHAR(255),
  seatsType VARCHAR(255),
  make VARCHAR(255),
  model VARCHAR(255),
  color VARCHAR(255),
  year INTEGER
);