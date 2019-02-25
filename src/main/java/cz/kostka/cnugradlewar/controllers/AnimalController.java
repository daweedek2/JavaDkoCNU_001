package cz.kostka.cnugradlewar.controllers;

import cz.kostka.cnugradlewar.entity.Animal;
import cz.kostka.cnugradlewar.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepo;

    @Autowired
    public AnimalController(AnimalRepository animalRepo) {
        this.animalRepo = animalRepo;
    }

    @GetMapping(value = "/")
    public String indexView ()
    {
        return "index";
    }

    @GetMapping(value = "/list")
    public String listView (Model model)
    {
        model.addAttribute("animals", animalRepo.findAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String addView (Model model)
    {
        model.addAttribute("animal", new Animal());
        return "add";
    }

    @PostMapping(value = "/add")
    public String createAnimal(@ModelAttribute Animal animal, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "add";
        }

        animalRepo.save(animal);
        return "success";
    }
}
