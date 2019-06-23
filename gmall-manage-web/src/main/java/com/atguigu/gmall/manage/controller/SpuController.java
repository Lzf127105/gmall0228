package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.manage.util.MyFastdfsUploadUtils;
import com.atguigu.gmall.service.BaseAttrInfoService;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Lzf
 * @create 2019-06-09 22:38
 */
@Controller
public class SpuController {

    @Reference
    SpuInfoService spuInfoService;

    /**
     * 查询属性信息列表
     */
    @RequestMapping("/getSpuInfoList")
    @ResponseBody
    public List<SpuInfo> getSpuInfoList(String catalog3Id){
        List<SpuInfo> spuInfos = spuInfoService.getSpuInfoList(catalog3Id);
        return spuInfos;
    }


    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrs = spuInfoService.baseSaleAttrList();
        return baseSaleAttrs;
    }

    @RequestMapping("/saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo){
        spuInfoService.saveSpu(spuInfo);
        return "success";
    }

    @RequestMapping("/uploadSpuImg")
    @ResponseBody
    public String uploadSpuImg(@RequestParam("file") MultipartFile file){
        String httpPath = MyFastdfsUploadUtils.uploadImage(file);
        return httpPath;
    }
}
