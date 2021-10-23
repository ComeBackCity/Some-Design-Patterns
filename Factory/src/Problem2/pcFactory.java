package Problem2;

public class pcFactory {
    public computerFactory getPC(String s){
        if(s == null)
            return null;
        if(s.equalsIgnoreCase("A"))
            return new computerFactoryA();
        else if (s.equalsIgnoreCase("B"))
            return  new computerFactoryB();
        else if(s.equalsIgnoreCase("C"))
            return  new computerFactoryC();

        return null;
    }
}
