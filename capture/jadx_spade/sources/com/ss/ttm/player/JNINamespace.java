package com.ss.ttm.player;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface JNINamespace {
    String value();
}
