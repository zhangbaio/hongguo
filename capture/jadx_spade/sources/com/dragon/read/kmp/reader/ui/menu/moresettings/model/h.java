package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h extends sm4.k {
    public static final int h;

    static {
        Covode.recordClassIndex(608626);
        h = sm4.k.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(final cm4.i reader) {
        super("阅读器正文插图显示", "出版书籍不支持该功能", "reader_picture_display", "content_picture");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.e = reader.f().f().t();
        c(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.g
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = h.e(cm4.i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(cm4.i iVar, boolean z, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        iVar.f().f().P(z);
        iVar.f().update(iVar);
        return Unit.INSTANCE;
    }
}
