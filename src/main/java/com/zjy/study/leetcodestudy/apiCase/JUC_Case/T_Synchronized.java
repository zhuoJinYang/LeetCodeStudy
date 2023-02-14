package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

/**
 * @Author zjy
 * @Date 2023/2/14 13:07
 * @Description
 *      synchronized 案例
 */
public class T_Synchronized {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"C").start();
    }

    private static class Ticket{
        private int num = 30;
        public synchronized void sale(){
            if (num > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (num--) + "张票，剩余" + num + "张票");
            }
        }
    }
}
