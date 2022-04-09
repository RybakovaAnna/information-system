package ru.ibs.training.informationsystem.model.report;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "number_of_wells", nullable = false)
    private Integer numberOfWells;

    @OneToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
