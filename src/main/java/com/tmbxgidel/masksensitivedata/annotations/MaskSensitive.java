package com.tmbxgidel.masksensitivedata.annotations;

import com.tmbxgidel.masksensitivedata.enums.MaskType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark sensitive fields that should be masked in logs.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaskSensitive {
    MaskType value(); // Specifies the type of sensitive data
}
