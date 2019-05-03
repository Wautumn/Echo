package com.wang.store.service;

import com.wang.store.dao.AddressDao;
import com.wang.store.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 14:45
 */
@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;

    public Address GetAddressById(int id){
        return addressDao.GetAddressById(id);
    }

    public int AddAddress(Address address){
        addressDao.AddAddress(address);
        return address.getId();
    }

    public List<Address> GetAddressByUser(int userid){
        List<Address> addresses=addressDao.GetAddressByUserid(userid);
        return addresses;
    }

    public void DeleteAddress(int id){
        addressDao.DeleteAddress(id);
    }

    public void UpdateAddress(Address address){
        addressDao.UpdateAddress(address);
    }
}
