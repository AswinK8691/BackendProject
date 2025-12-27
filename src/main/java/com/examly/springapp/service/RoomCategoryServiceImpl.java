package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryRepo repo;

    public RoomCategory add(RoomCategory category) {
        return repo.save(category);
    }

    public List<RoomCategory> getAll() {
        return repo.findAll();
    }

    public RoomCategory getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public RoomCategory update(Long id, RoomCategory category) {
        RoomCategory existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setCategoryName(category.getCategoryName());
            return repo.save(existing);
        }
        return null;
    }

    public Page<RoomCategory> paginate(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
