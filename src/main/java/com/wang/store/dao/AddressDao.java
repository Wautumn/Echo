package com.wang.store.dao;

import com.wang.store.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 14:20
 */
@Mapper
@Component
public interface AddressDao {


    Address GetAddressById(int id);

    void AddAddress(Address address);

    List<Address> GetAddressByUserid(int useid);

    void DeleteAddress(int id);

    void UpdateAddress(Address address);
}
