package ru.ibs.training.informationsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Должностное лицо, ответственное за предоставление данных
 */
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

    /**
     * Должность
     */
    @NotBlank
    @Column(name = "position", nullable = false, length = 50)
    private String position;

    /**
     * Ф.И.О
     */
    @NotBlank
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    /**
     * Номер контактного телефона
     */
    @NotNull
    @Column(name = "telephone", nullable = false)
    private Integer telephone;

    /**
     * E-mail
     */
    @NotBlank
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportId;
}
