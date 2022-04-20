package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Раздел 2. Баланс календарного времени фонда нефтяных скважин, часов
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fund_calendar_time")
public class FundCalendarTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fund_calendar_time_id_seq")
    @SequenceGenerator(sequenceName = "fund_calendar_time_id_seq", name = "fund_calendar_time_id_seq")
    private Long id;

    /**
     * Наименование
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Календарное время эксплуатационного фонда — всего (гр. 2 +5+7)
     */
    @NotNull
    @Column(name = "operating_fund", nullable = false)
    private Integer operatingFund;

    /**
     * В том числе календарное время действующего фонда всего
     */
    @NotNull
    @Column(name = "active_fund", nullable = false)
    private Integer activeFund;

    /**
     * В том числе календарное время действующего фонда в том числе время эксплуатации
     */
    @NotNull
    @Column(name = "operating_time", nullable = false)
    private Integer operatingTime;

    /**
     * В том числе календарное время действующего фонда в том числе время простоев
     */
    @NotNull
    @Column(name = "downtime", nullable = false)
    private Integer downtime;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * всего
     */
    @NotNull
    @Column(name = "without_production", nullable = false)
    private Integer withoutProduction;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * в том числе в бездействии с прошлых лет
     */
    @Column(name = "not_active")
    private Integer notActive;

    /**
     * В тои числе календарное время скважин, находящихся в ожидании освоения и освоении после бурения
     */
    @NotNull
    @Column(name = "pending", nullable = false)
    private Integer pending;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}