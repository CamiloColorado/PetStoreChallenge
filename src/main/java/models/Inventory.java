package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    private int approved;

    private int placed;

    private int delivered;

    @Override
    public String toString() {
        return "Inventory{" +
                "approved=" + approved +
                ", placed=" + placed +
                ", delivered=" + delivered +
                '}';
    }
}
