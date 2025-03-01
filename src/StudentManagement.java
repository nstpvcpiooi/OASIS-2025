public class StudentManagement {

    private Student[] students = new Student[100];
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

        String result = "";
        for (int i = 0; i < size; i++) {
            if (!checked[i]) {
                result += students[i].getGroup() + '\n';
                result += students[i].getInfo() + '\n';
                for (int j = i + 1; j < size; j++) {
                    if (sameGroup(students[i], students[j]) && !checked[j]) {
                        result += students[j].getInfo() + '\n';
                        checked[j] = true;
                    }
                }
                checked[i] = true;
            }
        }

        return result;
    }

    /** removeStudent.*/
    public void removeStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                students[i] = null;
                size--;
                break;
            }
        }
    }

    /** main.*/
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Nguyen Van An");
        s1.setId("17020001");
        s1.setGroup("K62CC");
        s1.setEmail("17020001@vnu.edu.vn");
    }
}