package com.zjy.study.leetcodestudy.practice.Subject181_200;

/**
 * @Author zjy
 * @Date 2023/3/15 9:38
 * @Description
 *      查找重复的电子邮箱
 */
public class Subject_0182 {
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
     * id 是该表的主键列。
     * 此表的每一行都包含一封电子邮件。电子邮件不包含大写字母。
     *
     *
     * 编写一个 SQL 查询来报告所有重复的电子邮件。 请注意，可以保证电子邮件字段不为 NULL。
     *
     * 以 任意顺序 返回结果表。
     *
     * 查询结果格式如下例。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * Person 表:
     * +----+---------+
     * | id | email   |
     * +----+---------+
     * | 1  | a@b.com |
     * | 2  | c@d.com |
     * | 3  | a@b.com |
     * +----+---------+
     * 输出:
     * +---------+
     * | Email   |
     * +---------+
     * | a@b.com |
     * +---------+
     * 解释: a@b.com 出现了两次。
     */

    /*
        Create table If Not Exists Person (id int, email varchar(255))
        Truncate table Person
        insert into Person (id, email) values ('1', 'a@b.com')
        insert into Person (id, email) values ('2', 'c@d.com')
        insert into Person (id, email) values ('3', 'a@b.com')
     */

    /*
        select email
        from Person
        group by email
        having count(email) > 1
     */
}
