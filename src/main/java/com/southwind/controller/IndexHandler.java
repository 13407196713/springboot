package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexHandler {

    @GetMapping("/index")
    public String index(Model model){
        System.out.println("index...");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1l,"张三",12));
        list.add(new Student(2l,"李四",22));
        list.add(new Student(3l,"王五",14));
        model.addAttribute("list",list);
        return "index";
    }

    @GetMapping("/index2")
    public String index2(Map<String,String>map){
        map.put("name","张三");
        return "index";
    }

    @GetMapping("/if")
    public String index3(Map<String,Boolean> map){
        map.put("flag",true);
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("name","tom");
        return "test";
    }

    @GetMapping("/url/{name}")
    @ResponseBody
    public String url(@PathVariable("name")String name){
        return name;
    }

    @GetMapping("/img")
    public String img(Model model){
        model.addAttribute("src","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583845001231&di=3d34ef449581a857e049c3cc21ece6af&imgtype=0&src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_match%2F0%2F11424473354%2F0.jpg");
        return "test";
    }

    @GetMapping("/eq")
    public String eq(Model model){
        model.addAttribute("age",30);
        return "test";
    }

    @GetMapping("/switch")
    public String switchTest(Model model){
        model.addAttribute("gender","女");
        return "test";
    }

    @GetMapping("/object")
    public String object(HttpServletRequest request){
        request.setAttribute("request","request对象");
        request.getSession().setAttribute("session","session对象");
        return "test";
    }

    @GetMapping("/util")
    public String util(Model model){
        model.addAttribute("name","zhangsan");
        model.addAttribute("users",new ArrayList<>());
        model.addAttribute("count",22);
        model.addAttribute("date",new Date());
        return "test";
    }

    @GetMapping("/validator")
    public void validatorUser(@Valid User user, BindingResult bindingResult){
        System.out.println(user);
        if(bindingResult.hasErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            for(ObjectError objectError:list){
                System.out.println(objectError.getCode()+"-"+objectError.getDefaultMessage());
            }
        }
    }

}
