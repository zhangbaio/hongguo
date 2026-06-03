package rq3;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class k {
    static {
        int i = l.c3;
    }

    public static void A(l lVar, boolean z) {
    }

    public static void B(l lVar, boolean z) {
    }

    public static void C(l lVar, boolean z) {
    }

    public static void D(l lVar, String str) {
    }

    public static void E(l lVar, boolean z, String cellTitleText, Float f, Typeface typeface) {
        Intrinsics.checkNotNullParameter(cellTitleText, "cellTitleText");
    }

    public static void F(l lVar, boolean z) {
    }

    public static void G(l lVar, boolean z) {
    }

    public static void H(l lVar, Function2 function2, Function1 function1) {
    }

    public static boolean I(l lVar, ds3.b request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return false;
    }

    public static void J(l lVar, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public static void a(l lVar, SaasVideoData saasVideoData, int i, String str) {
    }

    public static void b(l lVar) {
    }

    public static void c(l lVar, boolean z) {
    }

    public static FrameLayout d(l lVar) {
        return null;
    }

    public static gs3.a e(l lVar) {
        return null;
    }

    public static ts3.a f(l lVar) {
        return null;
    }

    public static String g(l lVar) {
        return "";
    }

    public static int i(l lVar) {
        return 0;
    }

    public static jr3.a j(l lVar) {
        return null;
    }

    public static boolean k(l lVar) {
        return false;
    }

    public static boolean m(l lVar) {
        return false;
    }

    public static void n(l lVar, boolean z) {
    }

    public static boolean o(l lVar) {
        return false;
    }

    public static boolean p(l lVar) {
        return false;
    }

    public static boolean q(l lVar) {
        return false;
    }

    public static boolean r(l lVar) {
        return false;
    }

    public static boolean s(l lVar) {
        return false;
    }

    public static void t(l lVar, SaasVideoData saasVideoData, int i, String str, Map extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
    }

    public static void u(l lVar) {
    }

    public static void v(l lVar, String tag, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public static void w(l lVar, String type, Bundle bundle) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public static void x(l lVar, int i) {
    }

    public static void y(l lVar, ts3.a aVar) {
    }

    public static void z(l lVar, boolean z) {
    }

    public static Args h(l lVar) {
        return new Args();
    }

    public static List l(l lVar) {
        return new ArrayList();
    }

    public static /* synthetic */ void K(l lVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            lVar.y6(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: interceptPauseWhenInvisible");
    }

    public static /* synthetic */ void L(l lVar, String str, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            lVar.C5(str, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFragmentEvent");
    }

    public static /* synthetic */ void M(l lVar, boolean z, String str, Float f, Typeface typeface, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                f = null;
            }
            if ((i & 8) != 0) {
                typeface = null;
            }
            lVar.J4(z, str, f, typeface);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitleIndex");
    }
}
