package com.example.demo;


import com.example.demo.Models.Education;
import com.example.demo.Models.Experience;
import com.example.demo.Repositories.EduRepository;
import com.example.demo.Repositories.ExpRepository;
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
        return "redirect:/display";
    }




    @RequestMapping("/update/{id}")
    public String updateListing(@PathVariable("id") long id, Model model) {
        model.addAttribute("education", eduRepository.findOne(id));

        return "Eduform";

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
        return "redirect:/displayexp";
    }


//    @RequestMapping("/displayexp")
//    public String listexp( Model model) {
//
//        model.addAttribute("experiences", expRepository.findAll());
//        return "Listexp";
//    }

    @RequestMapping("/display")
    public String details( Model model) {

        model.addAttribute("educations", eduRepository.findAll());
        model.addAttribute("experiences", expRepository.findAll());
        return "Display";
    }
//


}
