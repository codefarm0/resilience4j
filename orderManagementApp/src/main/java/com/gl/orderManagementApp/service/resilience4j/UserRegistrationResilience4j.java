package com.gl.orderManagementApp.service.resilience4j;

import com.gl.orderManagementApp.dto.SellerDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Service
public class UserRegistrationResilience4j {
    Logger logger = LoggerFactory.getLogger(UserRegistrationResilience4j.class);
    private RestTemplate restTemplate;

    public UserRegistrationResilience4j(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @CircuitBreaker(name = "service1", fallbackMethod = "fallbackForRegisterSeller")
    public String registerSeller(SellerDto sellerDto) {
        String response = restTemplate.postForObject("/addSeller", sellerDto, String.class);
        return response;
    }

    @CircuitBreaker(name = "service2", fallbackMethod = "fallbackForGetSeller")
    public List<SellerDto> getSellersList() {
        return restTemplate.getForObject("/sellersList", List.class);
    }

    public String fallbackForRegisterSeller(SellerDto sellerDto, Throwable t) {
        logger.error("Inside fallbackForRegisterSeller, cause - {}", t.toString());
        return "Inside fallback method. Some error occurred while calling service for seller registration";
    }

    public List<SellerDto> fallbackForGetSeller(Throwable t) {
        logger.error("Inside fallbackForGetSeller, cause - {}", t.toString());
        SellerDto sd = new SellerDto();
        sd.setFirstName("john");
        sd.setId(1111);
        sd.setEmailId("default");
        List<SellerDto> defaultList = new ArrayList<>();
        defaultList.add(sd);
        return defaultList;
    }
}
