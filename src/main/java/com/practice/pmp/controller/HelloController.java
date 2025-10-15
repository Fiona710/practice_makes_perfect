package com.practice.pmp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello World 示例Controller
 * 
 * @author zhangyaqi
 * @date 2025-10-15
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * 简单的Hello接口
     */
    @GetMapping("/hello")
    public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Hello, " + name + "!");
        result.put("timestamp", System.currentTimeMillis());
        result.put("success", true);
        return result;
    }

    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "UP");
        result.put("application", "Practice Makes Perfect");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

}

