package com.lalamove.springboot.pojo.dto;

/*{
        "id": <order_id>,
        "distance": <total_distance>,
        "status": "UNASSIGN"
}*/
public class PlaceOrderResponse {

    private long id;

    private long distance;

    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlaceOrderResponse{" +
                "id=" + id +
                ", distance=" + distance +
                ", status='" + status + '\'' +
                '}';
    }
}
