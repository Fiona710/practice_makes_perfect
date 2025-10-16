# Practice Makes Perfect

熟能生巧 - leetcode刷题记录

## 项目介绍

用于练习leetcode刷题题目

## 技术栈

- Java 8
- Spring Boot 2.7.18
- Maven
- Lombok

## 快速开始

### 1. 编译项目

```bash
mvn clean install
```

### 2. 运行项目

```bash
mvn spring-boot:run
```

或者运行主类：`com.practice.pmp.PracticeMakesPerfectApplication`

### 3. 访问测试

应用启动后，访问以下地址：

- Hello接口: http://localhost:8080/api/hello
- 带参数: http://localhost:8080/api/hello?name=张亚琦
- 健康检查: http://localhost:8080/api/health

## 项目结构

```
practice_makes_perfect/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── practice/
│   │   │           └── pmp/
│   │   │               ├── PracticeMakesPerfectApplication.java  # 启动类
│   │   │               └── controller/
│   │   │                   └── HelloController.java              # 示例控制器
│   │   └── resources/
│   │       └── application.yml                                   # 配置文件
│   └── test/
│       └── java/
│           └── com/
│               └── practice/
│                   └── pmp/
│                       └── PracticeMakesPerfectApplicationTests.java
├── pom.xml                                                       # Maven配置
├── .gitignore
└── README.md
```

## 开发说明

- 端口: 8080
- 日志级别: DEBUG (com.practice.pmp 包)
- 编码: UTF-8

## 作者

zhangyaqi

## 日期

2025-10-15

