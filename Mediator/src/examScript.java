public class examScript {
    private int studentID;
    private int marks;
    private int teacherID;

    public examScript(int studentID) {
        this.studentID = studentID;
    }

    public examScript(int studentID, int marks) {
        this.studentID = studentID;
        this.marks = marks;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
