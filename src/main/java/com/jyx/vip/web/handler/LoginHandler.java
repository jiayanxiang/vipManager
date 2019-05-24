package com.jyx.vip.web.handler;

import com.jyx.vip.common.ThisSystemException;
import com.jyx.vip.funcation.UserFuncation;
import com.jyx.vip.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginHandler {

    @Autowired
    UserFuncation userFuncation;

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request) {
        try {
            UserModel userModel = userFuncation.login(account, password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", userModel);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String index() {
        return "/index";
    }

    @RequestMapping("/welcome.do")
    public String welcome() {
        return "/welcome";
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession httpSession) {
        //让sessrion失效
        httpSession.invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updatepassword.do")
    public String updatepasswordView() {
        return "/updatepassword";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updatepassword.do")
    public String updatepassword(String oldPwd, String newPwd, String newAginPwd, HttpServletRequest httpServletRequest) throws Exception {
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("currentUser");
        try {
            userFuncation.updatePassword(userModel.getId(), oldPwd, newPwd, newAginPwd);
        } catch (ThisSystemException e) {
            httpServletRequest.setAttribute("message", e.getMessage());
            return "/updatepassword";
        }
        httpServletRequest.getSession().setAttribute("message", "修改成功，请重新登录");
        return "redirect:/login.jsp";
    }
}
