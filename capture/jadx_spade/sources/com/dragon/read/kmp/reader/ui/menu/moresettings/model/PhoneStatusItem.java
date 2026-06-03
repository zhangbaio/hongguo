package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PhoneStatusItem extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608632);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneStatusItem(final cm4.i reader) {
        super("手机状态栏常驻显示", "显示后台程序、通知、信号等", "display_system_top_banner", "status_bar");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.e = reader.f().f().u();
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.s
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = PhoneStatusItem.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        iVar.f().f().Q(z);
        u0.a.X();
        com.dragon.read.kmp.reader.services.x.a.c().B4(context, z);
        kotlinx.coroutines.i.e(scope, null, null, new PhoneStatusItem$1$1(null), 3, null);
        return Unit.INSTANCE;
    }
}
