package ParkingLot.Dtos;

import ParkingLot.Models.Operator;
import ParkingLot.Models.VehicleType;

public class IssueTicketRequestDto {
    private Long gateId;
    private String vehicleNo;
    private VehicleType vehicleType;
    private Operator operator;
    private String VehicleOwner;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getVehicleOwner() {
        return VehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        VehicleOwner = vehicleOwner;
    }
}
