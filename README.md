### 克隆项目注意
+ 需要新建一个springcloud2020空文件夹（也可以叫其他名字）
+ 把这个文件夹作为项目的根目录，把文件都克隆到这个文件夹
+ idea打开项目时候，也以这个springcloud2020文件夹作为根目录

### 第一次提交
添加父工程pom
### 第二次提交
添加payment8001模块
### 第三次提交
+ 添加Order80模块，用来调用payment8001模块的接口
+ order80模块本身不连接数据库（在配置文件里不配置数据库连接），而是通过Springboot提供的restTemplate，通过http方式访问payment接口
### 第四次提交
+ 添加api-commons模块，存放一些通用的entity类（如Payment、CommonResult）
+ 执行maven-clean后，执行maven-install命令，将api-commons打包并装载到本地仓库，供其他模块声明引入
+ maven-install命令成功后，可以通过查看target\maven-archiver\pom.properties 获取api-commons jar包的在本地仓库的路径,比如:

```properties
#Generated by Maven
#Thu Jun 25 20:51:50 CST 2020
version=1.0-SNAPSHOT
groupId=org.manzuo
artifactId=cloud-api-commons

```
### 第五次提交
+ 添加eureka-server7001模块，用来作为一个服务注册中心
+ 通过在主启动类使用 `@EnableEurekaServer` 注解,声明该模块为服务注册中心
+ 服务注册中心模块需要引入以下依赖
```xml
    <!--eureka-server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```
+ 通过在主启动类使用 `@EnableEurekaClient` 注解,声明该模块为服务提供者
+ 服务提供者模块需要引入以下依赖
```xml
        <!--eureka-client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
``` 
+ 把payment8001模块、Order80模块作为服务注册在服务注册中心里
