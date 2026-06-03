package rq3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class d {
    static {
        int i = e.a3;
    }

    public static boolean a(e eVar, View decorationView, RelativeLayout.LayoutParams decorationParams) {
        Intrinsics.checkNotNullParameter(decorationView, "decorationView");
        Intrinsics.checkNotNullParameter(decorationParams, "decorationParams");
        return false;
    }

    public static void b(e eVar) {
    }

    public static void c(e eVar) {
    }

    public static void d(e eVar) {
    }

    public static ViewGroup e(e eVar) {
        return null;
    }

    public static View f(e eVar) {
        return null;
    }

    public static int g(e eVar) {
        return -1;
    }

    public static View h(e eVar) {
        return null;
    }

    public static int i(e eVar) {
        return 0;
    }

    public static void j(e eVar, boolean z) {
    }

    public static void k(e eVar, boolean z, String forceVid, Bundle bundle, boolean z2, Integer num, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(forceVid, "forceVid");
    }

    public static void l(e eVar) {
    }

    public static void m(e eVar) {
    }

    public static void n(e eVar) {
    }

    public static void o(e eVar) {
    }

    public static void p(e eVar, boolean z) {
    }

    public static void q(e eVar, ir3.c scrollToBottomListener) {
        Intrinsics.checkNotNullParameter(scrollToBottomListener, "scrollToBottomListener");
    }

    public static void r(e eVar, boolean z) {
    }

    public static void s(e eVar) {
    }

    public static /* synthetic */ void w(e eVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eVar.X(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadVideoModelAndData");
    }

    public static /* synthetic */ boolean u(e eVar, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return eVar.O2(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: interceptPlayerResume");
    }

    public static /* synthetic */ boolean v(e eVar, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return eVar.k1(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lockScreenOrientation");
    }

    public static /* synthetic */ boolean x(e eVar, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return eVar.V2(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectPosition");
    }

    public static /* synthetic */ void y(e eVar, SaasVideoData saasVideoData, int i, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                saasVideoData = null;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                str = "sensor_horizontal";
            }
            eVar.B2(saasVideoData, i, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformToLandActivity");
    }

    public static /* synthetic */ void t(e eVar, boolean z, String str, Bundle bundle, boolean z2, Integer num, Boolean bool, Boolean bool2, int i, Object obj) {
        String str2;
        Bundle bundle2;
        boolean z3;
        Integer num2;
        Boolean bool3;
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            Boolean bool4 = null;
            if ((i & 4) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            if ((i & 8) != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            if ((i & 16) != 0) {
                num2 = null;
            } else {
                num2 = num;
            }
            if ((i & 32) != 0) {
                bool3 = null;
            } else {
                bool3 = bool;
            }
            if ((i & 64) == 0) {
                bool4 = bool2;
            }
            eVar.w3(z, str2, bundle2, z3, num2, bool3, bool4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToSingleFeed");
    }
}
