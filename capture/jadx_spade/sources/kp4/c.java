package kp4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.g;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int c;
    public lp4.b a;
    public lp4.a b;

    static {
        Covode.recordClassIndex(609303);
        c = 8;
    }

    public c(b story, yo4.d clientParam) {
        lp4.b cVar;
        Intrinsics.checkNotNullParameter(story, "story");
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        if (!story.n()) {
            cVar = new mp4.b(story, clientParam);
        } else {
            cVar = new mp4.c(story, clientParam);
        }
        this.a = cVar;
        this.b = new g(story);
    }
}
