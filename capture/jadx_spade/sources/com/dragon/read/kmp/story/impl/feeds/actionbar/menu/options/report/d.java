package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.g1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends fp4.c {
    public static final int i;
    public final kp4.b g;
    private boolean h;

    static {
        Covode.recordClassIndex(609242);
        i = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(kp4.b kmpStory) {
        super("举报", d2.B(f2.a.a), false, null, null, 28, null);
        Intrinsics.checkNotNullParameter(kmpStory, "kmpStory");
        this.g = kmpStory;
        f(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j;
                j = d.j(d.this);
                return j;
            }
        });
        e(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k;
                k = d.k(d.this);
                return k;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(d dVar) {
        if (!dVar.h) {
            dVar.h = true;
            ym4.a aVar = new ym4.a();
            aVar.g("type", "report");
            dVar.g.f.a.l("show_post_feedback", aVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final d dVar) {
        lp4.b bVar = dVar.g.f.a;
        ym4.a aVar = new ym4.a();
        aVar.g("type", "report");
        aVar.g("clicked_content", "report");
        Unit unit = Unit.INSTANCE;
        bVar.l("click_post_feedback", aVar);
        lp4.b bVar2 = dVar.g.f.a;
        ym4.a aVar2 = new ym4.a();
        aVar2.g("reason_type", "举报");
        bVar2.l("click_report", aVar2);
        g.e(new g1(false, false, null, true, 7, null), dVar.g, new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit l;
                l = d.l(d.this, (com.dragon.read.kmp.community.common.dialog.report.f) obj, (String) obj2);
                return l;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(d dVar, com.dragon.read.kmp.community.common.dialog.report.f fVar, String str) {
        if (fVar != null) {
            ym4.a aVar = new ym4.a();
            aVar.g("book_id", dVar.g.d().getBookId());
            aVar.g("group_id", dVar.g.d().getGroupId());
            aVar.g("clicked_content", fVar.b);
            dVar.g.f.a.l("report_success", aVar);
        }
        return Unit.INSTANCE;
    }
}
