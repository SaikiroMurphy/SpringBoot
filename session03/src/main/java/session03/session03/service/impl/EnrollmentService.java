package session03.session03.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import session03.session03.model.Enrollment;
import session03.session03.repository.impl.EnrollmentRepository;
import session03.session03.service.IService;

@Service
public class EnrollmentService implements IService<Enrollment>{
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment create(Enrollment t) {
        return enrollmentRepository.create(t);
    }

    @Override
    public Enrollment update(String id, Enrollment t) {
        return enrollmentRepository.update(id, t);
    }

    @Override
    public Enrollment detele(String id) {
        return enrollmentRepository.detele(id);
    }

    @Override
    public Enrollment findById(String id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found!"));
    }

}
