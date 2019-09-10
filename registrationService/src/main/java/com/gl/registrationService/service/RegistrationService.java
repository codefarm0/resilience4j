package com.gl.registrationService.service;

import com.gl.registrationService.dto.SellerDto;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public interface RegistrationService {


    String addSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}
