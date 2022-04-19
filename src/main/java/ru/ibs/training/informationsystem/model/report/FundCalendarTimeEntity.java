package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 2. Баланс календарного времени фонда нефтяных скважин, часов
 */
@Entity
@Data
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
    private Double operatingFund;

    /**
     * В том числе календарное время действующего фонда всего
     */
    @NotNull
    @Column(name = "active_fund", nullable = false)
    private Double activeFund;

    /**
     * В том числе календарное время действующего фонда в том числе время эксплуатации
     */
    @NotNull
    @Column(name = "operating_time", nullable = false)
    private Double operatingTime;

    /**
     * В том числе календарное время действующего фонда в том числе время простоев
     */
    @NotNull
    @Column(name = "downtime", nullable = false)
    private Double downtime;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * всего
     */
    @NotNull
    @Column(name = "without_production", nullable = false)
    private Double withoutProduction;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * в том числе в бездействии с прошлых лет
     */
    @NotNull
    @Column(name = "not_active", nullable = false)
    private Double notActive;

    /**
     * В тои числе календарное время скважин, находящихся в ожидании освоения и освоении после бурения
     */
    @NotNull
    @Column(name = "pending", nullable = false)
    private Double pending;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
