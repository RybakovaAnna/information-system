package ru.ibs.training.informationsystem.repositories.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.training.informationsystem.model.report.CommissionedWellsEntity;

@Repository
public interface CommissionedWellsRepository extends JpaRepository<CommissionedWellsEntity, Long> {
}
