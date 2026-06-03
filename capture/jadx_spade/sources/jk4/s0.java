package jk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    public final int a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;

    static {
        Covode.recordClassIndex(607882);
    }

    public s0(int i, boolean z, String emojiKey, String title, String editHint) {
        Intrinsics.checkNotNullParameter(emojiKey, "emojiKey");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(editHint, "editHint");
        this.a = i;
        this.b = z;
        this.c = emojiKey;
        this.d = title;
        this.e = editHint;
    }
}
