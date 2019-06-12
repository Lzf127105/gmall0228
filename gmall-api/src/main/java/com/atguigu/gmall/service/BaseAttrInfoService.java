package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseAttrInfo;

import java.util.List;

/**
 * @author Lzf
 * @create 2019-06-09 22:46
 */
public interface BaseAttrInfoService {
    public List<BaseAttrInfo> getAttrListByCtg3(String catalog3Id);
}
