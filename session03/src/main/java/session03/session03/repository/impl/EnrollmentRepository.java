package session03.session03.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import session03.session03.model.Enrollment;
import session03.session03.repository.IRepository;

@Repository
public class EnrollmentRepository implements IRepository<Enrollment>{
    private final List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        for (int i = 1; i <= 50; i++) {
            String id = String.format("E%02d", i);
            String studentName = "Student " + i;
            String courseId = String.format("C%02d", ((i - 1) % 10) + 1);
            enrollments.add(new Enrollment(id, studentName, courseId));
        }
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }

    @Override
    public Enrollment create(Enrollment t) {
        enrollments.add(t);
        return t;
    }

    @Override
    public Enrollment update(String id, Enrollment t) {
        Enrollment oldEnrollment = findById(id);

        if (oldEnrollment != null) {
            oldEnrollment.setStudentName(t.getStudentName());
            oldEnrollment.setCourseId(t.getCourseId());
        }

        return oldEnrollment;
    }

    @Override
    public Enrollment detele(String id) {
        Enrollment oldEnrollment = findById(id);

        if (oldEnrollment != null) {
            enrollments.remove(oldEnrollment);
        }

        return oldEnrollment;
    }

    @Override
    public Enrollment findById(String id) {
        return enrollments.stream().filter(i -> i.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}

