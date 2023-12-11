import java.util.*;

class Task implements Comparable<Task> {
    int deadline;
    int minutes;

    public Task(int deadline, int minutes) {
        this.deadline = deadline;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.deadline, other.deadline);
    }
}

public class TaskScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tasks: ");
        int tasks = scanner.nextInt();

        PriorityQueue<Task> pq = new PriorityQueue<>(Collections.reverseOrder());

        System.out.println("Enter deadlines and minutes for each task:");
        for (int i = 0; i < tasks; i++) {
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            pq.add(new Task(deadline, minutes));
        }

        int currentCompletionTime = 0;

        System.out.println("Maximum amount by which a task's completion time overshoots its deadline:");

        while (!pq.isEmpty()) {
            Task task = pq.poll();
            currentCompletionTime += task.minutes;
            int overshoot = Math.max(0, currentCompletionTime - task.deadline);
            System.out.println("Task Deadline: " + task.deadline + ", Overshoot: " + overshoot);
        }

        scanner.close();
    }
}
