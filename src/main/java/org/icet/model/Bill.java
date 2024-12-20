package org.icet.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bill {

    private Long customerId;
    private String customerName;
    private Long itemId;
    private String itemName;
    private LocalDate rentalStartDate;
    private  LocalDate expectedReturnDate;
    private Double totalCost;
}
