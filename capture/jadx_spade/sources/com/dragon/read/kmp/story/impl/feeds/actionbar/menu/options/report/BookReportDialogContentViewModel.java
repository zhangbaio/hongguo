package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookReportDialogContentViewModel extends com.dragon.read.kmp.community.common.dialog.report.a {
    public final kp4.b j;
    public final Function2<com.dragon.read.kmp.community.common.dialog.report.f, String, Unit> k;
    public final Function0<Unit> l;

    static {
        Covode.recordClassIndex(609241);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G0() {
        int i;
        if (((com.dragon.read.kmp.community.common.dialog.report.a) this).e) {
            return;
        }
        if (((com.dragon.read.kmp.community.common.dialog.report.a) this).f.getValue() == null) {
            b1.a.D("请选择举报类型");
            return;
        }
        com.dragon.read.kmp.community.common.dialog.report.f fVar = (com.dragon.read.kmp.community.common.dialog.report.f) ((com.dragon.read.kmp.community.common.dialog.report.a) this).f.getValue();
        boolean z = false;
        if (fVar != null) {
            int i2 = fVar.a;
            i = g.b;
            if (i2 == i) {
                z = true;
            }
        }
        if (z && StringsKt__StringsKt.isBlank((CharSequence) ((com.dragon.read.kmp.community.common.dialog.report.a) this).g.getValue())) {
            b1.a.D("请先描述具体抄袭/侵权原因");
            return;
        }
        ((com.dragon.read.kmp.community.common.dialog.report.a) this).e = true;
        this.k.invoke(((com.dragon.read.kmp.community.common.dialog.report.a) this).f.getValue(), ((com.dragon.read.kmp.community.common.dialog.report.a) this).g.getValue());
        kotlinx.coroutines.i.e(((com.dragon.read.kmp.community.common.dialog.report.a) this).c, Dispatchers.getIO(), null, new BookReportDialogContentViewModel$submitReport$1(this, null), 2, null);
    }

    public BookReportDialogContentViewModel(kp4.b kmpStory, Function2<? super com.dragon.read.kmp.community.common.dialog.report.f, ? super String, Unit> onSubmit, Function0<Unit> onSubmitSuccess) {
        Intrinsics.checkNotNullParameter(kmpStory, "kmpStory");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onSubmitSuccess, "onSubmitSuccess");
        this.j = kmpStory;
        this.k = onSubmit;
        this.l = onSubmitSuccess;
    }
}
