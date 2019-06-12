package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Lzf
 * @create 2019-06-09 22:46
 */
public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {

    public List<BaseAttrInfo> getAttrListByCtg3(String catalog3Id);
}
