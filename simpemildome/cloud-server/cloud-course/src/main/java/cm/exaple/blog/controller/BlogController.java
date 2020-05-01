package cm.exaple.blog.controller;

import cm.exaple.blog.dao.BlogDao;
import cn.example.code.entity.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class BlogController {

//    @Resource
    /**
     * 此类用于用户获取数据与用户添加修改删除自己的文章
     */
    @Resource
    private BlogDao blogDao;
    @RequestMapping(value = "getdata/{page}", method = RequestMethod.GET)
    public Result getBlog(@PathVariable("page") int page){
        PageHelper.startPage(page,6);
        PageInfo pageInfo = new PageInfo(blogDao.selBlog());
        return Result.ok(pageInfo);
    }

    @RequestMapping(value = "show/{id}")
    public Result showBlog(@PathVariable("id") int id){
        blogDao.upReadBlog(id);//更新阅读次数
        return Result.ok(blogDao.selBlogBean(id));
    }

    @RequestMapping(value = "serch",method = RequestMethod.GET)
    public Result serch(@RequestBody String serch){
        return Result.ok(blogDao.selSerchBlog(serch));
    }

    @RequestMapping(value = "serch/{title}", method = RequestMethod.GET)
    public Result serchBlog(@PathVariable("title") String title){
        if (blogDao.selSerchBlog(title) != null) {
            return Result.ok(blogDao.selSerchBlog(title));
        }
        return Result.error("未找到当前数据");
    }

    //删除博客
    @RequestMapping(value = "delblog/{id}", method = RequestMethod.POST)
    public Result delBlog(@PathVariable("id") int id){
        if (blogDao.delBlog(id) > 0){
            return Result.ok();
        }
        return Result.error("删除失败");
    }
    @RequestMapping(value = "blogjson/{id}", method = RequestMethod.GET)
    public Result getBlogJson(@PathVariable("id") int id){
        return Result.ok(blogDao.selBlogBean(id));
    }

    @RequestMapping(value = "blogup", method = RequestMethod.POST)
    public Result upBlog( String title, String smple, String content, int id){
        blogDao.upBlog(title,content,smple,String.valueOf(id));
        return Result.ok();
    }

    //插入文章
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result add( String title, String content, String img){
        return Result.ok(blogDao.addBlog(title,content,img));
    }
}
