package com.uber.nullaway.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.meta.TypeQualifierDefault;

@Target({ElementType.PACKAGE})
@TypeQualifierDefault({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public @interface NonNullFieldsToKotlin {
}
