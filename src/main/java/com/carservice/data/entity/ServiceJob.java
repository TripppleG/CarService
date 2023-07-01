package com.carservice.data.entity;

import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class ServiceJob {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Customer customer;

    @Enumerated
    @Column(name = "type")
    private ServiceJobType type;

    @Column(name = "date_started")
    private LocalDate dateStarted;

    @Column(name = "date_finished")
    private LocalDate dateFinished;
}
