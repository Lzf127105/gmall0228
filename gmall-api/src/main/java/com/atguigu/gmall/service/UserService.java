package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getUserInfoListAll();

    public void addUser(UserInfo userInfo);

    public void updateUser(String id, UserInfo userInfo);

    public List<UserAddress> getAddressListByUser(String userId);

    List<UserInfo> userList();

    UserAddress getUserAddressByAddressId(String deliveryAddress);
}
