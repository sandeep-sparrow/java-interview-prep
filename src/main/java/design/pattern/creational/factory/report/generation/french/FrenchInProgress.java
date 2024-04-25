package design.pattern.creational.factory.report.generation;

public class FrenchInProgress extends Response{

    protected FrenchInProgress(ProcessResult result) {
        super(result);
    }

    public void process(){
        System.out.println("print in progress information");
    }

    public void convert(){
        System.out.println("convert response to french dialect");
    }
}
