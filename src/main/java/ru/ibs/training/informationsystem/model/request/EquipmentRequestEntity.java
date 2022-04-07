package ru.ibs.training.informationsystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application_for_equipment")
public class EquipmentRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_for_equipment_id_seq")
    @SequenceGenerator(sequenceName = "application_for_equipment_id_seq", name = "application_for_equipment_id_seq")
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @NotBlank
    @Column(name = "type_of_equipment", nullable = false, length = 50)
    private String TypeOfEquipment;

    @NotBlank
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotBlank
    @Column(name = "justification", nullable = false)
    private String justification;
}
