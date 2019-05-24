package com.jyx.vip.funcation;

import com.jyx.vip.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

public interface UserFuncation {

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    UserModel login(String account,String password) throws Exception;

    @Transactional
    UserModel updatePassword(String id,String oldPwd,String newPwd,String newAginPwd) throws Exception;
}
