package ru.ibs.training.informationsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.ibs.training.informationsystem.controller.dto.ReportDto;
import ru.ibs.training.informationsystem.model.enums.FundCalendarTimeEnum;
import ru.ibs.training.informationsystem.model.report.FundCalendarTimeEntity;
import ru.ibs.training.informationsystem.model.report.ReportEntity;

@Mapper(componentModel = "spring")
public interface ReportMapper {

//    ReportEntity toEntity(ReportDto dto);

//    @Mapping(target = "field1_1", source = "oilProduction.oil")
    @Mappings({
            @Mapping(target = "field41_1", source = "entity", qualifiedByName = "tofield41_1"),
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
            @Mapping(target = "droppedOutFund", source = "wellFund.droppedOutFund")} )
    ReportDto toDto(ReportEntity entity);

    @Named("tofield41_1")
    default Integer operatingFundTotalTofield41_1(ReportEntity entity){
        for (FundCalendarTimeEntity fcte: entity.getFundCalendarTime()){
            if (fcte.getName()== FundCalendarTimeEnum.TOTAL.name()){
                return fcte.getOperatingFund();
            }
        }
        return null;
    }

}
