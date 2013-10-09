package me.blog.youreme.payback.action;

import me.blog.youreme.payback.service.LoginService;

import me.blog.youreme.payback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 28.
 * Time: 오후 11:28
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginAction {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap mav, @RequestParam("userId") String userId, @RequestParam("password") String password) {
        User user = loginService.getUser(userId);

        if (user != null && password.equals(user.getPassword())) {
            return "redirect:/" + userId + "/payback";
        } else {
            return "index";
        }
    }


}
