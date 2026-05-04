package session15.session15.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import session15.session15.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    
}
