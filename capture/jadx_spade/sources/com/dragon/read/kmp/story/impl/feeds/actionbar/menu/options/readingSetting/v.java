package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lp4.b;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v extends fp4.c {
    public static final int j;
    public final kp4.b g;
    public final KmpStoryFeedsVM h;
    private boolean i;

    static {
        Covode.recordClassIndex(609238);
        j = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(v vVar) {
        if (!vVar.i) {
            vVar.i = true;
            b.a.c(vVar.g.f.a, "show_story_font_config", null, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(v vVar) {
        b.a.c(vVar.g.f.a, "click_story_font_config", null, 2, null);
        g1 g1Var = new g1(false, false, null, true, 7, null);
        g1Var.f = false;
        x.d(g1Var, vVar.g, vVar.h);
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(kp4.b kmpStory, KmpStoryFeedsVM viewModel) {
        super("阅读设置", d2.C(f2.a.a), false, null, null, 28, null);
        Intrinsics.checkNotNullParameter(kmpStory, "kmpStory");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.g = kmpStory;
        this.h = viewModel;
        f(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit i;
                i = v.i(v.this);
                return i;
            }
        });
        e(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j2;
                j2 = v.j(v.this);
                return j2;
            }
        });
    }
}
