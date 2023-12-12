class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date.isEmpty() ? "\t" : String.format("%2s\t", date);
    }
}

class CalendarDisplay {
    private Stack weeks;

    public CalendarDisplay() {
        weeks = new Stack();
    }

    public void addWeekDay(WeekDay day) {
        weeks.push(day.toString());
    }

    public void displayCalendar() {
        System.out.println("Calendar:");
        System.out.println("Sun \tMon \tTue \tWed \tThu \tFri \tSat");

        while (!weeks.isEmpty()) {
            Stack weekDays = new Stack();
            for (int i = 0; i < 7; i++) {
                if (!weeks.isEmpty()) {
                    weekDays.push(weeks.pop());
                } else {
                    weekDays.push(""); // Push an empty string if there are no more days in the week
                }
            }

            while (!weekDays.isEmpty()) {
                System.out.print(weekDays.pop());
            }
            System.out.println();
        }
    }
}

public class CalendarApp2 {
    public static void main(String[] args) {
        CalendarDisplay calendarDisplay = new CalendarDisplay();

        // Example: Adding a week to the calendar
        calendarDisplay.addWeekDay(new WeekDay("Sun", ""));
        calendarDisplay.addWeekDay(new WeekDay("Mon", "1"));
        calendarDisplay.addWeekDay(new WeekDay("Tue", "2"));
        calendarDisplay.addWeekDay(new WeekDay("Wed", ""));
        calendarDisplay.addWeekDay(new WeekDay("Thu", "4"));
        calendarDisplay.addWeekDay(new WeekDay("Fri", ""));
        calendarDisplay.addWeekDay(new WeekDay("Sat", "6"));

        // Displaying the calendar
        calendarDisplay.displayCalendar();
    }
}
