import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Teacher {
    Mediator mediator;
    int id = 0;
    Vector<examScript> scripts ;
    List<Integer> marks ;
    Vector<examScript> examScriptVector = new Vector<>() ;
    Vector<Boolean> booleanVector = new Vector<>();

    public Teacher(Mediator mediator, int id) {
        this.mediator = mediator;
        this.id = id;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vector<examScript> getScripts() {
        return scripts;
    }

    public void setScripts(Vector<examScript> scripts) {
        this.scripts = scripts;
        //System.out.println(this.scripts.size());
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public void send(){
        String message;
        message = "[Examiner]Scripts and marks of student id ";
        for (int i=0; i<scripts.size(); i++) {
            message += scripts.get(i).getStudentID();
            if (i<scripts.size()-1)
                message += "," ;
        }
        message+= " sent to exam controller office";
        System.out.println(message);
        System.out.println();
        mediator.recieveScript(scripts,marks);
        /*scripts.clear();
        marks.clear();*/
    }

    public void reExamineReq(examScript e){
        examScriptVector.add(e);

    }

    public void examinerFullPrint(){
        //System.out.println(examScriptVector.size());
        System.out.print("\n[Examiner]Exam script of student id " );
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
        System.out.println(" received for re-examination");
    }

    public void changeAll(){
        marks.clear();
        for (int i=0; i<examScriptVector.size(); i++){
            change(examScriptVector.get(i));
        }

        mediator.recieveReResult(examScriptVector,booleanVector,marks);
    }

    public void change(examScript recheck){
        String s = "\nMarks of student id " + recheck.getStudentID() + " changed. Previous mark: " + recheck.getMarks() + " , now the corrected mark: " ;
        double a = (Math.random() * (1-0)+1)+0;
        boolean changed = false;
        //a = 0.4;
        if(a>0.5){
            marks.add(recheck.getMarks());
            int _toadd = (int) ((Math.random() * (10-1)+1)+1);
            recheck.setMarks(recheck.getMarks() + _toadd);
            changed = true;
            booleanVector.add(changed);

        }
        if(changed)
            s += recheck.getMarks();
        else{
            marks.add(recheck.getMarks());
            s = "\nMarks of student id " + recheck.getStudentID() + " is unchanged" ;
            booleanVector.add(changed);
        }

        System.out.print(s);
        //mediator.recieveReResult(recheck);
    }



}
