## Netty
- Netty 基于 NIO，但封装了 Selector 细节
- EventLoop 采用少线程多连接模型
- ChannelPipeline 实现责任链解耦
- Handler 只关注业务逻辑

- ChannelPipeline 是双向责任链
- Inbound 事件从前向后传播
- Outbound 事件从后向前传播
- Handler 顺序错误会导致数据丢失
