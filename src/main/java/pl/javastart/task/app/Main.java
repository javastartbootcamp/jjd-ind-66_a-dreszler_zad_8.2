package pl.javastart.task.app;

public class Main {

    public static void main(String[] args) {
        CashController cashController = new CashController();
        cashController.addEvent("Koncert Metallica", "Warszawa", 100);
        cashController.addEvent("Regaty morskie", "Gdańsk", 200);
        cashController.addEvent("Pokaz sztucznych ogni", "Gdynia", 160);
        cashController.addEvent("Pyrkon", "Poznań", 300);
        cashController.addEvent("Poznań Game Arena", "Poznań", 200);
        cashController.controlLoop();
    }
}