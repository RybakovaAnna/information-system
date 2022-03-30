package ru.ibs.training.informationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oil_production")
public class OilProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oil_production_id_seq")
    @SequenceGenerator(sequenceName = "oil_production_id_seq", name = "oil_production_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "mining_method", nullable = false)
    private String miningMethod;

    @NotNull
    @Column(name = "oil", nullable = false)
    private Double oil;

    @NotNull
    @Column(name = "registered_wells", nullable = false)
    private Integer registeredWells;

    @NotNull
    @Column(name = "worked_wells", nullable = false)
    private Integer workedWells;

    @NotNull
    @Column(name = "average_flow", nullable = false)
    private Double averageFlow;

    @NotNull
    @Column(name = "production_wells", nullable = false)
    private Integer  productionWells;

    @NotNull
    @Column(name = "extracted_liquid", nullable = false)
    private Double extractedLiquid;

    @ManyToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;

}
