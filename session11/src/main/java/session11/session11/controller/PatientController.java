package session11.session11.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import session11.session11.model.dto.request.PatientRequest;
import session11.session11.model.dto.response.ApiResponse;
import session11.session11.model.entity.Patient;
import session11.session11.service.PatientService;
import session11.session11.utils.enums.ApiResponseStatusEnum;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
@Slf4j
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ApiResponse<Patient>> createPatient(@Valid @RequestBody PatientRequest req) {
        Patient entity = patientService.createPatient(req);

        log.info("Thêm bệnh nhân: {}", entity.getFullName());
        int age = entity.getDob().until(java.time.LocalDate.now()).getYears();
        if (age > 120) {
            log.warn("Bệnh nhân {} có tuổi {} vượt quá mức bình thường!", entity.getFullName(), age);
            
        }
        ApiResponse<Patient> res = new ApiResponse<>(ApiResponseStatusEnum.SUCCESS, 201, entity, null);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Patient>> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.findPatientById(id);
        ApiResponse<Patient> res = new ApiResponse<>(ApiResponseStatusEnum.SUCCESS, 200, patient, null);
        return ResponseEntity.ok(res);
    }
    
}
