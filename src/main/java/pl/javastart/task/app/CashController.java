package pl.javastart.task.app;

import pl.javastart.task.io.InputReader;
import pl.javastart.task.model.Event;
import pl.javastart.task.model.Ticket;
import pl.javastart.task.model.TicketCash;

import java.util.Arrays;

class CashController {
    private static final int BUY_TICKET = 1;
    private static final int CLOSE = 0;
    private static final int INVALID_VALUE = -1;
    private static final String INVALID_TYPE = "undefined";
    private TicketCash ticketCash = new TicketCash();
    private InputReader inputReader = new InputReader();

    void controlLoop() {
        int option;
        do {
            printAvailableOptions();
            System.out.println("Wybrana opcja: ");
            option = inputReader.getInt();

            switch (option) {
                case BUY_TICKET:
                    purchaseLoop();
                    break;
                case CLOSE:
                    break;
                default:
                    System.out.println("Nieprawidłowa wartość");
            }
        } while (option != CLOSE);
    }

    private void purchaseLoop() {
        int option;
        do {
            ticketCash.printEventList();
            System.out.println("==================================================");
            option = inputReader.getInt();
            if (option >= 1 && option <= ticketCash.getEventNumber()) {
                Event event = ticketCash.getEvents()[option - 1];
                String type = chooseType();
                double discount = chooseDiscount();

                Ticket ticket = ticketCash.buyTicket(event, type, discount);
                ticket.printInfo();
            }
        } while (option != CLOSE);
    }

    private String chooseType() {
        int option;
        String type;
        do {
            System.out.println("==================================================");
            System.out.println("Podaj typ biletu:");
            ticketCash.printTicketTypes();
            option = inputReader.getInt();
            type = ticketCash.setType(option);
        } while (type.equals(INVALID_TYPE));

        return type;
    }

    private double chooseDiscount() {
        int option;
        double discount;
        do {
            System.out.println("==================================================");
            System.out.println("Podaj typ zniżki:");
            ticketCash.printDiscountTypes();
            option = inputReader.getInt();
            discount = ticketCash.setDiscount(option);
        } while (discount == INVALID_VALUE);

        return discount;
    }

    private void printAvailableOptions() {
        System.out.println("==================================================");
        System.out.println("Witaj w systemie zakupu biletów!\nWybierz opcję:");
        System.out.println("\t" + BUY_TICKET + " - kup bilet");
        System.out.println("\t" + CLOSE + " - zamknij aplikację");
        System.out.println("==================================================");
    }

    public TicketCash getTicketCash() {
        return ticketCash;
    }

    public void addEvent(String name, String location, double ticketPrice) {
        Event[] events = ticketCash.getEvents();
        int eventNumber = ticketCash.getEventNumber();
        if (eventNumber >= events.length) {
            ticketCash.setEvents(Arrays.copyOf(events, events.length * 2));
        }
        ticketCash.getEvents()[eventNumber] = new Event(name, location, ticketPrice);
        ticketCash.incrementEvents();
    }
}
