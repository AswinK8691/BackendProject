package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepo guestRepo;

    public List<Guest> getGuestByPhone(String phone) {
        return guestRepo.findByPhone(phone);
    }

}