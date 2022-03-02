package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dao.entities.Customer;

/**
 * @author zetu
 * @date 2022/3/2
 */
public interface EventService extends IService<Customer> {

    /**
     * 插入数据并且推送事件
     *
     * @author 泽兔
     * @date 2022/3/2 14:15
     */
    void insertAndPublish();
}
