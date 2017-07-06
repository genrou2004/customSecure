package com.security.controller;

import com.security.config.UserValidator;
import com.security.model.Education;
import com.security.model.Experience;
import com.security.model.User;
import com.security.respository.EducationRepository;
import com.security.respository.ExperienceRepository;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by student on 7/5/17.
 */
@Controller
public class HomeController {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private EducationRepository educationRepository;
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
    public String processEducationForm(@ModelAttribute Education education, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "education";
        }
        educationRepository.save(education);
        return "redirect:/experience";
    }

    @RequestMapping(value = "/experience", method = RequestMethod.GET)
    public String getExperienceForm(Model model) {

        model.addAttribute("experience", new Experience());
        return "experience";
    }

    @RequestMapping(value = "/experience", method = RequestMethod.POST)
    public String processExperienceForm(@ModelAttribute Experience experience, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "experience";
        }
        experienceRepository.save(experience);
        return "experience";
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public String getSkills(Model model) {

        model.addAttribute("skills", new Experience());
        return "skills";
    }

    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public String processSkills(@ModelAttribute Experience experience, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "skills";
        }
        experienceRepository.save(experience);
        return "redirect:/displayAll";
    }




    public UserValidator getUserValidator() {
        return userValidator;
    }
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }
}
