package br.com.farias.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
    public String showForm() {
        System.out.println("Handle sample controller");
        return "sample";
    }

}