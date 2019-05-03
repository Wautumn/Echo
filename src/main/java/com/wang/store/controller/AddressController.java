package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.Address;
import com.wang.store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 14:53
 */
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //获取某用户的所有地址
    @RequestMapping(value = "/getAddressByUser", method = RequestMethod.GET)
    public List<Address> GetAddressByUser(int userid) {
        return addressService.GetAddressByUser(userid);
    }

    @RequestMapping(value = "addAddress", method = RequestMethod.POST)
    public int AddAddress(@RequestBody JSONObject jsonObject) {
        Address address = new Address();
        int userid = Integer.parseInt(jsonObject.get("userid").toString());
        String name = jsonObject.get("name").toString();
        String phone = jsonObject.get("phone").toString();
        String province = jsonObject.get("province").toString();
        String city = jsonObject.get("city").toString();
        String district = jsonObject.get("district").toString();
        String detail = jsonObject.get("detail").toString();
        address.setUserid(userid);
        address.setName(name);
        address.setPhone(phone);
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);

        addressService.AddAddress(address);
        return address.getId();

    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    public String DeleteAddress(int id) {
        addressService.DeleteAddress(id);
        return "success";
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public String UpdateAddress(@RequestBody JSONObject jsonObject) {
        int id = Integer.parseInt(jsonObject.get("id").toString());
        Address address=addressService.GetAddressById(id);
        String name = jsonObject.get("name").toString();
        String phone = jsonObject.get("phone").toString();
        String province = jsonObject.get("province").toString();
        String city = jsonObject.get("city").toString();
        String district = jsonObject.get("district").toString();
        String detail = jsonObject.get("detail").toString();
        address.setName(name);
        address.setPhone(phone);
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        addressService.UpdateAddress(address);
        return "success";

    }
}
