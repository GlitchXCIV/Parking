import java.time.LocalTime;

public class Car {
    private String licensePlate;
    private String type; //auto (x1) o autotreno (x3)
    private LocalTime hStart;
    private LocalTime hEnd;

    public Car(String licensePlate, String type, LocalTime hStart, LocalTime hEnd) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.hStart = hStart;
        this.hEnd = hEnd;
    }


    public String getLicensePlate() { return licensePlate; }

    public String getType() { return type; }

    public LocalTime getHStart() { return hStart; }

    public LocalTime getHEnd() { return hEnd; }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", hStart=" + hStart +
                ", hEnd=" + hEnd +
                '}';
    }
}
