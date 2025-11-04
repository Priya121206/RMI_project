import java.rmi.*;
import java.util.*;

public class AttendanceClient {
    public static void main(String[] args) {
        try {
            AttendanceInterface ai = (AttendanceInterface) Naming.lookup("rmi://localhost/AttendanceService");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Student Attendance System ---");
                System.out.println("1. Mark Attendance");
                System.out.println("2. View Attendance");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        System.out.println(ai.markAttendance(name));
                        break;
                    case 2:
                        Map<String, String> data = ai.viewAttendance();
                        System.out.println("\n--- Attendance List ---");
                        for (Map.Entry<String, String> entry : data.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
