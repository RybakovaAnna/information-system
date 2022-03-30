//package ru.ibs.training.informationsystem.model;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//@Table(name = "oil_extraction_method")
//public class OilExtractionMethodEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oil_extraction_method_id_seq")
//    @SequenceGenerator(sequenceName = "oil_extraction_method_id_seq", name = "oil_extraction_method_id_seq")
//    private Long id;
//
//    @Column(name = "standard_pumps")
//    private Double standardPumps;
//
//    @Column(name = "electric_pumps")
//    private Long electricPumps;
//
//    @Column(name = "compressors")
//    private Long compressors;
//
//    @Column(name = "fountains")
//    private Double fountains;
//
//    @Column(name = "other_ways")
//    private Long  otherWays;
//
//    @Column(name = "total")
//    private Double total;
//
//    @Column(name = "old_wells")
//    private Double oldWells;
//
//    @Column(name = "old_wells_last_year")
//    private Double oldWellsLastYear;
//
//    @Column(name = "new_wells")
//    private Double newWells;
//
//    @ManyToMany(mappedBy = "OilExtractionMethodEntity")
//    private Set<OilProductionEntity> OilProductionEntity = new HashSet<>();
////    @Column(name = "report_id")
////    private Long reportId;
//
//}
