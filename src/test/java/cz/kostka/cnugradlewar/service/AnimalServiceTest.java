package cz.kostka.cnugradlewar.service;

import cz.kostka.cnugradlewar.entity.Animal;
import cz.kostka.cnugradlewar.repository.AnimalRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {

    @Mock
    AnimalRepository repository;

    @InjectMocks
    public AnimalService service;

    @Test(expected = NullPointerException.class)
    public void addEmptyAnimalTest() {
        Animal animal = new Animal(1, "", "");
        service.add(animal);
    }

    @Test
    public void addOneAnimalTest() {
        Animal animal = new Animal(1, "dkoName", "dkoDescription");
        Mockito.when(repository.save(animal)).thenReturn(animal);
        Assert.assertEquals("added animal equals returned animal", animal, service.add(animal));
        Mockito.verify(repository).save(animal);
    }

    @Test
    public void ListEmptyAnimalsTest(){
        Assert.assertEquals("list of animals should be empty", 0, service.listAll().size());
    }

    @Test
    public void ListOneAnimalTest(){
        Animal animal = new Animal(1, "dkoName", "dkoDescription");
        List <Animal> animalsList = new ArrayList<>();
        animalsList.add(animal);
        Mockito.when(repository.findAll()).thenReturn(animalsList);
        Assert.assertEquals("list should contain 1 animal", 1, service.listAll().size());
    }

}
