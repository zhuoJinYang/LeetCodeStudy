
实现多线程的方式：
1.继承Thread类
2.实现Runnable接口
3.实现Callable接口
4.线程池

```java
// Thread.State
public enum State {
    NEW,//新建     
    RUNNABLE,//准备就绪       
    BLOCKED, //阻塞        
    WAITING,//一直等待
    TIMED_WAITING,//超时等待，过时不候
    TERMINATED;//终止
}
```

synchronized            Lock
Java关键字                接口
无法判断获取锁的状态      可以判断是否获取锁
自动释放锁                手动释放锁
未获得锁的线程一直等待     线程不会一直等待
可重入锁,非公平        可重入锁,默认非公平
适合锁少量同步代码       适合锁大量同步代码

常用的辅助类：
1.CountDownLatch(减法计数器)
2.CyclicBarrier(加法计数器)
3.Semaphore(信号量)
