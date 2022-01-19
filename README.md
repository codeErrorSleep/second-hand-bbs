
![lYzB5Q.png](https://s2.ax1x.com/2020/01/02/lYzB5Q.png)


# second-hand-bbs

本项目是一个基于spring boot和spring data jpa的校园二手交易论坛,前端页面主要使用bootstrap4来完成,部分样式参考了一个西班牙购物网站.



## 更新

- 新增验证码注册效果(功能仍为完善)
- 修改搜素功能和同类推荐
- 优化注册与登录模块
- 修复商品上传问题
- 新增thymeleaf模板,增加复用
- 新增spring security权限管理
- 重构部分代码
- 更新新的角色管理
- 在管理员页面增加数据可视化组件



### TODO

- 修复用户更新功能
- 解决角色与用户之间的冲突
- 添加监控模块
- 整理项目(删除多余部分)
- 同类推荐功能

## 技术栈

- spring boot
- spring data jpa
- mysql
- spring security
- redis
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

2. 先在mysql中新建一个 db_second_hand_bbs数据库,然后导入本项目中mysql文件夹下的sql文件

3. 根据自己本地情况修改数据库配置，数据库配置在SpringBoot项目的application.properties中

4. 在IntelliJ IDEA中运行项目

**OK，至此，服务端就启动成功了，此时我们直接在地址栏输入**

> **http://localhost:8080/index**

**http://localhost:8080/admin/login** 进入后台管理员页面

**即可访问我们的项目.**

可以使用管理员用户账号密码都是aaa



## 注意事项
1. 如果导入后只显示项目中的文件，不显示项目结构.可参考[此文章](https://blog.csdn.net/junge1545/article/details/94400741)来解决
2. 产品图片保存在本地的 E盘second-hand-bbs文件夹当中,可在application.properties中修改图片文件保存位置.
3. redis目前主要用来保存验证码信息,如果不打开redis服务器的话会报一个error 的错误,可以不用管.(不过最好还是开启一下吧)


## 部分界面截图
![主界面](https://s2.ax1x.com/2020/01/02/ltCrwV.md.png)

![商品详情页面](https://s2.ax1x.com/2020/01/02/ltCWl9.md.png)

![个人的管理页面](https://s2.ax1x.com/2020/01/02/ltCLSH.md.png)




## 最后,希望朋友们顺手点个star,谢谢啦.
