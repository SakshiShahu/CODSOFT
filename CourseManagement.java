import java.util.*;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }
}

class Student {
    String studentId;
    String name;
    String[] registeredCourses;
    int courseCount;
//student constructor
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new String[5]; //max 5 courses
        this.courseCount = 0;
    }

    public void registerCourse(String courseCode) {
        if (courseCount < registeredCourses.length) {
            registeredCourses[courseCount] = courseCode;
            courseCount++;
        } else {
            System.out.println(" Cannot register more courses.");
        }
    }

    public void dropCourse(String courseCode) {
        boolean found = false;
        for (int i = 0; i < courseCount; i++) {
            if (registeredCourses[i].equals(courseCode)) {
                registeredCourses[i] = registeredCourses[courseCount - 1];
                registeredCourses[courseCount - 1] = null;
                courseCount--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" Course not found in your registered list.");
        }
    }

    public void listCourses() {
        if (courseCount == 0) {
            System.out.println("No courses registered.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + registeredCourses[i]);
            }
        }
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      //sample courses
        Course[] courses = {
            new Course("CS101", "Intro to Programming", "Basics of Java", 2, "Mon-Wed 10AM"),
            new Course("CS102", "Data Structures", "Stacks, Queues, Trees", 2, "Tue-Thu 11AM"),
            new Course("CS103", "DBMS", "Database Management Systems", 2, "Mon-Wed 2PM")
        };
//student input
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter Name: ");
        String sname = sc.nextLine();
        Student student = new Student(sid, sname);

        int choice;
        do {
            System.out.println("====OPTIONS====");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1://all available courses
                    System.out.println("--- Available Courses ---");
                    for (Course c : courses) {
                        System.out.println("Code: " + c.code);
                        System.out.println("Title: " + c.title);
                        System.out.println("Description: " + c.description);
                        System.out.println("Schedule: " + c.schedule);
                        System.out.println("Slots Left: " + (c.capacity - c.enrolled));
                        System.out.println("--------------------------");
                    }
                    break;

                case 2://register the course
                    System.out.print("Enter Course Code to Register: ");
                    String code = sc.nextLine();
                    boolean found = false;
                    for (Course c : courses) {
                        if (c.code.equalsIgnoreCase(code)) {
                            found = true;
                            if (c.enrolled < c.capacity) {
                                c.enrolled++;
                                student.registerCourse(c.code);
                                System.out.println(" Registered successfully.");
                            } else {
                                System.out.println(" Course is full.");
                            }
                            break;
                        }
                    }
                    if (!found) System.out.println(" Course not found.");
                    break;

                case 3://dropping the course
                    System.out.print("Enter Course Code to Drop: ");
                    String dropCode = sc.nextLine();
                    boolean dropped = false;
                    for (Course c : courses) {
                        if (c.code.equalsIgnoreCase(dropCode)) {
                            c.enrolled--;
                            student.dropCourse(dropCode);
                            System.out.println(" Dropped successfully.");
                            dropped = true;
                            break;
                        }
                    }
                    if (!dropped) System.out.println(" Course not found.");
                    break;

                case 4://display registered courses
                    System.out.println("--- Your Registered Courses ---");
                    student.listCourses();
                    break;

                case 0://exit 
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
