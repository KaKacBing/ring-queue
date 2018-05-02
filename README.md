# ring-queue

#### 简单实现：下述功能
博客:1分钟实现“延迟消息”功能 <https://blog.csdn.net/jiangzhexi/article/details/62450277> 

#### 已实现
* 环形队列长度为60，间隔1秒执行一次step
* 实现延时60秒执行任务

#### 待完善
* Task 任务 落地存储，容灾恢复
* 环形队列长度，执行间隔时间可配置化
