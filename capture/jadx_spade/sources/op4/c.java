package op4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int d;
    public final nn0.b a;
    private final com.dragon.read.kmp.story.impl.feeds.data.a b;
    public List<np4.e> c;

    static {
        Covode.recordClassIndex(609333);
        d = 8;
    }

    public final String a() {
        return this.b.a;
    }

    public final int b() {
        return this.b.b;
    }

    public final String c() {
        return this.b.c;
    }

    public c(nn0.b layout, com.dragon.read.kmp.story.impl.feeds.data.a info) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(info, "info");
        this.a = layout;
        this.b = info;
        this.c = new ArrayList();
    }
}
