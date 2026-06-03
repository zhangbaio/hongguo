package com.dragon.read.component.shortvideo.data.consts;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface PlayerConst$PlaySource {
    public static final a Companion;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(599038);
            a = new a();
        }

        private a() {
        }
    }

    static {
        Covode.recordClassIndex(599037);
        Companion = a.a;
    }
}
