import java.time.LocalTime;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.time.format.DateTimeFormatter;


public class Parking extends Car {

    private int numberOfCars = 0;
    private int maxNumberOfCars = 50;
    private ArrayList<Car> cars;

    public Parking(String licensePlate, String type, LocalTime hStart, LocalTime hEnd) {
        super(licensePlate, type, hStart, hEnd);
        this.cars = new ArrayList<>();
    }

    public String addCar(Car c) {
            if (this.numberOfCars == maxNumberOfCars) return "Parcheggio Pieno";
            else {
                if (getType() == "Auto") {
                    this.cars.add(c);
                    this.numberOfCars++;
                }
                if (getType() == "Tir") {
                    for (int i = 0; i < 3; i++) {
                        this.cars.add(c);
                        this.numberOfCars++;
                    }
                }
                return " ";
            }
        }

    public boolean removeCar (Car licensePlate, LocalTime hEnd) {
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (licensePlate.equals(c.getLicensePlate()) ){
                    this.cars.remove(i);
                    if (getType()== "Auto") this.numberOfCars--;
                    if (getType()=="Tir") {
                        for (int j = 0; j < 3; j++) this.numberOfCars--;
                    }
                return true;
            }
        }
        return false;
    }

    public int calculatedTime (LocalTime hStart, LocalTime hEnd) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
       /* LocalTime departure = LocalTime.parse(, dateFormat);
        LocalTime arrival = LocalTime.parse("1435", dateFormat);*/
        int t = (int) MINUTES.between(getHStart(), getHEnd());
        return t;
    }

    public double paymentParking (int t) {
        double sum=0;
        if (t<600) {//for minutes
            if (t>120 && t<240) sum = 2.00; // from 2h to 4 h
                else sum = t*0.01; //
        } else sum = 6.00; //over 6€, 10h
        if (getType()=="Tir") sum= sum*2;
        return sum;
    }

    public int placesAvailable(int numberOfCars, int maxNumberOfCars) {
        int available = maxNumberOfCars - numberOfCars;
        return available;
    }

    }
