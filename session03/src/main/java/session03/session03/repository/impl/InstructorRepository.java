package session03.session03.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import session03.session03.model.Instructor;
import session03.session03.repository.IRepository;

@Repository
public class InstructorRepository implements IRepository<Instructor>{
    private final List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor("I01", "Instructor 1", "instructor1@example.com"));
        instructors.add(new Instructor("I02", "Instructor 2", "instructor2@example.com"));
        instructors.add(new Instructor("I03", "Instructor 3", "instructor3@example.com"));
        instructors.add(new Instructor("I04", "Instructor 4", "instructor4@example.com"));
        instructors.add(new Instructor("I05", "Instructor 5", "instructor5@example.com"));
    }

    @Override
    public List<Instructor> findAll() {
        return instructors;
    }

    @Override
    public Instructor create(Instructor t) {
        instructors.add(t);
        return t;
    }

    @Override
    public Instructor update(String id, Instructor t) {
        Instructor oldInstructor = findById(id).orElseThrow(() -> new RuntimeException("Instructor not found!"));

        if (oldInstructor != null) {
            oldInstructor.setName(t.getName());
            oldInstructor.setEmail(t.getEmail());
        }

        return oldInstructor;
    }

    @Override
    public Instructor detele(String id) {
        Instructor oldInstructor = findById(id).orElseThrow(() -> new RuntimeException("Instructor not found!"));

        if (oldInstructor != null) {
            instructors.remove(oldInstructor);
        }

        return oldInstructor;
    }

    @Override
    public Optional<Instructor> findById(String id) {
        return instructors.stream().filter(i -> i.getId().equalsIgnoreCase(id)).findFirst();
    }
}

