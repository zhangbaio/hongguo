package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.g1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k extends fp4.c {
    public static final int i;
    public final kp4.b g;
    private boolean h;

    static {
        Covode.recordClassIndex(609244);
        i = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(kp4.b kmpStory) {
        super("举报", d2.B(f2.a.a), false, null, null, 28, null);
        Intrinsics.checkNotNullParameter(kmpStory, "kmpStory");
        this.g = kmpStory;
        f(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j;
                j = k.j(k.this);
                return j;
            }
        });
        e(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k;
                k = k.k(k.this);
                return k;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(k kVar) {
        if (!kVar.h) {
            kVar.h = true;
            ym4.a aVar = new ym4.a();
            aVar.g("post_id", kVar.g.d().getPostId());
            aVar.g("type", "report");
            kVar.g.f.a.l("show_post_feedback", aVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final k kVar) {
        lp4.b bVar = kVar.g.f.a;
        ym4.a aVar = new ym4.a();
        aVar.g("post_id", kVar.g.d().getPostId());
        aVar.g("type", "report");
        aVar.g("clicked_content", "report");
        Unit unit = Unit.INSTANCE;
        bVar.l("click_post_feedback", aVar);
        lp4.b bVar2 = kVar.g.f.a;
        ym4.a aVar2 = new ym4.a();
        aVar2.g("post_id", kVar.g.d().getPostId());
        aVar2.g("reason_type", "举报");
        bVar2.l("click_report", aVar2);
        com.dragon.read.kmp.community.common.dialog.report.e.c(new g1(false, false, null, true, 7, null), (List) null, kVar.g.d().getPostId(), new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit l;
                l = k.l(k.this, (com.dragon.read.kmp.community.common.dialog.report.f) obj, (String) obj2);
                return l;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(k kVar, com.dragon.read.kmp.community.common.dialog.report.f fVar, String str) {
        if (fVar != null) {
            lp4.b bVar = kVar.g.f.a;
            ym4.a aVar = new ym4.a();
            aVar.g("post_id", kVar.g.d().getPostId());
            aVar.g("report_reason", fVar.b);
            aVar.g("reason_type", "举报");
            aVar.g("content_detail", str);
            Unit unit = Unit.INSTANCE;
            bVar.l("report_post", aVar);
        }
        return Unit.INSTANCE;
    }
}
