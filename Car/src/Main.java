import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCars = 3;

        System.out.println("Введіть марку автомобілю:");
        String userInput = scanner.nextLine();

        Manufacturer manufacturer = new Manufacturer(new String[]{userInput});

        Manufacturer.Customer customer = new Manufacturer.Customer(20000.0);

        for (int i = 0; i < numCars; i++) {
            try {
                Car myCar = manufacturer.createCar();
                System.out.println("Машина " + (i+1) + ": " + myCar.getBrand() + " " + myCar.getColor() + " $" + myCar.getPrice());

                customer.chooseCar(myCar);
            } catch (CustomException e) {
                System.out.println("Виникла помилка: " + e.getMessage());
            }
        }

        // Створення та запуск потоків
        CarThread carThread1 = new CarThread(manufacturer);
        CarThread carThread2 = new CarThread(manufacturer);
        CarThread carThread3 = new CarThread(manufacturer);

        carThread1.start();
        carThread2.start();
        carThread3.start();
    }
}
