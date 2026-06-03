package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper;
import com.dragon.read.kmp.story.impl.feeds.guide.a;
import ec4.l0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j extends KmpBaseStoryExitAlertHelper {
    public static final int q;
    private final yo4.d l;
    private final float m;
    private final l0 n;
    private final tp4.b o;
    private final String p;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609291);
            int[] iArr = new int[KmpBaseStoryExitAlertHelper.DialogEvent.values().length];
            try {
                iArr[KmpBaseStoryExitAlertHelper.DialogEvent.EXIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmpBaseStoryExitAlertHelper.DialogEvent.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KmpBaseStoryExitAlertHelper.DialogEvent.GO_TO_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609290);
        q = 8;
    }

    private final int l() {
        return this.n.b;
    }

    private final int m() {
        return this.n.d;
    }

    private final void q() {
        com.dragon.read.kmp.story.impl.feeds.o oVar = com.dragon.read.kmp.story.impl.feeds.o.a;
        oVar.o(this.p);
        oVar.p(-1L);
    }

    @Override // com.dragon.read.kmp.story.impl.feeds.guide.a
    public boolean a() {
        if (l() <= 0) {
            return false;
        }
        return com.dragon.read.kmp.story.impl.feeds.o.a.l(this.p, l());
    }

    private final void k() {
        long g = com.dragon.read.kmp.story.impl.feeds.o.a.g();
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (g != -1 && m() > 0 && com.dragon.read.kmp.utils.o.a.b(g, epochMilliseconds) >= m()) {
            q();
        }
    }

    @Override // com.dragon.read.kmp.story.impl.feeds.guide.a
    public boolean b() {
        kp4.b g;
        kp4.b f;
        int roundToInt;
        boolean z;
        if (this.i.getValue().getFirst() == KmpStoryExitAlertType.V2) {
            return true;
        }
        k();
        boolean z2 = this.n.e;
        if ((!z2 && this.e) || (g = g()) == null || !h() || (f = this.d.f()) == null) {
            return false;
        }
        if (!z2 && this.d.d(f.a())) {
            return false;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(f.c.c * 100);
        float f2 = f.c.d;
        float f3 = 20 / 100.0f;
        float f4 = 50 / 100.0f;
        this.o.a("tryShowGuideDialog, readProgress = " + f2 + ", minLimit = 20, maxLimitF = 50");
        if (!this.n.c) {
            if (f3 <= f2 && f2 <= f4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
        }
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        com.dragon.read.kmp.story.impl.feeds.o oVar = com.dragon.read.kmp.story.impl.feeds.o.a;
        long g2 = oVar.g();
        if (g2 != -1 && p(g2, epochMilliseconds)) {
            this.o.d("今日已经达到下一篇退出挽留弹窗展示上限");
            return false;
        }
        if (a()) {
            this.o.d("达到下一篇退出挽留弹窗最大展示次数");
            oVar.p(epochMilliseconds);
            return false;
        }
        this.e = true;
        r(f, g, roundToInt, "exit");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(j jVar, String str) {
        jVar.l.f("page_name", str);
        return Unit.INSTANCE;
    }

    private final boolean p(long j, long j2) {
        if (com.dragon.read.kmp.utils.o.a.b(j, j2) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.dragon.read.kmp.story.impl.feeds.guide.a
    public void c(KmpBaseStoryExitAlertHelper.DialogEvent event, kp4.b targetStory) {
        kp4.c cVar;
        lp4.b bVar;
        int roundToInt;
        kp4.c cVar2;
        lp4.b bVar2;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(targetStory, "targetStory");
        this.h.setValue(new Pair<>(KmpStoryExitAlertType.NONE, null));
        kp4.b f = this.d.f();
        int i = a.a[event.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    n(f, targetStory, "popup", "exit");
                    return;
                }
                return;
            } else {
                if (f != null && (cVar2 = f.f) != null && (bVar2 = cVar2.a) != null) {
                    String a2 = targetStory.a();
                    roundToInt2 = MathKt__MathJVMKt.roundToInt(f.c.c * 100);
                    bVar2.b("exit", a2, "popup", "close", roundToInt2);
                    return;
                }
                return;
            }
        }
        if (f != null && (cVar = f.f) != null && (bVar = cVar.a) != null) {
            String a3 = targetStory.a();
            roundToInt = MathKt__MathJVMKt.roundToInt(f.c.c * 100);
            bVar.b("exit", a3, "popup", "exit", roundToInt);
        }
        zm4.d.a.b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(yo4.d clientParam, float f, l0 strategy, a.InterfaceC0074a dependency) {
        super(clientParam, f, strategy, dependency);
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.l = clientParam;
        this.m = f;
        this.n = strategy;
        this.o = new tp4.b("KmpNextStoryGuideAlertHelperV2");
        this.p = "story_exit_guide_next_content_strategy_v691";
    }

    private final void n(kp4.b bVar, kp4.b bVar2, final String str, String str2) {
        int roundToInt;
        if (bVar == null) {
            return;
        }
        q();
        kp4.b h = this.d.h(bVar2, bVar);
        ym4.a aVar = h.c.g;
        aVar.g("from_post_id", bVar.d().getPostId());
        aVar.g("from_book_id", bVar.d().getBookId());
        aVar.g("page_name", str);
        aVar.g("bar_type", str);
        a.InterfaceC0074a.C0075a.a(this.d, bVar, h, true, null, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit o;
                o = j.o(j.this, str);
                return o;
            }
        }, 8, null);
        lp4.b bVar3 = bVar.f.a;
        String a2 = h.a();
        roundToInt = MathKt__MathJVMKt.roundToInt(bVar.c.c * 100);
        bVar3.b(str2, a2, str, "read", roundToInt);
        ym4.a aVar2 = new ym4.a();
        aVar2.g("page_name", str);
        aVar2.g("bar_type", str);
        aVar2.g("from_post_id", bVar.d().getPostId());
        aVar2.g("from_book_id", bVar.d().getBookId());
        h.f.a.k(aVar2);
    }

    private final void r(kp4.b bVar, kp4.b bVar2, int i, String str) {
        this.h.setValue(new Pair<>(KmpStoryExitAlertType.V2, bVar2));
        com.dragon.read.kmp.story.impl.feeds.o.a.c(this.p);
        this.o.d("showNewGuideDialog, story = " + bVar.g() + ", nextStory = " + bVar2.g());
        this.d.a(bVar.a());
        this.d.b(bVar2.a());
        bVar.f.a.n(str, bVar2.a(), "popup", i);
        ym4.a aVar = new ym4.a();
        aVar.g("page_name", "popup");
        aVar.g("bar_type", "popup");
        aVar.g("from_post_id", bVar.d().getPostId());
        aVar.g("from_book_id", bVar.d().getBookId());
        bVar2.f.a.c(aVar);
    }
}
