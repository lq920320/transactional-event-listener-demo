package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.entities.Customer;
import com.example.dao.mappers.CustomerMapper;
import com.example.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zetu
 * @date 2022/3/4
 */
@Service
@Slf4j
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {


    @Override
    public Customer buildByName(String name) {
        Customer customer = new Customer();
        customer.setAvatar("456");
        customer.setName(name);
        customer.setLoginName(name);
        customer.setEmail("456@abc.com");
        customer.setGender(0);
        customer.setStatus(0);
        customer.setDescription("");

        Date now = new Date();
        customer.setCreateTime(now);
        customer.setCreateBy(name);
        customer.setUpdateTime(now);
        customer.setUpdateBy(name);
        customer.setIsDelete(false);
        return customer;
    }
}
