package design.pattern.creational.factory.report.generation;

import design.pattern.creational.factory.report.dao.ProcessResult;

public abstract class ResponseGenerator {
    public Response prepareResponse(ProcessResult result, ResponseType type){
        Response response = construct(result, type);
        response.read();
        response.process();
        response.format();
        return response;
    }

    protected abstract Response construct(ProcessResult result, ResponseType type);
}
