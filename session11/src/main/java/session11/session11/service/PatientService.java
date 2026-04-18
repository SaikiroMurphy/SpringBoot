package session11.session11.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import session11.session11.model.dto.request.PatientRequest;
import session11.session11.model.entity.Patient;
import session11.session11.repository.PatientRepository;
import session11.session11.utils.mappers.PatientMapper;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient createPatient(PatientRequest req) {
        Patient entity = patientMapper.toEntity(req);
        patientRepository.save(entity);
        return entity;
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại bệnh nhân có ID phù hợp!"));
    }
}
