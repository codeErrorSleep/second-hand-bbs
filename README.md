
![lYzB5Q.png](https://s2.ax1x.com/2020/01/02/lYzB5Q.png)


# second-hand-bbs

本项目是一个基于spring boot和spring data jpa的校园二手交易论坛,前端页面主要使用bootstrap4来完成,部分样式参考了一个西班牙购物网站.



## 更新

- 新增spring security权限管理
- 重构部分代码
- 更新新的角色管理
- 在管理员页面增加数据可视化组件





## 技术栈
- spring boot
- spring data jpa
- mysql
- spring security
- thymeleaf
- bootstrap4

## 功能介绍
- 分为用户和管理员两大部分,管理员能够管理大部分信息
- 购买链接通过添加微信,添加qq来实现
- 能够对产品进行留言
- 能够对个人的闲置物品和个人信息进行修改删除

## 快速运行
1. 克隆本项目到本地

    ` git clone git@github.com:504250439/second-hand-bbs.git `

2. 先在mysql中新建一个 spring 数据库,然后导入本项目中mysql文件夹下的三个sql文件.

3. 根据自己本地情况修改数据库配置，数据库配置在SpringBoot项目的application.properties中

4. 在IntelliJ IDEA中运行项目

**OK，至此，服务端就启动成功了，此时我们直接在地址栏输入**

> **http://localhost:8080/index**

**http://localhost:8080/admin/login** 进入后台管理员页面

**即可访问我们的项目.**

## 注意事项
1. 如果导入后只显示项目中的文件，不显示项目结构.可参考[此文章](https://blog.csdn.net/junge1545/article/details/94400741)来解决
2. 产品图片保存在本地的 E盘second-hand-bbs文件夹当中,可在application.properties中修改图片文件保存位置.


## 部分界面截图
![主界面](https://s2.ax1x.com/2020/01/02/ltCrwV.md.png)

![商品详情页面](https://s2.ax1x.com/2020/01/02/ltCWl9.md.png)

![个人的管理页面](https://s2.ax1x.com/2020/01/02/ltCLSH.md.png)



## todo
- 增加redis保存session
- 整理项目(删除多余部分)
- 同类推荐功能

## 最后,希望朋友们顺手点个star,谢谢啦.