package cm.exaple.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此类用于管理用户文章，方法为删除与查看
 */
@RestController
public class AdminController {
    @RequestMapping(value = "account/end", method = RequestMethod.GET)
    public String end(){
        return "ok";
    }
}
