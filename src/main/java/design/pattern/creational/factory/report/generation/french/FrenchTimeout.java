package design.pattern.creational.factory.report.generation.french;

import design.pattern.creational.factory.report.dao.ProcessResult;
import design.pattern.creational.factory.report.generation.Response;

public class FrenchTimeout extends Response {

    protected FrenchTimeout(ProcessResult result) {
        super(result);
    }

    public void process(){
        System.out.println("print timeout information");
    }

    public void convert(){
        System.out.println("convert response to french dialect");
    }
}
