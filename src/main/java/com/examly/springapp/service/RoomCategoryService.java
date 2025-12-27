package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.RoomCategory;

public interface RoomCategoryService {

    RoomCategory add(RoomCategory category);

    List<RoomCategory> getAll();

    RoomCategory getById(Long id);

    RoomCategory update(Long id, RoomCategory category);

    Page<RoomCategory> paginate(int page, int size);
}
