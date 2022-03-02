package com.example.model;

import lombok.Data;

/**
 * @author zetu
 * @date 2022/3/2
 */
@Data
public class RegisterEvent {
    /**
     * 推送事件的时间戳
     */
    private long timestamp;
    /**
     * 用户ID
     */
    private Integer customerId;
}
