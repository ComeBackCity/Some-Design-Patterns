public class Student {
    Mediator mediator;
    int id ;
    examScript result;
    boolean isUpdated;
    int oldMark;

    public Student(Mediator mediator, int id) {
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

    public examScript getResult() {
        return result;
    }

    public void setResult(examScript result) {
        this.result = result;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public int getOldMark() {
        return oldMark;
    }

    public void setOldMark(int oldMark) {
        this.oldMark = oldMark;
    }

    public void printResult(){
        System.out.println("[Student " + id + "] Result published. Got " + result.getMarks());
        //System.out.println("Result of "+ id + " is " + result.getMarks());
    }

    public void reexamineRequest(){
        System.out.println("Re-examine request sent");
        mediator.reciveReexReq(result);
    }

    public void printReexamineResult(){
        System.out.print("[Student id " + id +"]");
        if(isUpdated){
            System.out.println("Marks was previously " + oldMark + ". Now corrected marks are " + result.getMarks());
        }
        else {
            System.out.println("Marks unchanged");
        }
    }

}
