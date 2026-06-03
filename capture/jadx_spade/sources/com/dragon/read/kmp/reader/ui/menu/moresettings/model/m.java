package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608629);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(final cm4.i reader) {
        super("侧滑退出阅读器", null, "horizontal_flip_quit_reader", "left_swipe_exit");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.e = reader.f().f().r();
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.l
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = m.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        iVar.f().f().K(z);
        u0.a.X();
        return Unit.INSTANCE;
    }
}
