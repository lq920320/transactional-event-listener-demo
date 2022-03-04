package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dao.entities.Customer;

/**
 * @author zetu
 * @date 2022/3/4
 */
public interface CustomerService extends IService<Customer> {
    /**
     * 通过名字构建一个实体
     *
     * @param name
     * @return {@link Customer}
     * @author 泽兔
     * @date 2022/3/4 17:04
     */
    Customer buildByName(String name);
}
