package design.pattern.creational.factory.report.generation;

import design.pattern.creational.factory.report.dao.ProcessResult;

public abstract class Response {
    protected String message;
    protected ProcessResult result;
    protected String response;

    protected Response(ProcessResult result){
        this.result = result;
    }

    public void read(){
        System.out.print("read provided iformation");
    }

    public void process() {
        System.out.print("process data before formatting");
    }

    public void format(){
        System.out.print("format data to json format");
    }
}
