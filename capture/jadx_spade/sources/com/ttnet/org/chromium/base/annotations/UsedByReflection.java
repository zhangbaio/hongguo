package com.ttnet.org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public @interface UsedByReflection {
    String value();
}
