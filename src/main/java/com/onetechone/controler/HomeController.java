package com.onetechone.controler;

import com.onetechone.config.HibernateConfiguration;
import com.onetechone.data.UserService;
import com.onetechone.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by rasoul on 7/18/2017.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/get//{id}")
    public String first(Model model, @PathVariable("id") int id) {

        User user = userService.findById(id);

        System.out.println("Employee saved with ID: " + user.getName());

        model.addAttribute("heading", user.getName());

        return "first";
    }
}
