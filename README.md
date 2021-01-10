# Think

> 工程师的首要技术使命就是控制复杂度，本项目结合COLA（整洁面向对象分层架构）实现。

## 使用 Maven archetype 创建项目

```shell
mvn archetype:generate  -DgroupId=com.amos -DartifactId=think -Dversion=1.0.0-SNAPSHOT -Dpackage=com.amos.think -DarchetypeArtifactId=cola-framework-archetype-web -DarchetypeGroupId=com.alibaba.cola -DarchetypeVersion=4.0.0
```

## 项目架构图

![项目架构图](doc/image/framework.png)

## 项目案例

用户登录、注册、查询用户列表

## 项目重构指北

重构项目时，可以先把模块下的包建好，然后把之前项目的代码迁到指定包。最后，按业务线连起来，调试、跑通。

## 个人想法

> 可能有错，有问题的话提个Issue，谢谢

- 公司用的用户表，一般都配了个用户信息表，用于保存用户的附加信息，细想一下，全放一起真的不行吗？
- 不要把领域对象和数据库中的存的xxxDO混为一谈；想一下，领域对象要创建人、修改人、逻辑删除标识有啥用？
- 一开始不要过度设计，需求增加的过程中，更能看清项目未来的方向；另外，不要把重构一直往后拖，越早重构越可控；

## COLA 规范

> 含有部分个人习惯

|规范|用途|解释|
|---|---|---|
|xxxCmd| Client Request | Cmd代表Command，表示一个用户请求 |
|xxxForm| Request Form | xxxCO？xxxRequest？个人感觉还是xxxForm比较好 |
|IxxxService| Api Service | xxxServiceI不太习惯，就把I放在前边吧 |
|xxxValidator| Validator | 校验器，用于校验的类 |
|xxxConvertor| Convertor | 转化器，实现不同层级对象互转（[小彩蛋](./doc/README.md#Convertor)） |
|xxxDO| Data Object | 数据对象，用于持久化 |

### 模块规范

> 没有银弹，仅做参考，按需取舍吧

![核心业务模块](doc/image/module-app.png)
![领域模块](doc/image/module-domain.png)
![基础设施模块](doc/image/module-infra.png)

### 《代码精进之路》摘录

> 要记住，留给公司一个方便维护、整洁优雅的代码库，是我们技术人员最高技术使命，也是我们对公司做出的最大技术贡献。

- 【日志规范】能用debug就不要用info，能用warn就不要用error。滥用的error与狼来了无疑；
- 【方法参数要少】参数越少，越容易理解，也便于测试，各个参数的组合就如笛卡尔积；
- 【空行规范】方法、逻辑分段，要加空行，提高代码可读性。车轮毂与车轴之间有空隙，车才能跑；书法绘画有留白；
- 【防止破窗】首先我们要有一套规范，并尽量遵守规范，不要做“打破第一扇窗”的人；其次，发现“破窗”要及时修复，不要让问题进一步恶化；
- 【三次原则】第一次用到某功能时，写一个特定的解决方法；第二次又用到时，复制上一次的代码；第三次出现时，就要着手写通用解决方案了；
- 【最小惊奇原则】写代码不是写侦探小说，要的是简单易懂，而不是时不时搞点烧脑的骚操作；
- 【请求读写分离】增删改，会改变对象的状态，只需返回成功失败即可；查询是不会改变对象状态的，对系统没副作用。

## 参考

- [https://github.com/alibaba/COLA](https://github.com/alibaba/COLA)

- [COLA 4.0：应用架构的最佳实践](https://blog.csdn.net/significantfrank/article/details/110934799)

- 张建飞著. 代码精进之路：从码农到工匠[M].北京：人民邮电出版社，2020.1
