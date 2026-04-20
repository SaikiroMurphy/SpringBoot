package session12.session12.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session12.session12.model.entity.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Page<Supply> findByIsDeletedTrue(Pageable pageable);

    Page<Supply> findByIsDeletedFalse(Pageable pageable);

    Page<Supply> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
