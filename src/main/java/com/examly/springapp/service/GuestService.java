package com.examly.springapp.service;
import java.util.List;

import com.examly.springapp.model.*;
public interface GuestService {
    List<Guest> getGuestByPhone(String phone);

    
}