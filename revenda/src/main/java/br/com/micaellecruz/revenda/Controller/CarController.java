package br.com.micaellecruz.revenda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.micaellecruz.revenda.model.dto.CarDTO;
import br.com.micaellecruz.revenda.service.CarService;

@RestController
@RequestMapping("/carros")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> insert(@RequestBody CarDTO carDTO) {
        if (carDTO != null) {
            var result = carService.insertOrUpdate(carDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CarDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CarDTO(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<CarDTO> update(@RequestBody CarDTO carDTO) {
        if (carDTO != null) {
            var result = carService.insertOrUpdate(carDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CarDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CarDTO(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll() {
        var listOfCars = carService.findAll();
        return new ResponseEntity<>(listOfCars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CarDTO findById(@PathVariable int id) {
        return carService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        var isSuccess = carService.delete(id);
        if (isSuccess)
            return new ResponseEntity<>("Carro removido com sucesso!!!", HttpStatus.OK);
        return new ResponseEntity<>("Não foi possível remover o carro informado!!!", HttpStatus.NOT_FOUND);
    }
}