import java.util.*;


public class StudentsManager {
    public static void main(String[] args) {

        University university = getUniversity();

        // 2. Поиск студента по ID
        System.out.println("Поиск студента с ID = 2:");
        university.findMember(2);

        // 3. Обновление информации о студенте
        System.out.println("\nОбновление данных Bob:");
        HashSet<String> updatedCourses = new HashSet<>(Arrays.asList("Java", "Algorithms", "Machine Learning"));
        university.update("Robert", 23, 2, updatedCourses);
        university.findMember(2);

        // 4. Удаление студента
        System.out.println("\nУдаление Alice (ID = 1)");
        university.removeMember(1);
        university.getAllMembers();

        // 5. Вывод всех студентов
        System.out.println("\nВсе оставшиеся студенты:");
        university.getAllMembers();

        // 6. Поиск студентов по курсу "Math"
        System.out.println("\nСтуденты, записанные на курс 'Math':");
        university.MemberWhoHasThisCourse("Math");

        // 7. Проверка на дубликаты курсов
        System.out.println("\nДобавление Robert (ID=2) снова на курс 'Java':");
        university.update("Robert", 23, 2, updatedCourses); // Попытка повторного добавления
        university.findMember(2);
    }

    private static University getUniversity() {
        University university = new University();

        // 1. Добавление студентов
        HashSet<String> courses1 = new HashSet<>(Set.of("Math", "Physics"));
        university.addMember("Alice", 20, 1, courses1);

        HashSet<String> courses2 = new HashSet<>(Set.of("Java", "Algorithms"));
        university.addMember("Bob", 22, 2, courses2);

        HashSet<String> courses3 = new HashSet<>(Set.of("Data Science", "Math"));
        university.addMember("Charlie", 19, 3, courses3);
        return university;
    }
}
class Member{
    int id;
    String name;
    int age;
    Set<String> course;

    public Member(int id, HashSet<String> course, int age, String name) {
        this.id = id;
        this.course = course;
        this.age = age;
        this.name = name;
    }
}

class University{
    Map<Integer , Member> members = new HashMap<>();
    Set<Integer> n = new TreeSet<>();


    void addMember(String name,int age, int id, HashSet<String> course){
        members.put(id , new Member(id, course, age, name));
        System.out.println(members);
        n.contains(members);
    }

    void removeMember(int id){
            members.remove(id);
    }

    void update(String name, int age, int id, HashSet<String> course) {
        Member member = members.get(id);
        if(member != null){
            member.age = age;
            member.name = name;
            member.course = course;
        }
    }

    void findMember(int id){
        System.out.println(members.get(id));
    }

    void MemberWhoHasThisCourse(String nameCourse){
        List<Member> list = new ArrayList<>();
        for (Member member: members.values()){
            if(member.course.contains(nameCourse)){
                list.add(member);
            }
        }
        System.out.println(list);
    }

    void getAllMembers(){
        for (Member member : members.values()){
            System.out.println(member);
        }
    }
}