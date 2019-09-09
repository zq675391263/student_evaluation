package com.cqgcxy.evaluation.controller;

import com.cqgcxy.evaluation.dao.StudentDao;
import com.cqgcxy.evaluation.domain.Student;
import com.cqgcxy.evaluation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/student", method = RequestMethod.POST)
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;  //注入bcryct加密

    /**
     * 用户登录controller
     *
     * @param
     * @param password
     * @return public String encode(CharSequence rawPassword)： 对给定的内容进行加密，返回加密后的字符串
     * public boolean matches(CharSequence rawPassword, String encodedPassword)： 比较给定的字符串和加密后的字符串是否是同一个
     * rawPassword：未加密的字符串
     * encodedPassword： 加密后的字符串
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("stu_num")Integer num, @RequestParam("stu_psd")String password, Model model) {
        System.out.println("==========================================");
        System.out.println(num);
        System.out.println(password);
        try {
            Student student = studentService.findByNum(num);
            if (student == null) {
                return "redirect:../404.html";
            }
            if (bCryptPasswordEncoder.matches(password, student.getStu_psd())) {
                model.addAttribute("num",student.getStu_num());
                return "welcome";
            }

            return "redirect:../404.html";
        } catch (Exception e) {
            System.out.println("异常");
            System.out.println(e.getMessage());
            return "redirect:../404.html";
        }
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@RequestParam("stu_num")Integer num,@RequestParam("stu_psd")String psd,@RequestParam("stu_email")String email) {

        Student student = new Student();
        student.setStu_num(num);
        student.setStu_psd(bCryptPasswordEncoder.encode(psd));
        student.setStu_email(email);

        studentDao.save(student);


        return "redirect:../success.html";
    }
}
