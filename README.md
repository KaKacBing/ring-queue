# ring-queue

#### 使用 Java 简单实现：下述功能
阅读博客:1分钟实现“延迟消息”功能 <https://www.w3cschool.cn/architectroad/architectroad-delay-message.html> 

#### 已实现
* 环形队列长度为60，间隔1秒执行一次step
* 实现延时60秒执行任务

#### 待完善
* 应用重启，则任务丢失，需设计 Task 任务落地存储，容灾恢复
* 环形队列长度，执行间隔时间可配置化
