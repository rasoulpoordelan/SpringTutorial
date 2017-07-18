package com.onetechone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rasoul on 7/18/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/first")
    public String first(){
        return "first";
    }

}

