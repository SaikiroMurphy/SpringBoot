package session07.session07.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import session07.session07.model.dto.request.CandidateCreateRequest;
import session07.session07.model.dto.request.CandidateUpdateRequest;
import session07.session07.model.dto.response.CandidateResponse;
import session07.session07.model.entity.Candidate;
import session07.session07.repository.CandidateRepository;
import session07.session07.utils.mapper.CandidateMapper;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    public CandidateResponse addCandidate(CandidateCreateRequest req) {
        Candidate entity = CandidateMapper.dtoToEntity(req);
        candidateRepository.save(entity);
        return CandidateMapper.entityToDto(entity);
    }

    public CandidateResponse updateCandidate(CandidateUpdateRequest req, int id) {
        Candidate entity = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ứng viên có ID tương ứng."));

        entity.setAddress(req.getAddress());
        entity.setBio(req.getBio());
        
        candidateRepository.save(entity);
        return CandidateMapper.entityToDto(entity);
    }
}
