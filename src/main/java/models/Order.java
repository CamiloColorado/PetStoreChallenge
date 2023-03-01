package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private int id;

    private int petId;

    private int quantity;

    private String shipDate;

    private OrderStatusEnum status;

    private boolean complete;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate='" + shipDate + '\'' +
                ", status=" + status +
                ", complete=" + complete +
                '}';
    }
}
