package com.example.cloudserverclient.service;

import cn.example.code.entity.BlogBean;
import cn.example.code.entity.Result;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 对博客的阅读，添加，删除
 */
@FeignClient(value = "GATEWAY", fallbackFactory = FallbackBlogError.class)
public interface ServletBlog {
    @RequestMapping(value = "getdata/{page}")
    Result getBlog(@PathVariable("page") int page);

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    Result showBlog(@PathVariable("id") int id);

    @RequestMapping(value = "serch/{title}", method = RequestMethod.GET)
    Result serchBlog(@PathVariable("title") String title );

    @RequestMapping(value = "delblog/{id}", method = RequestMethod.POST)
    Result delBlog(@PathVariable("id") int id);

    @RequestMapping(value = "blogjson/{id}", method = RequestMethod.GET)
    Result getBlogJson(@PathVariable("id") int id);

    @RequestMapping(value = "blogup", method = RequestMethod.POST)
    Result upBlog(@RequestParam String title,@RequestParam String smple,@RequestParam String content,@RequestParam int id);

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result add(@RequestParam String title,@RequestParam String content,@RequestParam String img);
}
