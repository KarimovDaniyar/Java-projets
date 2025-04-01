import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Consumer;

public class WeeklyTest_1 {
    public static void main(String[] args) {
        // 1.	Напишите Java-программу для создания обобщенного метода, который принимает список любого типа и возвращает его в виде нового списка с элементами в обратном порядке.
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);list.add(1);list.add(2);
        list.add(3);list.add(4);list.add(5);
        list.add(6);

        ArrayList<String> sList = new ArrayList<>();
        sList.add("red");
        sList.add("blue");
        sList.add("r");
        sList.add("yellow");
        sList.add("rhthrhrhr");
        System.out.println(f1(list));
        System.out.println(f1(sList));

        Map<String, Integer> map = Map.of(
                "Apple", 3,
                "Banana", 2,
                "Cherry", 5
        );

        // 2.	Напишите Java-программу для реализации лямбда-выражения, которое находит среднюю длину строк в списке.
        inter f2 = (list2) -> {
            int c = 0;
            for (String i : list2) {
                c += i.length();
            }
            System.out.println(c / list2.size());
        };

        f2.getAvgLen(sList);

        // 3.	Используйте интерфейс Consumer, чтобы вывести каждый элемент списка с помощью лямбда-выражения.
        Consumer<List<?>> getAllEl = (list3) -> {
            list3.forEach(System.out::println);
        };
        getAllEl.accept(list);

        // 4.	Создайте обобщенный метод, который принимает Map и выводит каждую пару ключ-значение.
        f4(map);

        // 1.	Напишите Java-программу для создания обобщенного метода, который принимает список любого типа и целевой элемент. Метод возвращает индекс первого вхождения целевого элемента в списке. Если элемент не найден, вернуть -1.
        System.out.println("Your el has index: "+f5(list,5));

        // 2.    Напишите Java-программу для реализации лямбда-выражения, которое находит длину самой длинной и самой короткой строки в списке.
        myInterface getMAxMin = (l) -> {
            String maxStr = "", minStr = l.getFirst();

            for (String s : l) {
                if (s.length() > maxStr.length()) maxStr = s;
                if (s.length() < minStr.length()) minStr = s;
            }

            System.out.println("Самая длинная: " + maxStr);
            System.out.println("Самая короткая: " + minStr);
        };

        getMAxMin.getList(sList);

    }

    public static <T> List<T> f1(List<T> list){
        List<T> newList = new ArrayList<>();
        for (int i = list.size()-1; i > -1; i--){
            newList.add(list.get(i));
        }
        return newList;
    }

    public static <K, V> void f4(Map<K, V> map){
        Set<Map.Entry<K, V>> list = map.entrySet();
        System.out.println(list);
        map.forEach((key, value) -> System.out.println(key + ": " + value));    // list.forEach(x -> System.out.println(x));
    }

    public static <T> int f5(List<T> list, T el){
        for (int i = 0; i < list.size(); i++){
            if (el == list.get(i)){
                return i;
            }
        }return -1;
    }
}

interface inter{
    void getAvgLen(ArrayList<String> list);
}

interface myInterface{
    void getList(List<String> list);
}