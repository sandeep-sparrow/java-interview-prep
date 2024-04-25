package design.pattern.creational.factory.report.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String customerName;
    private String phoneNumber;
    private Double orderValue;

}
