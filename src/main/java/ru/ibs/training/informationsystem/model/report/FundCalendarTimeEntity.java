package ru.ibs.training.informationsystem.model.report;

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
    private Integer operatingFund;

    @NotNull
    @Column(name = "active_fund", nullable = false)
    private Integer activeFund;

    @NotNull
    @Column(name = "operating_time", nullable = false)
    private Integer operatingTime;

    @NotNull
    @Column(name = "downtime", nullable = false)
    private Integer downtime;

    @NotNull
    @Column(name = "without_production", nullable = false)
    private Integer withoutProduction;

    @NotNull
    @Column(name = "not_active", nullable = false)
    private Integer notActive;

    @NotNull
    @Column(name = "pending", nullable = false)
    private Integer pending;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
