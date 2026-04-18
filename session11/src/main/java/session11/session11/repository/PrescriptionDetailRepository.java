package session11.session11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session11.session11.model.entity.PrescriptionDetail;

@Repository
public interface PrescriptionDetailRepository extends JpaRepository<PrescriptionDetail, Long>{

}
