package com.examly.springapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomCategoryRepo;
import com.examly.springapp.repository.RoomRepo;
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepo repo;

    @Autowired
    private RoomCategoryRepo categoryRepo;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Room room) {
        room.setRoomCategory(categoryRepo.findById(1L).get());
        return new ResponseEntity<>(repo.save(room), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Room> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Room getById(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody Room r) {
        Room room = repo.findById(id).get();
        room.setRoomNumber(r.getRoomNumber());
        room.setPricePerNight(r.getPricePerNight());
        room.setAvailable(r.isAvailable());
        return repo.save(room);
    }

    @GetMapping("/category/{name}")
    public List<Room> getByCategory(@PathVariable String name) {
        return repo.findByRoomCategory_CategoryName(name);
    }

    @GetMapping("/number/{num}")
    public ResponseEntity<?> getByNumber(@PathVariable String num) {
        List<Room> list = repo.findByRoomNumber(num);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No room found with number: " + num);
        }
        return ResponseEntity.ok(list);
    }
}