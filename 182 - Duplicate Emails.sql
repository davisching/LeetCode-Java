/*  182 - Duplicate Emails - From @ LeetCode.com
    
    Write a SQL query to find all duplicate emails in a table named Person.

    +----+---------+
    | Id | Email   |
    +----+---------+
    | 1  | a@b.com |
    | 2  | c@d.com |
    | 3  | a@b.com |
    +----+---------+

    For example, your query should return the following for the above table:

    +---------+
    | Email   |
    +---------+
    | a@b.com |
    +---------+

    Note: All emails are in lowercase.
 
    
    Solution by @ Davis Ching, 2019
 */
 
 // solution one
 
select 
	email
from 
	person
group by
	email
having
	count(email) > 1
;

// solution two
select
    email
from
    (
    select
        email,
        count(email) c
    from
        person
    group by
        email
    ) as counter
where
    counter.c > 1
;
