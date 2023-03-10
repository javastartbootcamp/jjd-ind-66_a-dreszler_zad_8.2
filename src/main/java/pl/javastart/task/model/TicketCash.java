package pl.javastart.task.model;

import java.util.Arrays;

public class TicketCash {
    private static final int INITIAL_EVENT_MAX = 3;
    private static final double STUDENT_DISCOUNT = 0.23;
    private static final double PASSPORT_DISCOUNT = 0.5;
    private static final double INVALID_VALUE = -1;
    private int currentTicketId = 1;
    private Event[] events = new Event[INITIAL_EVENT_MAX];
    private int eventNumber = 0;

    public Ticket buyTicket(Event event, String type, double discount) {
        Ticket ticket = new Ticket(event, type, discount, currentTicketId);
        currentTicketId++;
        return ticket;
    }

    public void printEventList() {
        System.out.println("==================================================");
        System.out.println("Wybierz event, na który chcesz kupić bilet:");
        for (int i = 0; i < events.length; i++) {
            if (events[i] == null) {
                break;
            }
            System.out.println("\t" + (i + 1) + " - " + events[i].getInfo());
        }
        System.out.println("\t0 - powrót");
    }

    public double setDiscount(int option) {
        switch (option) {
            case 1:
                return STUDENT_DISCOUNT;
            case 2:
                return PASSPORT_DISCOUNT;
            default:
                System.out.println("Podano zły typ zniżki");
                return INVALID_VALUE;
        }
    }

    public String setType(int option) {
        switch (option) {
            case 1:
                return "internetowy";
            case 2:
                return "standardowy";
            case 3:
                return "prezentowy";
            default:
                System.out.println("Podano zły typ biletu");
                return "undefined";
        }
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public Event[] getEvents() {
        return events;
    }

    public void addEvent(String name, String location, double ticketPrice) {
        if (eventNumber >= events.length) {
            events = Arrays.copyOf(events, events.length * 2);
        }
        events[eventNumber] = new Event(name, location, ticketPrice);
        eventNumber++;
    }

    public void printDiscountTypes() {
        System.out.println("\t1 - zniżka studencka " + (STUDENT_DISCOUNT * 100) + "%");
        System.out.println("\t2 - paszport Polsatu " + (PASSPORT_DISCOUNT * 100) + "%");
        System.out.println("==================================================");
    }

    public void printTicketTypes() {
        System.out.println("\t" + "1 - bilet internetowy");
        System.out.println("\t" + "2 - bilet standardowy");
        System.out.println("\t" + "3 - bilet prezentowy");
        System.out.println("==================================================");
    }
}
