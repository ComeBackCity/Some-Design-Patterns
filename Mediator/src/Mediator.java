import java.util.List;
import java.util.Vector;

public interface Mediator {
    public void recieveScript(Vector<examScript> scripts, List<Integer> marks);
    public void reciveReexReq(examScript e);
    public void rexPrint();
    public void sendReReq();
    public void sendResult();
    public void recieveReResult(Vector<examScript> examScripts, Vector<Boolean> booleans, List<Integer> oldMarks);
    public void sendReResult();
    public void addStudent(Student s);
    public void addTeacher(Teacher t);
    public void scrutinize();
}
