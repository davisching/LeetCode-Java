/*  197 - Rising Temperature - From @ LeetCode.com
    
    Given a Weather table, write a SQL query to find all dates' Ids with higher temperature 
    compared to its previous (yesterday's) dates.

    +---------+------------------+------------------+
    | Id(INT) | RecordDate(DATE) | Temperature(INT) |
    +---------+------------------+------------------+
    |       1 |       2015-01-01 |               10 |
    |       2 |       2015-01-02 |               25 |
    |       3 |       2015-01-03 |               20 |
    |       4 |       2015-01-04 |               30 |
    +---------+------------------+------------------+

    For example, return the following Ids for the above Weather table:

    +----+
    | Id |
    +----+
    |  2 |
    |  4 |
    +----+

    Solution by @ Davis Ching, 2019
 */


SELECT
    w1.id
FROM
    weather w1
        JOIN
    weather w2
        ON
    datediff(w1.recorddate, w2.recorddate) = 1
        AND
    w1.temperature > w2.temperature
;
