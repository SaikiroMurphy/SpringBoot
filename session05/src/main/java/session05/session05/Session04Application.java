package session05.session05;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import session05.session05.model.entity.Course;
import session05.session05.model.entity.EnrollmentId;
import session05.session05.model.entity.Instructor;
import session05.session05.model.entity.Student;
import session05.session05.model.entity.StudentEnrollment;
import session05.session05.repository.CourseRepository;
import session05.session05.repository.InstructorRepository;
import session05.session05.repository.StudentEnrollmentRepository;
import session05.session05.repository.StudentRepository;
import session05.session05.utils.CourseStatus;

@SpringBootApplication
public class Session04Application {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		SpringApplication.run(Session04Application.class, args);
	}

	@Bean
	public CommandLineRunner seedData(
			InstructorRepository instructorRepository,
			CourseRepository courseRepository,
			StudentRepository studentRepository,
			StudentEnrollmentRepository enrollmentRepository) {

		return args -> {
			if (instructorRepository.count() > 0 || courseRepository.count() > 0 || studentRepository.count() > 0) {
				return;
			}

			List<Instructor> instructors = List.of(
				new Instructor(null, "Nguyen Van A", "nguyenvana@example.com", null),
				new Instructor(null, "Tran Thi B", "tranthib@example.com", null),
				new Instructor(null, "Le Van C", "levanc@example.com", null),
				new Instructor(null, "Pham Thi D", "phamthid@example.com", null),
				new Instructor(null, "Hoang Van E", "hoangvane@example.com", null)
			);

			instructors = instructorRepository.saveAll(instructors);

			List<Course> courses = List.of(
				createCourse("Java Basics", CourseStatus.PUBLISHED, instructors.get(0)),
				createCourse("Spring Boot Fundamentals", CourseStatus.PUBLISHED, instructors.get(1)),
				createCourse("Hibernate JPA", CourseStatus.PUBLISHED, instructors.get(2)),
				createCourse("REST API Development", CourseStatus.PUBLISHED, instructors.get(3)),
				createCourse("Database Design", CourseStatus.DRAFT, instructors.get(4)),
				createCourse("Microservices Architecture", CourseStatus.PUBLISHED, instructors.get(0)),
				createCourse("Unit Testing with JUnit", CourseStatus.PUBLISHED, instructors.get(1)),
				createCourse("Web Security", CourseStatus.ARCHIVED, instructors.get(2)),
				createCourse("Thymeleaf Templates", CourseStatus.PUBLISHED, instructors.get(3)),
				createCourse("Cloud Native Java", CourseStatus.DRAFT, instructors.get(4))
			);

			courses = courseRepository.saveAll(courses);

			List<Student> students = new ArrayList<>();
			for (int index = 1; index <= 50; index++) {
				students.add(new Student(null, "Student " + index, "student" + index + "@example.com", null));
			}

			students = studentRepository.saveAll(students);

			List<StudentEnrollment> enrollments = new ArrayList<>();
			for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
				Student student = students.get(studentIndex);
				for (int enrollmentIndex = 0; enrollmentIndex < 3; enrollmentIndex++) {
					Course course = courses.get((studentIndex * 3 + enrollmentIndex) % courses.size());
					StudentEnrollment enrollment = new StudentEnrollment();
					enrollment.setId(new EnrollmentId(student.getId(), course.getId()));
					enrollment.setStudent(student);
					enrollment.setCourse(course);
					enrollments.add(enrollment);
				}
			}

			enrollmentRepository.saveAll(enrollments);
		};
	}

	private static Course createCourse(String title, CourseStatus status, Instructor instructor) {
		Course course = new Course();
		course.setTitle(title);
		course.setStatus(status);
		course.setInstructor(instructor);
		return course;
	}
}
