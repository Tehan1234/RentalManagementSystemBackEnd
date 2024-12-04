package org.icet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bill")


public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long customerId;
    private String customerName;
    private Long itemId;
    private String itemName;
    private LocalDate rentalStartDate;
    private  LocalDate expectedReturnDate;
    private Double totalCost;
}
