package session05.session05.service;

import java.util.List;

import org.springframework.stereotype.Service;

import session05.session05.model.dto.request.InstructorCreateRequest;
import session05.session05.model.entity.Instructor;
import session05.session05.repository.InstructorRepository;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên có id = " + id));
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();
        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());
        return instructorRepository.save(instructor);
    }
}
