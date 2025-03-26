import java.util.*;

public class Assignment {
    public static void main(String[] args) {
        Task t = new Task("Сделать домашнее задание Assignment", 4,60);
        Task t1 = new Task("Купить новую обувь к лету",2, 120);
        Task t2 = new Task("В среду встретиться с одноклассниками", 1,120);
        Task t3 = new Task("Купить фонарик для велосипеда",2, 20);
        TaskSchedule myList =  new TaskSchedule();
        myList.addTask(t);
        myList.addTask(t1);
        myList.addTask(t2);
        myList.addTask(t3);
        System.out.println(myList.getListOfTasks());
        myList.doTask();
    }
}

class Task implements Comparable<Task> {
    String taskName;
    int priority;
    int duration;

    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Task Name='" + taskName + '\'' +
                ", priority=" + priority +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Task task) {
        int priorityComparison = Integer.compare(task.priority, this.priority);
        return (priorityComparison != 0) ? priorityComparison : Integer.compare(this.duration, task.duration);
    }
}


class TaskSchedule{
    List<Task> listOfTasks = new ArrayList<>();
    Queue<Task> listOfPendingTasks = new LinkedList<>();

    PriorityQueue<Task> scheduledTasks;
    ArrayDeque<Task> pendingTasks;

    void addTask(Task task){
        listOfTasks.add(task);
        Collections.sort(listOfTasks);
        System.out.println(task.taskName + " был добавлен успешно");
    }

    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public Queue<Task> getListOfPendingTasks() {
        return listOfPendingTasks;
    }

    void pendingTask(Task task) {
        listOfPendingTasks.add(task);
        System.out.println(task.taskName + " был добавлен в отложенный список");
    }

    void doTask(){
        while(!listOfTasks.isEmpty()){
            Task task = listOfTasks.removeFirst();
            System.out.println("Выполняеться :" +task.taskName);
        }
        System.out.println("Выполняются задачи из списка отложенных: ");
       while(!listOfPendingTasks.isEmpty()){
           Task task = listOfPendingTasks.poll();
           System.out.println(task.taskName);
       }
    }
}