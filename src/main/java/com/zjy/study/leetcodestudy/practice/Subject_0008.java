package com.zjy.study.leetcodestudy.practice;

/**
 * @Author zjy
 * @Date 2023/2/9 8:32
 * @Description
 *      字符串转换整数 (atoi)
 */
public class Subject_0008 {
    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 1。读入字符串并丢弃无用的前导空格
     * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 5.如果整数数超过 32 位有符号整数范围 [−2(31),  2(31) − 1] ，需要截断这个整数，使其保持在这个范围内。
     * 具体来说，小于 −2(31) 的整数应该被固定为 −2(31) ，大于 2(31) − 1 的整数应该被固定为 2(31) − 1 。
     * 6.返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *  
     *
     * 示例 1：
     * 输入：s = "42"
     * 输出：42
     * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："42"（读入 "42"）
     *            ^
     * 解析得到整数 42 。
     * 由于 "42" 在范围 [-2(31), 2(31) - 1] 内，最终结果为 42 。
     *
     * 示例 2：
     * 输入：s = "   -42"
     * 输出：-42
     * 解释：
     * 第 1 步："   -42"（读入前导空格，但忽视掉）
     *             ^
     * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     *              ^
     * 第 3 步："   -42"（读入 "42"）
     *                ^
     * 解析得到整数 -42 。
     * 由于 "-42" 在范围 [-2(31), 2(31) - 1] 内，最终结果为 -42 。
     *
     * 示例 3：
     * 输入：s = "4193 with words"
     * 输出：4193
     * 解释：
     * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     *              ^
     * 解析得到整数 4193 。
     * 由于 "4193" 在范围 [-2(31), 2(31) - 1] 内，最终结果为 4193 。
     */
    private static int myAtoi(String s) {
        int len =  s.length(), left = 0;
        for(; left < len; left++){
            // 需要去除头部空格
            if( s.charAt(left) != ' ') {
                break;
            }
        }
        if(left == len) {
            return 0;
        }
        // 用int来保存优雅: res，边界：boundary
        int res = 0, flag = 1, boundary = 214748364;
        // 需要变量来保存符号位:flag
        if( s.charAt(left) == '-'){
            flag = -1;
            left++;
        }else if( s.charAt(left) == '+'){
            left++;
        }
        for(; left < len; left++){
            // 碰到不是数字时，就可以break
            if( s.charAt(left) > '9' ||  s.charAt(left) < '0') {
                break;
            }
            /*
                题目要求不能超过int范围，所以需要判断结果是否越界：
                    1. 因为res每次都会 * 10 ，所以外面定义了一个int最大值除以10的数字：214748364
                    res > boundary 意思是，此时res已经大于number了，他 * 10 一定越界；

                    2. res == boundary && str.charAt(left) > '7' 的意思是，当res == 214748364
                    此时res * 10 变成 2147483640 此时没越界，但是还需要 + str.charAt(left)- '0'，
                    而int最大值为 2147483647，所以当str.charAt(left) > '7'时会越界

                    3. 有的人疑惑，-2147483648 可以到8呢
                        假设flag == -1，也就是负数，并且res == boundary && str.charAt(left) > '7'，此时看return
                            return flag == 1 ?Integer.MAX_VALUE : Integer.MIN_VALUE;
                            所以不会错
             */
            if(res > boundary || (res == boundary &&  s.charAt(left) > '7'))
                // 最终返回时判断正负
            {
                return flag == 1 ?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 +  s.charAt(left) - '0';
        }
        // 最终返回时判断正负
        return flag * res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("4193 with words"));
    }
    /**
     * 感想：
     *      纯纯逻辑题,加油,未来可期
     */
}
