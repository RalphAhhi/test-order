package com.lalamove.springboot.controller;

import com.lalamove.springboot.exceptions.custom.InvalidOrderRequestException;
import com.lalamove.springboot.validation.OrderValidator;
import com.lalamove.springboot.pojo.dto.PlaceOrderRequest;
import com.lalamove.springboot.pojo.dto.PlaceOrderResponse;
import com.lalamove.springboot.pojo.dto.TakeOrderRequest;
import com.lalamove.springboot.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
public class OrderController {

    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    private OrderValidator orderValidator = new OrderValidator();

    @PostMapping(value = "/order")
    public ResponseEntity placeOrder(@RequestBody  PlaceOrderRequest order) throws Exception {
        logger.info("Placing an order ",order);
        if (!orderValidator.isValidOrderRequest(order)) {
           throw new InvalidOrderRequestException("INVALID_ORDER_REQUEST");
        }
        PlaceOrderResponse placeOrderResponse = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(placeOrderResponse);
    }

    @PutMapping(value = "order/{id}")
    public ResponseEntity takeOrder(@RequestBody TakeOrderRequest order)  {
        logger.info("Taking an order ",order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value= "orders")
    public ResponseEntity orderList(@RequestParam( value = "page", defaultValue = "0", required = false) int page,
                                    @RequestParam(value = "limit", defaultValue = "10" ,required = false) int limit) {
        logger.info("Retrieving  orders ");
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
