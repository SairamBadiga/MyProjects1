package models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private int parkingLotID;
    private List<Gate> gates;
    private List<ParkingFloor> parkingFloors;
    private int parkingCount;
    private VehicleTypes supportedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStatergy spotAssignmentStatergy;

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public VehicleTypes getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(VehicleTypes supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SpotAssignmentStatergy getSpotAssignmentStatergy() {
        return spotAssignmentStatergy;
    }

    public void setSpotAssignmentStatergy(SpotAssignmentStatergy spotAssignmentStatergy) {
        this.spotAssignmentStatergy = spotAssignmentStatergy;
    }
}
