import java.util.LinkedList;
import java.util.Queue;

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

class Week {
    private Queue<WeekDay> days;

    public Week() {
        days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.add(day);
    }

    public Queue<WeekDay> getDays() {
        return days;
    }
}

class CalendarDisplay {
    private Queue<Week> calendar;

    public CalendarDisplay() {
        calendar = new LinkedList<>();
    }

    public void addWeek(Week week) {
        calendar.add(week);
    }

    public void displayCalendar() {
        System.out.println("Calendar:");
        System.out.println("Sun \tMon \tTue \tWed \tThu \tFri \tSat");

        for (Week week : calendar) {
            for (WeekDay day : week.getDays()) {
                System.out.print(day);
            }
            System.out.println();
        }
    }
}

public class CalendarApp {
    public static void main(String[] args) {
        CalendarDisplay calendarDisplay = new CalendarDisplay();

        // Example: Adding a week to the calendar
        Week week = new Week();
        week.addDay(new WeekDay("Sun", ""));
        week.addDay(new WeekDay("Mon", "1"));
        week.addDay(new WeekDay("Tue", "2"));
        week.addDay(new WeekDay("Wed", ""));
        week.addDay(new WeekDay("Thu", "4"));
        week.addDay(new WeekDay("Fri", ""));
        week.addDay(new WeekDay("Sat", "6"));

        calendarDisplay.addWeek(week);

        // Displaying the calendar
        calendarDisplay.displayCalendar();
    }
}
