package ru.ibs.training.informationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank
    @Column(name = "showing", nullable = false)
    private String showing;

    @NotNull
    @Column(name = "actually", nullable = false)
    private Double actually;

    @ManyToOne
    @JoinColumn(name="report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
