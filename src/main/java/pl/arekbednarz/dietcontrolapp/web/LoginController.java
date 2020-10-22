package pl.arekbednarz.dietcontrolapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.dietcontrolapp.entity.User;

import javax.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController
{
    @GetMapping
    public String prepareLogin()
    {
        return "login"; // spring security will do the rest
    }
}

