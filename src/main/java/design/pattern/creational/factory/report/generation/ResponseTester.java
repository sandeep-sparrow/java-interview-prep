package design.pattern.creational.factory.report.generation;

import design.pattern.creational.factory.report.dao.Order;
import design.pattern.creational.factory.report.dao.ProcessResult;
import design.pattern.creational.factory.report.generation.french.FrenchResponseGenerator;

public class ResponseTester {
    public static void main(String[] args) {
        Order order1 = Order.builder()
                .orderValue(100.00)
                .phoneNumber("+91-9819148956")
                .customerName("Sandeep")
                .build();

        ProcessResult result1 = ProcessResult.builder()
                .orderId(101)
                .order(order1)
                .responseType(ResponseType.SUCCESS)
                .build();

        FrenchResponseGenerator frenchFactory = new FrenchResponseGenerator();
        Response resp1 = frenchFactory.prepareResponse(result1, result1.responseType);
    }
}
