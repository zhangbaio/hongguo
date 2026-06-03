package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608624);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(final cm4.i reader) {
        super("目录外露" + em4.a.b(null, null, 3, null) + "片段", null, "show_highlight_scene", "highlight");
        boolean z;
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.f().f().i() != 2) {
            z = true;
        } else {
            z = false;
        }
        this.e = z;
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.d
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = e.e(cm4.i.this, this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, e eVar, boolean z, Context context, CoroutineScope scope) {
        int i;
        Intrinsics.checkNotNullParameter(scope, "scope");
        lm4.i f = iVar.f().f();
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        f.J(i);
        u0.a.X();
        if (context != null) {
            f.a(eVar, context, z);
        }
        return Unit.INSTANCE;
    }
}
