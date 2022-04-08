package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Раздел 7.
 * Движение нфти (включая газовый конденсат) с начала года, тонн
 */
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

    /**
     * Остаток на начало отчетного года
     */
    @Column(name = "balance_at_the_beginning")
    private double balanceAtTheBeginning;

    /**
     * Приход: добыто
     */
    @Column(name = "extracted")
    private double extracted;

    /**
     * поступило от других предприятий
     */
    @Column(name = "succumbed")
    private double succumbed;

    /**
     * Итого
     */
    @Column(name = "total")
    private double total;

    /**
     * Расход на производственно-технические нужды
     */
    @Column(name = "expenses_for_technical_needs")
    private double expensesForTechnicalNeeds;

    /**
     * Потери — всего
     */
    @Column(name = "total_loss")
    private double totalLoss;

    /**
     * Сдано — всего
     */
    @Column(name = "total_handed_over")
    private double totalHandedOver;

    /**
     * в том числе: нефтегазоперерабатывающим заводам
     */
    @Column(name = "oil_and_gas_processing")
    private double oilAndGasProcessing;

    /**
     * в том числе газоперерабатывающим
     */
    @Column(name = "gas_processing")
    private double gasProcessing;

    /**
     * сдано широкой фракции от стабилизации нефти
     */
    @Column(name = "oil_stabilized")
    private double oilStabilized;

    /**
     * экспорт
     */
    @Column(name = "export")
    private double export;

    /**
     * бурению
     */
    @Column(name = "drilling")
    private double drilling;

    /**
     * прочим своим предприятиям и организациям1
     */
    @Column(name = "other_organizations")
    private double otherOrganizations;

    /**
     * отпущено прочим предприятиям1
     */
    @Column(name = "released_to_enterprises")
    private double releasedToEnterprises;

    /**
     * Итого расхода
     */
    @Column(name = "total_consumption")
    private double totalConsumption;

    /**
     * Остаток на конец отчетного периода
     */
    @Column(name = "balance_at_the_end")
    private double balanceAtTheEnd;

    /**
     * в том числе в нефтепроводах и емкостях, введенных в отчетном году
     */
    @Column(name = "in_oil_pipelines")
    private double inOilPipelines;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
