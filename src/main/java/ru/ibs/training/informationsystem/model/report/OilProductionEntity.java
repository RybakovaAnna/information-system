package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 1.
 * Добыча нефти, тонн
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oil_production")
public class OilProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oil_production_id_seq")
    @SequenceGenerator(sequenceName = "oil_production_id_seq", name = "oil_production_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "mining_method", nullable = false, length = 60)
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
    @Column(name = "registered_wells")
    private Integer registeredWells;

    /**
     * Число отработанных скважино-месяцев с начала года
     */
    @Column(name = "worked_wells")
    private Integer workedWells;

    /**
     * Средний дебит на отработанный скважино-месяц, т (фактически)
     */
    @Column(name = "average_flow")
    private Double averageFlow;

    /**
     * Число скважин, дающих продукцию на конец отчетного периода
     */
    @Column(name = "production_wells")
    private Integer productionWells;

    /**
     * Извлечено из скважин жидкости с начала года, т
     */
    @Column(name = "extracted_liquid")
    private Double extractedLiquid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private ReportEntity reportId;

}
