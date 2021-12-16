package br.com.micaellecruz.revenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.micaellecruz.revenda.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer>{
    // Métodos SQL personalizados
}    

