package ru.ibs.training.informationsystem.model.report;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Раздел 8.
 * Подготовка нефти (включая газовый конденсат), тонн
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oil_preparation")
public class OilPreparationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oil_preparation_id_seq")
    @SequenceGenerator(sequenceName = "oil_preparation_id_seq", name = "oil_preparation_id_seq")
    private Long id;

    /**
     * Поступало жидкости на установки по подготовке нефти
     */
    @Column(name = "received_liquid")
    private double receivedLiquid;

    /**
     * Получено нефти с установок
     */
    @Column(name = "received_oil")
    private double receivedOil;

    /**
     * Подготовлено нефти другими способами (трубная деэмульсация, простой, отстой и другое)
     */
    @Column(name = "prepared_oil")
    private double preparedOil;

    /**
     * Потери нефти при подготовке
     */
    @Column(name = "oil_losses")
    private double oilLosses;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
