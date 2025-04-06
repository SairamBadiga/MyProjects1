package services;

import exceptions.GateNotFoundException;
import models.Gate;
import models.Ticket;
import models.Vehicle;
import models.VehicleTypes;
import repositories.GateRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueToken(Long gateId, String vehicleNo,
                             String owner,
                             VehicleTypes vehicleType) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setCreateAt(new Date());
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if(optionalGate.isEmpty()){
            throw new GateNotFoundException();

        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedBy(gate.getOperator());
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNo);
        Vehicle savedVehicle;
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNo);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwner(owner);
            vehicleRepository.save();
            savedVehicle = vehicle;
        }
        else{
            savedVehicle = optionalVehicle.get();
        }

        ticket.setVehicle(savedVehicle);
        return ticket;

    }
}
