package ru.ibs.training.informationsystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

/**
 * Заявка на оборудование
 */
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
    private UUID id;

    /**
     * Статус
     */
    @NotBlank
    @Column(name = "status", nullable = false, length = 15)
    private String status;

    /**
     * Наименование оборудования
     */
    @NotBlank
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    /**
     * Тип оборудования
     */
    @NotBlank
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    /**
     * Требуемое количество
     */
    @NotNull
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /**
     * Дата
     */
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * Обоснование
     */
    @NotBlank
    @Column(name = "justification", nullable = false)
    private String comment;
}
