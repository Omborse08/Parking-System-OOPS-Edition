package ParkingSystem1;

class ParkingTicket{
    private int ticketid;
    private Vehicle vehicle;
    private int slotNuber;
    private int hours;
    private static final int fees = 30;

    ParkingTicket(int ticketid,Vehicle vehicle,int slotNuber,int hours) {
        this.ticketid = ticketid;
        this.vehicle = vehicle;
        this.slotNuber = slotNuber;
        this.hours = hours;
    }

    public int getTicketid() {
        return ticketid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotNuber() {
        return slotNuber;
    }

    public int getHours() {
        return hours;
    }

    public int getFees() {
        return fees * getHours();
    }
}
