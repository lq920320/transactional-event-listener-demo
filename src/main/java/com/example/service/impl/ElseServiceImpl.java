package com.example.service.impl;

import com.example.dao.entities.Customer;
import com.example.service.CustomerService;
import com.example.service.ElseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO description
 *
 * @author zetu
 * @date 2022/3/4
 */
@Service
@Slf4j
public class ElseServiceImpl implements ElseService {

    @Autowired
    private CustomerService customerService;

    @Override
    public void doSomethingElse() {
        customerService.save(customerService.buildByName("case1"));
        throw new RuntimeException("我是异常！");
    }

    @Override
    public void doSomethingElse2() {
        try {
            customerService.save(customerService.buildByName("case2"));
            throw new RuntimeException("我是异常！");
        } catch (Exception e) {
            log.error("there is an exception {} ", e.getMessage());
        }
    }

    @Override
    public void doSomethingElse3() {
        customerService.save(customerService.buildByName("case3"));
        throw new RuntimeException("我是异常！");
    }

    @Override
    public void doSomethingElse4() {
        try {
            Customer customer = customerService.buildByName("case4-aaaaaaaaaaaaaskajhkdhasjkhdjahsfjgsdjgfhsjdyfjsdbvjhsjhadjysda");
            customerService.save(customer);
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doSomethingElse5() {
        customerService.save(customerService.buildByName("case5"));
        throw new RuntimeException("我是异常！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doSomethingElse6() {
        try {
            customerService.save(customerService.buildByName("case6"));
            throw new RuntimeException("我是异常！");
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doSomethingElse7() {
//        customerService.save(customerService.buildByName("case7"));
        throw new RuntimeException("我是异常！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doSomethingElse8() {
        try {
            throw new RuntimeException("我是异常！");
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
    }

    @Override
    // @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void doSomethingElse9() {
        customerService.save(customerService.buildByName("case9"));
        throw new RuntimeException("我是异常！");
    }

    @Override
    //    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void doSomethingElse10() {
        try {
            customerService.save(customerService.buildByName("case10"));
            throw new RuntimeException("我是异常！");
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
    }
}
