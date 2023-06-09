package jym.yeongmu.client.controller;

import jym.yeongmu.client.model.CarDto;
import jym.yeongmu.client.service.CarApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("random-data")
public class CarApiController {
    private final CarApiService service;

    public CarApiController(CarApiService service) {
        this.service = service;
    }

    @PostMapping("buy-car")
    public CarDto buyCar(){
        return this.service.buyNewCar();
    }
//
//    @GetMapping("show-cars")
//    public List<CarDto> getCars(){
//        return this.service.getCarsOwned();
//    }
}
