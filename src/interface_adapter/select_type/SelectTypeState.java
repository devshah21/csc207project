package interface_adapter.select_type;

public class SelectTypeState {

    private String totalQ = "";

    private String username = "";

    public SelectTypeState(SelectTypeState copy){
        totalQ = copy.totalQ;
        username = copy.username;
    }

    public SelectTypeState() {}

    public String getTotalQ(){return totalQ;}
    public void setTotalQ(String totalQ){this.totalQ = totalQ;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

}
