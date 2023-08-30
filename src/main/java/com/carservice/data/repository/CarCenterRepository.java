package com.carservice.data.repository;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.enums.CarBrand;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarCenterRepository extends JpaRepository<CarCenter, Long> {
    List<CarCenter> findAllByName(String name);

    List<CarCenter> findAllByNameStartingWith(String CarCenterName, Sort sort);

    List<CarCenter> findAllByWorkWithBrand(CarBrand brand);

    List<CarCenter> findAllByWorkWithBrandStartingWith(CarBrand brand, Sort sort);
}
