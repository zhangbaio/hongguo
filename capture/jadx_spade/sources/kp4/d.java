package kp4;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int h;
    public final String a;
    public int b;
    public float c;
    public float d;
    public final Map<String, Integer> e;
    public String f;
    public final ym4.a g;

    static {
        Covode.recordClassIndex(609304);
        h = 8;
    }

    private final void c(float f) {
        float coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f, this.d);
        this.d = coerceAtLeast;
    }

    public final void b(float f) {
        float coerceIn;
        c(f);
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 100.0f);
        this.c = coerceIn;
    }

    public d(String postPosition) {
        Intrinsics.checkNotNullParameter(postPosition, "postPosition");
        this.a = postPosition;
        this.e = new LinkedHashMap();
        this.g = new ym4.a();
    }

    public final int a(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Integer num = this.e.get(chapterId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
