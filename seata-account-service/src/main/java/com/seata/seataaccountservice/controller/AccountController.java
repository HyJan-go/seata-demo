package com.seata.seataaccountservice.controller;

import com.seata.common.Result;
import com.seata.seataaccountservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * @author: HyJan
 * @create: 2020-08-02 17:59
 **/
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * @param userId
     * @param money
     * @return
     * @ResponseBody 虽然访问时返回的确实是json字符串, 但是response 的content type是text/html
     * 要想设置为json的，要设置 produces = MediaType.APPLICATION_JSON_UTF8_VALUE
     */
    @RequestMapping(value = "/decrease", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return Result.success(null);
    }
}
