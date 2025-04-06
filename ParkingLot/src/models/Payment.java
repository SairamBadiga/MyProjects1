package models;

import java.util.Date;

public class Payment extends BaseModel{
    private Long referenceId;
    private double amount;
    private PaymentMode paymentmode;
    private PaymentStatus paymentstatus;

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(PaymentMode paymentmode) {
        this.paymentmode = paymentmode;
    }

    public PaymentStatus getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(PaymentStatus paymentstatus) {
        this.paymentstatus = paymentstatus;
    }


}
