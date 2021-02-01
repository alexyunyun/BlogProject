# SSM框架学习笔记

## Day0

### 环境搭建

1. 创建maven工程并导入坐标
2. 创建实体类和dao接口
3. 创建Mybatis的主配置文件SqlMappingConfig.xml
4. 创建映射配置文件IUserDao.xml

注意事项：

1.  mybatis的映射配置文件位置必须和dao接口的包结构相同
2. 映射配置文件的mapper标签namespace属性的取值必须是dao接口的全限定类名
3. 映射配置文件的操作配置，id属性的取值必须是dao接口的方法名 

ONGL表达式，Object Graphic Navigation Language,对象图导航语言

它通过对象的取值方法来获取数据，在写法上把get省略了，如user.username

### 根据查询条件对象查询记录

QueryVO中的查询条件是综合的查询条件



### 当pojo中的属性名与数据库中的列名不对应的时候

1. 修改映射配置文件中的sql语句，即起别名，这种方法执行效率最高

2. 配置查询结果的列名和实体类的属性名的对应关系

   利用resultMap配置

### 配置properties

可以在标签内部配置连接数据库的信息，也可以通过属性引用外部配置文件信息

resource属性：常用的用于指定配置文件的位置，是按照类路径的写法写，并且必须存在于类路径下

url属性：是要求按照URL的写法来写，URL:Uniform Resource Locator 统一资源定位符。他是可以唯一标识一个资源的位置。URL组成：协议 主机 端口 URI

URI:Uniform Resource Identifier 统一资源标识符，他是在应用中可以唯一定位一个资源的。

如http://localhost:8080/mybatis/demo1Servlet



### typeAliases配置

用于配置别名，type属性指定的是实体类全限定类名，alias属性指定别名，当指定了别名就不再区分大小写。

<package name=""></package>用于指定要配置别名的包，当指定之后，该包下的实体类都会注册别名，并且类名就是别名，不再区分大小写。

![image-20210118211439704](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210118211439704.png)

## Day1

### 连接池

连接池: 作用是减少获取连接的时间

mybatis中的连接池

配置位置：

主配置文件SqlMappingConfig.xml中的datasource标签，type属性表示采用何种连接池方式

type属性的取值：

 POOLED：采用传统的javax.sql.DataSource规范中的连接池，mybatis中有针对规范的实现

UNPOOLED:采用传统的获取链接方式，虽然也实现javax.sql.DataSource接口，但是并没有使用池的方式

JNDI:采用服务器提供的JNDI技术实现，来获取DataSource对象，不同的服务器所能拿到的datasource是不一样的，且如果不是web或maven的war工程是不可使用的。

### 动态SQL

<where>和<if test="”>

### 多表查询

#### 一对多

一方实体类中包含多方的集合的引用，如List<Account> accounts

多方实体类中包含一方的引用，如 Private User user;

一方的映射配置文件中在resultMap中配置<collection>包含属性property和ofType，其中ofType表明集合中每个元素的封装类型

![image-20210119161600450](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210119161600450.png)

sql语句为![image-20210119161644230](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210119161644230.png)

多方的配置文件中需配置<association> ，需包含属性property，column和javaType，其中javaType表明要封装的Java类型

![image-20210119161748919](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210119161748919.png)

sql语句为

![image-20210119161812117](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210119161812117.png)







