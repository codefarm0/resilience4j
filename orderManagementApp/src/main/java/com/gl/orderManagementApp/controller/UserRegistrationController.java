package com.gl.orderManagementApp.controller;

import com.gl.orderManagementApp.dto.SellerDto;
import com.gl.orderManagementApp.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register/seller")
    public String registerAsSeller(@RequestBody SellerDto sellerDto) {
        return userRegistrationService.registerSeller(sellerDto);
    }

    @GetMapping("/sellerList")
    public List<SellerDto> getSellersList() {
        return userRegistrationService.getSellersList();
    }
}
