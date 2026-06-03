package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608633);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(final cm4.i reader) {
        super("下拉页面快捷添加书签", "仅左右翻页模式", "bookmark_setting", "bookmark");
        Intrinsics.checkNotNullParameter(reader, "reader");
        int l = reader.f().f().l();
        boolean z = true;
        if (l != 0 && l != 1) {
            z = false;
        }
        this.e = z;
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.t
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = u.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(scope, "scope");
        lm4.i f = iVar.f().f();
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        f.O(i);
        u0.a.X();
        com.dragon.read.kmp.reader.utils.q qVar = com.dragon.read.kmp.reader.utils.q.a;
        String b = iVar.a().b();
        if (z) {
            str = "on";
        } else {
            str = "off";
        }
        qVar.a(b, "bookmark_setting", str);
        return Unit.INSTANCE;
    }
}
