package com.zjy.study.leetcodestudy.practice.Subject41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/28 8:49
 * @Description
 *      N 皇后
 */
public class Subject_0051 {
    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * 示例 1：
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     *
     * 示例 2：
     * 输入：n = 1
     * 输出：[["Q"]]
     */
    private static List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        List<List<String>> solutions = new ArrayList<>();
        solve(solutions,queens,n,0,0,0,0);
        return solutions;
    }

    private static void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2){
        if (row == n){
            List<String> board = generateBoard(queens,n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0){
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    private static List<String> generateBoard(int[] queens,int n){
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
