package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    SkillsBook skillsBook;
    @Autowired
    EducationBook educationBook;
    @Autowired
    ExpirenceBook experienceBook;
    @Autowired
    ResumeRepository userinfoBook;

    @GetMapping("/")
    public String userinfoget(Model model) {
        model.addAttribute("userinfo", new UserInfo());
        return "userinfoget";
    }

    @GetMapping("/add")
    public String resumeform(Model model) {
        model.addAttribute("userinfo", userinfoBook.findAll());
        model.addAttribute("educationstring", educationBook.findAll());
        model.addAttribute("skill", skillsBook.findAll());
        model.addAttribute("experience", experienceBook.findAll());

        return "resumeform";
    }

    @GetMapping("/addeducation")
    public String addeducation(Model model) {
        model.addAttribute("education", new Education());
        System.out.println("Help");
        return "educationget";
    }

    @GetMapping("/addskills")
    public String addskills(Model model) {
        model.addAttribute("skill", new Skills());
        return "skillsget";
    }

    @GetMapping("/addexperience")
    public String addexperience(Model model) {
        model.addAttribute("experience", new Experience());
        return "experienceget";
    }

    @PostMapping("/process")
    public String processForm(@Valid UserInfo info, BindingResult result) {
        if (result.hasErrors()) {
            return "resumeform";
        }
        userinfoBook.save(info);
        return "redirect:/add";
    }


    /*
    @RequestMapping("/updateskills/{id}")
    public String updateSkills(@PathVariable("id") long id, Model model) {
        model.addAttribute("skills", skillsBook.findOne(id));
        return "resumeform";
    }

    @RequestMapping("/updateeducation/{id}")
    public String updateeducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education", educationBook.findOne(id));
        return "resumeform";
    }

    @RequestMapping("/updateexperience/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience", experienceBook.findOne(id));
        return "resumeform";
    }

    */



    @PostMapping("/processskills")
    public String processSkills(@Valid Skills skill, BindingResult result) {
        System.out.println(skill.getId());
        if (result.hasErrors()) {
            return "/addskills";
        }
        skillsBook.save(skill);
        return "redirect:/add";
    }

    @PostMapping("/processeducation")
    public String processEducation( @Valid Education education, BindingResult result) {
        System.out.println(education.getId());
        System.out.println("help");
        if (result.hasErrors()) {
            return "/addeducation";
        }
        educationBook.save(education);
        return "redirect:/add";
    }

    @PostMapping("/processexperience")
    public String processExperience(@Valid Experience experience, BindingResult result) {
        if (result.hasErrors()) {
            return "/addexperience";
        }
        experienceBook.save(experience);
        return "redirect:/add";
    }
}