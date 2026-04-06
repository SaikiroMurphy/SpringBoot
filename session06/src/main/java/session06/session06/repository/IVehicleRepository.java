package session06.session06.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import session06.session06.model.dto.response.VehicleResponse;
import session06.session06.model.entity.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, String>{
    @Query("""
            SELECT new session06.session06.model.dto.response.VehicleResponse(
            v.id, 
            v.licensePlate, 
            v.color, 
            v.type) 
            FROM Vehicle v 
            WHERE (:keyword IS NULL OR :keyword = '') 
            OR LOWER(v.id) LIKE LOWER(CONCAT('%', :keyword, '%')) 
            OR LOWER(v.licensePlate) LIKE LOWER(CONCAT('%', :keyword, '%')) 
            OR LOWER(v.color) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    Page<VehicleResponse> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
