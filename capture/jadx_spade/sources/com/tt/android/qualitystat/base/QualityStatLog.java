package com.tt.android.qualitystat.base;

import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.base.QualityStatLog$defaultLogDelegate$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class QualityStatLog {
    static final /* synthetic */ KProperty[] a;
    private static final Lazy b;
    public static final QualityStatLog c;

    private QualityStatLog() {
    }

    private final uj6.c d() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return (uj6.c) lazy.getValue();
    }

    private final uj6.c e() {
        uj6.c g = UserStatAgent.g.g();
        if (g == null) {
            return d();
        }
        return g;
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(654030);
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(QualityStatLog.class), "defaultLogDelegate", "getDefaultLogDelegate()Lcom/tt/android/qualitystat/interceptor/ILogDelegate;"))};
        c = new QualityStatLog();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QualityStatLog$defaultLogDelegate$2.a>() { // from class: com.tt.android.qualitystat.base.QualityStatLog$defaultLogDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }

            public static final class a implements uj6.c {
                a() {
                }

                @Override // uj6.c
                public void onLogPrint(int i, String str, String str2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    Log.println(i, str, str2);
                                    return;
                                } else {
                                    Logger.e(str, str2);
                                    return;
                                }
                            }
                            Logger.w(str, str2);
                            return;
                        }
                        Logger.i(str, str2);
                        return;
                    }
                    Logger.d(str, str2);
                }
            }
        });
        b = lazy;
    }

    public final void a(String str) {
        e().onLogPrint(3, "ttquality", str);
    }

    public final void c(String str) {
        e().onLogPrint(6, "ttquality", str);
    }

    public final void f(String str) {
        e().onLogPrint(4, "ttquality", str);
    }

    public final void h(String str) {
        e().onLogPrint(5, "ttquality", str);
    }

    public final void b(String str, String str2) {
        e().onLogPrint(3, "ttquality", str + ':' + str2);
    }

    public final void g(String str, String str2) {
        e().onLogPrint(4, "ttquality", str + ':' + str2);
    }

    public final void i(String str, String str2) {
        e().onLogPrint(5, "ttquality", str + ':' + str2);
    }
}
