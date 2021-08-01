package ua.training.kondratenko.cargodelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cargo")
public class CargoController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("word", "Welcome at cargo delivery page!");
        return "index";
    }
}