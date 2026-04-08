package session07.session07.model.dto.response;

import lombok.Data;

@Data
public class CandidateResponse {
    private int id;
    private String fullName;
    private String email;
    private int age;
    private int yearsOfExperience;
    private String address;
    private String bio;
    private String phone;
}
