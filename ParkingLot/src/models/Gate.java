package models;

public class Gate extends BaseModel {
    private int gate_id;
    private GateType gate_type;
    private Operator operator;
    private GateStatus gateStatus;

    public int getGate_id() {
        return gate_id;
    }

    public void setGate_id(int gate_id) {
        this.gate_id = gate_id;
    }

    public GateType getGate_type() {
        return gate_type;
    }

    public void setGate_type(GateType gate_type) {
        this.gate_type = gate_type;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
