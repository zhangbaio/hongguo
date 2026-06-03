package jk4;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t0 {
    public static final int d;
    public final int a;
    public final String b;
    public MutableState<Boolean> c;

    static {
        Covode.recordClassIndex(607883);
        d = 8;
    }

    public t0(int i, String content, MutableState<Boolean> isSelected) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(isSelected, "isSelected");
        this.a = i;
        this.b = content;
        this.c = isSelected;
    }
}
