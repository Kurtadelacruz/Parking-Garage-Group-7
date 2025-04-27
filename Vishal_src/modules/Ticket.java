package modules;
import java.time.Duration;
import java.time.LocalTime;
import java.io.Serializable;

public class Ticket implements Serializable {
	private String ticketID;
	private static int count = 0;
	private LocalTime issuedTime;
	private LocalTime payoutTime;
	private double totalCharge;
	private TicketStatus parkingTicketStatus;
	
	public Ticket() {
		this.setTicketID("T" + String.valueOf(++count));
		this.setIssuedTime(LocalTime.now());
		this.setTotalCharge(0.0);
		this.setParkingTicketStatus(TicketStatus.ACTIVE);
    }
	
	public double calculateFee() {
		this.setPayoutTime(LocalTime.now());
		Duration duration = Duration.between(payoutTime, issuedTime);
		long minutes = duration.toMinutes();
//		Charge is set at $3 per hour, 0.05 per minute
		double rate = 0.05;
		this.setTotalCharge(rate * minutes);
		this.setParkingTicketStatus(TicketStatus.PAID);
		return this.totalCharge;
		
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public LocalTime getIssuedTime() {
		return issuedTime;
	}

	public void setIssuedTime(LocalTime issuedTime) {
		this.issuedTime = issuedTime;
	}

	public LocalTime getPayoutTime() {
		return payoutTime;
	}

	public void setPayoutTime(LocalTime payoutTime) {
		this.payoutTime = payoutTime;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	public TicketStatus getParkingTicketStatus() {
		return parkingTicketStatus;
	}

	public void setParkingTicketStatus(TicketStatus parkingTicketStatus) {
		this.parkingTicketStatus = parkingTicketStatus;
	}
	
	
	
}


