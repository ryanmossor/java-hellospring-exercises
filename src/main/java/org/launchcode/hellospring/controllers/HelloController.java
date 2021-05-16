package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody   // Each method in the class will inherit this annotation
@RequestMapping("hello")    // Every method in the class should begin with /hello
public class HelloController {

    // Handles requests at /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value="{langGreeting}", method={RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (language.equals("spanish")) {
            return "<h1 style='color:green;font-family:Arial;'>Hola, " + name + "!</h1>";
        } else if (language.equals("french")) {
            return "<h1 style='color:blue;font-family:Arial;'>Hola, " + name + "!</h1>";
        } else if (language.equals("german")) {
            return "<h1 style='color:red;font-family:Arial;'>Hola, " + name + "!</h1>";
        } else if (language.equals("swedish")) {
            return "<h1 style='color:deepskyblue;font-family:Arial;'>Hola, " + name + "!</h1>";
        } else {
            return "<h1 style='color:purple;font-family:Arial;'>Hola, " + name + "!</h1>";
        }
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='langGreeting' method='POST'>" + // submit a request to /hello
                            "<input type='text' name='name'/>" +
                            "<select name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='swedish'>Swedish</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'/>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }
}
