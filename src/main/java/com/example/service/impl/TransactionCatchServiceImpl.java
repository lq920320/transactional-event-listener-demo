package com.example.service.impl;

import com.example.service.CustomerService;
import com.example.service.ElseService;
import com.example.service.TransactionCatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zetu
 * @date 2022/3/4
 */
@Service
@Slf4j
public class TransactionCatchServiceImpl implements TransactionCatchService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ElseService elseService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String catch1() {
        // save data
        customerService.save(customerService.buildByName("catch1"));
        try {
            elseService.doSomethingElse();
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
        return "success";
    }

    @Override
    public String catch2() {
        // save data
        customerService.save(customerService.buildByName("catch2"));
        elseService.doSomethingElse2();
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String catch3() {
        // save data
        customerService.save(customerService.buildByName("catch3"));
        try {
            elseService.doSomethingElse3();
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
        return "success";
    }

    @Override
    public String catch4() {
        // save data
        customerService.save(customerService.buildByName("catch4"));
        elseService.doSomethingElse4();
        return "success";
    }


    @Override
    public String catch5() {
        // save data
        customerService.save(customerService.buildByName("catch5"));
        try {
            elseService.doSomethingElse5();
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
        return "success";
    }

    @Override
    public String catch6() {
        // save data
        customerService.save(customerService.buildByName("catch6"));
        elseService.doSomethingElse6();
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String catch7() {
        // 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在主方法中try-catch
        // save data
        customerService.save(customerService.buildByName("catch7"));
        try {
            elseService.doSomethingElse7();
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String catch8() {
        // 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在从方法中try-catch
        // save data
        customerService.save(customerService.buildByName("catch8"));
        elseService.doSomethingElse8();
        return "success";
    }

    @Override
    public String catch9() {
        // 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在主方法中try-catch
        // save data
        customerService.save(customerService.buildByName("catch9"));
        try {
            elseService.doSomethingElse9();
        } catch (Exception e) {
            log.info("there is an exception {} ", e.getMessage());
        }
        return "success";
    }

    @Override
    public String catch10() {
        // 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在从方法中try-catch
        // save data
        customerService.save(customerService.buildByName("catch10"));
        elseService.doSomethingElse10();

        return "success";
    }
}
