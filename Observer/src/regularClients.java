public class regularClients implements Observer {

    private serverState serverState;
    private Subject company;
    private String response;
    private int hour;

    public regularClients(Subject company) {
        this.company = company;
        this.response = "No";
        this.hour = 0;
        company.registerObserver(this);
        this.serverState = new serverState(0);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
        //this.setHour(0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public void update(serverState serverState) {
        if(this.serverState.getState() == 0 && serverState.getState() == 1)
        {
            wtopd();
        }
        else if(this.serverState.getState() == 0 && serverState.getState() == 2)
        {
            wtofd();
        }
        else if(this.serverState.getState() == 1 && serverState.getState() == 0)
        {
            pdtow(response,hour);
        }
        else if(this.serverState.getState() == 1 && serverState.getState() == 2)
        {
            pdtofd();
        }
        else if(this.serverState.getState() == 2 && serverState.getState() == 0)
        {
            fdtow(response,hour);
        }
        else if(this.serverState.getState() == 2 && serverState.getState() == 1)
        {
            fdtopd();
        }
        this.serverState = serverState;
    }



    public void wtopd(){
        System.out.println("Server is partially down");
        System.out.println("Do you want to use full functionality for 20$ a hour?");
    }
    public void wtofd(){
        System.out.println("Server is fully down");
        System.out.println("Do you want to use full functionality for 20$ a hour?");
    }
    public void pdtofd(){
        System.out.println("Server is fully down");
    }
    public void pdtow(String response, int hour){
        System.out.println("Server is fully active");
        if(response.equalsIgnoreCase("Yes"))
        {
            //System.out.println("Debug hour=" + hour);
            int bill = hour * 20;
            System.out.println("Your last service bill is " + bill + "$");
        }

    }
    public void fdtow(String response, int hour){
        System.out.println("Server is fully active");
        if(response.equalsIgnoreCase("Yes"))
        {
            //System.out.println("Debug hour=" + hour);
            int bill = hour * 20;
            System.out.println("Your last service bill is " + bill + "$");
        }
    }
    public void fdtopd(){
        System.out.println("Server is partially down");
    }
}
