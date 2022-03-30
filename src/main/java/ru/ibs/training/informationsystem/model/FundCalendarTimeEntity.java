package ru.ibs.training.informationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "operating_fund", nullable = false)
    private Double operatingFund;

    @NotNull
    @Column(name = "active_fund", nullable = false)
    private Double activeFund;

    @NotNull
    @Column(name = "operating_time", nullable = false)
    private Double operatingTime;

    @NotNull
    @Column(name = "downtime", nullable = false)
    private Double downtime;

    @NotNull
    @Column(name = "without_production", nullable = false)
    private Double withoutProduction;

    @NotNull
    @Column(name = "not_active", nullable = false)
    private Double notActive;

    @NotNull
    @Column(name = "pending", nullable = false)
    private Double pending;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
