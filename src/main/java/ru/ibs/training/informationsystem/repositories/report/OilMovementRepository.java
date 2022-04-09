package ru.ibs.training.informationsystem.repositories.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.training.informationsystem.model.report.OilMovementEntity;

@Repository
public interface OilMovementRepository extends JpaRepository<OilMovementEntity, Long> {
}
