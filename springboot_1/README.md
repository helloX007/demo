# Getting Started

### 概述
这个springboot项目，用来尝试springboot中应用一些技术

### Guides
--com.demo.springboot_1.listener.InitListener是实现了一个ServletContextListener,
实现的listener会在应用启动的时候执行init方法，应用结束的时候执行destory方法，
实现类添加了@WebListener注解标识这是一个listener，应用启动类上添加了@ServletComponentScan让spring去扫描listener实现得以生效。

--devtools热部署相关，文档记录在了博客上：https://blog.csdn.net/charberming/article/details/104046564