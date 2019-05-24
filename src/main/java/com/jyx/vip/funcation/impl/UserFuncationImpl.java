package com.jyx.vip.funcation.impl;

import com.jyx.vip.common.AssertThrowUtils;
import com.jyx.vip.common.ThisSystemException;
import com.jyx.vip.dao.UserDao;
import com.jyx.vip.funcation.UserFuncation;
import com.jyx.vip.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFuncationImpl implements UserFuncation {

    @Autowired
    UserDao userDao;

    @Override
    public UserModel login(String account, String password) throws Exception {

        account = AssertThrowUtils.thorwIfBlank("账户不能为空!", account);
        password = AssertThrowUtils.thorwIfBlank("密码不能为空", password);

        UserModel userModel = userDao.select("account", account);

        if (userModel == null) {
            throw new ThisSystemException("账户不存在");
        }

        if (!userModel.getPassword().equals(password)) {
            throw new ThisSystemException("密码错误");
        }
        return userModel;
    }

    /*
        修改密码
     */
    @Override
    public UserModel updatePassword(String id, String oldPwd, String newPwd, String newAginPwd) throws Exception {
//        1.验证参数
        id = AssertThrowUtils.thorwIfBlank("id不能为空", id);
        oldPwd = AssertThrowUtils.thorwIfBlank("旧密码不能为空", oldPwd);
        newPwd = AssertThrowUtils.thorwIfBlank("新密码不能为空", newPwd);
        newAginPwd = AssertThrowUtils.thorwIfBlank("再次输入密码不能为空", newAginPwd);
        AssertThrowUtils.assertEquals("验证失败，两次密码不一致", newPwd, newAginPwd);
//        2.找用户
        UserModel userModel = userDao.select("id", id);
        AssertThrowUtils.assertNotNull("无法找到用户", userModel);
//        3.验证旧密码
        AssertThrowUtils.assertEquals("验证失败，旧密码不正确", userModel.getPassword(), oldPwd);
//        4.更新密码
        userModel.setPassword(newPwd);

        return userModel;
    }
}
