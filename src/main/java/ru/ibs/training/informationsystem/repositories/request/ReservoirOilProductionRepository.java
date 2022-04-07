package ru.ibs.training.informationsystem.repositories.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.training.informationsystem.model.report.ReservoirOilProductionEntity;

@Repository
public interface ReservoirOilProductionRepository extends JpaRepository<ReservoirOilProductionEntity, Long> {
}
