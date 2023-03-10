package pl.javastart.task.model;

public class Event {
    private String name;
    private String location;
    private double ticketPrice;

    public Event(String name, String location, double ticketPrice) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
    }

    String getInfo() {
        return "Wydarzenie: " + name + ", lokalizacja: " + location + ", cena biletu: " + ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
