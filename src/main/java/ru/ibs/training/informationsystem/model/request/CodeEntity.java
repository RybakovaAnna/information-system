package ru.ibs.training.informationsystem.model.request;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "code")
public class CodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codes_id_seq")
    @SequenceGenerator(sequenceName = "codes_id_seq", name = "codes_id_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "okud", nullable = false)
    private Integer okud;

    @NotNull
    @Column(name = "okpo", nullable = false)
    private Integer okpo;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;

}
