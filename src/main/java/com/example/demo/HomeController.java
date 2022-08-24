package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class HomeController {

//    public String english()
//    {
//        return "en";
//    }
    @RequestMapping("/en")
    public ModelAndView english(@RequestParam("sometext") String someText)
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("someText",someText);
        mv.setViewName("en");
        return mv;
    }

    @RequestMapping("/nl")
    public String dutch()
    {
        return "nl";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest req)
    {
        String language = req.getParameter("lang");
        if(Objects.equals(language, "en"))
            return "en";
        else if(Objects.equals(language, "nl"))
            return "nl";

            return "Hohoho, sorry we have not translated to this language yet!";

    }
}
