package pl.arekbednarz.dietcontrolapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.dietcontrolapp.entity.Plan;
import pl.arekbednarz.dietcontrolapp.entity.User;
import pl.arekbednarz.dietcontrolapp.service.PlanService;
import pl.arekbednarz.dietcontrolapp.service.UserService;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipePlanDTO;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/plans")
public class PlanController
{

    @Autowired
    private PlanService planService;

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String addPlanForm(Model model, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        Plan plan = new Plan();
        model.addAttribute("plan", plan);
        model.addAttribute("user", user);
        return "plan/addPlan";
    }

    @PostMapping("/add")
    public String addPlan(@ModelAttribute @Valid Plan plan, Principal principal, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "plan/addPlan";
        }
        User user = userService.findUserByEmail(principal.getName());
        plan.setUser(user);
        planService.save(plan);
        return "redirect:/plans";
    }

    @GetMapping
    public String planList(Model model, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        List<Plan> plans = planService.findPlansByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("plans", plans);
        return "plan/planList";
    }


    @GetMapping("/{id}")
    public String planDetails(@PathVariable Long id, Model model, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        Map<String, List<RecipePlanDTO>> planMap = planService.getSpecifiedPlanMap(user.getId(), id);
        model.addAttribute("plan_description", planService.findOne(id));
        model.addAttribute("plan", planMap);

        return "plan/details";
        // todo secure if user not allowed

    }

    @GetMapping("/edit/{id}")
    public String editRecipe(Model model, @PathVariable Long id, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        Optional<Plan> plan = planService.find(id);
        model.addAttribute("user", user);
        model.addAttribute(plan);
        return "plan/addPlan";
    }

    @PostMapping("/edit/{id}")
    public String editEventPost(@PathVariable Long id, @ModelAttribute @Valid Plan plan,
                                Principal principal, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "plan/addPlan";
        }
        if (plan.getId() == null)
        {
            plan.setId(id);
        }
        Optional<Plan> planOld = planService.find(id);
        User user = userService.findUserByEmail(principal.getName());
        plan.setCreated(planOld.orElseThrow().getCreated());
        plan.setUser(user);
        planService.update(plan);
        return "redirect:../../plans";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model)
    {
        model.addAttribute("item", planService.findOne(id));
        return "dashboard/confirmDelete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        planService.delete(id);
        return "redirect:/plans";
    }
}
