package ru.ibs.training.informationsystem.repositories.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.training.informationsystem.model.report.FundCalendarTimeEntity;

@Repository
public interface FundCalendarTimeRepository extends JpaRepository<FundCalendarTimeEntity, Long> {
}
