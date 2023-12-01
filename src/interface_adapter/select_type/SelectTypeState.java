package interface_adapter.select_type;

public class SelectTypeState {

    private String totalQ = "";

    public SelectTypeState(SelectTypeState copy){totalQ = copy.totalQ;}

    public SelectTypeState() {}

    public String getTotalQ(){return totalQ;}
    public void setTotalQ(String totalQ){this.totalQ = totalQ;}

}
