package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.entities.Customer;
import com.example.dao.mappers.CustomerMapper;
import com.example.model.RegisterEvent;
import com.example.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @author zetu
 * @date 2022/3/2
 */
@Service
@Slf4j
public class EventServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements EventService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAndPublish() {
        Integer customerId = this.createUser();
        if (Objects.nonNull(customerId)) {
            RegisterEvent event = new RegisterEvent();
            event.setTimestamp(System.currentTimeMillis());
            event.setCustomerId(customerId);
            applicationContext.publishEvent(event);
        }
//        System.out.println(1000 / 0);
    }

    public Integer createUser() {
        Customer customer = new Customer();
        customer.setAvatar("123");
        customer.setName("A");
        customer.setLoginName("A");
        customer.setEmail("123@abc.com");
        customer.setGender(1);
        customer.setStatus(0);
        customer.setDescription("");

        Date now = new Date();
        customer.setCreateTime(now);
        customer.setCreateBy(12);
        customer.setUpdateTime(now);
        customer.setUpdateBy("A");
        customer.setIsDelete(false);
        this.save(customer);

        return customer.getId();
    }

}
