- SSH结构
- web.xml配置对spring容器管理
- spring--config.xml配置数据源及会话工厂
- 更换数据库请调整dataSource和sesionFactory
- 事务管理采用@transcational注解
- 采用Hibernate注解形式完成ORM映射
- 测试成功增加、查询病人
- 暂未涉及web页面

----

# 重要更新（项目结构调整）

- 新增doTest目录，用于项目测试，采用Junit测试，需要自己添加Junit测试环境
- 数据库更换为Mysql，新增目录sql，存放数据库脚本
- test测试通过查询及插入数据