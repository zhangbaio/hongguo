package me.ele.lancet.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface Insert {
    boolean checkHookName() default false;

    boolean mayCreateSuper() default false;

    boolean needHotFix() default false;

    boolean shouldIgnoreCheck() default false;

    String value();
}
