package com.lalamove.springboot.pojo.dto;

public class TakeOrderResponse {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TakeOrderRequest{" +
                "status='" + status + '\'' +
                '}';
    }
}
