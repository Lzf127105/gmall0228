package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.service.BaseAttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Lzf
 * @create 2019-06-09 22:38
 */
@Controller
public class AttrController {

    @Reference
    BaseAttrInfoService baseAttrInfoService;

    /**
     * 查询属性信息列表
     */
    @RequestMapping("/getAttrListByCtg3")
    @ResponseBody
    public List<BaseAttrInfo> getAttrListByCtg3(String catalog3Id){
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.getAttrListByCtg3(catalog3Id);
        return baseAttrInfoList;
    }


    /**
     * 保存属性
     */
    @RequestMapping("saveAttr")
    @ResponseBody
    public String saveAttr(BaseAttrInfo baseAttrInfo){
        baseAttrInfoService.saveAttr(baseAttrInfo);
        return "sucess";
    }
}
