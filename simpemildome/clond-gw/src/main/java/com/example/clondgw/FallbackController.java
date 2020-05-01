package com.example.clondgw;

import cn.example.code.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public Result fallback() {
        return Result.error(500, "服务不可用");
    }
}
