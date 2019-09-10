package com.gl.orderManagementApp.service;

import com.gl.orderManagementApp.dto.SellerDto;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public interface UserRegistrationService {
    String registerSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}
