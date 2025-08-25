package com.example.test.services.impl;

import com.example.test.services.GuestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GuestServiceImpl implements GuestService {

    @Override
    public Integer getAgeOrYearOfBirth(Integer age, Integer yearOfBirth) {
        if (age != null && yearOfBirth == null) {
            return getAge(age);
        } else {
            return getYearOfBirth(yearOfBirth);
        }
    }

    // Tính năm sinh từ tuổi
    public Integer getYearOfBirth(Integer age) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - age;
    }

    // Tính tuổi từ năm sinh
    public Integer getAge(Integer yearOfBirth) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - yearOfBirth;
    }
}
