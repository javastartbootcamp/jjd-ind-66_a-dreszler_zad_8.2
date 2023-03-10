package pl.javastart.task.app;

public class Main {

    public static void main(String[] args) {
        CashController cashController = new CashController();
        cashController.getTicketCash().addEvent("Koncert Metallica", "Warszawa", 100);
        cashController.getTicketCash().addEvent("Regaty morskie", "Gdańsk", 200);
        cashController.getTicketCash().addEvent("Pokaz sztucznych ogni", "Gdynia", 160);
        cashController.getTicketCash().addEvent("Pyrkon", "Poznań", 300);
        cashController.getTicketCash().addEvent("Poznań Game Arena", "Poznań", 200);
        cashController.controlLoop();
    }
}