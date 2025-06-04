
public class TestEreditarietà {
    static class vehicle {
        protected String brand = "Ford";

        public void honk() {
            System.out.println("Tuut, tuut!");
        }
    }

    static class Car extends vehicle {
        protected  String modelName = "Mustang";

        public static void main(String[] args) {
            Car myCar = new Car();
            myCar.honk();
            System.out.println(myCar.brand + " " + myCar.modelName);
        }
    }
}
