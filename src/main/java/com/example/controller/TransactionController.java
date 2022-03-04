package com.example.controller;

import com.example.service.TransactionCatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务的try-catch
 *
 * @author zetu
 * @date 2022/3/4
 */
@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private TransactionCatchService transactionCatchService;

    @GetMapping("catch1")
    public String catch1() {
        // 主方法不开启事务，从方法也不开启事务，在主方法中try-catch
        return transactionCatchService.catch1();
    }

    @GetMapping("catch2")
    public String catch2() {
        // 主方法不开启事务，从方法也不开启事务，在从方法中try-catch
        return transactionCatchService.catch2();
    }

    @GetMapping("catch3")
    public String catch3() {
        // 主方法开启事务，从方法加入事务，在主方法中try-catch
        return transactionCatchService.catch3();
    }

    @GetMapping("catch4")
    public String catch4() {
        // 主方法开启事务，从方法加入事务，在从方法中try-catch
        return transactionCatchService.catch4();
    }

    @GetMapping("catch5")
    public String catch5() {
        // 主方法不开启事务，从方法开启事务，在主方法中try-catch
        return transactionCatchService.catch5();
    }

    @GetMapping("catch6")
    public String catch6() {
        // 主方法不开启事务，从方法开启事务，在从方法中try-catch
        return transactionCatchService.catch6();
    }

    @GetMapping("catch7")
    public String catch7() {
        // 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在主方法中try-catch
        return transactionCatchService.catch7();
    }

    @GetMapping("catch8")
    public String catch8() {
        // 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在从方法中try-catch
        return transactionCatchService.catch8();
    }

    @GetMapping("catch9")
    public String catch9() {
        // 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在主方法中try-catch
        return transactionCatchService.catch9();
    }

    @GetMapping("catch10")
    public String catch10() {
        // 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在从方法中try-catch
        return transactionCatchService.catch10();
    }

}
