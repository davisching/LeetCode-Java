/*  183 - Customers Who Never Order - From @ LeetCode.com
    
    Suppose that a website contains two tables, the Customers table and the Orders table. 
    Write a SQL query to find all customers who never order anything.

    Table: Customers.

    +----+-------+
    | Id | Name  |
    +----+-------+
    | 1  | Joe   |
    | 2  | Henry |
    | 3  | Sam   |
    | 4  | Max   |
    +----+-------+

    Table: Orders.

    +----+------------+
    | Id | CustomerId |
    +----+------------+
    | 1  | 3          |
    | 2  | 1          |
    +----+------------+

    Using the above tables as example, return the following:

    +-----------+
    | Customers |
    +-----------+
    | Henry     |
    | Max       |
    +-----------+

    
    Solution by @ Davis Ching, 2020.
 */
 
 
// SOLUTION ONE
select
    name as 'customers'
from
    customers
where 
    id
not in
    (   
        select 
            customerid 
        from 
            orders
    )
;

// SOLUTION TWO
select
    name as 'customers'
from
    customers c
left join
    orders o
on
    c.id = o.customerid
where
    o.customerid is null
;
