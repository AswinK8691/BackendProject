package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryService;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody(required = false) RoomCategory category) {
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(service.add(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<RoomCategory> list = service.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RoomCategory rc = service.getById(id);
        if (rc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room category not found");
        }
        return ResponseEntity.ok(rc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RoomCategory category) {
        return ResponseEntity.ok(service.update(id, category));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    }

    @GetMapping("/page/{page}/{size}")
    public Page<RoomCategory> paginate(@PathVariable int page, @PathVariable int size) {
        return service.paginate(page, size);
    }
}
