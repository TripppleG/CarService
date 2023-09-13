package com.carservice.web.view.model;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.CarCenter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateAppointmentViewModel {
    @NotNull(message = "The car must be set!")
    private Car car;

    @NotNull(message = "The car center must be set!")
    private CarCenter carCenter;

    @NotNull(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;
}
