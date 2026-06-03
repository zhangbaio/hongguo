package ar3;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.dragon.read.component.shortvideo.data.consts.HolderType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class k {
    static {
        int i = l.u0;
    }

    public static void a(l lVar, p videoPlayerViewAnimListener) {
        Intrinsics.checkNotNullParameter(videoPlayerViewAnimListener, "videoPlayerViewAnimListener");
    }

    public static Rect b(l lVar) {
        return null;
    }

    public static a c(l lVar) {
        return null;
    }

    public static d d(l lVar) {
        return null;
    }

    public static List f(l lVar) {
        return null;
    }

    public static String g(l lVar) {
        return "";
    }

    public static View h(l lVar) {
        return null;
    }

    public static n i(l lVar) {
        return null;
    }

    public static o j(l lVar) {
        return null;
    }

    public static int k(l lVar) {
        return -1;
    }

    public static View l(l lVar) {
        return null;
    }

    public static boolean m(l lVar) {
        return false;
    }

    public static void n(l lVar) {
    }

    public static void o(l lVar) {
    }

    public static void p(l lVar, String type, Bundle bundle) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public static HolderType e(l lVar) {
        return HolderType.COMMON_VIDEO;
    }

    public static /* synthetic */ void q(l lVar, String str, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            lVar.T0(str, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendHolderEvent");
    }
}
