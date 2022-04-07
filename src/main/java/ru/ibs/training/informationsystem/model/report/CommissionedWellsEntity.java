package ru.ibs.training.informationsystem.model.report;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commissioned_wells")
public class CommissionedWellsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commissioned_wells_id_seq")
    @SequenceGenerator(sequenceName = "commissioned_wells_id_seq", name = "commissioned_wells_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "in_all", nullable = false)
    private Integer inAll;

    @NotNull
    @Column(name = "from_drilling", nullable = false)
    private Integer fromDrilling;

    @NotNull
    @Column(name = "from_conservation", nullable = false)
    private Integer fromConservation;

    @NotNull
    @Column(name = "from_other_funds", nullable = false)
    private Integer fromOtherFunds;

    @NotNull
    @Column(name = "dormant", nullable = false)
    private Integer  dormant;

    @ManyToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
