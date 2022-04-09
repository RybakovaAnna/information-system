package ru.ibs.training.informationsystem.model.report;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oil_movement")
public class OilMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oil_movement_id_seq")
    @SequenceGenerator(sequenceName = "oil_movement_id_seq", name = "oil_movement_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "number", nullable = false)
    private Double number;

    @OneToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
