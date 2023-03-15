package com.zjy.study.leetcodestudy.practice.Subject181_200;

/**
 * @Author zjy
 * @Date 2023/3/15 10:12
 * @Description
 *      删除重复的电子邮箱
 */
public class Subject_0196 {
    /**
     * SQL架构
     * 表: Person
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | email       | varchar |
     * +-------------+---------+
     * id是该表的主键列。
     * 该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。
     *
     *
     * 编写一个 SQL 删除语句来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。
     *
     * 以 任意顺序 返回结果表。 （注意： 仅需要写删除语句，将自动对剩余结果进行查询）
     *
     * 查询结果格式如下所示。
     *
     *
     * 示例 1:
     *
     * 输入:
     * Person 表:
     * +----+------------------+
     * | id | email            |
     * +----+------------------+
     * | 1  | john@example.com |
     * | 2  | bob@example.com  |
     * | 3  | john@example.com |
     * +----+------------------+
     * 输出:
     * +----+------------------+
     * | id | email            |
     * +----+------------------+
     * | 1  | john@example.com |
     * | 2  | bob@example.com  |
     * +----+------------------+
     * 解释: john@example.com重复两次。我们保留最小的Id = 1。
     */

    /*
        Create table If Not Exists Person (Id int, Email varchar(255))
        Truncate table Person
        insert into Person (id, email) values ('1', 'john@example.com')
        insert into Person (id, email) values ('2', 'bob@example.com')
        insert into Person (id, email) values ('3', 'john@example.com')
     */

    /*
        delete p1 from Person p1,Person p2
        where p1.email = p2.email and p1.Id > p2.Id
     */
}
