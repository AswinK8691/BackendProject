package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;
import com.examly.springapp.service.GuestServiceImpl;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestRepo repo;
    @Autowired
    private GuestServiceImpl guestService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Guest guest) {
        return new ResponseEntity<>(repo.save(guest), HttpStatus.CREATED);
    }

    @GetMappin'
    ?g
    public List<Guest> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Guest getById(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PutMapping("/{id}")
    public Guest update(@PathVariable Long id, @RequestBody Guest g) {
        Guest guest = repo.findById(id).get();
        guest.setName(g.getName());
        guest.setPhone(g.getPhone());
        guest.setEmail(g.getEmail());
        return repo.save(guest);
    }

    @GetMapping("/email/{email}")
    public List<Guest> getByEmail(@PathVariable String email) {
        return repo.findByEmail(email);

    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getGuestByPhone(@PathVariable String phone) {
        List<Guest> guests = guestService.getGuestByPhone(phone);

        if (guests.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No guest found with phone: " + phone);
        }

        return ResponseEntity.ok(guests);
    }

    
}
