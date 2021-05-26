package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Handles requests at /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        // First param must match variable name in template
        // Second param must match local variable name in this method
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        // Alternate method of passing in attributeValue; don't need to declare it as a variable first
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
