public class Car implements Vehicle {
    String brand;
    String color;
    double price;

    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isBudget(double budget) {
        return price <= budget;
    }
}
