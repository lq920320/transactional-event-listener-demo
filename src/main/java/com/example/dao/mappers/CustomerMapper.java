package com.example.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dao.entities.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zetu
 * @date 2022/3/2
 */
@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
}
