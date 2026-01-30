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