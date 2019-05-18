import java.text.ParsePosition;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

        Parking car1 = new Parking("CT783JY", "Auto", (LocalTime.parse("1225", formatter)), (LocalTime.parse("1835", formatter))); // 6h 0.01/minutes
        Parking car2 = new Parking("DB381TA", "Auto", (LocalTime.parse("1447", formatter)), (LocalTime.parse("1555", formatter))); // 1h 0.01/minutes
        Parking car3 = new Parking("CZ853HA", "Tir", (LocalTime.parse("0920", formatter)), (LocalTime.parse("1235", formatter))); // 3h 2€
        Parking car4 = new Parking("FF453NJ", "Auto", (LocalTime.parse("0920", formatter)), (LocalTime.parse("2015", formatter))); //11h 6€

        System.out.println(car1.toString());
        System.out.println("Posti disponibili: " + car1.placesAvailable(1, 50));
        System.out.println(car2.toString());
        System.out.println(car3.toString());
        System.out.println(car4.toString());

        System.out.println("Importo del veicolo targato " + car1.getLicensePlate() + " : " + car1.paymentParking(car1.calculatedTime((LocalTime.parse("1225", formatter)), (LocalTime.parse("1835", formatter)))) + "€"); //2€ +1.70€
        System.out.println("Importo del veicolo targato " + car2.getLicensePlate() + " : " + car2.paymentParking(car2.calculatedTime((LocalTime.parse("1447", formatter)), (LocalTime.parse("1555", formatter)))) + "€"); //0.68€
        System.out.println("Importo del veicolo targato " + car3.getLicensePlate() + " : " + car3.paymentParking(car3.calculatedTime((LocalTime.parse("0920", formatter)), (LocalTime.parse("1235", formatter)))) + "€"); // 2€*2 dato che è un tir
        System.out.println("Importo del veicolo targato " + car4.getLicensePlate() + " : " + car4.paymentParking(car4.calculatedTime((LocalTime.parse("0920", formatter)), (LocalTime.parse("2015", formatter)))) + "€"); // 6€
    }
}
