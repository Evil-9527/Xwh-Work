＃Xwh-工作<br>

#1.使用IDEA内置工具操作DB2:<br>
cmd操作DB2，连接到数据库实体后创建数据表，如不指定Schema的名称，则创建到本机用户名对应的Schema下。
IDEA内置工具操作数据应当赋予数据库连接用户的权限，否则无法操作。cmd:db2 grant Dbadm on database to user dbuser（db2admin）
<br>
#2.存在问题：<br>
jpa方式给数据库插入数据时，应当传入一个对应实体对象，本代码传入对象的各个属性值。 
<br>任务1.2.4:xdemo1-2-4
<br>任务3：xdemo-3
