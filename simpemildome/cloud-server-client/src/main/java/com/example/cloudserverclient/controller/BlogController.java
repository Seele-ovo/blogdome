package com.example.cloudserverclient.controller;

import cn.example.code.entity.Result;
import com.example.cloudserverclient.service.ServletBlog;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * 用户端 用于查找博客，搜索博客，阅读博客
 * 管理员端，增加博客，删除博客，修改博客，查询博客
 */
@RestController
public class BlogController {

    @Resource
    private ServletBlog servletBlog;
    //获取数组动态生成标签
    @RequestMapping(value = "getdata/{page}", method = RequestMethod.GET)
    public Result getBlog(@PathVariable("page") int page){
        return servletBlog.getBlog(page);
    }
    //根据id获取单个页面内容显示
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public ModelAndView showBlog(@PathVariable("id") int id){
        ModelAndView mode = new ModelAndView();
        mode.addObject("model",servletBlog.showBlog(id));
        mode.setViewName("detail");
        return mode;
    }
    @RequestMapping(value = "serch/{title}", method = RequestMethod.GET)
    public Result serch(@PathVariable("title") String title){
        return servletBlog.serchBlog(title);
    }

    @RequestMapping(value = "delblog/{id}", method = RequestMethod.POST)
    public Result delBlog(@PathVariable("id") int id){
        return servletBlog.delBlog(id);
    }
    @RequestMapping(value = "blogjson/{id}", method = RequestMethod.GET)
    public Result getBlogJson(@PathVariable("id") int id){
       return  servletBlog.showBlog(id);
    }

    @RequestMapping(value = "blogup", method = RequestMethod.POST)
    public Result upBlog(@RequestParam String title,@RequestParam String smple,@RequestParam String content,@RequestParam("id") int id){

        return servletBlog.upBlog(title,smple,content,id);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result add(String title, String content, String img){
        return servletBlog.add(title,content,img);
    }

}
