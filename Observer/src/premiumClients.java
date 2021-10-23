public class premiumClients implements Observer {

    private serverState serverState;
    private Subject company;
    private String response;


    public premiumClients(Subject company) {
        this.company = company;
        this.response = "No";
        company.registerObserver(this);
        this.serverState = new serverState(0);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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
            pdtow();
        }
        else if(this.serverState.getState() == 1 && serverState.getState() == 2)
        {
            pdtofd(response);
        }
        else if(this.serverState.getState() == 2 && serverState.getState() == 0)
        {
            fdtow();
        }
        else if(this.serverState.getState() == 2 && serverState.getState() == 1)
        {
            fdtopd();
        }
        this.serverState = serverState;

    }



    public void wtopd(){
        System.out.println("Server is partially down");
        System.out.println("Do you want to take service from our partner server?");
    }
    public void wtofd(){
        System.out.println("Server is fully down");
        System.out.println("Enjoy the service from our partner DEF company");
    }
    public void pdtofd(String response){
        System.out.println("Server is fully down");
        if (response.equalsIgnoreCase("Yes"))
            System.out.println("We transfered the data to DEF server");
    }
    public void pdtow(){
        System.out.println("Server is fully active");
    }
    public void fdtow(){
        System.out.println("Server is fully active");
    }
    public void fdtopd(){
        System.out.println("Server is partially down");
    }


}
