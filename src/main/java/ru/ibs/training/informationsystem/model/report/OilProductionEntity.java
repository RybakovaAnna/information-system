package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 1.
 * Добыча нефти, тонн
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "mining_method")
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

    /**
     * Добыча с начала года
     */
    @NotNull
    @Column(name = "oil", nullable = false)
    private Double oil;

    /**
     * Число числившихся скважино-месяцев с начала года
     */
    @NotNull
    @Column(name = "registered_wells", nullable = false)
    private Integer registeredWells;

    /**
     * Число отработанных скважино-месяцев с начала года
     */
    @NotNull
    @Column(name = "worked_wells", nullable = false)
    private Integer workedWells;

    /**
     * Средний дебит на отработанный скважино-месяц, т (фактически)
     */
    @NotNull
    @Column(name = "average_flow", nullable = false)
    private Double averageFlow;

    /**
     * Число скважин, дающих продукцию на конец отчетного периода
     */
    @NotNull
    @Column(name = "production_wells", nullable = false)
    private Integer productionWells;

    /**
     * Извлечено из скважин жидкости с начала года, т
     */
    @NotNull
    @Column(name = "extracted_liquid", nullable = false)
    private Double extractedLiquid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private ReportEntity reportId;

}
