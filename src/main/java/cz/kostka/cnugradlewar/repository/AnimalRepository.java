package cz.kostka.cnugradlewar.repository;

import cz.kostka.cnugradlewar.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <Animal, Integer> {
}