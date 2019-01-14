package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.impl.ILoginService;
import com.example.demo.util.Captcha;
import com.example.demo.util.GifCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam Map map) {
        loginService.addUser(map);
        return "register ok";
    }

    @RequestMapping(value = "/vcode", method = RequestMethod.GET)
    public void vcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        HttpSession session = request.getSession(true);

        Captcha captcha = new GifCaptcha(146, 33, 4);
        captcha.out(response.getOutputStream());

        String vcodeText = captcha.text().toLowerCase();
        session.setAttribute("vcode", vcodeText);

        System.out.println("------" + session.getAttribute("vcode"));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam Map map) {
        HttpSession session = request.getSession();
        Subject subject = SecurityUtils.getSubject();
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);   //完成登录
            String name = subject.getPrincipal().toString();
            User user = loginService.findUserByUsername(name);
            session.setAttribute("user", user);
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message", "未知账户");
            return "redirect:/login";
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message", "密码不正确");
            return "redirect:/login";
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message", "账户已锁定");
            return "redirect:/login";
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message", "用户名或密码错误次数过多");
            return "redirect:/login";
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            request.setAttribute("message", "用户名或密码不正确");
            return "redirect:/login";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
    @ResponseBody
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("userInfo:view")
    @RequestMapping(value = "/create")
    @ResponseBody
    public String create() {
        return "Create success!";
    }
}
