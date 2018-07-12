package com.lalamove.springboot.service;

import com.lalamove.springboot.pojo.OrderStatus;
import com.lalamove.springboot.pojo.dto.PlaceOrderRequest;
import com.lalamove.springboot.pojo.dto.PlaceOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    public static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private GoogleDirectionClientService googleDirectionClient;

    public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) throws Exception {
        String distance = googleDirectionClient.getDistance(placeOrderRequest);
        //Save to database
        logger.info("Saving to database...");

        PlaceOrderResponse placeOrderResponse = new PlaceOrderResponse();
        placeOrderResponse.setId(123L);
        placeOrderResponse.setDistance(distance);
        placeOrderResponse.setStatus(OrderStatus.UNASSIGN.toString());
        return placeOrderResponse;

    }

}
