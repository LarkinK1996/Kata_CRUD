package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    public final UserService userDao;

    public UserController(UserService userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.get(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userDao.add(user);
        return "redirect:/";
    }


    @PostMapping("/update/{id}")
    public String set(@ModelAttribute("user") User user, @PathVariable(name = "id") int id) {
        userDao.set(id, user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userDao.get(id);

        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        userDao.delete(id);
        return "redirect:/";
    }
}

