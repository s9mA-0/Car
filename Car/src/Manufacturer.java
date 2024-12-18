class Manufacturer {
    String[] brands = {"Toyota", "Ford", "Honda", "Nissan", "Volkswagen"};
    String name;

    public Manufacturer(String[] userBrands) {
        if (userBrands.length > 0) {
            this.name = userBrands[0];
        } else {
            this.name = brands[(int) (Math.random() * brands.length)];
        }
    }

    public Car createCar() throws CustomException {
        String[] colors = {"Червоний", "Голубий", "Зелений", "Чорний", "Білий"};
        int price = (int) ((int)10000.0 + Math.random() * 20000.0);

        if (price > 30000) {
            throw new CustomException("Ціна автомобіля перевищує допустиму межу.");
        }

        String color = colors[(int) (Math.random() * colors.length)];

        Car car = new Car(name, color, price);
        return car;
    }

    public static class Customer {
        private double budget;

        public Customer(double budget) {
            this.budget = budget;
        }

        public void chooseCar(Car car) throws CustomException {
            if (car.isBudget(budget)) {
                System.out.println("Ти можеш взяти " + car.getBrand() + " " + car.getColor() + " за $" + car.getPrice());
            } else {
                throw new CustomException("Цей авто не підходить під твій бюджет.");
            }
        }
    }
}
