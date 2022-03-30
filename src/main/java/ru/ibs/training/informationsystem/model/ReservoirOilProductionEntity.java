package ru.ibs.training.informationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservoir_oil_production")
public class ReservoirOilProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservoir_oil_production_id_seq")
    @SequenceGenerator(sequenceName = "reservoir_oil_production_id_seq", name = "reservoir_oil_production_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "method_of_influence", nullable = false)
    private String methodOfInfluence;

    @NotNull
    @Column(name = "oil_production", nullable = false)
    private Double oilProduction;

    @NotNull
    @Column(name = "production_increase", nullable = false)
    private Double productionIncrease;

    @ManyToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
