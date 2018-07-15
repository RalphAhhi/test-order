package com.lalamove.springboot.service;

import com.lalamove.springboot.model.OrderStatus;
import com.lalamove.springboot.model.dto.PlaceOrderRequest;
import com.lalamove.springboot.model.dto.PlaceOrderResponse;
import com.lalamove.springboot.model.entity.Order;
import com.lalamove.springboot.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;


    @Mock
    private GoogleDirectionClientService googleDirectionClient;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenValidPlaceOrderRequestThenReturnResponse() throws Exception {
        Assert.assertNotNull(orderService);
        PlaceOrderRequest mockRequest = new PlaceOrderRequest();
        mockRequest.destination = new ArrayList(Arrays.asList(1.30,20));
        mockRequest.origin = new ArrayList(Arrays.asList(2.30,40));
        Mockito.when(googleDirectionClient.getDistance(mockRequest)).then(e -> "74.m");
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(mockOrder());
        PlaceOrderResponse placeOrderResponse = orderService.placeOrder(mockRequest);
        Assert.assertEquals(OrderStatus.UNASSIGN.toString(),placeOrderResponse.getStatus());
        Assert.assertEquals("74.m",placeOrderResponse.getDistance());
    }

    private Order mockOrder() {
        Order order = new Order();
        order.setId(123L);
        return order;
    }









}
