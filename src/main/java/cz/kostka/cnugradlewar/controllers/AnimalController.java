package cz.kostka.cnugradlewar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {

    @GetMapping(value = "/")
    public String indexView ()
    {
        return "index";
    }

    @GetMapping(value = "/list")
    public String listView ()
    {
        return "list";
    }

    @GetMapping(value = "/add")
    public String addView ()
    {
        return "add";
    }

}
