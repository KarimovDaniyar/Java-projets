import java.lang.foreign.ValueLayout;
import java.util.*;

public class JavaExercises {
    public static void main(String[] args) {
        // 22 задание
        ArrayList<String> colors = new ArrayList<>(3);
        colors.add("blue");
        colors.add("grey");
        colors.add("white");
        for(int i = 0; i<colors.size(); i++){
            System.out.println(colors.get(i));
        }
        // 21 задание
        replaceSecondElements("Alym", colors);

        // 20 задание
        colors.add("Tolon");
        System.out.println(colors);

        // 19 задание
        colors.trimToSize();

        // 18 задание
        System.out.println(isEmpty(colors));

        // 17 задание
        colors.clear();

        // 16 задание
        ArrayList<String> newArr = colors;
        System.out.println(newArr);
    }
    public static void replaceSecondElements(String s, ArrayList<String> arr){
        arr.set(1, s);
        System.out.println(arr);
    }

    public static boolean isEmpty(ArrayList<String> arr){
        return arr.size() == 0;
    }
}
class LinkedListExercises{
    public static void main(String[] args) {
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> newArr = new LinkedList<>();
        arr.add(1); arr.add(5); arr.add(10);
        newArr.add(15); newArr.add(20);
        // 26
        arr.set(1,0);
        // 25
        System.out.println(arr.isEmpty());
        // 24
        for(int i: newArr){
            System.out.println(arr.contains(i) ? "yes" : "no");
        }
        // 23
        ArrayList<Integer> iarr = new ArrayList<>(arr);
        System.out.println(iarr);
        // 22
        System.out.println(iarr.contains(3));
        // 21
        System.out.println(arr.getLast());
        // 20
        System.out.println(arr.getFirst());
    }
}

class HashSetExercises{
    public static void main(String[] args) {
        HashSet<Integer> n = new HashSet<>();
        n.add(10);n.add(20);n.add(30);
        HashSet<Integer> n1 = new HashSet<>();
        n1.add(11);n1.add(22);n1.add(30);

        // 12
        n.clear();
        // 11
        HashSet<Integer> n2 = new HashSet<>();
        for (int i : n1){
            if(n.contains(i)){
                n2.add(i);
            }
        }
        n.addAll(n1);
        System.out.println(n2 + "" + n);
        // 10
        n.addAll(n1);
        // 8
        TreeSet<Integer> treeN = new TreeSet<>(n);
        System.out.println(treeN);
        // 9
        for(int i : treeN){
            if(i<7){
                System.out.println((i));
            }
        }
        // 7
        ArrayList<Integer> arrayN = new ArrayList<>(n);
        // 6
        HashSet<Integer> newHashN = new HashSet<>(n);
    }
}

class TreeSetExercises{
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12); treeSet.add(23);
        treeSet.add(4); treeSet .add(25);
        // 10
        EqualOrGreater(4,treeSet);
        treeSet.ceiling(4);
        // 11
        EqualOrLess(4,treeSet);
        treeSet.floor(4);
        // 12
        treeSet.higher(4);
        // 13
        treeSet.lower(6);
        // 14
        System.out.println(treeSet);
        treeSet.pollFirst();
        System.out.println(treeSet);
        // 15
        System.out.println(treeSet);
        treeSet.pollLast();
        System.out.println(treeSet);
        // 16
        treeSet.remove(4);
    }
    static void EqualOrGreater(int n, TreeSet<Integer> arr){
        for (int i : arr){
            if (i >= n) System.out.println(i);
            }
        }
    static void EqualOrLess(int n, TreeSet<Integer> arr){
        for (int i : arr){
            if (i <= n) System.out.println(i);
        }
    }
}

class PriorityQueueExercises{
    public static void main(String[] args) {
        PriorityQueue<Integer> parr = new PriorityQueue<>();
        parr.add(1); parr.add(2); parr.add(3);
        PriorityQueue<Integer> parr1 = new PriorityQueue<>();
        parr1.add(5); parr1.add(4); parr1.add(3);
        // 6
        System.out.println(parr.size());
        // 7
        for(int i: parr1){
            System.out.println(parr.contains(i) ? "yes" : "no");
        }
        System.out.println(parr);
        // 8
        System.out.println(parr.peek()); // just for look, pool delete el
        // 9
        System.out.println(parr.poll());
        System.out.println(parr);
        // 10
        ArrayList<Integer> arr = new ArrayList<>(parr);
        System.out.println(arr);
        // 11
        for(Integer i : parr){
            System.out.println(i.toString());
        }
        // 12
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(10,Collections.reverseOrder());
        pq1.add(10);
        pq1.add(22);
        pq1.add(36);
        pq1.add(25);
        pq1.add(16);
        pq1.add(70);
        pq1.add(82);
        pq1.add(89);
        pq1.add(14);
        while (!pq1.isEmpty()){
            System.out.println(pq1.poll() + " " );
        }
    }
}

class HasMapExercises{
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2,"red");  hashMap.put(1,"red");  hashMap.put(3,"red");  hashMap.put(6,"red");

        // 6
        HashMap<Integer, String> newHashMap = new HashMap<>(hashMap);
        System.out.println(newHashMap);

        HashMap<Integer,String> new_hash_map;
        new_hash_map = (HashMap)hashMap.clone();
        System.out.println(new_hash_map);

        // 7
        hashMap.containsKey(3);
        // 8
        hashMap.containsValue(3);
        // 9
        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        System.out.println(set);
        // 10
        Set<Integer> set1 = hashMap.keySet();
        System.out.println(set1);
        // 11
        System.out.println(hashMap.get(3));
        // 12
        System.out.println(hashMap.values());
    }
}

class TreeMapExercises{
    public static void main(String[] args) {
        // 1
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"blue");treeMap.put(2,"blue");treeMap.put(3,"blue");treeMap.put(4,"blue");
        // 2
        TreeMap<Integer, String> newTreeMap = new TreeMap<>(treeMap);
        // 3
        treeMap.containsKey(2);
        // 4
        treeMap.containsValue("blue");
        // 5
        treeMap.forEach((key, value) ->{
            System.out.println(key);
        });
        // 6
        treeMap.clear();
    }
}