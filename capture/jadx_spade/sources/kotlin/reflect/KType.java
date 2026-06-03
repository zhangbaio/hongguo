package kotlin.reflect;

import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KType extends KAnnotatedElement {
    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
