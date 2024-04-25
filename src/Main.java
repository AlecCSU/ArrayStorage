import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "1234 Strawberry Fields"));
        students.add(new Student(5, "Paul", "5678 Penny Lane"));
        students.add(new Student(3, "George", "9876 Blue Jay Way"));
        students.add(new Student(4, "Ringo", "6543 Octopus Gardens"));
        students.add(new Student(2, "Brian", "3210 Abby Road"));

        // Sort by name
        System.out.println("Before sorting by name:");
        printStudents(students);
        selectionSort(students, new StudentSortByName());
        System.out.println("After sorting by name:");
        printStudents(students);

        // Sort by roll number
        System.out.println("Before sorting by roll number:");
        printStudents(students);
        selectionSort(students, new StudentSortByRollNo());
        System.out.println("After sorting by roll number:");
        printStudents(students);
    }

    private static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap if minIndex changed
            if (minIndex != i) {
                Student temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }

    private static void printStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
