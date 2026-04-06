package session06.session06.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session06.session06.model.dto.response.ApiResponse;
import session06.session06.model.dto.response.PageResponse;
import session06.session06.model.dto.response.VehicleResponse;
import session06.session06.service.VehicleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping()
    public ResponseEntity<ApiResponse<PageResponse<VehicleResponse>>> getVehicles(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String sortBy,
        @RequestParam(required = false) String direction,
        @RequestParam(required = false) String keyword
    ) {
        PageResponse<VehicleResponse> data = vehicleService.getPagedVehicles(page, size, sortBy, direction, keyword);
        return ResponseEntity.ok().body(new ApiResponse<>(true, "Success!", data));
    }
    
}
