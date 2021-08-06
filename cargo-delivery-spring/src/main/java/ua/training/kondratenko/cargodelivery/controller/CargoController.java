package ua.training.kondratenko.cargodelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CargoController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/cargo"})
    public String getIndex(Model model) {
        model.addAttribute("word", "Welcome at cargo delivery page!");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public String getUserPage(Model model) {
        return "user";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String getAdminPage(Model model) {
        return "admin";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/logout")
    public String getLogoutPage(Model model) {
        return "index";
    }

    @RequestMapping()
    public String getErrorPage() {
        return "error";
    }

}