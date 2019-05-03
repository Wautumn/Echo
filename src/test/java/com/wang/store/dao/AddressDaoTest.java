package com.wang.store.dao;

import com.wang.store.entity.Address;
import com.wang.store.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;

    @Test
    public void add() {
        Address address=new Address();
        address.setUserid(1);
        address.setProvince("上海");
        address.setCity("上海");
        address.setDistrict("嘉定");
        address.setDetail("同济大学");
        address.setName("王花花1");
        address.setPhone("12345");
        addressDao.AddAddress(address);
        System.out.println(address.getId());
    }

    @Test
    public void get() {
        List<Address> addresses=addressDao.GetAddressByUserid(1);
        for(Address address:addresses){
            System.out.println(address.getName());
        }

    }

    @Test
    public void delete() {
        addressDao.DeleteAddress(1);

    }

    @Test
    public void update() {
        Address address=addressDao.GetAddressById(2);
        address.setName("王花花更新");
        addressDao.UpdateAddress(address);
    }
}
