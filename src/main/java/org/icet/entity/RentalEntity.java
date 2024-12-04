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
@Table(name = "rental")

public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    private Long itemId;

    private LocalDate rentalDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private String totalCost;
}
