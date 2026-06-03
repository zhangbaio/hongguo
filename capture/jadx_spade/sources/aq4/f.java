package aq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.ui.GradientOrientation;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(609416);
    }

    public static final g a(e params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float f = params.a;
        float f2 = params.b;
        float f3 = params.c;
        float f4 = params.d;
        float f5 = params.e;
        float f6 = params.f;
        float f7 = params.g;
        float f8 = params.h;
        float f9 = params.i;
        float f10 = params.j;
        if (f7 > 0.0f) {
            arrayList.add(new h(0.0f, 0.0f, f7, f2));
        }
        if (f8 > 0.0f) {
            arrayList.add(new h(0.0f, 0.0f, f, f8));
        }
        if (f9 > 0.0f) {
            arrayList.add(new h(f - f9, 0.0f, f, f2));
        }
        if (f10 > 0.0f) {
            arrayList.add(new h(0.0f, f2 - f10, f, f2));
        }
        if (f3 > 0.0f) {
            arrayList2.add(new i(new h(f7, 0.0f, f3 + f7, f2), GradientOrientation.LEFT_TO_RIGHT));
        }
        if (f4 > 0.0f) {
            arrayList2.add(new i(new h(0.0f, f8, f, f4 + f8), GradientOrientation.TOP_TO_BOTTOM));
        }
        if (f5 > 0.0f) {
            arrayList2.add(new i(new h((f - f5) - f9, 0.0f, f - f9, f2), GradientOrientation.RIGHT_TO_LEFT));
        }
        if (f6 > 0.0f) {
            arrayList2.add(new i(new h(0.0f, (f2 - f6) - f10, f, f2 - f10), GradientOrientation.BOTTOM_TO_TOP));
        }
        return new g(params.a, params.b, arrayList, arrayList2);
    }
}
