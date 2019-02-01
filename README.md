### java 基础测试3
#### EXAM1
使用sakila 数据库。
下载成功之后，将sakila-schema.sql 和sakila-data.sql 放在 项目根目录docker/mysql/文件夹下。
程序使用mysql + jdbc。 不得使用spring。
要求：
1、根据 Country ID。返回所有属于这个 Country 的 CityID 及名称。
Country ID: id
Country `name` 的城市
城市 ID | 城市名称
1 | A Corua (La Corua)
... | ...
2、根据 Customer ID。返回这个Customer中租的所的 Film，按租用时间倒排序。
上机编程题3.md 7/22/2018
2 / 2
Customer ID: id
`name` 租用的Film
Film ID | Film 名称 | 租用时间
628 | NORTHWEST POLISH | 2005-08-23 15:35:59 
... | ... | ...

3、项目根目录下需要docker/mysql/Dockerfile 文件用于构建mysql镜像，mysql 基础镜像使用
registry.saas.hand-china.com/tools/mysql:5.6。镜像中需要通过命令行依次导入sakila-schema.sql
和sakila-data.sql。MYSQL_ROOT_PASSWORD 通过docker-compose环境变量指定。
4、项目根目录下需要docker/java/Dockerfile 文件用于构建镜像，Java 基础镜像使用
registry.saas.hand-china.com/hap-cloud/base:latest。
5、数据库连接信息需要从java 的环境变量中读取。包含：ip、端口、数据库名、用户名、密码。环境变量配
置在docker-compose。
6、程序中使用的Country ID 和Customer ID 需要从环境变量中读取。环境变量配置在docker-compose。


### 运行
- 运行步骤
	- git clone git@github.com:feiwenli/JavaTest3.git
	- cd JavaTest3/
	- sh build.sh
	- sh start.sh

