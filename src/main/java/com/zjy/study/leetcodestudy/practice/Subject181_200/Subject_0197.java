package com.zjy.study.leetcodestudy.practice.Subject181_200;

/**
 * @Author zjy
 * @Date 2023/3/15 10:21
 * @Description
 *      上升的温度
 */
public class Subject_0197 {
    /**
     * SQL架构
     * 表： Weather
     *
     * +---------------+---------+
     * | Column Name   | Type    |
     * +---------------+---------+
     * | id            | int     |
     * | recordDate    | date    |
     * | temperature   | int     |
     * +---------------+---------+
     * id 是这个表的主键
     * 该表包含特定日期的温度信息
     *
     *
     * 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
     *
     * 返回结果 不要求顺序 。
     *
     * 查询结果格式如下例。
     *
     *
     * 示例 1：
     *
     * 输入：
     * Weather 表：
     * +----+------------+-------------+
     * | id | recordDate | Temperature |
     * +----+------------+-------------+
     * | 1  | 2015-01-01 | 10          |
     * | 2  | 2015-01-02 | 25          |
     * | 3  | 2015-01-03 | 20          |
     * | 4  | 2015-01-04 | 30          |
     * +----+------------+-------------+
     * 输出：
     * +----+
     * | id |
     * +----+
     * | 2  |
     * | 4  |
     * +----+
     * 解释：
     * 2015-01-02 的温度比前一天高（10 -> 25）
     * 2015-01-04 的温度比前一天高（20 -> 30）
     */

    /*
        Create table If Not Exists Weather (id int, recordDate date, temperature int)
        Truncate table Weather
        insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')
        insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')
        insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')
        insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')
     */

    /*
        select w1.id
        from Weather w1,Weather w2
        where DATEDIFF(w1.recordDate,w2.recordDate) = 1
        and w1.Temperature > w2.Temperature
     */
}
