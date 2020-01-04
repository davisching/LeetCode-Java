/*  196 - Delete Duplicate Emails - From @ LeetCode.com
    
    Write a SQL query to delete all duplicate email entries in a table named Person, 
    keeping only unique emails based on its smallest Id.

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    | 3  | john@example.com |
    +----+------------------+
    Id is the primary key column for this table.

    For example, after running your query, the above Person table should have the following rows:

    +----+------------------+
    | Id | Email            |
    +----+------------------+
    | 1  | john@example.com |
    | 2  | bob@example.com  |
    +----+------------------+

    Note:

    Your output is the whole Person table after executing your sql. Use delete statement.
    
    Solution by @ Davis Ching, 2020.
 */
 
// SOLUTION ONE
 
delete 
    p1
from
    person p1,
    person p2
where
    p1.email = p2.email
        and
    p1.id > p2.id
;

// SOLUTION 2
delete from
    person
where
    id
not in (
	select
		*
	from
		(
		select 
			min(id) as id
		from
			person
		group by
			email
		) as p
    )
;
