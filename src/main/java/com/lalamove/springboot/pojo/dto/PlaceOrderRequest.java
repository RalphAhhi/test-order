package com.lalamove.springboot.pojo.dto;

import java.util.List;

/*{
        "origin": ["START_LATITUDE", "START_LONGTITUDE"],
        "destination": ["END_LATITUDE", "END_LONGTITUDE"]

}*/
public class PlaceOrderRequest {

    private List<String> origin;

    private List<String> destination;

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "PlaceOrderRequest{" +
                "origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
