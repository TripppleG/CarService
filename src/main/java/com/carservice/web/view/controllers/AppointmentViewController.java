package com.carservice.web.view.controllers;

import com.carservice.data.repository.CarCenterRepository;
import com.carservice.data.repository.CarRepository;
import com.carservice.data.repository.CustomerRepository;
import com.carservice.dto.AppointmentDTO;
import com.carservice.dto.CarDTO;
import com.carservice.exceptions.AppointmentNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.AppointmentService;
import com.carservice.web.view.model.AppointmentViewModel;
import com.carservice.web.view.model.CreateAppointmentViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentViewController {
    private final AppointmentService appointmentService;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CarCenterRepository carCenterRepository;
    private final CustomerRepository customerRepository;

    private AppointmentViewModel convertToAppointmentViewModel(AppointmentDTO appointmentDTO) {
        return modelMapper.map(appointmentDTO, AppointmentViewModel.class);
    }

    @GetMapping
    public String getAppointments(Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointments()
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @ExceptionHandler({AppointmentNotFoundException.class, CustomerNotFoundException.class})
    public String handleException(AppointmentNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/error/appointment-errors";
    }

    @GetMapping("/create-appointment")
    public String showCreateAppointmentForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String ownerEmail = authentication.getName();
        model.addAttribute("customer", customerRepository.findByEmail(ownerEmail));
        model.addAttribute("cars", carRepository.findAllByOwnerEmail(ownerEmail));
        model.addAttribute("carCenter", carCenterRepository.findAll());
        model.addAttribute("appointment", new CreateAppointmentViewModel());
        return "/appointments/create-appointment";
    }

    @PostMapping("/create")
    public String createAppointment(@Valid @ModelAttribute("appointment") AppointmentViewModel appointment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/appointments";
        }
        appointmentService.create(modelMapper.map(appointment, AppointmentDTO.class));
        return "redirect:/appointments";
    }

    @GetMapping("/edit-appointment/{id}")
    public String showUpdateAppointmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", modelMapper.map(appointmentService.getAppointment(id), AppointmentViewModel.class));
        return "/appointments/edit-appointment";
    }

    @PostMapping("/update-appointment/{id}")
    public String updateAppointment(@PathVariable("id") Long id, @Valid @ModelAttribute("appointment") AppointmentViewModel appointment,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/appointments/edit-appointment";
        }
        appointmentService.updateAppointment(id, modelMapper.map(appointment, AppointmentDTO.class));
        return "redirect:/appointments";
    }

    @GetMapping("/delete-appointment/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments-by-customer-email/{customerEmail}")
    public String getAppointmentsByCustomer(@PathVariable("customerEmail") String customerEmail, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCustomerEmail(customerEmail)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-date-created/{dateCreated}")
    public String getAppointmentsByDateCreated(@PathVariable("dateCreated") LocalDate dateCreated, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByDateCreated(dateCreated)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-date-of-appointment/{dateOfAppointment}")
    public String getAppointmentsByDateOfAppointment(@PathVariable("dateOfAppointment") LocalDate dateOfAppointment, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByDateOfAppointment(dateOfAppointment)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-car-center-name/{carCenterName}")
    public String getAppointmentsByCarCenterName(@PathVariable("carCenterName") String carCenterName, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCarCenterName(carCenterName)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-customer-first-name-starts")
    public String getAppointmentsByCustomerFirstNameStartsWith(@RequestParam String customerName, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCustomerFirstNameStartsWith(customerName, Sort.by("firstName"))
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-customer-email-and-date-of-appointment")
    public String getAppointmentsByCustomerEmailAndDateOfAppointment(@RequestParam String customerEmail,
     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfAppointment, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCustomerEmailAndDateOfAppointment(customerEmail, dateOfAppointment)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-car-center-name-and-date-created/")
    public String getAppointmentsByCarCenterNameAndDateCreated(@RequestParam String carCenterName,
       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dateCreated, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCarCenterNameAndDateCreated(carCenterName, dateCreated)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-car-center-name-and-date-of-appointment")
    public String getAppointmentsByCarCenterNameAndDateOfAppointment(@RequestParam String carCenterName,
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dateOfAppointment, Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByCarCenterNameAndDateOfAppointment(carCenterName, dateOfAppointment)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }

    @GetMapping("/appointments-by-has-passed-true")
    public String getAppointmentsByHasPassedTrue(Model model) {
        final List<AppointmentViewModel> appointments = appointmentService.getAppointmentsByHasPassedTrue()
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }
}
