package Model;

public class Error {
    private String message;
    private String type;

    public Error() {
        this.message = "";
        this.type = "";
    }

    public void setNeedleError (String msg){
        this.message = msg;
        this.type = "NEEDLE";
    }

    public void setPumpError (String msg){
        this.message = msg;
        this.type = "PUMP";
    }

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }
}
