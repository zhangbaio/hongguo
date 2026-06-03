package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608622);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final cm4.i reader) {
        super("点击听书自动进入听读同步", null, "auto_listen_while_read_mode", "auto_listen_read");
        boolean z;
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.f().f().a() != 2) {
            z = true;
        } else {
            z = false;
        }
        this.e = z;
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = b.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        int i;
        Intrinsics.checkNotNullParameter(scope, "scope");
        lm4.i f = iVar.f().f();
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        f.z(i);
        u0.a.X();
        return Unit.INSTANCE;
    }
}
