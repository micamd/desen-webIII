package util;

import br.com.micaellecruz.revenda.model.Car;
import br.com.micaellecruz.revenda.model.dto.CarDTO;

public class CarMapping {

    private CarMapping() {
    }

    public static CarDTO fromCar(Car car) {
        return new CarDTO(car.getId(), car.getBoard(), car.getModel(), car.getMark(), car.getColor(),
                car.getModelYear(), car.getYearOfManufacture(), car.getPrice());
    }

    public static Car toCar(CarDTO carDTO) {
        return new Car(carDTO.getId(), carDTO.getBoard(), carDTO.getModel(), carDTO.getMark(), carDTO.getColor(),
                carDTO.getModelYear(), carDTO.getYearOfManufacture(), carDTO.getPrice());
    }
}