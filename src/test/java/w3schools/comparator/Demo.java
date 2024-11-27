package w3schools.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Student - age , name
 * 2. Sorting the age of the students
 */
class Student {
    public String name;
    public int age;

    public Student(String n, int a) {
        name = n;
        age = a;
    }
}

class Demo implements Comparator {
    public static Logger log = LogManager.getLogger(ArrayListComparator.class);

    static Comparator<Student> com = new Comparator<Student>() {
        @Override
        public int compare(Student i, Student j) {
            if (i.age > j.age) return 1;
            if (i.age < j.age) return -1;
            return 0;
        }
    };

    public static void main(String[] args) {
        List<Student> studs = new ArrayList<>();
        studs.add(new Student("Collins", 35));
        studs.add(new Student("Ethan", 8));
        studs.add(new Student("Ezra", 39));
        studs.add(new Student("emilia", 6));

        // Use a comparator to sort the age of students
        // system asked to use list sort itself
        studs.sort(com);

        for (Student s : studs) {
            log.info("{} {} ", s.name, s.age);
        }
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

