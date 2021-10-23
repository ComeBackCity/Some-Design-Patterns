import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class exam_Result {
    public static void main(String[] args) {
        ExamController e = new ExamController();
        Vector<examScript> examScriptVector = new Vector<>();
        Vector<Student> students = new Vector<>();
        List<Integer> marksheet = new LinkedList<>();
        Vector<Integer> integerVector = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        for (int i=1; i<=5; i++){
            Student s = new Student(e,i);
            e.addStudent(s);
            students.add(s);
            int marks = (int) (Math.random() * (95-0)+1);
            examScript examScript = new examScript(i,marks);
            examScriptVector.add(examScript);
            marksheet.add(marks);
            /*integerVector.add(false);*/
        }


        Teacher teacher = new Teacher(e,1);
        e.addTeacher(teacher);
        teacher.setScripts(examScriptVector);
        teacher.setMarks(marksheet);
        teacher.send();
        e.scrutinize();
        e.sendResult();
        System.out.println("\n[Student--->]");
        for(int i=0; i<students.size(); i++){
            students.get(i).printResult();
            System.out.println("Do you want to apply for re-examine?\n" + "1. yes\n" + "2. no");
            integerVector.add(scanner.nextInt());
            if(integerVector.get(i) == 1){
                students.get(i).reexamineRequest();
            }
        }
        e.rexPrint();
        e.sendReReq();
        teacher.examinerFullPrint();
        teacher.changeAll();
        e.sendReResult();
        System.out.println("\n ");
        for (int i=0; i<integerVector.size(); i++){
            if(integerVector.get(i)==1){
                students.get(i).printReexamineResult();
            }
        }
    }
}
