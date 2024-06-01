// Java code in Material Oceanic Theme
import java.util.*;
import java.text.*;

public class AttendanceManagementSystem {
private static List<Student> students = new ArrayList<Student>();
private static boolean[] attendanceList = null;

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date date = new Date();

boolean exit = false;
int choice;

while (!exit) {
System.out.println("Attendance Management System");
System.out.println("=============================");
System.out.println("Today's Date: " + dateFormat.format(date));
System.out.println("1. Add new student");
System.out.println("2. Take attendance");
System.out.println("3. View attendance report");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();

switch (choice) {
case 1:
addStudent();
break;
case 2:
takeAttendance();
break;
case 3:
viewAttendanceReport();
break;
case 4:
exit = true;
break;
default:
System.out.println("Invalid choice. Please try again.");

}
}

System.out.println("Goodbye!");
}

// Add a new student
private static void addStudent() {
Scanner sc = new Scanner(System.in);
System.out.print("Enter student name: ");
String name = sc.nextLine();
students.add(new Student(name));
System.out.println("Student added successfully!");
}

// Take attendance for all students
private static void takeAttendance() {
Scanner sc = new Scanner(System.in);
attendanceList = new boolean[students.size()];

for (int i = 0; i < students.size(); i++) {
System.out.print("Is " + students.get(i).getName() + " present? (y/n): ");
String response = sc.next().toLowerCase();
if (response.equals("y")) {
attendanceList[i] = true;

} else {
attendanceList[i] = false;
}
}

System.out.println("Attendance taken successfully!");
}

// View attendance report for all students
private static void viewAttendanceReport() {
System.out.println("Attendance Report:");
System.out.println("==================");
for (int i = 0; i < students.size(); i++) {

System.out.println(students.get(i).getName() + ": " + (attendanceList[i] ? "Present" : "Absent"));
}
}
}

class Student {
private String name;

public Student(String name) {
this.name = name;
}

public String getName() {
return name;
}
}
