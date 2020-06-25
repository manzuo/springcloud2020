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