package session06.session06.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import session06.session06.model.dto.response.PageResponse;
import session06.session06.model.dto.response.ZoneResponse;
import session06.session06.repository.IZoneRepository;

@Service
@RequiredArgsConstructor
public class ZoneService {
    private final IZoneRepository zoneRepository;

    public PageResponse<ZoneResponse> getPagedZones(int page, int size, String sortBy, String direction, String keyword) {
                if (page < 0) {
            page = 0;
        }

        Sort sort;
        if (sortBy == null || sortBy.isBlank() || direction == null || direction.isBlank()) {
            sort = Sort.unsorted();
        } else {
            Sort.Direction dir = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
            sort = Sort.by(dir, sortBy);
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ZoneResponse> zones = zoneRepository.findAllByKeyword(keyword, pageable);

        return new PageResponse<>(
            zones.getContent(),
            zones.getNumber(),
            zones.getSize(),
            zones.getTotalElements(),
            zones.getTotalPages(),
            zones.isLast()
        );
    }
}
