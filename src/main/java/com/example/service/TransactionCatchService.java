package com.example.service;

/**
 * 事务捕获
 *
 * @author zetu
 * @date 2022/3/4
 */
public interface TransactionCatchService {
    /**
     * 主方法不开启事务，从方法也不开启事务，在主方法中try-catch
     *
     * @return {@link String} transaction status
     * @author 泽兔
     * @date 2022/3/4 11:58
     */
    String catch1();

    /**
     * 主方法不开启事务，从方法也不开启事务，在从方法中try-catch
     *
     * @return {@link String}  transaction status
     * @author 泽兔
     * @date 2022/3/4 11:59
     */
    String catch2();

    /**
     * 主方法开启事务，从方法加入事务，在主方法中try-catch
     *
     * @return {@link String} transaction status
     * @author 泽兔
     * @date 2022/3/4 11:58
     */
    String catch3();

    /**
     * 主方法开启事务，从方法加入事务，在从方法中try-catch
     *
     * @return {@link String} transaction status
     * @author 泽兔
     * @date 2022/3/4 11:58
     */
    String catch4();

    /**
     * 主方法不开启事务，从方法开启事务，在主方法中try-catch
     *
     * @return {@link String} transaction status
     * @author 泽兔
     * @date 2022/3/4 11:59
     */
    String catch5();

    /**
     * 主方法不开启事务，从方法开启事务，在从方法中try-catch
     *
     * @return {@link String} transaction status
     * @author 泽兔
     * @date 2022/3/4 11:59
     */
    String catch6();

    /**
     * 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在主方法中try-catch
     *
     * @return {@link String}
     * @author 泽兔
     * @date 2022/3/4 15:50
     */
    String catch7();

    /**
     * 主方法开启事务，从方法也开启事务，从方法默认事务传播机制，在从方法中try-catch
     *
     * @return {@link String}
     * @author 泽兔
     * @date 2022/3/4 15:51
     */
    String catch8();

    /**
     * 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在主方法中try-catch
     *
     * @return {@link String}
     * @author 泽兔
     * @date 2022/3/4 15:51
     */
    String catch9();

    /**
     * 主方法开启事务，从方法也开启事务，从方法的传播机制为新建事务或者嵌套事务，在从方法中try-catch
     *
     * @return {@link String}
     * @author 泽兔
     * @date 2022/3/4 15:52
     */
    String catch10();
}
