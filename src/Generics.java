public class Generics {
    public static void main(String[] args) {
        Example<Car, String> cars = new Example<>();
        cars.addToString(new Car("bmv", 2005), "fkabj k");
        cars.addToString(new Car("audi", 1994), " oskg or");
        System.out.println(cars.getString());

        shout("dwd");
    }

    public static <T> void shout (T t){
        System.out.println(t + "???");
    }
}