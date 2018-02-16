package com.example.demo;


import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    EduRepository eduRepository;

    @Autowired
    ExpRepository  expRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    ReferenceRepository referenceRepository;

    @RequestMapping("/")
    public String index(){

        return "index";
    }


    @GetMapping("/edu")
    public String loadEduform(Model model){

       model.addAttribute("education", new Education());

       return "Eduform";
    }

    @PostMapping("/edu")
    public String processEduform(@Valid @ModelAttribute("education") Education education, BindingResult result, Model model){

        if(result.hasErrors())
            return "Eduform";
        eduRepository.save(education);
        model.addAttribute("education", eduRepository);
        return "redirect:/";
    }

    @GetMapping("/contact")
    public String loadContactform(Model model){

        model.addAttribute("contact", new ContactInfo());

        return "Contactform";
    }

    @PostMapping("/contact")
    public String processEduform(@Valid @ModelAttribute("contact") ContactInfo contact, BindingResult result, Model model){

        if(result.hasErrors())
            return "Contactform";
        contactRepository.save(contact);
        model.addAttribute("contact", contactRepository);
        return "redirect:/";
    }


    @RequestMapping("/update/refer/{id}")
    public String updateReference(@PathVariable("id") long id, Model model) {
        model.addAttribute("reference", referenceRepository.findOne(id));

        return "Referform";
    }

    @RequestMapping("/update/edu/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education", eduRepository.findOne(id));

        return "Eduform";

    }
    @RequestMapping("/update/exp/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience", expRepository.findOne(id));

        return "Expform";
    }

    @RequestMapping("/update/skill/{id}")
    public String updateKill(@PathVariable("id") long id, Model model) {
        model.addAttribute("skill", skillRepository.findOne(id));

        return "Skillform";
    }

    @RequestMapping("/update/contact/{id}")
    public String updateContact(@PathVariable("id") long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));

        return "Contactform";
    }


    @GetMapping("/exp")
    public String loadExpform(Model model){

        model.addAttribute("experience", new Experience());

        return "Expform";
    }

    @PostMapping("/exp")
    public String processExpform(@Valid @ModelAttribute("experience") Experience experience, BindingResult result, Model model){

        if(result.hasErrors())
            return "Expform";
        expRepository.save(experience);
        model.addAttribute("experience", expRepository);
        return "redirect:/";
    }

    @GetMapping("/skill")
    public String loadskillform(Model model){

        model.addAttribute("skill", new Skill());

        return "Skillform";
    }

    @PostMapping("/skill")
    public String processskillform(@Valid @ModelAttribute("skill") Skill skill, BindingResult result, Model model){

        if(result.hasErrors())
            return "Skillform";
        skillRepository.save(skill);
        model.addAttribute("skill", skillRepository);
        return "redirect:/";
    }


    @GetMapping("/refer")
    public String loadReferform(Model model){

        model.addAttribute("reference", new Reference());

        return "Referform";
    }

    @PostMapping("/refer")
    public String procesReferform(@Valid @ModelAttribute("reference") Reference reference, BindingResult result, Model model){

        if(result.hasErrors())
            return "Referform";
        referenceRepository.save(reference);
        model.addAttribute("reference", referenceRepository);
        return "redirect:/";
    }


    @RequestMapping("/display")
    public String details( Model model) {

        model.addAttribute("educations", eduRepository.findAll());
        model.addAttribute("experiences", expRepository.findAll());
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("references", referenceRepository.findAll());

        return "Display";
    }
//


}
