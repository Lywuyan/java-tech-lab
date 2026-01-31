## synchronized 解决的问题
- 确保临界区互斥
- 保证可见性
## synchronized 的局限
- 粒度固定
- 无法中断
- 无超时机制
## synchronized vs ReentrantLock（核心对比）
  维度	synchronized	ReentrantLock
  自动释放	✅	            ❌
  可中断	    ❌	            ✅
  公平锁	    ❌	            ✅
  超时	    ❌	            ✅
  灵活性	    低	            高
## 线程池
不推荐使用 Executors 创建线程池，因为它们要么使用无界队列，要么使用无界线程，存在 OOM 风险。
生产环境中我会显式使用 ThreadPoolExecutor，并根据业务场景设置有界队列和合理的拒绝策略。
## CountDownLatch
CountDownLatch 是一个同步工具类，它允许一个或多个线程等待直到其他线程完成执行。
## Semaphore
Semaphore 是一个计数信号量，它可以控制同时访问的线程数量，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
## CyclicBarrier
CyclicBarrier 是一个同步工具类，它允许一组线程互相等待，直到到达某个公共屏障点。
### 总结
CountDownLatch：一次性等待多个任务完成
Semaphore：限制同时访问资源的线程数量
CyclicBarrier：多线程分阶段同步
## Atomic 和 Lock 对比
Atomic：原子操作，线程安全，性能高，非阻塞
Lock：锁，线程安全，性能低，阻塞型