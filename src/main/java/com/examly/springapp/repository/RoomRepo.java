package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    List<Room> findByRoomCategory_CategoryName(String categoryName);

    List<Room> findByRoomNumber(String roomNumber);
}
