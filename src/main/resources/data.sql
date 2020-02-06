INSERT INTO customer (id, name, phone, zipcode) 

SELECT '0', 'Prokarma Auto', '123-456-7890', '98043'

WHERE NOT EXISTS (SELECT name FROM customer WHERE name = 'Prokarma Auto');