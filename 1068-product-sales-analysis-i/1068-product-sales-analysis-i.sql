# Write your MySQL query statement below
Select
    pro.product_name,
    sal.year,
    sal.price
From 
    Sales as sal
Join Product as pro on
    pro.product_id = sal.product_id