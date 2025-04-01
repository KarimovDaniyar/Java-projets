import java.time.LocalDateTime;
import java.util.*;

public class TaskManager {
    PriorityQueue<Task> scheduleTasks;
    ArrayDeque<Task> pendingTasks;
    HashMap<Task, ArrayList<LocalDateTime>> completedTasks;

    public TaskManager() {
        this.scheduleTasks = new PriorityQueue<>(Task::compareTo);
        this.pendingTasks = new ArrayDeque<>();
        this.completedTasks = new HashMap<>();
    }

    public void addTask(Task t) {
        scheduleTasks.offer(t);
    }

    public void printAllTasks() {
        System.out.println("Scheduled Tasks (sorted by priority):");
        for (Task t : scheduleTasks) {
            System.out.println("[" + t.priority + "] " +
                    t.name + " ( " + t.duration + ")");
        }

        System.out.println("Pending Tasks(FIFO order):");
        for (Task t : pendingTasks) {
            System.out.println(t.name + ", " + t.priority + ", " + t.duration);
        }

        System.out.println("Completed Tasks: ");
        for (Map.Entry<Task, ArrayList<LocalDateTime>> entry : completedTasks.entrySet()) {
            System.out.println(entry.getKey().name + ": (" +
                    entry.getValue().get(0) + "," +
                    entry.getValue().get(1));
        }
    }

    public void delayTask(Task t){
        pendingTasks.offer(t);
        scheduleTasks.remove(t);
    }

    public void processTask(){
        if(!scheduleTasks.isEmpty()){
            Task t = scheduleTasks.poll();
            System.out.println("Processing Task: "+t.priority+", "+
                    t.name+", "+t.duration);
            LocalDateTime timenow = LocalDateTime.now();
            ArrayList<LocalDateTime> list = new ArrayList<>();
            list.add(timenow);
            list.add(timenow.plusMinutes(t.duration));
            completedTasks.put(t,list);
            //completedTasks.put(t,new ArrayList<>(Arrays.asList(timenow,timenow.plusMinutes(t.getDuration()))))
            return;
        }
        if(!pendingTasks.isEmpty()){
            Task t = pendingTasks.poll();
            System.out.println("Processing Task: "+t.priority+", "+
                    t.name+", "+t.duration);
            return;
        }
        System.out.println("No more tasks left to be executed. Quitting.");
    }
}

class Task{
    int priority;
    String name;
    int duration;

    public Task(int priority, String name, int duration){
        this.priority = priority;
        this.name = name;
        this.duration = duration;
    }

    int compareTo(Task t) {
        if (this.priority != t.priority) {
            return Integer.compare(t.priority, this.priority);
        } else {
            return Integer.compare(this.duration, t.duration);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task t = new Task(3, "Code Review", 20);
        manager.addTask(t);
        manager.addTask(new Task(5, "System Update", 45));
        Task t1 = new Task(2, "Database Backup", 30);
        manager.addTask(t1);
        manager.addTask(new Task(5, "Deploy New Feature", 50));
        manager.addTask(new Task(4, "Bug Fixing", 25));

        manager.printAllTasks();
        manager.processTask();
        manager.delayTask(t);
        manager.printAllTasks();
        manager.delayTask(t1);
        manager.printAllTasks();
        manager.processTask();
        manager.printAllTasks();
        manager.processTask();
    }
}