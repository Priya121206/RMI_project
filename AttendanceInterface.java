import java.rmi.*;
import java.util.*;

public interface AttendanceInterface extends Remote {
    String markAttendance(String studentName) throws RemoteException;
    Map<String, String> viewAttendance() throws RemoteException;
}
