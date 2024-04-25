package design.pattern.creational.factory.report.generation;

public class FrenchResponseGenerator extends ResponseGenerator{
    @Override
    protected Response construct(ProcessResult result, ResponseType type) {
        Response response = null;
        switch (type){
            case SUCCESS:
                response = new FrenchSuccess(result);
                break;
            case FAILURE:
                response = new FrenchFailure(result);
                break;
            case TIMEOUT:
                response = new FrenchTimeout(result);
                break;
            case IN_PROGRESS:
                response = new FrenchInProgress(result);
                break;

        }
        return response;
    }
}
