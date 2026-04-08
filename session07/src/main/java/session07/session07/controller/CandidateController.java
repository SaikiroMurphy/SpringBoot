package session07.session07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import session07.session07.model.dto.request.CandidateCreateRequest;
import session07.session07.model.dto.request.CandidateUpdateRequest;
import session07.session07.model.dto.response.CandidateResponse;
import session07.session07.service.CandidateService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping
    public CandidateResponse addCandidate(@Valid @RequestBody CandidateCreateRequest req) {
        
        return candidateService.addCandidate(req);
    }
    
    @PutMapping("update/{id}")
    public CandidateResponse updateCandidate(@PathVariable int id, @Valid @ModelAttribute CandidateUpdateRequest req) {
        return candidateService.updateCandidate(req, id);
    }
}
