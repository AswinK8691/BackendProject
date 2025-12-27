package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @GetMapping("/{id}")
    public void get(@PathVariable Long id) {
    }
}

