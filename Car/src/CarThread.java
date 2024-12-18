public class CarThread extends Thread {
    private Manufacturer manufacturer;

    public CarThread(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void run() {
        try {
            Car car = manufacturer.createCar();
            System.out.println("Створено автомобіль у потоці: " + car.getBrand() + " " + car.getColor() + " $" + car.getPrice());
        } catch (CustomException e) {
            System.out.println("Виникла помилка у потоці: " + e.getMessage());
        }
    }
}
