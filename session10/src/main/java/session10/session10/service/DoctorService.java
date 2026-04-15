package session10.session10.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import session10.session10.model.dto.request.DoctorRequest;
import session10.session10.model.entity.Doctor;
import session10.session10.repository.DoctorRepository;
import session10.session10.utils.mappers.DoctorMapper;

@Service
@RequiredArgsConstructor
public class DoctorService implements IService<DoctorRequest, Doctor>{
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Doctor create(DoctorRequest req) {
        Doctor entity = doctorMapper.toEntity(req);
        doctorRepository.save(entity);
        return entity;
    }

    @Override
    public Doctor update(DoctorRequest req, Long id) {
        Doctor oldEntity = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại bác sĩ có ID phù hợp!"));

        Doctor newEntity = doctorMapper.updateEntity(oldEntity, req);

        doctorRepository.save(newEntity);

        return newEntity;
    }

    @Override
    public Doctor deleteById(Long id) {
        Doctor entity = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại bác sĩ có ID phù hợp!"));

        doctorRepository.delete(entity);

        return entity;
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

}
