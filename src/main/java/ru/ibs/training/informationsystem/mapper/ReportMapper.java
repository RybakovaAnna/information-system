package ru.ibs.training.informationsystem.mapper;

import org.mapstruct.*;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.model.enums.CommissionedWellsEnum;
import ru.ibs.training.informationsystem.model.enums.FundCalendarTimeEnum;
import ru.ibs.training.informationsystem.model.enums.OilProductionEnum;
import ru.ibs.training.informationsystem.model.enums.ReservoirOilProductionEnum;
import ru.ibs.training.informationsystem.model.report.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class ReportMapper {

    @AfterMapping
    protected void convertingPartDtoToEntity(@MappingTarget ReportEntity reportEntity, ReportDto reportDto) {
//        Раздел 1
        Set<OilProductionEntity> oilProductionEntities = new HashSet<>();

        OilProductionEntity oilProductionEntity1 = new OilProductionEntity();
        oilProductionEntity1.setMiningMethod(OilProductionEnum.STANDARD_PUMP.name());
        oilProductionEntity1.setReportId(reportEntity);
        oilProductionEntity1.setOil(reportDto.getField1_1());
        oilProductionEntity1.setRegisteredWells(reportDto.getField1_2());
        oilProductionEntity1.setWorkedWells(reportDto.getField1_3());
        oilProductionEntity1.setAverageFlow(reportDto.getField1_4());
        oilProductionEntity1.setProductionWells(reportDto.getField1_5());
        oilProductionEntity1.setExtractedLiquid(reportDto.getField1_6());
        oilProductionEntities.add(oilProductionEntity1);

        OilProductionEntity oilProductionEntity2 = new OilProductionEntity();
        oilProductionEntity2.setMiningMethod(OilProductionEnum.ELECTRIC_PUMP.name());
        oilProductionEntity2.setReportId(reportEntity);
        oilProductionEntity2.setOil(reportDto.getField2_1());
        oilProductionEntity2.setRegisteredWells(reportDto.getField2_2());
        oilProductionEntity2.setWorkedWells(reportDto.getField2_3());
        oilProductionEntity2.setAverageFlow(reportDto.getField2_4());
        oilProductionEntity2.setProductionWells(reportDto.getField2_5());
        oilProductionEntity2.setExtractedLiquid(reportDto.getField2_6());
        oilProductionEntities.add(oilProductionEntity2);

        OilProductionEntity oilProductionEntity3 = new OilProductionEntity();
        oilProductionEntity3.setMiningMethod(OilProductionEnum.COMPRESSOR.name());
        oilProductionEntity3.setReportId(reportEntity);
        oilProductionEntity3.setOil(reportDto.getField3_1());
        oilProductionEntity3.setRegisteredWells(reportDto.getField3_2());
        oilProductionEntity3.setWorkedWells(reportDto.getField3_3());
        oilProductionEntity3.setAverageFlow(reportDto.getField3_4());
        oilProductionEntity3.setProductionWells(reportDto.getField3_5());
        oilProductionEntity3.setExtractedLiquid(reportDto.getField3_6());
        oilProductionEntities.add(oilProductionEntity3);

        OilProductionEntity oilProductionEntity4 = new OilProductionEntity();
        oilProductionEntity4.setMiningMethod(OilProductionEnum.FOUNTAIN.name());
        oilProductionEntity4.setReportId(reportEntity);
        oilProductionEntity4.setOil(reportDto.getField4_1());
        oilProductionEntity4.setRegisteredWells(reportDto.getField4_2());
        oilProductionEntity4.setWorkedWells(reportDto.getField4_3());
        oilProductionEntity4.setAverageFlow(reportDto.getField4_4());
        oilProductionEntity4.setProductionWells(reportDto.getField4_5());
        oilProductionEntity4.setExtractedLiquid(reportDto.getField4_6());
        oilProductionEntities.add(oilProductionEntity4);

        OilProductionEntity oilProductionEntity5 = new OilProductionEntity();
        oilProductionEntity5.setMiningMethod(OilProductionEnum.OTHER_WAYS.name());
        oilProductionEntity5.setReportId(reportEntity);
        oilProductionEntity5.setOil(reportDto.getField5_1());
        oilProductionEntity5.setRegisteredWells(reportDto.getField5_2());
        oilProductionEntity5.setWorkedWells(reportDto.getField5_3());
        oilProductionEntity5.setAverageFlow(reportDto.getField5_4());
        oilProductionEntity5.setProductionWells(reportDto.getField5_5());
        oilProductionEntity5.setExtractedLiquid(reportDto.getField5_6());
        oilProductionEntities.add(oilProductionEntity5);

        OilProductionEntity oilProductionEntity6 = new OilProductionEntity();
        oilProductionEntity6.setMiningMethod(OilProductionEnum.TOTAL.name());
        oilProductionEntity6.setReportId(reportEntity);
        oilProductionEntity6.setOil(reportDto.getField6_1());
        oilProductionEntity6.setRegisteredWells(reportDto.getField6_2());
        oilProductionEntity6.setWorkedWells(reportDto.getField6_3());
        oilProductionEntity6.setAverageFlow(reportDto.getField6_4());
        oilProductionEntity6.setProductionWells(reportDto.getField6_5());
        oilProductionEntity6.setExtractedLiquid(reportDto.getField6_6());
        oilProductionEntities.add(oilProductionEntity6);

        OilProductionEntity oilProductionEntity7 = new OilProductionEntity();
        oilProductionEntity7.setMiningMethod(OilProductionEnum.OLD_WELLS.name());
        oilProductionEntity7.setReportId(reportEntity);
        oilProductionEntity7.setOil(reportDto.getField7_1());
        oilProductionEntity7.setRegisteredWells(reportDto.getField7_2());
        oilProductionEntity7.setWorkedWells(reportDto.getField7_3());
        oilProductionEntity7.setAverageFlow(reportDto.getField7_4());
        oilProductionEntity7.setProductionWells(reportDto.getField7_5());
        oilProductionEntity7.setExtractedLiquid(reportDto.getField7_6());
        oilProductionEntities.add(oilProductionEntity7);

        OilProductionEntity oilProductionEntity8 = new OilProductionEntity();
        oilProductionEntity8.setMiningMethod(OilProductionEnum.OLD_OLD_WELLS.name());
        oilProductionEntity8.setReportId(reportEntity);
        oilProductionEntity8.setOil(reportDto.getField8_1());
        oilProductionEntity8.setRegisteredWells(reportDto.getField8_2());
        oilProductionEntity8.setWorkedWells(reportDto.getField8_3());
        oilProductionEntity8.setAverageFlow(reportDto.getField8_4());
        oilProductionEntity8.setProductionWells(reportDto.getField8_5());
        oilProductionEntity8.setExtractedLiquid(reportDto.getField8_6());
        oilProductionEntities.add(oilProductionEntity8);

        OilProductionEntity oilProductionEntity10 = new OilProductionEntity();
        oilProductionEntity10.setMiningMethod(OilProductionEnum.NEW_WELLS.name());
        oilProductionEntity10.setReportId(reportEntity);
        oilProductionEntity10.setOil(reportDto.getField10_1());
        oilProductionEntity10.setRegisteredWells(reportDto.getField10_2());
        oilProductionEntity10.setWorkedWells(reportDto.getField10_3());
        oilProductionEntity10.setAverageFlow(reportDto.getField10_4());
        oilProductionEntity10.setProductionWells(reportDto.getField10_5());
        oilProductionEntity10.setExtractedLiquid(reportDto.getField10_6());
        oilProductionEntities.add(oilProductionEntity10);

        OilProductionEntity oilProductionEntity11 = new OilProductionEntity();
        oilProductionEntity11.setMiningMethod(OilProductionEnum.RANDOM_OIL.name());
        oilProductionEntity11.setReportId(reportEntity);
        oilProductionEntity11.setOil(reportDto.getField11_1());
        oilProductionEntities.add(oilProductionEntity11);

        OilProductionEntity oilProductionEntity12 = new OilProductionEntity();
        oilProductionEntity12.setMiningMethod(OilProductionEnum.EXPLORATION_WELLS.name());
        oilProductionEntity12.setReportId(reportEntity);
        oilProductionEntity12.setOil(reportDto.getField12_1());
        oilProductionEntities.add(oilProductionEntity12);

        OilProductionEntity oilProductionEntity13 = new OilProductionEntity();
        oilProductionEntity13.setMiningMethod(OilProductionEnum.TOTAL_OIL_PRODUCED.name());
        oilProductionEntity13.setReportId(reportEntity);
        oilProductionEntity13.setOil(reportDto.getField13_1());
        oilProductionEntities.add(oilProductionEntity13);

        reportEntity.setOilProduction(oilProductionEntities);

//        Раздел 2
        Set<FundCalendarTimeEntity> fundCalendarTimeEntities = new HashSet<>();

        FundCalendarTimeEntity fundCalendarTimeEntity1 = new FundCalendarTimeEntity();
        fundCalendarTimeEntity1.setName(FundCalendarTimeEnum.TOTAL.name());
        fundCalendarTimeEntity1.setReportId(reportEntity);
        fundCalendarTimeEntity1.setOperatingFund(reportDto.getField41_1());
        fundCalendarTimeEntity1.setActiveFund(reportDto.getField41_2());
        fundCalendarTimeEntity1.setOperatingTime(reportDto.getField41_3());
        fundCalendarTimeEntity1.setDowntime(reportDto.getField41_4());
        fundCalendarTimeEntity1.setWithoutProduction(reportDto.getField41_5());
        fundCalendarTimeEntity1.setNotActive(reportDto.getField41_6());
        fundCalendarTimeEntity1.setPending(reportDto.getField41_7());
        fundCalendarTimeEntities.add(fundCalendarTimeEntity1);

        FundCalendarTimeEntity fundCalendarTimeEntity2 = new FundCalendarTimeEntity();
        fundCalendarTimeEntity2.setName(FundCalendarTimeEnum.NEW.name());
        fundCalendarTimeEntity2.setReportId(reportEntity);
        fundCalendarTimeEntity2.setOperatingFund(reportDto.getField42_1());
        fundCalendarTimeEntity2.setActiveFund(reportDto.getField42_2());
        fundCalendarTimeEntity2.setOperatingTime(reportDto.getField42_3());
        fundCalendarTimeEntity2.setDowntime(reportDto.getField42_4());
        fundCalendarTimeEntity2.setWithoutProduction(reportDto.getField42_5());
        fundCalendarTimeEntity2.setPending(reportDto.getField42_7());
        fundCalendarTimeEntities.add(fundCalendarTimeEntity2);

        reportEntity.setFundCalendarTime(fundCalendarTimeEntities);

//        Раздел 3
        Set<CommissionedWellsEntity> commissionedWellsEntities = new HashSet<>();

        CommissionedWellsEntity commissionedWellsEntity1 = new CommissionedWellsEntity();
        commissionedWellsEntity1.setName(CommissionedWellsEnum.OIL.name());
        commissionedWellsEntity1.setReportId(reportEntity);
        commissionedWellsEntity1.setInAll(reportDto.getField51_1());
        commissionedWellsEntity1.setFromDrilling(reportDto.getField51_2());
        commissionedWellsEntity1.setFromConservation(reportDto.getField51_3());
        commissionedWellsEntity1.setFromOtherFunds(reportDto.getField51_4());
        commissionedWellsEntity1.setDormant(reportDto.getField51_5());
        commissionedWellsEntities.add(commissionedWellsEntity1);

        CommissionedWellsEntity commissionedWellsEntity2 = new CommissionedWellsEntity();
        commissionedWellsEntity2.setName(CommissionedWellsEnum.EXPLORATION.name());
        commissionedWellsEntity2.setReportId(reportEntity);
        commissionedWellsEntity2.setInAll(reportDto.getField52_1());
        commissionedWellsEntities.add(commissionedWellsEntity2);

        CommissionedWellsEntity commissionedWellsEntity3 = new CommissionedWellsEntity();
        commissionedWellsEntity3.setName(CommissionedWellsEnum.STANDARD_PUMP.name());
        commissionedWellsEntity3.setReportId(reportEntity);
        commissionedWellsEntity3.setInAll(reportDto.getField53_1());
        commissionedWellsEntity3.setFromDrilling(reportDto.getField53_2());
        commissionedWellsEntity3.setFromConservation(reportDto.getField53_3());
        commissionedWellsEntity3.setFromOtherFunds(reportDto.getField53_4());
        commissionedWellsEntity3.setDormant(reportDto.getField53_5());
        commissionedWellsEntities.add(commissionedWellsEntity3);

        CommissionedWellsEntity commissionedWellsEntity4 = new CommissionedWellsEntity();
        commissionedWellsEntity4.setName(CommissionedWellsEnum.ELECTRIC_PUMP.name());
        commissionedWellsEntity4.setReportId(reportEntity);
        commissionedWellsEntity4.setInAll(reportDto.getField54_1());
        commissionedWellsEntity4.setFromDrilling(reportDto.getField54_2());
        commissionedWellsEntity4.setFromConservation(reportDto.getField54_3());
        commissionedWellsEntity4.setFromOtherFunds(reportDto.getField54_4());
        commissionedWellsEntity4.setDormant(reportDto.getField54_5());
        commissionedWellsEntities.add(commissionedWellsEntity4);

        CommissionedWellsEntity commissionedWellsEntity5 = new CommissionedWellsEntity();
        commissionedWellsEntity5.setName(CommissionedWellsEnum.COMPRESSOR.name());
        commissionedWellsEntity5.setReportId(reportEntity);
        commissionedWellsEntity5.setInAll(reportDto.getField55_1());
        commissionedWellsEntity5.setFromDrilling(reportDto.getField55_2());
        commissionedWellsEntity5.setFromConservation(reportDto.getField55_3());
        commissionedWellsEntity5.setFromOtherFunds(reportDto.getField55_4());
        commissionedWellsEntity5.setDormant(reportDto.getField55_5());
        commissionedWellsEntities.add(commissionedWellsEntity5);

        CommissionedWellsEntity commissionedWellsEntity6 = new CommissionedWellsEntity();
        commissionedWellsEntity6.setName(CommissionedWellsEnum.FOUNTAIN.name());
        commissionedWellsEntity6.setReportId(reportEntity);
        commissionedWellsEntity6.setInAll(reportDto.getField56_1());
        commissionedWellsEntity6.setFromDrilling(reportDto.getField56_2());
        commissionedWellsEntity6.setFromConservation(reportDto.getField56_3());
        commissionedWellsEntity6.setFromOtherFunds(reportDto.getField56_4());
        commissionedWellsEntity6.setDormant(reportDto.getField56_5());
        commissionedWellsEntities.add(commissionedWellsEntity6);

        CommissionedWellsEntity commissionedWellsEntity7 = new CommissionedWellsEntity();
        commissionedWellsEntity7.setName(CommissionedWellsEnum.INJECTION.name());
        commissionedWellsEntity7.setReportId(reportEntity);
        commissionedWellsEntity7.setInAll(reportDto.getField57_1());
        commissionedWellsEntity7.setFromDrilling(reportDto.getField57_2());
        commissionedWellsEntity7.setFromConservation(reportDto.getField57_3());
        commissionedWellsEntity7.setFromOtherFunds(reportDto.getField57_4());
        commissionedWellsEntity7.setDormant(reportDto.getField57_5());
        commissionedWellsEntities.add(commissionedWellsEntity7);

        CommissionedWellsEntity commissionedWellsEntity8 = new CommissionedWellsEntity();
        commissionedWellsEntity8.setName(CommissionedWellsEnum.AFTER_WORKING.name());
        commissionedWellsEntity8.setReportId(reportEntity);
        commissionedWellsEntity8.setInAll(reportDto.getField58_1());
        commissionedWellsEntities.add(commissionedWellsEntity8);

        reportEntity.setCommissionedWells(commissionedWellsEntities);

//        Раздел 4
        Set<ReservoirOilProductionEntity> reservoirOilProductionEntities = new HashSet<>();

        ReservoirOilProductionEntity reservoirOilProductionEntity1 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity1.setMethodOfInfluence(ReservoirOilProductionEnum.TOTAL.name());
        reservoirOilProductionEntity1.setReportId(reportEntity);
        reservoirOilProductionEntity1.setOilProduction(reportDto.getField61_1());
        reservoirOilProductionEntity1.setProductionIncrease(reportDto.getField61_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity1);

        ReservoirOilProductionEntity reservoirOilProductionEntity2 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity2.setMethodOfInfluence(ReservoirOilProductionEnum.WATER_INJECTION.name());
        reservoirOilProductionEntity2.setReportId(reportEntity);
        reservoirOilProductionEntity2.setOilProduction(reportDto.getField62_1());
        reservoirOilProductionEntity2.setProductionIncrease(reportDto.getField62_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity2);

        ReservoirOilProductionEntity reservoirOilProductionEntity3 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity3.setMethodOfInfluence(ReservoirOilProductionEnum.HYDRODYNAMIC.name());
        reservoirOilProductionEntity3.setReportId(reportEntity);
        reservoirOilProductionEntity3.setOilProduction(reportDto.getField63_1());
        reservoirOilProductionEntity3.setProductionIncrease(reportDto.getField63_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity3);

        ReservoirOilProductionEntity reservoirOilProductionEntity4 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity4.setMethodOfInfluence(ReservoirOilProductionEnum.NEW.name());
        reservoirOilProductionEntity4.setReportId(reportEntity);
        reservoirOilProductionEntity4.setOilProduction(reportDto.getField64_1());
        reservoirOilProductionEntity4.setProductionIncrease(reportDto.getField64_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity4);

        ReservoirOilProductionEntity reservoirOilProductionEntity5 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity5.setMethodOfInfluence(ReservoirOilProductionEnum.PHYSICAL_CHEMICAl.name());
        reservoirOilProductionEntity5.setReportId(reportEntity);
        reservoirOilProductionEntity5.setOilProduction(reportDto.getField65_1());
        reservoirOilProductionEntity5.setProductionIncrease(reportDto.getField65_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity5);

        ReservoirOilProductionEntity reservoirOilProductionEntity6 = new ReservoirOilProductionEntity();
        reservoirOilProductionEntity6.setMethodOfInfluence(ReservoirOilProductionEnum.THERMAL.name());
        reservoirOilProductionEntity6.setReportId(reportEntity);
        reservoirOilProductionEntity6.setOilProduction(reportDto.getField66_1());
        reservoirOilProductionEntity6.setProductionIncrease(reportDto.getField66_2());
        reservoirOilProductionEntities.add(reservoirOilProductionEntity6);

        reportEntity.setReservoirOilProduction(reservoirOilProductionEntities);

        reportEntity.getWellFund().setReportId(reportEntity);
        reportEntity.getGasProduction().setReportId(reportEntity);
        reportEntity.getOilMovement().setReportId(reportEntity);
        reportEntity.getOilPreparation().setReportId(reportEntity);
        reportEntity.getExecutive().setReportId(reportEntity);

    }

    @Mappings({
//            Раздел 1
            @Mapping(target = "oilProduction", ignore = true),
//            Раздел 2
            @Mapping(target = "fundCalendarTime", ignore = true),
//            Раздел 3
            @Mapping(target = "commissionedWells", ignore = true),
//            Раздел 4
            @Mapping(target = "reservoirOilProduction", ignore = true),
//            Раздел 5
            @Mapping(source = "oilGasProduct", target = "wellFund.oilGasProduct"),
            @Mapping(source = "stoppedLastMonth", target = "wellFund.stoppedLastMonth"),
            @Mapping(source = "totalActive", target = "wellFund.totalActive"),
            @Mapping(source = "dormantFund", target = "wellFund.dormantFund"),
            @Mapping(source = "waitingAfterWork", target = "wellFund.waitingAfterWork"),
            @Mapping(source = "developmentWork", target = "wellFund.developmentWork"),
            @Mapping(source = "totalFund", target = "wellFund.totalFund"),
            @Mapping(source = "telemechanized", target = "wellFund.telemechanized"),
            @Mapping(source = "waterIntake", target = "wellFund.waterIntake"),
            @Mapping(source = "injection", target = "wellFund.injection"),
            @Mapping(source = "inActive", target = "wellFund.inActive"),
            @Mapping(source = "control", target = "wellFund.control"),
            @Mapping(source = "wasteWaterDischarge", target = "wellFund.wasteWaterDischarge"),
            @Mapping(source = "inConservation", target = "wellFund.inConservation"),
            @Mapping(source = "pendingLiquidation", target = "wellFund.pendingLiquidation"),
            @Mapping(source = "liquidationExpl", target = "wellFund.liquidationExpl"),
            @Mapping(source = "liquidationDrilling", target = "wellFund.liquidationDrilling"),
            @Mapping(source = "totalWellsFund", target = "wellFund.totalWellsFund"),
            @Mapping(source = "onStartYear", target = "wellFund.onStartYear"),
            @Mapping(source = "fromGasFund", target = "wellFund.fromGasFund"),
            @Mapping(source = "arrivedInFund", target = "wellFund.arrivedInFund"),
            @Mapping(source = "droppedOutFund", target = "wellFund.droppedOutFund"),
//            @Mapping(source = "id", target = "wellFund.reportId"),
//            Раздел 6
            @Mapping(source = "production", target = "gasProduction.production"),
            @Mapping(source = "consumption", target = "gasProduction.consumption"),
            @Mapping(source = "losses", target = "gasProduction.losses"),
            @Mapping(source = "burnt", target = "gasProduction.burnt"),
//            @Mapping(source = "id", target = "gasProduction.reportId"),
//            Раздел 7
            @Mapping(source = "balanceAtTheBeginning", target = "oilMovement.balanceAtTheBeginning"),
            @Mapping(source = "extracted", target = "oilMovement.extracted"),
            @Mapping(source = "succumbed", target = "oilMovement.succumbed"),
            @Mapping(source = "total", target = "oilMovement.total"),
            @Mapping(source = "expensesForTechnicalNeeds", target = "oilMovement.expensesForTechnicalNeeds"),
            @Mapping(source = "totalLoss", target = "oilMovement.totalLoss"),
            @Mapping(source = "totalHandedOver", target = "oilMovement.totalHandedOver"),
            @Mapping(source = "oilAndGasProcessing", target = "oilMovement.oilAndGasProcessing"),
            @Mapping(source = "gasProcessing", target = "oilMovement.gasProcessing"),
            @Mapping(source = "oilStabilized", target = "oilMovement.oilStabilized"),
            @Mapping(source = "export", target = "oilMovement.export"),
            @Mapping(source = "drilling", target = "oilMovement.drilling"),
            @Mapping(source = "otherOrganizations", target = "oilMovement.otherOrganizations"),
            @Mapping(source = "releasedToEnterprises", target = "oilMovement.releasedToEnterprises"),
            @Mapping(source = "totalConsumption", target = "oilMovement.totalConsumption"),
            @Mapping(source = "balanceAtTheEnd", target = "oilMovement.balanceAtTheEnd"),
            @Mapping(source = "inOilPipelines", target = "oilMovement.inOilPipelines"),
//            @Mapping(source = "id", target = "oilMovement.reportId"),
//            Раздел 8
            @Mapping(source = "receivedLiquid", target = "oilPreparation.receivedLiquid"),
            @Mapping(source = "receivedOil", target = "oilPreparation.receivedOil"),
            @Mapping(source = "preparedOil", target = "oilPreparation.preparedOil"),
            @Mapping(source = "oilLosses", target = "oilPreparation.oilLosses"),
//            @Mapping(source = "id", target = "oilPreparation.reportId"),
//            Должностное лицо
            @Mapping(source = "position", target = "executive.position"),
            @Mapping(source = "fullName", target = "executive.fullName"),
            @Mapping(source = "telephone", target = "executive.telephone"),
            @Mapping(source = "email", target = "executive.email")
    })
    public abstract ReportEntity toEntity(ReportDto dto);

    @BeforeMapping
    protected void convertingPartEntityToDto(ReportEntity reportEntity, @MappingTarget ReportDto reportDto) {

        for (OilProductionEntity entity : reportEntity.getOilProduction()) {
            if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.STANDARD_PUMP.name())) {
                reportDto.setField1_1(entity.getOil());
                reportDto.setField1_2(entity.getRegisteredWells());
                reportDto.setField1_3(entity.getWorkedWells());
                reportDto.setField1_4(entity.getAverageFlow());
                reportDto.setField1_5(entity.getProductionWells());
                reportDto.setField1_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.ELECTRIC_PUMP.name())) {
                reportDto.setField2_1(entity.getOil());
                reportDto.setField2_2(entity.getRegisteredWells());
                reportDto.setField2_3(entity.getWorkedWells());
                reportDto.setField2_4(entity.getAverageFlow());
                reportDto.setField2_5(entity.getProductionWells());
                reportDto.setField2_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.COMPRESSOR.name())) {
                reportDto.setField3_1(entity.getOil());
                reportDto.setField3_2(entity.getRegisteredWells());
                reportDto.setField3_3(entity.getWorkedWells());
                reportDto.setField3_4(entity.getAverageFlow());
                reportDto.setField3_5(entity.getProductionWells());
                reportDto.setField3_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.FOUNTAIN.name())) {
                reportDto.setField4_1(entity.getOil());
                reportDto.setField4_2(entity.getRegisteredWells());
                reportDto.setField4_3(entity.getWorkedWells());
                reportDto.setField4_4(entity.getAverageFlow());
                reportDto.setField4_5(entity.getProductionWells());
                reportDto.setField4_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.OTHER_WAYS.name())) {
                reportDto.setField5_1(entity.getOil());
                reportDto.setField5_2(entity.getRegisteredWells());
                reportDto.setField5_3(entity.getWorkedWells());
                reportDto.setField5_4(entity.getAverageFlow());
                reportDto.setField5_5(entity.getProductionWells());
                reportDto.setField5_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.TOTAL.name())) {
                reportDto.setField6_1(entity.getOil());
                reportDto.setField6_2(entity.getRegisteredWells());
                reportDto.setField6_3(entity.getWorkedWells());
                reportDto.setField6_4(entity.getAverageFlow());
                reportDto.setField6_5(entity.getProductionWells());
                reportDto.setField6_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.OLD_WELLS.name())) {
                reportDto.setField7_1(entity.getOil());
                reportDto.setField7_2(entity.getRegisteredWells());
                reportDto.setField7_3(entity.getWorkedWells());
                reportDto.setField7_4(entity.getAverageFlow());
                reportDto.setField7_5(entity.getProductionWells());
                reportDto.setField7_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.OLD_OLD_WELLS.name())) {
                reportDto.setField8_1(entity.getOil());
                reportDto.setField8_2(entity.getRegisteredWells());
                reportDto.setField8_3(entity.getWorkedWells());
                reportDto.setField8_4(entity.getAverageFlow());
                reportDto.setField8_5(entity.getProductionWells());
                reportDto.setField8_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.NEW_WELLS.name())) {
                reportDto.setField10_1(entity.getOil());
                reportDto.setField10_2(entity.getRegisteredWells());
                reportDto.setField10_3(entity.getWorkedWells());
                reportDto.setField10_4(entity.getAverageFlow());
                reportDto.setField10_5(entity.getProductionWells());
                reportDto.setField10_6(entity.getExtractedLiquid());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.RANDOM_OIL.name())) {
                reportDto.setField11_1(entity.getOil());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.EXPLORATION_WELLS.name())) {
                reportDto.setField12_1(entity.getOil());
            } else if (Objects.equals(entity.getMiningMethod(), OilProductionEnum.TOTAL_OIL_PRODUCED.name())) {
                reportDto.setField13_1(entity.getOil());
            }
        }

        for (FundCalendarTimeEntity entity : reportEntity.getFundCalendarTime()) {
            if (Objects.equals(entity.getName(), FundCalendarTimeEnum.TOTAL.name())) {
                reportDto.setField41_1(entity.getOperatingFund());
                reportDto.setField41_2(entity.getActiveFund());
                reportDto.setField41_3(entity.getOperatingTime());
                reportDto.setField41_4(entity.getDowntime());
                reportDto.setField41_5(entity.getWithoutProduction());
                reportDto.setField41_6(entity.getNotActive());
                reportDto.setField41_7(entity.getPending());
            } else if (Objects.equals(entity.getName(), FundCalendarTimeEnum.NEW.name())) {
                reportDto.setField42_1(entity.getOperatingFund());
                reportDto.setField42_2(entity.getActiveFund());
                reportDto.setField42_3(entity.getOperatingTime());
                reportDto.setField42_4(entity.getDowntime());
                reportDto.setField42_5(entity.getWithoutProduction());
                reportDto.setField42_7(entity.getPending());
            }
        }

        for (CommissionedWellsEntity entity : reportEntity.getCommissionedWells()) {
            if (Objects.equals(entity.getName(), CommissionedWellsEnum.OIL.name())) {
                reportDto.setField51_1(entity.getInAll());
                reportDto.setField51_2(entity.getFromDrilling());
                reportDto.setField51_3(entity.getFromConservation());
                reportDto.setField51_4(entity.getFromOtherFunds());
                reportDto.setField51_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.EXPLORATION.name())) {
                reportDto.setField52_1(entity.getInAll());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.STANDARD_PUMP.name())) {
                reportDto.setField53_1(entity.getInAll());
                reportDto.setField53_2(entity.getFromDrilling());
                reportDto.setField53_3(entity.getFromConservation());
                reportDto.setField53_4(entity.getFromOtherFunds());
                reportDto.setField53_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.ELECTRIC_PUMP.name())) {
                reportDto.setField54_1(entity.getInAll());
                reportDto.setField54_2(entity.getFromDrilling());
                reportDto.setField54_3(entity.getFromConservation());
                reportDto.setField54_4(entity.getFromOtherFunds());
                reportDto.setField54_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.COMPRESSOR.name())) {
                reportDto.setField55_1(entity.getInAll());
                reportDto.setField55_2(entity.getFromDrilling());
                reportDto.setField55_3(entity.getFromConservation());
                reportDto.setField55_4(entity.getFromOtherFunds());
                reportDto.setField55_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.FOUNTAIN.name())) {
                reportDto.setField56_1(entity.getInAll());
                reportDto.setField56_2(entity.getFromDrilling());
                reportDto.setField56_3(entity.getFromConservation());
                reportDto.setField56_4(entity.getFromOtherFunds());
                reportDto.setField56_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.INJECTION.name())) {
                reportDto.setField57_1(entity.getInAll());
                reportDto.setField57_2(entity.getFromDrilling());
                reportDto.setField57_3(entity.getFromConservation());
                reportDto.setField57_4(entity.getFromOtherFunds());
                reportDto.setField57_5(entity.getDormant());
            } else if (Objects.equals(entity.getName(), CommissionedWellsEnum.AFTER_WORKING.name())) {
                reportDto.setField58_1(entity.getInAll());
            }
        }

        for (ReservoirOilProductionEntity entity : reportEntity.getReservoirOilProduction()) {
            if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.TOTAL.name())) {
                reportDto.setField61_1(entity.getOilProduction());
                reportDto.setField61_2(entity.getProductionIncrease());
            } else if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.WATER_INJECTION.name())) {
                reportDto.setField62_1(entity.getOilProduction());
                reportDto.setField62_2(entity.getProductionIncrease());
            } else if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.HYDRODYNAMIC.name())) {
                reportDto.setField63_1(entity.getOilProduction());
                reportDto.setField63_2(entity.getProductionIncrease());
            } else if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.NEW.name())) {
                reportDto.setField64_1(entity.getOilProduction());
                reportDto.setField64_2(entity.getProductionIncrease());
            } else if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.PHYSICAL_CHEMICAl.name())) {
                reportDto.setField65_1(entity.getOilProduction());
                reportDto.setField65_2(entity.getProductionIncrease());
            } else if (Objects.equals(entity.getMethodOfInfluence(), ReservoirOilProductionEnum.THERMAL.name())) {
                reportDto.setField66_1(entity.getOilProduction());
                reportDto.setField66_2(entity.getProductionIncrease());
            }
        }
    }

    @Mappings({
//            Раздел 1
            @Mapping(target = "field1_1", ignore = true),
            @Mapping(target = "field1_2", ignore = true),
            @Mapping(target = "field1_3", ignore = true),
            @Mapping(target = "field1_4", ignore = true),
            @Mapping(target = "field1_5", ignore = true),
            @Mapping(target = "field1_6", ignore = true),
            @Mapping(target = "field2_1", ignore = true),
            @Mapping(target = "field2_2", ignore = true),
            @Mapping(target = "field2_3", ignore = true),
            @Mapping(target = "field2_4", ignore = true),
            @Mapping(target = "field2_5", ignore = true),
            @Mapping(target = "field2_6", ignore = true),
            @Mapping(target = "field3_1", ignore = true),
            @Mapping(target = "field3_2", ignore = true),
            @Mapping(target = "field3_3", ignore = true),
            @Mapping(target = "field3_4", ignore = true),
            @Mapping(target = "field3_5", ignore = true),
            @Mapping(target = "field3_6", ignore = true),
            @Mapping(target = "field4_1", ignore = true),
            @Mapping(target = "field4_2", ignore = true),
            @Mapping(target = "field4_3", ignore = true),
            @Mapping(target = "field4_4", ignore = true),
            @Mapping(target = "field4_5", ignore = true),
            @Mapping(target = "field4_6", ignore = true),
            @Mapping(target = "field5_1", ignore = true),
            @Mapping(target = "field5_2", ignore = true),
            @Mapping(target = "field5_3", ignore = true),
            @Mapping(target = "field5_4", ignore = true),
            @Mapping(target = "field5_5", ignore = true),
            @Mapping(target = "field5_6", ignore = true),
            @Mapping(target = "field6_1", ignore = true),
            @Mapping(target = "field6_2", ignore = true),
            @Mapping(target = "field6_3", ignore = true),
            @Mapping(target = "field6_4", ignore = true),
            @Mapping(target = "field6_5", ignore = true),
            @Mapping(target = "field6_6", ignore = true),
            @Mapping(target = "field7_1", ignore = true),
            @Mapping(target = "field7_2", ignore = true),
            @Mapping(target = "field7_3", ignore = true),
            @Mapping(target = "field7_4", ignore = true),
            @Mapping(target = "field7_5", ignore = true),
            @Mapping(target = "field7_6", ignore = true),
            @Mapping(target = "field8_1", ignore = true),
            @Mapping(target = "field8_2", ignore = true),
            @Mapping(target = "field8_3", ignore = true),
            @Mapping(target = "field8_4", ignore = true),
            @Mapping(target = "field8_5", ignore = true),
            @Mapping(target = "field8_6", ignore = true),
            @Mapping(target = "field10_1", ignore = true),
            @Mapping(target = "field10_2", ignore = true),
            @Mapping(target = "field10_3", ignore = true),
            @Mapping(target = "field10_4", ignore = true),
            @Mapping(target = "field10_5", ignore = true),
            @Mapping(target = "field10_6", ignore = true),
            @Mapping(target = "field11_1", ignore = true),
            @Mapping(target = "field12_1", ignore = true),
            @Mapping(target = "field13_1", ignore = true),
//            Раздел 2
            @Mapping(target = "field41_1", ignore = true),
            @Mapping(target = "field41_2", ignore = true),
            @Mapping(target = "field41_3", ignore = true),
            @Mapping(target = "field41_4", ignore = true),
            @Mapping(target = "field41_5", ignore = true),
            @Mapping(target = "field41_6", ignore = true),
            @Mapping(target = "field41_7", ignore = true),
            @Mapping(target = "field42_1", ignore = true),
            @Mapping(target = "field42_2", ignore = true),
            @Mapping(target = "field42_3", ignore = true),
            @Mapping(target = "field42_4", ignore = true),
            @Mapping(target = "field42_5", ignore = true),
            @Mapping(target = "field42_7", ignore = true),
//            Раздел 3
            @Mapping(target = "field51_1", ignore = true),
            @Mapping(target = "field51_2", ignore = true),
            @Mapping(target = "field51_3", ignore = true),
            @Mapping(target = "field51_4", ignore = true),
            @Mapping(target = "field51_5", ignore = true),
            @Mapping(target = "field52_1", ignore = true),
            @Mapping(target = "field53_1", ignore = true),
            @Mapping(target = "field53_2", ignore = true),
            @Mapping(target = "field53_3", ignore = true),
            @Mapping(target = "field53_4", ignore = true),
            @Mapping(target = "field53_5", ignore = true),
            @Mapping(target = "field54_1", ignore = true),
            @Mapping(target = "field54_2", ignore = true),
            @Mapping(target = "field54_3", ignore = true),
            @Mapping(target = "field54_4", ignore = true),
            @Mapping(target = "field54_5", ignore = true),
            @Mapping(target = "field55_1", ignore = true),
            @Mapping(target = "field55_2", ignore = true),
            @Mapping(target = "field55_3", ignore = true),
            @Mapping(target = "field55_4", ignore = true),
            @Mapping(target = "field55_5", ignore = true),
            @Mapping(target = "field56_1", ignore = true),
            @Mapping(target = "field56_2", ignore = true),
            @Mapping(target = "field56_3", ignore = true),
            @Mapping(target = "field56_4", ignore = true),
            @Mapping(target = "field56_5", ignore = true),
            @Mapping(target = "field57_1", ignore = true),
            @Mapping(target = "field57_2", ignore = true),
            @Mapping(target = "field57_3", ignore = true),
            @Mapping(target = "field57_4", ignore = true),
            @Mapping(target = "field57_5", ignore = true),
            @Mapping(target = "field58_1", ignore = true),
//            Раздел 4
            @Mapping(target = "field61_1", ignore = true),
            @Mapping(target = "field61_2", ignore = true),
            @Mapping(target = "field62_1", ignore = true),
            @Mapping(target = "field62_2", ignore = true),
            @Mapping(target = "field63_1", ignore = true),
            @Mapping(target = "field63_2", ignore = true),
            @Mapping(target = "field64_1", ignore = true),
            @Mapping(target = "field64_2", ignore = true),
            @Mapping(target = "field65_1", ignore = true),
            @Mapping(target = "field65_2", ignore = true),
            @Mapping(target = "field66_1", ignore = true),
            @Mapping(target = "field66_2", ignore = true),
//            Раздел 5
            @Mapping(target = "oilGasProduct", source = "wellFund.oilGasProduct"),
            @Mapping(target = "stoppedLastMonth", source = "wellFund.stoppedLastMonth"),
            @Mapping(target = "totalActive", source = "wellFund.totalActive"),
            @Mapping(target = "dormantFund", source = "wellFund.dormantFund"),
            @Mapping(target = "waitingAfterWork", source = "wellFund.waitingAfterWork"),
            @Mapping(target = "developmentWork", source = "wellFund.developmentWork"),
            @Mapping(target = "totalFund", source = "wellFund.totalFund"),
            @Mapping(target = "telemechanized", source = "wellFund.telemechanized"),
            @Mapping(target = "waterIntake", source = "wellFund.waterIntake"),
            @Mapping(target = "injection", source = "wellFund.injection"),
            @Mapping(target = "inActive", source = "wellFund.inActive"),
            @Mapping(target = "control", source = "wellFund.control"),
            @Mapping(target = "wasteWaterDischarge", source = "wellFund.wasteWaterDischarge"),
            @Mapping(target = "inConservation", source = "wellFund.inConservation"),
            @Mapping(target = "pendingLiquidation", source = "wellFund.pendingLiquidation"),
            @Mapping(target = "liquidationExpl", source = "wellFund.liquidationExpl"),
            @Mapping(target = "liquidationDrilling", source = "wellFund.liquidationDrilling"),
            @Mapping(target = "totalWellsFund", source = "wellFund.totalWellsFund"),
            @Mapping(target = "onStartYear", source = "wellFund.onStartYear"),
            @Mapping(target = "fromGasFund", source = "wellFund.fromGasFund"),
            @Mapping(target = "arrivedInFund", source = "wellFund.arrivedInFund"),
            @Mapping(target = "droppedOutFund", source = "wellFund.droppedOutFund"),
//            Раздел 6
            @Mapping(target = "production", source = "gasProduction.production"),
            @Mapping(target = "consumption", source = "gasProduction.consumption"),
            @Mapping(target = "losses", source = "gasProduction.losses"),
            @Mapping(target = "burnt", source = "gasProduction.burnt"),
//            Раздел 7
            @Mapping(target = "balanceAtTheBeginning", source = "oilMovement.balanceAtTheBeginning"),
            @Mapping(target = "extracted", source = "oilMovement.extracted"),
            @Mapping(target = "succumbed", source = "oilMovement.succumbed"),
            @Mapping(target = "total", source = "oilMovement.total"),
            @Mapping(target = "expensesForTechnicalNeeds", source = "oilMovement.expensesForTechnicalNeeds"),
            @Mapping(target = "totalLoss", source = "oilMovement.totalLoss"),
            @Mapping(target = "totalHandedOver", source = "oilMovement.totalHandedOver"),
            @Mapping(target = "oilAndGasProcessing", source = "oilMovement.oilAndGasProcessing"),
            @Mapping(target = "gasProcessing", source = "oilMovement.gasProcessing"),
            @Mapping(target = "oilStabilized", source = "oilMovement.oilStabilized"),
            @Mapping(target = "export", source = "oilMovement.export"),
            @Mapping(target = "drilling", source = "oilMovement.drilling"),
            @Mapping(target = "otherOrganizations", source = "oilMovement.otherOrganizations"),
            @Mapping(target = "releasedToEnterprises", source = "oilMovement.releasedToEnterprises"),
            @Mapping(target = "totalConsumption", source = "oilMovement.totalConsumption"),
            @Mapping(target = "balanceAtTheEnd", source = "oilMovement.balanceAtTheEnd"),
            @Mapping(target = "inOilPipelines", source = "oilMovement.inOilPipelines"),
//            Раздел 8
            @Mapping(target = "receivedLiquid", source = "oilPreparation.receivedLiquid"),
            @Mapping(target = "receivedOil", source = "oilPreparation.receivedOil"),
            @Mapping(target = "preparedOil", source = "oilPreparation.preparedOil"),
            @Mapping(target = "oilLosses", source = "oilPreparation.oilLosses"),
//            Должностное лицо
            @Mapping(target = "position", source = "executive.position"),
            @Mapping(target = "fullName", source = "executive.fullName"),
            @Mapping(target = "telephone", source = "executive.telephone"),
            @Mapping(target = "email", source = "executive.email")
    })
    public abstract ReportDto toDto(ReportEntity entity);
}
