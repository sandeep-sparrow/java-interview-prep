package design.pattern.creational.factory.report.generation;

public class FrenchSuccess extends Response{

    protected FrenchSuccess(ProcessResult result) {
        super(result);
    }

    public void process(){
        System.out.println("print success information");
    }

    public void convert(){
        System.out.println("convert response to french dialect");
    }
}
