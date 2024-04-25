package design.pattern.creational.factory.report.dao;

import design.pattern.creational.factory.report.generation.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProcessResult {

    public int orderId;
    public Order order;
    public ResponseType responseType;

}
