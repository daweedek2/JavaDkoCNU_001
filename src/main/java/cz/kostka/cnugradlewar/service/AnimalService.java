package cz.kostka.cnugradlewar.service;

import cz.kostka.cnugradlewar.entity.Animal;
import cz.kostka.cnugradlewar.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepo;
    private NullPointerException exception;

    @Autowired
    public AnimalService(AnimalRepository animalRepo) {
        this.animalRepo = animalRepo;
    }

    public Animal add (Animal animal) {
        if (animal.getDescription().equals("")){
            throw exception;
        }
        else animalRepo.save(animal);
        return animal;
    }

    public List<Animal> listAll () {
        return animalRepo.findAll();
    }
}
