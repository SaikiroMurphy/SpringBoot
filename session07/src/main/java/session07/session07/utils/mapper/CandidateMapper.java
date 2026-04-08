package session07.session07.utils.mapper;

import session07.session07.model.dto.request.CandidateCreateRequest;
import session07.session07.model.dto.response.CandidateResponse;
import session07.session07.model.entity.Candidate;

public class CandidateMapper {
    public static CandidateResponse entityToDto(Candidate entity) {
        CandidateResponse dto = new CandidateResponse();
        
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        dto.setYearsOfExperience(entity.getYearsOfExperience());
        dto.setAddress(entity.getAddress());
        dto.setBio(entity.getBio());
        dto.setPhone(entity.getPhone());

        return dto;
    }

    public static Candidate dtoToEntity(CandidateCreateRequest req) {
        Candidate entity = new Candidate();

        entity.setFullName(req.getFullName());
        entity.setEmail(req.getEmail());
        entity.setAge(req.getAge());
        entity.setYearsOfExperience(req.getYearsOfExperience());
        entity.setPhone(req.getPhone());

        return entity;
    }
}
