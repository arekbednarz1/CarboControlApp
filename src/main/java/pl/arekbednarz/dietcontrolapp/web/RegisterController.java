package pl.arekbednarz.dietcontrolapp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arekbednarz.dietcontrolapp.entity.User;
import pl.arekbednarz.dietcontrolapp.service.UserService;

import javax.validation.Valid;


@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register")
    public String registerAction (@ModelAttribute @Valid User user, BindingResult result) {
        User user1 = userService.findUserByEmail(user.getEmail());
        if (user1 != null) {
            result.rejectValue("email", "error.user",
                            "Użytkownik z podanym adresem email jest już zarejestrowany.");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        if (!user.getPassword().equals(user.getPasswordRepeat())) {
            return"registration";
        }
        user.setEnable(true);
        user.setSuperUser(0);
        userService.save(user);
        return "redirect:/login";
    }
}
