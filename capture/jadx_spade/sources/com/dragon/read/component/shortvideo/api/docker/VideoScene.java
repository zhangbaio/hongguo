package com.dragon.read.component.shortvideo.api.docker;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface VideoScene {
    public static final a Companion;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598660);
            a = new a();
        }

        private a() {
        }

        public final String a(int i) {
            if (i == 0) {
                return "single";
            }
            if (i != 1) {
                return null;
            }
            return "recommend";
        }
    }

    static {
        Covode.recordClassIndex(598659);
        Companion = a.a;
    }
}
