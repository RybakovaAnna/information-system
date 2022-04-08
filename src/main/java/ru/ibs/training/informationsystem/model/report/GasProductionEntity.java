package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gas_production")
public class GasProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gas_production_id_seq")
    @SequenceGenerator(sequenceName = "gas_production_id_seq", name = "gas_production_id_seq")
    private Long id;

    @NotNull
    @Column(name = "production", nullable = false)
    private Double production;

    @NotNull
    @Column(name = "consumption", nullable = false)
    private Double consumption;

    @NotNull
    @Column(name = "losses", nullable = false)
    private Double losses;

    @NotNull
    @Column(name = "burnt", nullable = false)
    private Double burnt;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
