基本类型：
byte、short、int、long、char、float、double、boolean

BIO(同步阻塞)：一个连接一个线程
NIO(同步非阻塞)：一个请求一个线程
AIO(异步非阻塞)：一个有效请求一个线程

反射：运行时通过class,constructor,field,method四个方法获取一个类的各个组成部分
序列化(实现Serializable接口)：传递和保存对象,保存对象的完整性和可传递性

java中,为什么不允许静态方法中访问非静态变量?:
静态变量属于类本身,在类加载的时候就分配了内存空间,可以通过类名直接访问.
非静态变量属于类的对象,只有在类对象产生时,才会分配内存,通过类实例访问.

HashMap:
基于map接口,元素以键值对方式存储,允许有null值,线程不安全
初始化大小默认16,2倍扩容,负载因子0.75
JDK1.7采用数组+链表存储
JDK1.8采用数组+链表+红黑树存储(链表长度超过阈值[8])

jsp,servlet?:
servlet是服务端的java程序,担当客户端和服务端的中间层
jsp是java服务器页面,本质是简化的servlet设计,目的是将表示逻辑从servlet中分离出来
JVM只能识别java代码,不能识别jsp,jsp编译成JVM能识别的servlet
jsp有内置对象,servlet没有内置对象

jsp内置对象?:
1.pageContext,页面上下文对象
2.request
3.response
4.session
5.application,应用程序对象
6.page,JSP本身
7.exception
8.out,用于在web浏览器内输出信息,管理应用服务器上的缓冲区,作用域page
9.config,获取服务器的配置信息

session,cookie?:
存储位置:
    cookie存储在客户端浏览器,session存储在服务器
存储容量:
    cookie<=4k,一个站点最多保留20个cookie,
    session没有上线,出于对服务器的保护,session内不可存储过多东西,并且要设置session删除机制
存储方式:
    cookie只能保存ASCII字符串,需要通过编码方式存储为Unicode字符或者二进制数据
    session能存储任何类型的数据
隐私策略:
    cookie对客户端可见,不安全
    session存储在服务器,安全
有效期:
    开发可以通过设置cookie属性,达到使cookie长期有效
    session依赖于JESSIONID的cookie,cookie JSESSIONID的过期时间默认为-1，
        关闭窗口该session就会失效，因而session达不到长期有效的效果
跨域支持:
    cookie支持跨域
    session不支持跨域

客户端禁止cookie,实现session使用:
1.通过url重写,把sessionid作为参数追加在原url中,后续的浏览器与服务器交互中携带sessionid参数
2.服务器返回数据包含sessionid,浏览器发送请求,携带sessionid参数
3.通过http协议的其他header字段,服务器每次返回时设置该header字段信息,
    浏览器中js读取该header字段,请求服务器时,js设置携带该header字段

xss攻击?:
xss(Cross Site Scripting),跨站脚本攻击,一种常见于web应用程序中的计算机安全漏洞
预防:
1.获取用户的输入,不用innerHtml,用innerText
2.对用户输入过滤,如对&<>"'/等转义