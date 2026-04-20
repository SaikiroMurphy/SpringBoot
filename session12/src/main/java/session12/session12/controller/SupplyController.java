package session12.session12.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import session12.session12.enums.ApiStatus;
import session12.session12.model.dto.request.SupplyRequest;
import session12.session12.model.dto.response.ApiResponse;
import session12.session12.model.dto.response.PageResponse;
import session12.session12.model.dto.response.SupplyResponse;
import session12.session12.service.SupplyService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    @PostMapping
    public ResponseEntity<ApiResponse<SupplyResponse>> create(@RequestBody @Valid SupplyRequest request) {
        SupplyResponse createdSupply = supplyService.createSupply(request);
        ApiResponse<SupplyResponse> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Tạo mới vật tư thành công");
        response.setData(createdSupply);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        supplyService.deleteSupply(id);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Xóa vật tư thành công");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplyResponse>> update(@PathVariable Long id, @RequestBody @Valid SupplyRequest request) {
        SupplyResponse updatedSupply = supplyService.updateSupply(id, request);
        ApiResponse<SupplyResponse> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Cập nhật vật tư thành công");
        response.setData(updatedSupply);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SupplyResponse>>> getInStock(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<SupplyResponse> supplies = supplyService.findByIsDeletedFalse(pageable);
        ApiResponse<List<SupplyResponse>> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Lấy danh sách vật tư thành công");
        response.setData(supplies.getContent());
        response.setMeta(
            new PageResponse(
                supplies.getNumber(),
                supplies.getSize(),
                supplies.getTotalElements(),
                supplies.getTotalPages()
            )
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<SupplyResponse>>> searchByName(
            @RequestParam(required = false) String name,
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<SupplyResponse> supplies = supplyService.searchByName(name, pageable);
        ApiResponse<List<SupplyResponse>> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Tìm kiếm vật tư thành công");
        response.setData(supplies.getContent());
        response.setMeta(
            new PageResponse(
                supplies.getNumber(),
                supplies.getSize(),
                supplies.getTotalElements(),
                supplies.getTotalPages()
            )
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}/export")
    public ResponseEntity<ApiResponse<SupplyResponse>> exportSupply(
        @PathVariable Long id,
        @RequestParam @Min(value = 1, message = "Số lượng xuất phải lớn hơn 0") Integer quantity) {
        SupplyResponse exportedSupply = supplyService.exportSupply(id, quantity);
        ApiResponse<SupplyResponse> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Xuất vật tư thành công");
        response.setData(exportedSupply);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @PatchMapping("/{id}/import")
    public ResponseEntity<ApiResponse<SupplyResponse>> importSupply(
        @PathVariable Long id,
        @RequestParam @Min(value = 1, message = "Số lượng nhập phải lớn hơn 0") Integer quantity) {
        SupplyResponse importedSupply = supplyService.importSupply(id, quantity);
        ApiResponse<SupplyResponse> response = new ApiResponse<>();
        response.setStatus(ApiStatus.SUCCESS);
        response.setMessage("Nhập vật tư thành công");
        response.setData(importedSupply);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
