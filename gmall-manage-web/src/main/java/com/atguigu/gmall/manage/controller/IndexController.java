package com.atguigu.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lzf
 * @create 2019-06-09 15:22
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("attrListPage")
    public String getAttrListPage(){
        return "attrListPage";
    }

}
