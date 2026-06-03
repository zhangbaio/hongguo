package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    static {
        Covode.recordClassIndex(609479);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(e90 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        String str = it2.a;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(e90 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        String str = it2.a;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final boolean d(om0 om0Var) {
        Intrinsics.checkNotNullParameter(om0Var, "<this>");
        Integer num = om0Var.y;
        int value = VideoContentType.UnrealShortPlay.getValue();
        if (num != null && num.intValue() == value && om0Var.X0 != null) {
            return true;
        }
        return false;
    }

    public static final String c(om0 om0Var) {
        Intrinsics.checkNotNullParameter(om0Var, "<this>");
        Integer num = om0Var.y;
        int value = VideoContentType.ShortSeriesPlay.getValue();
        if (num != null && num.intValue() == value) {
            return "series";
        }
        int value2 = VideoContentType.MotionComic.getValue();
        if (num != null && num.intValue() == value2) {
            return "motion_comic";
        }
        int value3 = VideoContentType.TelePlay.getValue();
        if (num != null && num.intValue() == value3) {
            return "teleplay";
        }
        int value4 = VideoContentType.Movie.getValue();
        if (num != null && num.intValue() == value4) {
            return "movie";
        }
        int value5 = VideoContentType.PUGC.getValue();
        if (num == null || num.intValue() != value5) {
            int value6 = VideoContentType.UnrealShortPlay.getValue();
            if (num == null || num.intValue() != value6) {
                return "";
            }
        }
        return "pugc_material";
    }

    public static final ym4.a e(om0 om0Var) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(om0Var, "<this>");
        List list = om0Var.s0;
        String str3 = null;
        if (list != null) {
            str = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.dragon.read.kmp.util.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence f;
                    f = j.f((e90) obj);
                    return f;
                }
            }, 30, null);
        } else {
            str = null;
        }
        ym4.a g = new ym4.a().g("src_material_id", om0Var.p).g("material_id", om0Var.a).g("material_type", c(om0Var)).g("side_title", str);
        List list2 = om0Var.t0;
        if (list2 != null) {
            str3 = CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, new Function1() { // from class: com.dragon.read.kmp.util.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence g2;
                    g2 = j.g((e90) obj);
                    return g2;
                }
            }, 30, null);
        }
        ym4.a g2 = g.g("recommend_reason_info", str3);
        if (Intrinsics.areEqual(om0Var.t, Boolean.TRUE)) {
            str2 = "vertical";
        } else {
            str2 = "horizontal";
        }
        return g2.g("direction", str2).g("recommend_group_id", om0Var.A).g("recommend_info", om0Var.z);
    }
}
