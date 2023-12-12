public class Calendar {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Run the program as: java Calendar <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        if (month < 1 || month > 12 || year < 0) {
            System.out.println("Invalid month or year");
            return;
        }

        printCalendar(month, year);
    }

    private static void printCalendar(int month, int year) {
        int[][] calendar = generateCalendar(month, year);

        System.out.println("Calendar for " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] == 0) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%3d ", calendar[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] generateCalendar(int month, int year) {
        int[][] calendar = new int[6][7];

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int maxDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);

        int row = 0;
        int col = dayOfWeek - 1;

        for (int day = 1; day <= maxDay; day++) {
            calendar[row][col] = day;
            col++;

            if (col == 7) {
                col = 0;
                row++;
            }
        }

        return calendar;
    }

    private static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        return monthNames[month - 1];
    }
}
