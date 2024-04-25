package design.pattern.creational.factory.report.generation;

public enum ResponseType {

    SUCCESS("Success!"),
    FAILURE("Failure!"),
    TIMEOUT("Time out!"),
    IN_PROGRESS("In Progress!");

    private final String msg;

    ResponseType(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
