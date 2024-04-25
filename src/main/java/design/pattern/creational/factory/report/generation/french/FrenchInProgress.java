package design.pattern.creational.factory.report.generation.french;

import design.pattern.creational.factory.report.dao.ProcessResult;
import design.pattern.creational.factory.report.generation.Response;

public class FrenchInProgress extends Response {

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
