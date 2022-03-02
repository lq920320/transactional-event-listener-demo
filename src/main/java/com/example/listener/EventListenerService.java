package com.example.listener;

import com.example.dao.entities.Customer;
import com.example.model.RegisterEvent;
import com.example.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;

/**
 * @author zetu
 * @date 2022/3/2
 */
@Component
@Slf4j
public class EventListenerService {
    @Autowired
    private EventService eventService;

//    @EventListener
//    public void listenRegisterEvent(RegisterEvent event) {
//        Customer customer = eventService.getById(event.getCustomerId());
//        log.info("获取到用户ID：{}", event.getCustomerId());
//        if (Objects.nonNull(customer)) {
//            log.info("用户注册成功，发送邮件到 {}", customer.getEmail());
//        } else {
//            log.warn("未获取到用户，发送邮件到 {}", event.getCustomerId());
//        }
//    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true)
    public void listenRegisterEvent2(RegisterEvent event) {
        // Spring的事务管理是使用 PlatformTransactionManager 管理的
        // 我们可以在 org.springframework.transaction.support.AbstractPlatformTransactionManager.commit 处打断点来监测事务是否提交
        log.info("after commit");
        Customer customer = eventService.getById(event.getCustomerId());
        log.info("获取到用户ID：{}", event.getCustomerId());
        if (Objects.nonNull(customer)) {
            log.info("用户注册成功，发送邮件到 {}", customer.getEmail());
        } else {
            log.warn("未获取到用户，发送邮件到 {}", event.getCustomerId());
        }
    }
}
