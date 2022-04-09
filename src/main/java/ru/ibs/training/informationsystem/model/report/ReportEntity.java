package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_seq")
    @SequenceGenerator(sequenceName = "report_id_seq", name = "report_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "name_company", nullable = false)
    private String nameCompany;

    @NotBlank
    @Column(name = "mailing_address")
    private String mailingAddress;

    /**
     * Код
     */
    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private CodeEntity code;

    /**
     * Раздел 1.
     * Добыча нефти, тонн
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilProductionEntity> oilProduction;

    /**
     * Раздел 2.
     * Баланс календарного времени фонда нефтяных скважин, часов
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FundCalendarTimeEntity> fundCalendarTime;

    /**
     * Раздел 3.
     * Ввод в действие скважин, единиц
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CommissionedWellsEntity> commissionedWells;

    /**
     * Раздел 4.
     * Добыча нефти из пластов, разрабатываемых с применением методов
     * искусственного воздействия на пласт, тонн
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ReservoirOilProductionEntity> reservoirOilProduction;

    /**
     * Раздел 5.
     * Фонд скважин на конец отчетного периода, единиц
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WellFundEntity> wellFund;

    /**
     * Раздел 6.
     * Добыча нефтяного (попутного) газа, тысяч кубических метров
     */
    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private GasProductionEntity gasProduction;

    /**
     * Раздел 7.
     * Движение нфти (включая газовый конденсат) с начала года, тонн
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilMovementEntity> oilMovement;

    /**
     * Раздел 8.
     * Подготовка нефти (включая газовый конденсат), тонн
     */
    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilPreparationEntity> oilPreparation;

    /**
     * Должностное лицо, ответственное за предоставление данных
     */
    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private ExecutiveEntity executive;

    @Column(name = "date")
    private LocalDate date;
}