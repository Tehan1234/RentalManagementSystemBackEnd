package org.icet.repository;

import org.icet.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
}
