package ru.ibs.training.informationsystem.model;

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

    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private CodeEntity code;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilProductionEntity> oilProduction;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FundCalendarTimeEntity> fundCalendarTime;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CommissionedWellsEntity> commissionedWells;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ReservoirOilProductionEntity> reservoirOilProduction;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WellFundEntity> wellFund;

    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private GasProductionEntity gasProduction;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilMovementEntity> oilMovement;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OilPreparationEntity> oilPreparation;

    @OneToOne(mappedBy = "reportId", cascade = CascadeType.ALL)
    private ExecutiveEntity executive;

    @Column(name = "date")
    private LocalDate date;
}
