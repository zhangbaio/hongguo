package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608627);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(final cm4.i reader) {
        super("智能推荐日夜间模式", "根据当前使用环境亮度推荐切换", "night_mode_guide", "intelligent_theme");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.e = reader.f().g().f();
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = j.e(cm4.i.this, this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, j jVar, boolean z, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        iVar.f().g().j(z);
        if (z) {
            ig4.g.b("将为你智能推荐日夜间模式", (ToastDuration) null, 2, (Object) null);
        } else {
            ig4.g.b("已关闭智能推荐日夜间模式", (ToastDuration) null, 2, (Object) null);
        }
        k.a(jVar);
        return Unit.INSTANCE;
    }
}
