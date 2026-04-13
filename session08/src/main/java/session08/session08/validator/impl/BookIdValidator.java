package session08.session08.validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import session08.session08.repository.BookRepository;
import session08.session08.validator.annotation.ExistingBookId;

@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long>{
    private final BookRepository bookRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext arg1) {
        return bookRepository.existsById(id);
    }

}
