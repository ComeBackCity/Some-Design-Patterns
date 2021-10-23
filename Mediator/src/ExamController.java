import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ExamController implements Mediator {

    Vector<Student> students ;
    Vector<Teacher> teachers ;
    int studentID = 0;
    int teacherID = 0;
    Vector<examScript> scripts ;
    List<Integer> marks ;
    float probability = (float) 0.5;
    Vector<examScript> examScriptVector = new Vector<>();
    List<Integer> integers ;
    Vector<Boolean> afterChange = new Vector<>();
    examScript e,re;


    public ExamController() {
        students = new Vector<>();
        teachers = new Vector<>();
        scripts = new Vector<>();
        marks = new LinkedList<>();
    }

    @Override
    public void recieveScript(Vector<examScript> scripts, List<Integer> marks) {
        //String s = "";
        this.scripts = scripts;
        //System.out.println(this.scripts.size());
        this.marks = marks;
        System.out.print("[Exam Controller]Scripts and marks of ");
        for(int i=1; i<=scripts.size(); i++){
            if(i==scripts.size()){
                System.out.print(i + " ");
            }
            else
                System.out.print(i + ",");
        }
        System.out.println(" have been received");
        for(int i=0; i<scripts.size(); i++)
        {
            System.out.print("Student id: " + this.scripts.get(i).getStudentID() + " marks: " + this.marks.get(i) + ".\n");
        }
        System.out.println();

    }

    @Override
    public void reciveReexReq(examScript e) {
        this.examScriptVector.add(e);
    }

    void loopPrint(){
        for (int i=0; i<examScriptVector.size(); i++){
            if(i==examScriptVector.size()-1){
                System.out.print(examScriptVector.get(i).getStudentID() );
            }
            else if(i==examScriptVector.size()-2){
                System.out.print(examScriptVector.get(i).getStudentID() + " and ");
            }
            else {
                System.out.print(examScriptVector.get(i).getStudentID() + ",");
            }

        }
    }

    @Override
    public void rexPrint() {
        System.out.print("\n[Exam Controller]Re-examine request recieved from student ID " );
        loopPrint();
        System.out.println();
    }


    @Override
    public void sendReReq() {
        System.out.print("\n[Exam Controller]Exam script of student id " );
        loopPrint();
        System.out.println(" have been sent to the examiner");
        for (int i=0 ;i<examScriptVector.size(); i++){
            teachers.get(teacherID).reExamineReq(examScriptVector.get(i));
        }

    }

    @Override
    public void sendResult() {
        for (int i=0; i<scripts.size(); i++)
        {
            for (int j=0; j<students.size(); j++)
            {
                if(students.get(j).getId() == scripts.get(i).getStudentID())
                {
                    students.get(j).setResult(scripts.get(i));
                }
            }
        }

        System.out.println("\n[Exam Controller] Result has been sent ot the respective student");
    }

    @Override
    public void recieveReResult(Vector<examScript> examScripts, Vector<Boolean> booleans, List<Integer> oldMarks) {
        this.examScriptVector.clear();
        this.examScriptVector = examScripts;
        this.afterChange = booleans;
        this.integers = oldMarks;
        System.out.println("\n\n[Exam Controller]Received updated marks from teacher");
        for (int i=0; i<booleans.size(); i++){
            if(booleans.get(i)){
                System.out.println("Marks of student id " + examScripts.get(i).getStudentID() + " updated from " + oldMarks.get(i) + " to " + examScripts.get(i).getMarks());
            }
            else {
                System.out.println("Marks of student id " + examScripts.get(i).getStudentID() + " is unchanged");
            }
        }
    }

    @Override
    public void sendReResult() {
        System.out.println("\n[Exam Controller]Recheck result has been sent to student");
        for (int k=0 ;k<examScriptVector.size(); k++){
            for (int i=0; i<students.size(); i++){
                if(students.get(i).getId() == examScriptVector.get(k).getStudentID()){
                    students.get(i).setResult(examScriptVector.get(k));
                    if(afterChange.get(k)){
                        System.out.print("\nUpdated marks have been sent to student id " + students.get(i).getId());
                        students.get(i).setUpdated(afterChange.get(k));
                        students.get(i).setOldMark(integers.get(k));

                    }
                    else {
                        System.out.print("\nStudent id " + students.get(i).getId() + " have been informed of no change");
                        students.get(i).setUpdated(afterChange.get(k));
                        students.get(i).setOldMark(integers.get(k));
                    }
                }
            }
        }

    }

    @Override
    public void addStudent(Student s) {
        students.add(s);
    }

    @Override
    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    @Override
    public void scrutinize() {
        int count = 0,old_mark = 0;
        System.out.println("[Exam Controller]Scrutinization has been done");
        for (int i=0; i<scripts.size()-1; i++){
            double a = (Math.random() * (1-0))+0;
            //System.out.println(a);
            //System.out.println(old_mark);
            if(a > probability)
            {
                int _toadd = (int) ((Math.random() * (10-1)+1)+1);
                count++;
                old_mark = marks.get(i);
                marks.set(i,marks.get(i)+_toadd) ;
                scripts.get(i).setMarks(marks.get(i));
                System.out.println("Mark of student id " + scripts.get(i).getStudentID() + " was incorrect.\nPrevious mark: " + old_mark + ", Corrected mark: " + marks.get(i));
                //System.out.println("Old mark of student id " + scripts.get(i).getStudentID() + " is " + old_mark + " and new mark is " + marks.get(i));
            }


        }

        if(count == 0){
            int i = scripts.size()-1;
            //System.out.println(i);
            double a = (Math.random() * (1-0)+1)+0;
            if(a > probability)
            {
                int _toadd = (int) ((Math.random() * (10-1)+1)+1);
                old_mark = marks.get(i);
                marks.set(i,marks.get(i)+_toadd) ;
                scripts.get(i).setMarks(marks.get(i));
                System.out.println("Old mark of student id " + scripts.get(i).getStudentID() + " is " + old_mark + "and new mark is" + marks.get(i));
            }


        }

    }

}
