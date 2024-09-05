package com.soybean.infrastructure.utils;

import com.soybean.infrastructure.constants.constant.ExceptionConstant;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {
    private static final Validator VALIDATOR = SpringUtils.getBean(Validator.class);

    public static <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = VALIDATOR.validate(object, groups);
        if(!CollectionUtils.isEmpty(validate)){
            throw new ConstraintViolationException(ExceptionConstant.PARAM_VALIDATOR_EXCEPTION, validate);
        }
    }
}
