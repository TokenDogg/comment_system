# comment_system
 评论系统

## 功能模块1:设计评论系统，注意评论是对【帖子】进行的，比如小红书，或者朋友圈等动态。
1. 需要有Controller层，提供Http调用接口
2. 能够通过Postman等工具可以进行如下操作:8:
   - 能够创建评论 
   - 能够对创建的评论A 进行评论
   - 能够对创建的评论B 进行评论
   - 能够对评论进行分页查询
   - 能够根据评论ID进行查询评论详情
   - 能够对评论进行举报
   - 能够对评论进行点赞
   - 请自由发挥对评论进行排序 
## 功能2:
1. 用户对发布的 【帖子】评论后，用户的评论点赞，需要设计系统通知被点赞。

## 表结构脚本是 db_comments.sql 
## 配置文件位于src/main/resources/application.properties
## Postman:
- https://api.postman.com/collections/37469485-ca94f9f4-cffb-4f9e-8e63-51a33e91e65d?access_key=PMAT-01J4JWSTP4CF17C1DXAWHGEDAP