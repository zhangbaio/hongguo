package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BottomInfoItem extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608623);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomInfoItem(final cm4.i reader) {
        super("展示进度、时间和电量", null, "display_progress_time_battery", "bottom_info");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.e = reader.f().f().v();
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = BottomInfoItem.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        iVar.f().f().S(z);
        kotlinx.coroutines.i.e(scope, null, null, new BottomInfoItem$1$1(null), 3, null);
        return Unit.INSTANCE;
    }
}
