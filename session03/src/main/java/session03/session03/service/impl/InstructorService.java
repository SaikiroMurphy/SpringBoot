package session03.session03.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import session03.session03.model.Instructor;
import session03.session03.repository.impl.InstructorRepository;
import session03.session03.service.IService;

@Service
public class InstructorService implements IService<Instructor>{
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor create(Instructor t) {
        return instructorRepository.create(t);
    }

    @Override
    public Instructor update(String id, Instructor t) {
        return instructorRepository.update(id, t);
    }

    @Override
    public Instructor detele(String id) {
        return instructorRepository.detele(id);
    }

    @Override
    public Instructor findById(String id) {
        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found!"));
    }

}
