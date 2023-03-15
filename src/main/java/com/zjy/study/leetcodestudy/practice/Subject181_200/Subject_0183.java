package com.zjy.study.leetcodestudy.practice.Subject181_200;

/**
 * @Author zjy
 * @Date 2023/3/15 9:43
 * @Description
 *      从不订购的客户
 */
public class Subject_0183 {
    /**
     * SQL架构
     * 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
     *
     * Customers 表：
     *
     * +----+-------+
     * | Id | Name  |
     * +----+-------+
     * | 1  | Joe   |
     * | 2  | Henry |
     * | 3  | Sam   |
     * | 4  | Max   |
     * +----+-------+
     * Orders 表：
     *
     * +----+------------+
     * | Id | CustomerId |
     * +----+------------+
     * | 1  | 3          |
     * | 2  | 1          |
     * +----+------------+
     * 例如给定上述表格，你的查询应返回：
     *
     * +-----------+
     * | Customers |
     * +-----------+
     * | Henry     |
     * | Max       |
     * +-----------+
     */

    /*
        Create table If Not Exists Customers (id int, name varchar(255))
        Create table If Not Exists Orders (id int, customerId int)
        Truncate table Customers
        insert into Customers (id, name) values ('1', 'Joe')
        insert into Customers (id, name) values ('2', 'Henry')
        insert into Customers (id, name) values ('3', 'Sam')
        insert into Customers (id, name) values ('4', 'Max')
        Truncate table Orders
        insert into Orders (id, customerId) values ('1', '3')
        insert into Orders (id, customerId) values ('2', '1')
     */

    /*
        select Name Customers
        from Customers
        where Id Not in (
            select CustomerId from Orders
        )
     */
}
