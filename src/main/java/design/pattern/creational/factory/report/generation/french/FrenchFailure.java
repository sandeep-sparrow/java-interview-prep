package design.pattern.creational.factory.report.generation;

public class FrenchFailure extends Response{

    protected FrenchFailure(ProcessResult result) {
        super(result);
    }

    public void process(){
        System.out.println("print failure information");
    }

    public void convert(){
        System.out.println("convert response to french dialect");
    }
}
