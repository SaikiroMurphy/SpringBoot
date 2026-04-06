package session06.session06.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session06.session06.model.dto.response.ApiResponse;
import session06.session06.model.dto.response.PageResponse;
import session06.session06.model.dto.response.ZoneResponse;
import session06.session06.service.ZoneService;

@RestController
@RequestMapping("api/v1/zones")
@RequiredArgsConstructor
public class ZoneController {
    private final ZoneService zoneService;

        @GetMapping()
    public ResponseEntity<ApiResponse<PageResponse<ZoneResponse>>> getZones(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String sortBy,
        @RequestParam(required = false) String direction,
        @RequestParam(required = false) String keyword
    ) {
        PageResponse<ZoneResponse> data = zoneService.getPagedZones(page, size, sortBy, direction, keyword);
        return ResponseEntity.ok().body(new ApiResponse<>(true, "Success!", data));
    }

}
