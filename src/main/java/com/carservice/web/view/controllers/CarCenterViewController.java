package com.carservice.web.view.controllers;


import com.carservice.dto.CarCenterDTO;
import com.carservice.exceptions.CarCenterNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.CarCenterService;
import com.carservice.web.view.model.CarCenterViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/car-centers")
public class CarCenterViewController {
    private final CarCenterService carCenterService;
    private final ModelMapper modelMapper;

    private CarCenterViewModel convertToCarCenterViewModel(CarCenterDTO carCenterDTO) {
        return modelMapper.map(carCenterDTO, CarCenterViewModel.class);
    }

    @GetMapping
    public String getCarCenters(Model model) {
        final List<CarCenterViewModel> carCenters =
                carCenterService.getCarCenters().stream()
                        .map(this::convertToCarCenterViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("carCenters", carCenters);
        return "/car-centers/car-centers";
    }

    @ExceptionHandler({CarCenterNotFoundException.class, CustomerNotFoundException.class})
    public String handleException(CarCenterNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/error/car-center-errors";
    }

    @GetMapping("/create-car-center")
    public String showCreateCarCenterForm(@Valid @ModelAttribute("carCenter") CarCenterViewModel carCenter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/car-centers/create-car-center";
        }
        carCenterService.create(modelMapper.map(carCenter, CarCenterDTO.class));
        return "redirect:/car-centers";
    }

    @GetMapping("/create")
    public String createCarCenter(@Valid @ModelAttribute("carCenter") CarCenterViewModel carCenter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/car-centers/create-car-center";
        }
        carCenterService.create(modelMapper.map(carCenter, CarCenterDTO.class));
        return "redirect:/car-centers";
    }

    @GetMapping("/update/{id}")
    public String showUpdateCarCenterForm(@PathVariable("id") Long id, Model model) {
        CarCenterDTO carCenterDTO = carCenterService.getCarCenter(id);
        model.addAttribute("carCenter", carCenterDTO);
        return "/car-centers/update-car-center";
    }

    @PostMapping("/update-car-center/{id}")
    public String updateCarCenter(@PathVariable Long id, @Valid @ModelAttribute("carCenter") CarCenterViewModel carCenter,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/car-centers/update-car-center";
        }
        carCenterService.updateCarCenter(id, modelMapper.map(carCenter, CarCenterDTO.class));
        return "redirect:/car-centers";
    }


    @GetMapping("/delete-car-center/{id}")
    public String deleteCarCenter(@PathVariable("id") Long id) {
        carCenterService.deleteCarCenter(id);
        return "redirect:/car-centers";
    }

}
