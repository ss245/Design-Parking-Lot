package ParkingLot.Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private BillStatus billStatus;
    private List<Payment> paymentList;
    private Gate gate;
    private Operator generatedBy;
    private Ticket ticket;
    private double amount;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private Date exitTime;
}
