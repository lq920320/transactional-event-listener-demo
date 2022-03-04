package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.entities.Customer;
import com.example.service.CustomerService;
import com.example.service.TransactionCatchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zetu
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class TransactionServiceTest {

    @Autowired
    private TransactionCatchService transactionCatchService;
    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("主方法不开启事务，从方法也不开启事务，在主方法中try-catch")
    @Order(1)
    public void case1() {
        transactionCatchService.catch1();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch1");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case1 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case1 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法不开启事务，从方法也不开启事务，在从方法中try-catch")
    @Order(2)
    public void case2() {
        transactionCatchService.catch2();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch2");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case2 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case2 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法加入事务，在主方法中try-catch")
    @Order(3)
    public void case3() {
        transactionCatchService.catch3();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch3");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case3 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case3 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法加入事务，在从方法中try-catch")
    @Order(4)
    public void case4() {
        transactionCatchService.catch4();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch4");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case4 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case4 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法不开启事务，从方法开启事务，在主方法中try-catch")
    @Order(5)
    public void case5() {
        transactionCatchService.catch5();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch5");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case5 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case5 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法不开启事务，从方法开启事务，在从方法中try-catch")
    @Order(6)
    public void case6() {
        transactionCatchService.catch6();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch6");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case6 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case6 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在主方法中try-catch")
    @Order(7)
    public void case7() {
        transactionCatchService.catch7();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch7");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case7 transaction not rollback, then delete it!");
            customerService.removeById(customer.getId());
        } else {
            log.info("case7 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在从方法中try-catch")
    @Order(8)
    public void case8() {
        transactionCatchService.catch8();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch8");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case8 transaction not rollback, then delete it!");
            customerService.removeById(customer.getId());
        } else {
            log.info("case8 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在主方法中try-catch")
    @Order(9)
    public void case9() {
        transactionCatchService.catch9();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch9");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case9 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case9 transaction rollback");
        }
    }

    @Test
    @DisplayName("主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在从方法中try-catch")
    @Order(10)
    public void case10() {
        transactionCatchService.catch10();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "catch10");
        Customer customer = customerService.getOne(queryWrapper);
        if (customer != null) {
            log.info("case10 transaction not rollback, then delete it!");
//            customerService.removeById(customer.getId());
        } else {
            log.info("case10 transaction rollback");
        }
    }
}
