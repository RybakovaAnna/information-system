package ru.ibs.training.informationsystem.model.report;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 4.
 * Добыча нефти из пластов, разрабатываемых с применением методов
 * искусственного воздействия на пласт, тонн
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservoir_oil_production")
public class ReservoirOilProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservoir_oil_production_id_seq")
    @SequenceGenerator(sequenceName = "reservoir_oil_production_id_seq", name = "reservoir_oil_production_id_seq")
    private Long id;

    /**
     * Методы воздействия
     */
    @NotBlank
    @Column(name = "method_of_influence", nullable = false)
    private String methodOfInfluence;

    /**
     * Добыча нефти с применением методов искусственного воздействия на пласт
     */
    @NotNull
    @Column(name = "oil_production", nullable = false)
    private Double oilProduction;

    /**
     * В том числе увеличение (прирост) добычи за счет применения этих методов (фактически)
     */
    @NotNull
    @Column(name = "production_increase", nullable = false)
    private Double productionIncrease;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
