package cl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.StringUtilsKt;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z0 {
    static {
        Covode.recordClassIndex(608067);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(gk4.w wVar, Function0 function0, Function0 function02, Function3 function3, int i, int i2, Composer composer, int i3) {
        j(wVar, function0, function02, function3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(MutableState mutableState, androidx.compose.ui.layout.w coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        a0.h c = androidx.compose.ui.layout.x.c(coordinates);
        float f = c.a;
        float f2 = c.b;
        mutableState.setValue(new int[]{(int) f, (int) f2, (int) (c.c - f), (int) (c.d - f2)});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MutableState mutableState, MutableState mutableState2, gk4.w wVar, Function0 function0) {
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            u.a.b(new p((int[]) mutableState2.getValue(), wVar.d(), wVar.i(), wVar.k()));
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final gk4.w wVar, final gk4.w item, Function2 onStart, final Function2 onSuccess, final Function3 onError) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.dragon.read.kmp.subscribe.n.a.z(item, onStart, new Function2() { // from class: cl4.x0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit p;
                p = z0.p(Function2.this, wVar, item, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue());
                return p;
            }
        }, new Function3() { // from class: cl4.y0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit q;
                q = z0.q(Function3.this, item, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue(), (Throwable) obj3);
                return q;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function3 function3, gk4.w wVar, boolean z, long j, Throwable th) {
        function3.invoke(Boolean.valueOf(z), Long.valueOf(j), th);
        tb4.f a = tb4.f.f3.a();
        int r = wVar.r();
        String objectId = wVar.getObjectId();
        Intrinsics.checkNotNull(objectId);
        String objectId2 = wVar.getObjectId();
        Intrinsics.checkNotNull(objectId2);
        a.P3("other_works", new gk4.b0(r, objectId, z, j, objectId2, null, 32, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function2 function2, gk4.w wVar, gk4.w wVar2, boolean z, long j) {
        String str;
        function2.invoke(Boolean.valueOf(z), Long.valueOf(j));
        HashMap hashMap = new HashMap();
        Object l = com.dragon.read.kmp.utils.k0.a.b().l("profile_user_id");
        if (l instanceof String) {
            str = (String) l;
        } else {
            str = null;
        }
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(str);
        if (takeIfNotEmpty != null) {
            hashMap.put("profile_user_id", takeIfNotEmpty);
        }
        if (wVar.s()) {
            hashMap.put("profile_tab_name", "profile_post");
        } else if (wVar.o()) {
            hashMap.put("profile_tab_name", "profile_star_info");
        }
        tb4.f a = tb4.f.f3.a();
        int r = wVar2.r();
        String objectId = wVar2.getObjectId();
        Intrinsics.checkNotNull(objectId);
        String objectId2 = wVar2.getObjectId();
        Intrinsics.checkNotNull(objectId2);
        a.P3("other_works", new gk4.b0(r, objectId, z, j, objectId2, hashMap));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final gk4.w r40, kotlin.jvm.functions.Function0<kotlin.Unit> r41, kotlin.jvm.functions.Function0<kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.r, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cl4.z0.j(gk4.w, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
