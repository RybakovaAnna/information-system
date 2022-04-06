package ru.ibs.training.informationsystem.repositories.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.training.informationsystem.model.request.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
