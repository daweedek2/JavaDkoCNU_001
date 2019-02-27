package cz.kostka.cnugradlewar.controllers;

import cz.kostka.cnugradlewar.entity.Animal;
import cz.kostka.cnugradlewar.repository.AnimalRepository;
import cz.kostka.cnugradlewar.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(value = "/")
    public String indexView ()
    {
        return "index";
    }

    @GetMapping(value = "/list")
    public String listView (Model model)
    {
        model.addAttribute("animals", animalService.listAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String addView (Model model)
    {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "add";
    }

    @PostMapping(value = "/add")
    public String createAnimal(@ModelAttribute Animal animal, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "error";
        }
        animalService.add(animal);
        return "success";
    }
}
