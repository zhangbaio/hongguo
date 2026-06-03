package com.dragon.read.kmp.share.manger;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.vb0;
import com.bytedance.kmp.reading.model.wb0;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.utils.StringUtilsKt;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import xn4.b0;
import xn4.g0;
import yn0.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(608926);
        a = new c();
    }

    private c() {
    }

    public final Observable<String> e(final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Observable l = UserApiService.l(UserApiService.a, new vb0(url), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = l.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.manger.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String f;
                f = c.f(url, (wb0) obj);
                return f;
            }
        };
        Observable<String> map = observeOn.map(new Function() { // from class: com.dragon.read.kmp.share.manger.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String g;
                g = c.g(Function1.this, obj);
                return g;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    public final void j(yn4.b bVar) {
        if (bVar == null) {
            return;
        }
        ym4.a j = new ym4.a().j(bVar.b());
        j.g("show_duration", Long.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds() - bVar.d));
        j.g("use_channel_cache", Boolean.TRUE);
        List<String> list = bVar.f;
        if (list != null) {
            j.g("channel_list", list.toString());
        }
        ym4.o.a.d("share_page_show", j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (String) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String str, wb0 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        bc4.b.d(bc4.b.a, it2.a, it2.b, it2.c, false, 0, 24, (Object) null);
        String str2 = it2.c;
        if (str2 != null) {
            return str2;
        }
        return str;
    }

    public final void i(yn4.b bVar, String str) {
        if (bVar != null && str != null) {
            ym4.o.a.d("share_page_close", bVar.b().g("reason", str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String d(String shareUrl, Map<String, String> params, String str) {
        String str2;
        com.dragon.read.kmp.base.l a2;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Result.Companion companion = Result.Companion;
            a2 = com.dragon.read.kmp.base.m.a(shareUrl);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str2 = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (a2 == null) {
            return shareUrl;
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(params);
        a2.b(mutableMap);
        String c = a2.c();
        if (Intrinsics.areEqual(str, "weibo")) {
            return g0.a.e(c);
        }
        str2 = Result.m773constructorimpl(c);
        if (!Result.m779isFailureimpl(str2)) {
            shareUrl = str2;
        }
        return shareUrl;
    }

    public final String c(String str, yn4.b bVar, String str2) {
        String str3;
        ym4.a g;
        if (bVar == null) {
            return str;
        }
        boolean z = false;
        if (str != null) {
            try {
                if (StringUtilsKt.a(str)) {
                    z = true;
                }
            } catch (Exception unused) {
                return str;
            }
        }
        if (z) {
            ym4.a aVar = new ym4.a();
            aVar.g("share_timestamp", Long.valueOf(bVar.b));
            String str4 = bVar.a;
            if (str4 == null) {
                str4 = str2;
            }
            aVar.g("share_channel", str4);
            String str5 = bVar.a;
            if (str5 == null) {
                str5 = str2;
            }
            aVar.g("source_channel", str5);
            yn4.a aVar2 = bVar.c;
            ym4.a aVar3 = null;
            if (aVar2 != null) {
                str3 = aVar2.a;
            } else {
                str3 = null;
            }
            aVar.g("entrance", str3);
            com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
            yn4.a aVar4 = bVar.c;
            if (aVar4 != null && (g = aVar4.g()) != null) {
                aVar3 = g.g("share_timestamp", Long.valueOf(bVar.b));
            }
            String str6 = "";
            if (aVar3 != null) {
                try {
                    gn6.a c = com.dragon.read.kmp.base.h.c();
                    c.getSerializersModule();
                    str6 = c.a(ym4.a.Companion.serializer(), aVar3);
                } catch (Exception e) {
                    a.a.b(yn0.b.b, "JSONUtils", "safeJsonString, error = " + e.getMessage(), false, 4, (Object) null);
                }
            }
            aVar.g("report_params", str6);
            return d(str, aVar.f(), str2);
        }
        return str;
    }

    public final void h(yn4.b bVar, String str, String str2) {
        boolean z;
        yn4.a aVar;
        String type;
        if (bVar != null && str != null) {
            ym4.a b = bVar.b();
            String str3 = bVar.g;
            if (StringUtilsKt.a(str2)) {
                b.g("second_share_channel", str);
                b.g("share_channel", str2);
                bVar.a = str2;
                yn4.a aVar2 = bVar.c;
                if (aVar2 != null) {
                    aVar2.e(str);
                }
            } else {
                b.g("share_channel", str);
                bVar.a = null;
            }
            if (bVar.e > 0) {
                b.g("loading_did_show", Boolean.TRUE);
                b.g("loading_duration", Long.valueOf(bVar.e));
            } else {
                b.g("loading_did_show", Boolean.FALSE);
                b.g("loading_duration", 0L);
            }
            if (str3 != null && str3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                b.g("linktype", str3);
            }
            ym4.o.a.d("choose_share_channel", b);
            bVar.g = null;
            if (!Intrinsics.areEqual(str, "long_image") && (aVar = bVar.c) != null && (type = aVar.getType()) != null) {
                b0.a.i(type);
            }
        }
    }
}
