package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 3.
 * Ввод в действие скважин, единиц
 */
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

    /**
     * Наименование
     */
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Новые скважины Всего (гр. 2+3+4)
     */
    @NotNull
    @Column(name = "in_all", nullable = false)
    private Integer inAll;

    /**
     * Новые скважины в том числе из бурения и освоения после бурения
     */
    @NotNull
    @Column(name = "from_drilling", nullable = false)
    private Integer fromDrilling;

    /**
     * Новые скважины в том числе из консервации
     */
    @NotNull
    @Column(name = "from_conservation", nullable = false)
    private Integer fromConservation;

    /**
     * Новые скважины в том числе из других фондов скважин
     */
    @NotNull
    @Column(name = "from_other_funds", nullable = false)
    private Integer fromOtherFunds;

    /**
     * Введенные из бездействия(с прошлых лет)
     */
    @NotNull
    @Column(name = "dormant", nullable = false)
    private Integer dormant;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
