package ru.ibs.training.informationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "executive")
public class ExecutiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "executive_id_seq")
    @SequenceGenerator(sequenceName = "executive_id_seq", name = "executive_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @NotBlank
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @NotNull
    @Column(name = "telephone", nullable = false)
    private Integer telephone ;

    @NotBlank
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
