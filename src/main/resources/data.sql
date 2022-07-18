drop table if exists learningresources;

create table learningresources(
    learning_resource_id int primary key,
    learning_resource_name varchar(255),
    cost_price double,
    selling_price double,
    learning_resource_status varchar(255),
    created_date varchar(255),
    published_date varchar(255),
    retired_date varchar(255)
);


           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1310, 'Java 101 for beginners', 499, 599, 'LIVE', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1311, 'Python 101 for beginners', 499, 599, 'LIVE', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1312, 'Scala 101 for beginners', 499, 599, 'PUBLISHED', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1313, 'GO 101 for beginners', 699, 799, 'PLANNING', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1314, 'Microservices with Spring Boot', 899, 999, 'LIVE', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1315, 'Design Patterns', 999, 1199, 'PUBLISHED', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1316, 'DevOps and its practices', 699, 799, 'PLANNING', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1317, 'Advanced Java', 799, 999, 'PUBLISHED', '2021-11-07', '2022-01-02', '2025-01-02');
           INSERT INTO learningresources (learning_resource_id,learning_resource_name,cost_price,selling_price,learning_resource_status,created_date,published_date,retired_date)
           VALUES (1318, 'Advanced Python', 599, 999, 'PLANNING', '2021-11-07', '2022-01-02', '2025-01-02');