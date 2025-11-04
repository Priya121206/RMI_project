import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class AttendanceServer extends UnicastRemoteObject implements AttendanceInterface {
    private Map<String, String> attendanceList;

    protected AttendanceServer() throws RemoteException {
        attendanceList = new HashMap<>();
    }

    public String markAttendance(String studentName) throws RemoteException {
        attendanceList.put(studentName, "Present");
        return "Attendance marked for: " + studentName;
    }

    public Map<String, String> viewAttendance() throws RemoteException {
        return attendanceList;
    }

    public static void main(String[] args) {
        try {
            AttendanceServer server = new AttendanceServer();
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost/AttendanceService", server);
            System.out.println("Attendance Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}

