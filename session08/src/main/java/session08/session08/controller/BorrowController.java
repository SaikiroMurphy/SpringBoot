package session08.session08.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import session08.session08.model.dto.request.BorrowCreateDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/borrows")
public class BorrowController {
    @PostMapping()
    public String postMethodName(@Valid @RequestBody BorrowCreateDTO req) {
        
        return "done";
    }
    
}
