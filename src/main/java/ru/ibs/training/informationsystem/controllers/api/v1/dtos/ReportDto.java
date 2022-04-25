package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Oтчёт (1-ТЭК)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    @JsonProperty("id")
    private Long id;

    /**
     * Дата "О внесении изменений"
     */
    private LocalDate formDate;

    /**
     * Номер формы
     */
    private Long formNumber;

    /**
     * Наименования отчитывающейся организации
     */
    private String nameCompany;

    /**
     * Почтовый адрес
     */
    private String mailingAddress;

    /**
     * Код ОКПО
     */
    private String okpoNum;

    /**
     * Раздел 1.
     * Добыча нефти, тонн
     */
    /**
     * Добыча с начала года
     */
    @JsonProperty("field1_1")
    @NotNull
    private Double field1_1;

    @JsonProperty("field2_1")
    @NotNull
    private Double field2_1;

    @JsonProperty("field3_1")
    @NotNull
    private Double field3_1;

    @JsonProperty("field4_1")
    @NotNull
    private Double field4_1;

    @JsonProperty("field5_1")
    @NotNull
    private Double field5_1;

    @JsonProperty("field6_1")
    @NotNull
    private Double field6_1;

    @JsonProperty("field7_1")
    @NotNull
    private Double field7_1;

    @JsonProperty("field8_1")
    @NotNull
    private Double field8_1;

    @JsonProperty("field10_1")
    @NotNull
    private Double field10_1;

    @JsonProperty("field11_1")
    @NotNull
    private Double field11_1;

    @JsonProperty("field12_1")
    @NotNull
    private Double field12_1;

    @JsonProperty("field13_1")
    @NotNull
    private Double field13_1;

    /**
     * Число числившихся скважино-месяцев с начала года
     */
    @JsonProperty("field1_2")
    @NotNull
    private Integer field1_2;

    @JsonProperty("field2_2")
    @NotNull
    private Integer field2_2;

    @JsonProperty("field3_2")
    @NotNull
    private Integer field3_2;

    @JsonProperty("field4_2")
    @NotNull
    private Integer field4_2;

    @JsonProperty("field5_2")
    @NotNull
    private Integer field5_2;

    @JsonProperty("field6_2")
    @NotNull
    private Integer field6_2;

    @JsonProperty("field7_2")
    @NotNull
    private Integer field7_2;

    @JsonProperty("field8_2")
    @NotNull
    private Integer field8_2;


    @JsonProperty("field10_2")
    @NotNull
    private Integer field10_2;

    /**
     * Число отработанных скважино-месяцев с начала года
     */
    @JsonProperty("field1_3")
    @NotNull
    private Integer field1_3;

    @JsonProperty("field2_3")
    @NotNull
    private Integer field2_3;

    @JsonProperty("field3_3")
    @NotNull
    private Integer field3_3;

    @JsonProperty("field4_3")
    @NotNull
    private Integer field4_3;

    @JsonProperty("field5_3")
    @NotNull
    private Integer field5_3;

    @JsonProperty("field6_3")
    @NotNull
    private Integer field6_3;

    @JsonProperty("field7_3")
    @NotNull
    private Integer field7_3;

    @JsonProperty("field8_3")
    @NotNull
    private Integer field8_3;

    @JsonProperty("field10_3")
    @NotNull
    private Integer field10_3;

    /**
     * Средний дебит на отработанный скважино-месяц, т (фактически)
     */
    @JsonProperty("field1_4")
    @NotNull
    private Double field1_4;

    @JsonProperty("field2_4")
    @NotNull
    private Double field2_4;

    @JsonProperty("field3_4")
    @NotNull
    private Double field3_4;

    @JsonProperty("field4_4")
    @NotNull
    private Double field4_4;

    @JsonProperty("field5_4")
    @NotNull
    private Double field5_4;

    @JsonProperty("field6_4")
    @NotNull
    private Double field6_4;

    @JsonProperty("field7_4")
    @NotNull
    private Double field7_4;

    @JsonProperty("field8_4")
    @NotNull
    private Double field8_4;

    @JsonProperty("field10_4")
    @NotNull
    private Double field10_4;

    /**
     * Число скважин, дающих продукцию на конец отчетного периода
     */
    @JsonProperty("field1_5")
    @NotNull
    private Integer field1_5;

    @JsonProperty("field2_5")
    @NotNull
    private Integer field2_5;

    @JsonProperty("field3_5")
    @NotNull
    private Integer field3_5;

    @JsonProperty("field4_5")
    @NotNull
    private Integer field4_5;

    @JsonProperty("field5_5")
    @NotNull
    private Integer field5_5;

    @JsonProperty("field6_5")
    @NotNull
    private Integer field6_5;

    @JsonProperty("field7_5")
    @NotNull
    private Integer field7_5;

    @JsonProperty("field8_5")
    @NotNull
    private Integer field8_5;

    @JsonProperty("field10_5")
    @NotNull
    private Integer field10_5;

    /**
     * Извлечено из скважин жидкости с начала года, т
     */
    @JsonProperty("field1_6")
    @NotNull
    private Double field1_6;

    @JsonProperty("field2_6")
    @NotNull
    private Double field2_6;

    @JsonProperty("field3_6")
    @NotNull
    private Double field3_6;

    @JsonProperty("field4_6")
    @NotNull
    private Double field4_6;

    @JsonProperty("field5_6")
    @NotNull
    private Double field5_6;

    @JsonProperty("field6_6")
    @NotNull
    private Double field6_6;

    @JsonProperty("field7_6")
    @NotNull
    private Double field7_6;

    @JsonProperty("field8_6")
    @NotNull
    private Double field8_6;

    @JsonProperty("field10_6")
    @NotNull
    private Double field10_6;

    /**
     * Раздел 2.
     * Баланс календарного времени фонда нефтяных скважин, часов
     */
    /**
     * Календарное время эксплуатационного фонда — всего (гр. 2 +5+7)
     */
    @JsonProperty("field41_1")
    @NotNull
    private Integer field41_1;

    @JsonProperty("field42_1")
    @NotNull
    private Integer field42_1;

    /**
     * В том числе календарное время действующего фонда всего
     */
    @JsonProperty("field41_2")
    @NotNull
    private Integer field41_2;

    @JsonProperty("field42_2")
    @NotNull
    private Integer field42_2;

    /**
     * В том числе календарное время действующего фонда в том числе время эксплуатации
     */
    @JsonProperty("field41_3")
    @NotNull
    private Integer field41_3;

    @JsonProperty("field42_3")
    @NotNull
    private Integer field42_3;

    /**
     * В том числе календарное время действующего фонда в том числе время простоев
     */
    @JsonProperty("field41_4")
    @NotNull
    private Integer field41_4;

    @JsonProperty("field42_4")
    @NotNull
    private Integer field42_4;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * всего
     */
    @JsonProperty("field41_5")
    @NotNull
    private Integer field41_5;

    @JsonProperty("field42_5")
    @NotNull
    private Integer field42_5;

    /**
     * В том числе календарное время скважин, не дававших продукцию в последнем месяце отчетного периода
     * в том числе в бездействии с прошлых лет
     */
    @JsonProperty("field41_6")
    @NotNull
    private Integer field41_6;

    /**
     * В тои числе календарное время скважин, находящихся в ожидании освоения и освоении после бурения
     */
    @JsonProperty("field41_7")
    @NotNull
    private Integer field41_7;

    @JsonProperty("field42_7")
    @NotNull
    private Integer field42_7;

    /**
     * Раздел 3.
     * Ввод в действие скважин, единиц
     */
    /**
     * Новые скважины Всего (гр. 2+3+4)
     */
    @JsonProperty("field51_1")
    @NotNull
    private Integer field51_1;

    @JsonProperty("field52_1")
    @NotNull
    private Integer field52_1;

    @JsonProperty("field53_1")
    @NotNull
    private Integer field53_1;

    @JsonProperty("field54_1")
    @NotNull
    private Integer field54_1;

    @JsonProperty("field55_1")
    @NotNull
    private Integer field55_1;

    @JsonProperty("field56_1")
    @NotNull
    private Integer field56_1;

    @JsonProperty("field57_1")
    @NotNull
    private Integer field57_1;

    @JsonProperty("field58_1")
    @NotNull
    private Integer field58_1;

    /**
     * Новые скважины в том числе из бурения и освоения после бурения
     */
    @JsonProperty("field51_2")
    @NotNull
    private Integer field51_2;

    @JsonProperty("field53_2")
    @NotNull
    private Integer field53_2;

    @JsonProperty("field54_2")
    @NotNull
    private Integer field54_2;

    @JsonProperty("field55_2")
    @NotNull
    private Integer field55_2;

    @JsonProperty("field56_2")
    @NotNull
    private Integer field56_2;

    @JsonProperty("field57_2")
    @NotNull
    private Integer field57_2;

    /**
     * Новые скважины в том числе из консервации
     */
    @JsonProperty("field51_3")
    @NotNull
    private Integer field51_3;

    @JsonProperty("field53_3")
    @NotNull
    private Integer field53_3;

    @JsonProperty("field54_3")
    @NotNull
    private Integer field54_3;

    @JsonProperty("field55_3")
    @NotNull
    private Integer field55_3;

    @JsonProperty("field56_3")
    @NotNull
    private Integer field56_3;

    @JsonProperty("field57_3")
    @NotNull
    private Integer field57_3;

    /**
     * Новые скважины в том числе из других фондов скважин
     */
    @JsonProperty("field51_4")
    @NotNull
    private Integer field51_4;

    @JsonProperty("field53_4")
    @NotNull
    private Integer field53_4;

    @JsonProperty("field54_4")
    @NotNull
    private Integer field54_4;

    @JsonProperty("field55_4")
    @NotNull
    private Integer field55_4;

    @JsonProperty("field56_4")
    @NotNull
    private Integer field56_4;

    @JsonProperty("field57_4")
    @NotNull
    private Integer field57_4;

    /**
     * Введенные из бездействия(с прошлых лет)
     */
    @JsonProperty("field51_5")
    @NotNull
    private Integer field51_5;

    @JsonProperty("field53_5")
    @NotNull
    private Integer field53_5;

    @JsonProperty("field54_5")
    @NotNull
    private Integer field54_5;

    @JsonProperty("field55_5")
    @NotNull
    private Integer field55_5;

    @JsonProperty("field56_5")
    @NotNull
    private Integer field56_5;

    @JsonProperty("field57_5")
    @NotNull
    private Integer field57_5;

    /**
     Раздел 4.
     Добыча нефти из пластов, разрабатываемых с применением методов
     искусственного воздействия на пласт, тонн
     */
    /**
     * Добыча нефти с применением методов искусственного воздействия на пласт
     */
    @JsonProperty("field61_1")
    @NotNull
    private Double field61_1;

    @JsonProperty("field62_1")
    @NotNull
    private Double field62_1;

    @JsonProperty("field63_1")
    @NotNull
    private Double field63_1;

    @JsonProperty("field64_1")
    @NotNull
    private Double field64_1;

    @JsonProperty("field65_1")
    @NotNull
    private Double field65_1;

    @JsonProperty("field66_1")
    @NotNull
    private Double field66_1;

    /**
     * В том числе увеличение (прирост) добычи за счет применения этих методов (фактически)
     */
    @JsonProperty("field61_2")
    @NotNull
    private Double field61_2;

    @JsonProperty("field62_2")
    @NotNull
    private Double field62_2;

    @JsonProperty("field63_2")
    @NotNull
    private Double field63_2;

    @JsonProperty("field64_2")
    @NotNull
    private Double field64_2;

    @JsonProperty("field65_2")
    @NotNull
    private Double field65_2;

    @JsonProperty("field66_2")
    @NotNull
    private Double field66_2;

    /**
     * Раздел 5.
     * Фонд скважин на конец отчетного периода, единиц
     */
    @JsonProperty("field111_1")
    @NotNull
    private Integer oilGasProduct;

    @JsonProperty("field112_1")
    @NotNull
    private Integer stoppedLastMonth;

    @JsonProperty("field113_1")
    @NotNull
    private Integer totalActive;

    @JsonProperty("field114_1")
    @NotNull
    private Integer dormantFund;

    @JsonProperty("field115_1")
    @NotNull
    private Integer waitingAfterWork;

    @JsonProperty("field116_1")
    @NotNull
    private Integer developmentWork;

    @JsonProperty("field117_1")
    @NotNull
    private Integer totalFund;

    @JsonProperty("field118_1")
    @NotNull
    private Integer telemechanized;

    @JsonProperty("field119_1")
    @NotNull
    private Integer waterIntake;

    @JsonProperty("field120_1")
    @NotNull
    private Integer injection;

    @JsonProperty("field121_1")
    @NotNull
    private Integer inActive;

    @JsonProperty("field123_1")
    @NotNull
    private Integer control;

    @JsonProperty("field124_1")
    @NotNull
    private Integer wasteWaterDischarge;

    @JsonProperty("field125_1")
    @NotNull
    private Integer inConservation;

    @JsonProperty("field127_1")
    @NotNull
    private Integer pendingLiquidation;

    @JsonProperty("field128_1")
    @NotNull
    private Integer liquidationExpl;

    @JsonProperty("field129_1")
    @NotNull
    private Integer liquidationDrilling;

    @JsonProperty("field130_1")
    @NotNull
    private Integer totalWellsFund;

    @JsonProperty("field131_1")
    @NotNull
    private Integer onStartYear;

    @JsonProperty("field132_1")
    @NotNull
    private Integer fromGasFund;

    @JsonProperty("field141_1")
    @NotNull
    private Integer arrivedInFund;

    @JsonProperty("field142_1")
    @NotNull
    private Integer droppedOutFund;

    /**
     * Раздел 6. Добыча нефтяного (попутного) газа, тысяч кубических метров
     */
    @JsonProperty("field151_1")
    @NotNull
    private Double production;

    @JsonProperty("field151_2")
    @NotNull
    private Double consumption;

    @JsonProperty("field151_3")
    @NotNull
    private Double losses;

    @JsonProperty("field151_4")
    @NotNull
    private Double burnt;

    /**
     * Раздел 7.
     * Движение нфти (включая газовый конденсат) с начала года, тонн
     */
    @JsonProperty("field161_1")
    @NotNull
    private Double balanceAtTheBeginning;

    @JsonProperty("field162_1")
    @NotNull
    private Double extracted;

    @JsonProperty("field163_1")
    @NotNull
    private Double succumbed;

    @JsonProperty("field166_1")
    @NotNull
    private Double total;

    @JsonProperty("field167_1")
    @NotNull
    private Double expensesForTechnicalNeeds;

    @JsonProperty("field168_1")
    @NotNull
    private Double totalLoss;

    @JsonProperty("field171_1")
    @NotNull
    private Double totalHandedOver;

    @JsonProperty("field172_1")
    @NotNull
    private Double oilAndGasProcessing;

    @JsonProperty("field173_1")
    @NotNull
    private Double gasProcessing;

    @JsonProperty("field174_1")
    @NotNull
    private Double oilStabilized;

    @JsonProperty("field175_1")
    @NotNull
    private Double export;

    @JsonProperty("field176_1")
    @NotNull
    private Double drilling;

    @JsonProperty("field177_1")
    @NotNull
    private Double otherOrganizations;

    @JsonProperty("field178_1")
    @NotNull
    private Double releasedToEnterprises;

    @JsonProperty("field179_1")
    @NotNull
    private Double totalConsumption;

    @JsonProperty("field180_1")
    @NotNull
    private Double balanceAtTheEnd;

    @JsonProperty("field181_1")
    @NotNull
    private Double inOilPipelines;

    /**
     * Раздел 8.
     * Подготовка нефти (включая газовый конденсат), тонн
     */
    @JsonProperty("field182_1")
    @NotNull
    private Double receivedLiquid;

    @JsonProperty("field183_1")
    @NotNull
    private Double receivedOil;

    @JsonProperty("field184_1")
    @NotNull
    private Double preparedOil;

    @JsonProperty("field185_1")
    @NotNull
    private Double oilLosses;

    /**
     * Должность
     */
    private String position;

    /**
     * Ф.И.О
     */
    private String fullName;

    /**
     * Номер контактного телефона
     */
    private Integer telephone;

    /**
     * E-mail
     */
    private String email;
    /**
     * Дата составления документа
     */
    private LocalDate date;
}
