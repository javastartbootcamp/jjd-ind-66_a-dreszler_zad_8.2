package pl.javastart.task.model;

public class Ticket {
    private Event event;
    private String type;
    private double discount;
    private int ticketId;
    private static final double LOGISTICS_PRICE = 5;
    private static final double GIFT_PRICE_MODIFIER = 0.05;
    private static final String ONLINE = "internetowy";
    private static final String STANDARD = "standardowy";
    private static final String GIFT = "prezentowy";
    private static final int INVALID_TYPE = -1;
    private static final String WRONG_PRICE = "undefined";

    Ticket(Event event, String type, double discount, int ticketId) {
        this.event = event;
        this.type = type;
        this.discount = discount;
        this.ticketId = ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    double getOnlinePrice() {
        return event.getTicketPrice() * (1 - discount);
    }

    double getStandardPrice() {
        return getOnlinePrice() + LOGISTICS_PRICE;
    }

    double getGiftPrice() {
        return getStandardPrice() + getOnlinePrice() * GIFT_PRICE_MODIFIER;
    }

    public double getFinalPrice() {
        return switch (type) {
            case ONLINE -> getOnlinePrice();
            case STANDARD -> getStandardPrice();
            case GIFT -> getGiftPrice();
            default -> INVALID_TYPE;
        };
    }

    public void printInfo() {
        String finalPriceInfo;
        switch (type) {
            case ONLINE:
                finalPriceInfo = String.format("%.2fzł\n", getFinalPrice());
                break;
            case STANDARD:
                finalPriceInfo = String.format("%.2fzł + %.2fzł = %.2fzł", getOnlinePrice(), LOGISTICS_PRICE, getFinalPrice());
                break;
            case GIFT:
                finalPriceInfo = String.format("%.2f + %.2fzł + (%.0f%% * %.2fzł) = %.2fzł", getOnlinePrice(),
                        LOGISTICS_PRICE, GIFT_PRICE_MODIFIER * 100, getOnlinePrice(), getFinalPrice());
                break;
            default:
                finalPriceInfo = WRONG_PRICE;
        }
        System.out.printf("Bilet %s: cena podstawowa %.2fzł, zniżka %.0f%%, cena finalna wyniesie: %s\n", type,
                event.getTicketPrice(), discount * 100, finalPriceInfo);
    }
}
