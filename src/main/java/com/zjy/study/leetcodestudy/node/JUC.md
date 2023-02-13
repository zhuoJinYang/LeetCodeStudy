
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

ReentrantLock 