
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

线程池：三大方式,七大参数,四种拒绝策略
程序运行，本质：占用系统资源！优化资源的使用 =》 池化技术(线程池、连接池、内存池、对象池)[创建、销毁，十分浪费资源]

池化技术：事先准备好一些资源,如果有人要用，就来我这里拿，用完了之后还给我，以此来提高效率
1、降低资源消耗
2、提高响应速度
3、方便线程管理
(不允许用Executors去创建线程池,而是通过ThreadPoolExecutor的方式,
Executors和singleThreadPool允许请求队列长度为Integer.MAX_VALUE,会堆积大量的请求,从而导致OOM,
CachedThreadPool允许创建线程数量为Integer.MAX_VALUE,可能创建大量的线程,从而导致OOM)