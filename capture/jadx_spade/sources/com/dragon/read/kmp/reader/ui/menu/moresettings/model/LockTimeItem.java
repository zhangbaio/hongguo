package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LockTimeItem extends sm4.g {
    public static final int h;

    static {
        Covode.recordClassIndex(608630);
        h = sm4.g.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockTimeItem(cm4.i reader) {
        super("锁屏时间", "", "", "lock_time");
        Intrinsics.checkNotNullParameter(reader, "reader");
        d(sm4.c.a(reader.f().f().b()));
        e(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.n
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit g;
                g = LockTimeItem.g(LockTimeItem.this, (cm4.i) obj, (com.dragon.read.kmp.reader.ui.menu.ui.c) obj2, (CoroutineScope) obj3);
                return g;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(LockTimeItem lockTimeItem, cm4.i reader, com.dragon.read.kmp.reader.ui.menu.ui.c panelStack, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(panelStack, "panelStack");
        Intrinsics.checkNotNullParameter(scope, "scope");
        com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar = new com.dragon.read.kmp.reader.ui.menu.moresettings.o(sm4.c.a.c(sm4.c.a(reader.f().f().b())));
        panelStack.e(oVar, androidx.compose.runtime.internal.t.c(1911839350, true, new LockTimeItem$1$1(oVar, reader, scope, lockTimeItem, panelStack)));
        return Unit.INSTANCE;
    }
}
