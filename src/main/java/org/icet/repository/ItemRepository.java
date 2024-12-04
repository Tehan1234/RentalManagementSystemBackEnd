package org.icet.repository;

import org.icet.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    ItemEntity findByName(String name);

    List<ItemEntity> findByAvailability(String available);
}
