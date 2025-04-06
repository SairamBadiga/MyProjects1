package models;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private int billId;
    private Vehicle vehicle;
    private Ticket ticket;
    private double amount;
    private Gate gate;
    private Operator generatedBy;
    private List<Payment> payments;
    private Date exitTime;
    private BillStatus billStatus;
    private FeeCalculationStatergyType feeCalculationStatergyType;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public FeeCalculationStatergyType getFeeCalculationStatergyType() {
        return feeCalculationStatergyType;
    }

    public void setFeeCalculationStatergyType(FeeCalculationStatergyType feeCalculationStatergyType) {
        this.feeCalculationStatergyType = feeCalculationStatergyType;
    }
}

