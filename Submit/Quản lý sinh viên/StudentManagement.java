public class StudentManagement {
    public Student[] students = new Student[100];
    public int size = 0;

    /** sameGroup.*/
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /** addStudent.*/
    public void addStudent(Student newStudent) {
        students[size] = newStudent;
        size++;
    }

    /** studentsByGroup.*/
    public String studentsByGroup() {
        boolean[] checked = new boolean[100];

        for (int i = 0; i < size; i++) {
            checked[i] = false;
        }

        String group = "";

        for (int i = 0; i < size; i++) {
            if (!checked[i]) {
                group += students[i].getGroup() + '\n';
                group += students[i].getInfo() + '\n';
                for (int j = i + 1; j < size; j++) {
                    if (sameGroup(students[i], students[j]) && !checked[j]) {
                        group += students[j].getInfo() + '\n';
                        checked[j] = true;
                    }
                }
                checked[i] = true;
            }
        }

        return group;
    }

    /** removeStudent.*/
    public void removeStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < size; j++) {
                    students[j] = students[j + 1];
                }
                students[size] = null;
                size--;
            }
        }
    }
}

