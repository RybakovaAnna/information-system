package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Раздел 5.
 * Фонд скважин на конец отчетного периода, единиц
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "well_fund")
public class WellFundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "well_fund_id_seq")
    @SequenceGenerator(sequenceName = "well_fund_id_seq", name = "well_fund_id_seq")
    private Long id;

    /**
     * Дающие нефть и газ
     */
    @Column(name = "oil_gas_product")
    private int oilGasProduct;

    /**
     * Остановленные в последнем месяце отчетного периода из числа давших добычу в этом месяце
     */
    @Column(name = "stopped_last_month")
    private int stoppedLastMonth;

    /**
     * Итого действующих
     */
    @Column(name = "total_active")
    private int totalActive;

    /**
     * Не дававших продукцию в последнем месяце отчетного периода (бездействующий фонд)
     */
    @Column(name = "dormant_fund")
    private int dormantFund;

    /**
     * Осваиваемые и ожидающие освоения после бурения
     */
    @Column(name = "waiting_after_work")
    private int waitingAfterWork;

    /**
     * в том числе находящиеся в работах по освоению
     */
    @Column(name = "development_work")
    private int developmentWork;

    /**
     * Весь эксплуатационный фонд нефтяных скважин
     */
    @Column(name = "total_fund")
    private int totalFund;

    /**
     * из эксплуатационного фонда нефтяных скважин — телемеханизированные
     */
    @Column(name = "telemechanized")
    private int telemechanized;

    /**
     * Кроме того, скважины: водозаборные и дающие йодобромную и техническую воду
     */
    @Column(name = "water_intake")
    private int waterIntake;

    /**
     * нагнетательные
     */
    @Column(name = "injection")
    private int injection;

    /**
     * в том числе действующие
     */
    @Column(name = "in_active")
    private int inActive;

    /**
     * контрольные
     */
    @Column(name = "control")
    private int control;

    /**
     * поглощающие скважины для сбора сточных вод и прочие
     */
    @Column(name = "waste_water_discharge")
    private int wasteWaterDischarge;

    /**
     * находящиеся в консервации
     */
    @Column(name = "in_conservation")
    private int inConservation;

    /**
     * находящиеся в ожидании ликвидации
     */
    @Column(name = "pending_liquidation")
    private int pendingLiquidation;

    /**
     * ликвидированные после эксплуатации
     */
    @Column(name = "liquidation_expl")
    private int liquidationExpl;

    /**
     * ликвидированные после бурения
     */
    @Column(name = "liquidation_drilling")
    private int liquidationDrilling;

    /**
     * Общий фонд скважин
     */
    @Column(name = "total_wells_fund")
    private int totalWellsFund;

    /**
     * Принято скважин из бурения с начала года
     * (включая ликвидированные и находящиеся в ожидании ликвидации после эксплуатационного и разведочного бурения)
     */
    @Column(name = "in_start_year")
    private int onStartYear;

    /**
     * Принято из газового фонда
     */
    @Column(name = "from_gas_fund")
    private int fromGasFund;

    /**
     * Прибыло в эксплуатационный фонд нефтяных скважин
     */
    @Column(name = "arrived_in_fund")
    private int arrivedInFund;

    /**
     * Выбыло из эксплуатационного фонда нефтяных скважин
     */
    @Column(name = "dropped_out_fund")
    private int droppedOutFund;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}