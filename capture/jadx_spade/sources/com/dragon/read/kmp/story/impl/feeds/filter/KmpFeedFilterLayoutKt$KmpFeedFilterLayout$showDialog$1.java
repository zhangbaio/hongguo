package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.dragon.read.story.impl.tab.page.bookmall.f1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1 implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
    final /* synthetic */ String a;
    final /* synthetic */ List<f1> b;
    final /* synthetic */ String c;
    final /* synthetic */ ym4.a d;
    final /* synthetic */ Function1<String, Unit> e;

    /* JADX WARN: Multi-variable type inference failed */
    KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1(String str, List<f1> list, String str2, ym4.a aVar, Function1<? super String, Unit> function1) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = aVar;
        this.e = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(com.dragon.read.kmp.service.g gVar) {
        gVar.a();
        return Unit.INSTANCE;
    }

    private static final String h(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState) {
        i(mutableState, null);
        return Unit.INSTANCE;
    }

    private static final void i(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(MutableState mutableState, String str) {
        i(mutableState, str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
        e(gVar, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(final com.dragon.read.kmp.service.g r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1.e(com.dragon.read.kmp.service.g, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, Function1 function1, com.dragon.read.kmp.service.g gVar, MutableState mutableState, String str2, ym4.a aVar) {
        String h;
        boolean z = true;
        if ((!Intrinsics.areEqual(h(mutableState), str)) && (h = h(mutableState)) != null) {
            if (h.length() <= 0) {
                z = false;
            }
            if (!z) {
                h = null;
            }
            if (h != null) {
                new vc4.a().m(h).n(str2).h("0").j(aVar).b();
            }
        }
        function1.invoke(h(mutableState));
        gVar.a();
        return Unit.INSTANCE;
    }
}
