package session08.session08.validator.annotation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import session08.session08.validator.impl.BookIdValidator;

@Target(ElementType.FIELD) // 🔥 bắt buộc
@Retention(RetentionPolicy.RUNTIME) // 🔥 bắt buộc
@Constraint(validatedBy = BookIdValidator.class)
@Documented
public @interface ExistingBookId {

    String message() default "Sách không tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}