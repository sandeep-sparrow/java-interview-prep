package design.pattern.creational.factory.report.generation.french;

import design.pattern.creational.factory.report.dao.ProcessResult;
import design.pattern.creational.factory.report.generation.Response;

public class FrenchSuccess extends Response {

    protected FrenchSuccess(ProcessResult result) {
        super(result);
    }

    public void process(){
        System.out.println("print success information - french");
    }

    public void convert(){
        System.out.println("convert response to french dialect");
    }
}
