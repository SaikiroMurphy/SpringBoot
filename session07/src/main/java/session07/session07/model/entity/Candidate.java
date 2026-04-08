package session07.session07.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String email;
    
    @Column
    private int age;
    
    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    @Column
    private String address;

    @Column
    private String bio;

    @Column
    private String phone;
}
