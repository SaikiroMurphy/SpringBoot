package session06.session06.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import session06.session06.model.dto.response.ZoneResponse;
import session06.session06.model.entity.Zone;

@Repository
public interface IZoneRepository extends JpaRepository<Zone, String>{
    @Query("""
            SELECT new session06.session06.model.dto.response.ZoneResponse(
                z.id,
                z.name,
                z.capacity,
                z.occupiedSpots)
            FROM Zone z
            WHERE (:keyword IS NULL OR :keyword = '')
            OR LOWER(z.id) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(z.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    Page<ZoneResponse> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);

}
