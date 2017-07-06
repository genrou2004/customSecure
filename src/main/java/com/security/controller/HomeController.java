package com.security.controller;

import com.security.config.UserValidator;
import com.security.model.*;
import com.security.respository.*;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by student on 7/5/17.
 */
@Controller
public class HomeController {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ExperienceRepository experienceRepository;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //========================================
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "redirect:/education";
    }

    @RequestMapping(value = "/education", method = RequestMethod.GET)
    public String getEducationForm(Model model) {

        model.addAttribute("education", new Education());
        return "education";
    }

    @RequestMapping(value = "/education", method = RequestMethod.POST)
    public String processEducationForm(@ModelAttribute Education education, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "education";
        }
        educationRepository.save(education);
        model.addAttribute(new Education());
        return "education";
    }

    @RequestMapping(value = "/experience", method = RequestMethod.GET)
    public String getExperienceForm(Model model) {

        model.addAttribute("experience", new Experience());
        return "experience";
    }

    @RequestMapping(value = "/experience", method = RequestMethod.POST)
    public String processExperienceForm(@ModelAttribute Experience experience, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "experience";
        }
        experienceRepository.save(experience);
        model.addAttribute(new Experience()); //to relaod and remove the data of the form(Rest form)
        return "experience";
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public String getSkills(Model model) {

        model.addAttribute("skill", new Skills());
        return "skills";
    }

    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public String processSkills(@ModelAttribute Skills skill, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "skills";
        }
        skillsRepository.save(skill);
        return "redirect:/displayAll";
    }


    @RequestMapping(value = "/checkRole", method = RequestMethod.GET)
    public String getRole(Model model, User user, Principal principal) {

        //String username = user.getUsername();
        user = userRepository.findByUsername(principal.getName());
        String typeRole = user.getUserType();
        System.out.println("Here is Role type inserted: "+typeRole);
        if (typeRole.equalsIgnoreCase("jobseeker")){
            return "jobseeker";
        }else if(typeRole.equalsIgnoreCase("recruiter")) {
            return "redirect:/job";
        }else
            return "Wrong Role Type, Please insert the correct role";


    }




    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public String getJob(Model model) {

        model.addAttribute("job", new Skills());
        return "jobForm";
    }

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    public String processJob(@ModelAttribute Job jobs, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "jobForm";
        }
        jobRepository.save(jobs);
        return "jobForm";
    }




    public UserValidator getUserValidator() {
        return userValidator;
    }
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }
}
