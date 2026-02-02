## OOM
- Java 堆用于存放对象实例
- OOM: Java heap space 表示堆内存耗尽
- 持有对象引用会导致内存无法回收
## GC
- Minor GC 回收新生代
- GC 发生会 STW
- GC 日志是性能分析的重要依据
- Full GC 会回收整个堆，STW 时间长
- Full GC 频繁出现通常是危险信号
- 内存泄漏的本质是对象可达性未断开
- 静态集合是常见泄漏源
## stack
- 每个线程有独立的 JVM 栈
- -Xss 决定单线程栈大小
- 线程过多会导致 native thread OOM
- 线程池大小必须受控
## 类加载
- 类由 ClassLoader 加载，不是 JVM
- 双亲委派保证核心类安全
- ContextClassLoader 用于 SPI
- 类加载问题本质是命名空间隔离


