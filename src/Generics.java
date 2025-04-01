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

class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

class Example<T, V> {
    private String string = "";

    public String getString(){
        return string;
    }

    public void addToString(T t, V v){
        if(this.string.equals("")){
            this.string += t.toString() +" - "+ v.toString();
        }else{
            this.string += " - " + t.toString() + " - " + v.toString();
        }
    }
}
