package com.carservice.web.view.controllers;


import com.carservice.dto.CarCenterDTO;
import com.carservice.dto.CreateCustomerDTO;
import com.carservice.services.CarCenterService;
import com.carservice.services.CustomerService;
import com.carservice.web.view.model.CarCenterViewModel;
import com.carservice.web.view.model.CustomerViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerViewController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public String showRegisterCustomerForm(@Valid @ModelAttribute("customer") CustomerViewModel customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/car-centers/create-car-center";
        }
        customerService.create(modelMapper.map(customer, CreateCustomerDTO.class));
        return "redirect:/car-centers";
    }
}
