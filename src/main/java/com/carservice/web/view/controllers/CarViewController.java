package com.carservice.web.view.controllers;

import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import com.carservice.exceptions.CarNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.CarService;
import com.carservice.web.view.model.CarViewModel;
import com.carservice.web.view.model.CreateCarViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarViewController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    private CarViewModel convertToCarViewModel(CarDTO carDTO) {
        return modelMapper.map(carDTO, CarViewModel.class);
    }

    @GetMapping
    public String getCars(Model model) {
        final List<CarViewModel> cars = carService.getCars()
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    @ExceptionHandler({CarNotFoundException.class, CustomerNotFoundException.class})
    public String handleException(CarNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/error/car-errors";
    }

    @GetMapping("/create-car")
    public String showCreateCarForm(Model model) {
        model.addAttribute("brand", CarBrand.values());
        model.addAttribute("car", new CreateCarViewModel());
        return "cars/create-car";
    }

    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") CreateCarViewModel car,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brand", CarBrand.values());
            return "/cars/create-car";
        }
        carService.create(modelMapper.map(car, CarDTO.class));
        return "redirect:/cars";
    }

    @GetMapping("/edit-car/{licensePlate}")
    public String showEditCarForm(Model model, @PathVariable String licensePlate) {
        model.addAttribute("brand", CarBrand.values());
        model.addAttribute("car", modelMapper.map(carService.getCar(licensePlate), CarViewModel.class));
        return "cars/edit-car";
    }

    @PostMapping("/update/{licensePlate}")
    public String updateCar(@PathVariable("licensePlate") String licensePlate, @Valid @ModelAttribute("car") CarViewModel car,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/edit-car";
        }
        carService.updateCar(car.getLicensePlate(), modelMapper.map(car, CarDTO.class));
        return "redirect:/cars";
    }

    @GetMapping("/delete/{licensePlate}")
    public String processProgramForm(@PathVariable("licensePlate") String licensePlate) {
        carService.deleteCar(licensePlate);
        return "redirect:/cars";
    }

    // Search by license plate
    @GetMapping("/search-car")
    public  String processSearchCarForm() {
        return "/cars/search-car";
    }

    // Search by brand
    @GetMapping("/search-car-by-brand")
    public  String getCarsByBrand(Model model, @RequestParam CarBrand brand) {
        final List<CarViewModel> cars = carService.getCarsByBrand(brand)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by
    @GetMapping("/search-car-by-model")
    public  String getCarsByModelStartingWith(Model model, @RequestParam String carModel) {
        final List<CarViewModel> cars = carService.getCarsByModelStartingWith(carModel, Sort.by("model"))
                .stream().map(this::convertToCarViewModel).collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by year
    @GetMapping("/search-car-by-year")
    public  String getCarsByYear(Model model, @RequestParam LocalDate year) {
        final List<CarViewModel> cars = carService.getCarsByYear(year)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by owner email
    @GetMapping("/search-car-by-owner-email")
    public  String getCarsByOwnerEmail(Model model, @RequestParam String ownerEmail) {
        final List<CarViewModel> cars = carService.getCarsByOwnerEmail(ownerEmail)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by owner phone number
    @GetMapping("/search-car-by-owner-phone-number")
    public  String getCarsByOwnerPhoneNumber(Model model, @RequestParam String ownerPhoneNumber) {
        final List<CarViewModel> cars = carService.getCarsByOwnerPhoneNumber(ownerPhoneNumber)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by brand and model
    @GetMapping("/search-car-by-brand-and-model")
    public  String getCarsByBrandAndModel(Model model, @RequestParam CarBrand brand, @RequestParam String carModel) {
        final List<CarViewModel> cars = carService.getCarsByBrandAndModel(brand, carModel)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by brand and year
    @GetMapping("/search-car-by-brand-and-year")
    public  String getCarsByBrandAndYear(Model model, @RequestParam CarBrand brand, @RequestParam LocalDate year) {
        final List<CarViewModel> cars = carService.getCarsByBrandAndYear(brand, year)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by model and year
    @GetMapping("/search-car-by-model-and-year")
    public  String getCarsByModelAndYear(Model model, @RequestParam String carModel, @RequestParam LocalDate year) {
        final List<CarViewModel> cars = carService.getCarsByModelAndYear(carModel, year)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }

    // Search by brand, model and year
    @GetMapping("/search-car-by-brand-model-and-year")
    public  String getCarsByBrandAndModelAndYear(Model model, @RequestParam CarBrand brand, @RequestParam String carModel, @RequestParam LocalDate year) {
        final List<CarViewModel> cars = carService.getCarsByBrandAndModelAndYear(brand, carModel, year)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "/cars/cars";
    }
}
