package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.entities.Customer;
import com.example.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zetu
 * @date 2022/3/4
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClearDataTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("清除数据")
    public void clearData() {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", "456@abc.com");
        customerService.remove(queryWrapper);
    }

}
