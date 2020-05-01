package com.example.cloudserverclient.service;


import cn.example.code.entity.BlogBean;
import cn.example.code.entity.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FallbackBlogError implements FallbackFactory<ServletBlog> {

    @Override
    public ServletBlog create(Throwable throwable) {
        return new ServletBlog() {
            @Override
            public Result getBlog(int page) {
                return Result.error("发生错误");
            }

            @Override
            public Result showBlog(int id) {
                return Result.error("发生错误");
            }

            @Override
            public Result serchBlog(String serch) {
                return Result.error("发生错误");
            }

            @Override
            public Result delBlog(int id) {
                return Result.error("发生错误");
            }

            @Override
            public Result getBlogJson(int id) {
                return Result.error("发生错误");
            }

            @Override
            public Result upBlog(String title, String smple, String content, int id) {
                return Result.error();
            }

            @Override
            public Result add(String title, String content, String img) {
                return Result.error();
            }

        };
    }
}