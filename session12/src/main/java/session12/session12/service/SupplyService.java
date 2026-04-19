package session12.session12.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import session12.session12.mapper.SupplyMapper;
import session12.session12.model.dto.request.SupplyRequest;
import session12.session12.model.dto.response.SupplyResponse;
import session12.session12.model.entity.Supply;
import session12.session12.repository.SupplyRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;

    public SupplyResponse createSupply(SupplyRequest request) {

        Supply supply = supplyMapper.toEntity(request);

        supplyRepository.save(supply);
        log.info("Đã tạo mới vật tư: {} với ID: {}", supply.getName(), supply.getId());

        return supplyMapper.toResponse(supply);
    }

    public void deleteSupply(Long id) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> {    
                    log.error("Không tìm thấy vật tư với ID: {}", id);
                    return new EntityNotFoundException("Không tìm thấy vật tư với ID: " + id);
                });
        
        if (supply.getIsDeleted() != null && supply.getIsDeleted()) {
            log.warn("Vật tư với ID: {} đã bị xóa trước đó", id);
            throw new EntityNotFoundException("Vật tư đã bị xóa");
        }

        supply.setIsDeleted(true);
        supplyRepository.save(supply);
        log.info("Đã xóa vật tư với ID: {}", id);
    }

    public SupplyResponse getSupplyById(Long id) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Không tìm thấy vật tư với ID: {}", id);
                    return new EntityNotFoundException("Không tìm thấy vật tư với ID: " + id);
                });

        if (supply.getIsDeleted() != null && supply.getIsDeleted()) {
            log.warn("Vật tư với ID: {} đã bị xóa trước đó", id);
            throw new EntityNotFoundException("Vật tư đã bị xóa");
        }

        return supplyMapper.toResponse(supply);
    }

    public SupplyResponse updateSupply(Long id, SupplyRequest request) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Không tìm thấy vật tư với ID: {}", id);
                    return new EntityNotFoundException("Không tìm thấy vật tư với ID: " + id);
                });

        if (supply.getIsDeleted() != null && supply.getIsDeleted()) {
            log.warn("Vật tư với ID: {} đã bị xóa trước đó", id);
            throw new EntityNotFoundException("Vật tư đã bị xóa");
        }

        supplyMapper.updateEntity(request, supply);

        supplyRepository.save(supply);
        log.info("Đã cập nhật vật tư với ID: {}", id);

        return supplyMapper.toResponse(supply);
    }

    public Page<SupplyResponse> findByIsDeletedFalse(Pageable pageable) {
        Page<Supply> suppliesPage = supplyRepository.findByIsDeletedFalse(pageable);
        log.info("Số lượng vật tư đang có sẵn: {}", suppliesPage.getTotalElements());

        if (suppliesPage.isEmpty()) {
            log.info("Không tìm thấy vật tư nào đang có sẵn");
            return Page.empty();
            
        }
        
        return suppliesPage.map(supplyMapper::toResponse);
    }

    public Page<SupplyResponse> findByIsDeletedTrue(Pageable pageable) {
        Page<Supply> suppliesPage = supplyRepository.findByIsDeletedTrue(pageable);
        log.info("Số lượng vật tư đã bị xóa: {}", suppliesPage.getTotalElements());

        if (suppliesPage.isEmpty()) {
            log.info("Không tìm thấy vật tư nào đã bị xóa");
            return Page.empty();
        }

        return suppliesPage.map(supplyMapper::toResponse);
    }
}
