package pl.javastart.task.model;

public class TicketCash {
    private static final int INITIAL_EVENT_MAX = 3;
    private static final double STUDENT_DISCOUNT = 0.23;
    private static final double PASSPORT_DISCOUNT = 0.5;
    private static final int STUDENT_DISCOUNT_OPTION = 1;
    private static final int PASSPORT_DISCOUNT_OPTION = 2;
    private static final int ONLINE = 1;
    private static final int STANDARD = 2;
    private static final int GIFT = 3;
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
            case STUDENT_DISCOUNT_OPTION:
                return STUDENT_DISCOUNT;
            case PASSPORT_DISCOUNT_OPTION:
                return PASSPORT_DISCOUNT;
            default:
                System.out.println("Podano zły typ zniżki");
                return INVALID_VALUE;
        }
    }

    public String setType(int option) {
        switch (option) {
            case ONLINE:
                return "internetowy";
            case STANDARD:
                return "standardowy";
            case GIFT:
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

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public void incrementEvents() {
        eventNumber++;
    }

    public void printDiscountTypes() {
        System.out.println(STUDENT_DISCOUNT_OPTION + "\t - zniżka studencka " + (STUDENT_DISCOUNT * 100) + "%");
        System.out.println(PASSPORT_DISCOUNT_OPTION + "\t - paszport Polsatu " + (PASSPORT_DISCOUNT * 100) + "%");
        System.out.println("==================================================");
    }

    public void printTicketTypes() {
        System.out.println("\t" + ONLINE + " - bilet internetowy");
        System.out.println("\t" + STANDARD + " - bilet standardowy");
        System.out.println("\t" + GIFT + " - bilet prezentowy");
        System.out.println("==================================================");
    }
}
