package kotlin.reflect;

import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}
