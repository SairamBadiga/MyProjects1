package models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private int parkingSpotId;
    private List<VehicleTypes> vehicleTypeList;
    private ParkingSpotStatus parkingSpotStatus;
}
