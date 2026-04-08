package session07.session07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session07.session07.model.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
