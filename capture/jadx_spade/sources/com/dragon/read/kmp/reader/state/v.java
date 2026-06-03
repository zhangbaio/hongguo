package com.dragon.read.kmp.reader.state;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    public static final v a;

    static {
        Covode.recordClassIndex(608586);
        a = new v();
    }

    private v() {
    }

    public final void b(cm4.i activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final <T extends ViewModel> T a(cm4.i reader, KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (reader.b() instanceof NsReaderActivity) {
            NsReaderActivity b = reader.b();
            Intrinsics.checkNotNull(b, "null cannot be cast to non-null type com.dragon.read.component.biz.interfaces.NsReaderActivity");
            return (T) ViewModelProviders.of(b).get(JvmClassMappingKt.getJavaClass((KClass) clazz));
        }
        throw new IllegalArgumentException("activity must be KmpNsReaderActivityWrapper");
    }
}
