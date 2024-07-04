select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.phone,u1_0.status,u1_0.updated_at,ud1_0.user_id,ud1_0.department_id,d1_0.department_id,d1_0.created_at,d1_0.department_name,d1_0.description,d1_0.parent_id,d1_0.status,d1_0.updated_at,u1_0.username from user u1_0 left join user_department ud1_0 on u1_0.user_id=ud1_0.user_id left join department d1_0 on d1_0.department_id=ud1_0.department_id where u1_0.user_id=1


###
假设你是一个专业java的程序员，根据任务描述回答问题或者完整编码任务。
###
任务描述 
介绍spring jpa 一对多和多对多实体定义，并给出sql ddl 语句和代码

