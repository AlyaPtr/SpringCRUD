package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(name="/")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value="/create")
    public String addUser(User user, ModelMap modelMap) {
        userService.add(user);
        modelMap.addAttribute("users", userService.getAllUsers());
        return "redirect:/";
    }

    @GetMapping(value="/delete/{id}")
    public String removeUser(@PathVariable (value = "id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@PathVariable long id, User user) {
        userService.editUser(user);
        return "edit";
    }

}
