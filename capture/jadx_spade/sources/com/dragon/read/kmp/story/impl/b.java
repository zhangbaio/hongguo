package com.dragon.read.kmp.story.impl;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.RecArrowType;
import com.bytedance.kmp.ugc.model.SecondaryInfoDataType;
import com.bytedance.kmp.ugc.model.TruncateFlag;
import com.bytedance.kmp.ugc.model.rp;
import com.bytedance.kmp.ugc.model.sp;
import com.bytedance.kmp.ugc.model.ts;
import com.bytedance.kmp.ugc.model.us;
import com.bytedance.kmp.ugc.model.vf;
import com.bytedance.kmp.ugc.model.wy;
import com.dragon.read.kmp.utils.h0;
import ip4.e;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609194);
    }

    public static final e b(yo4.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return new e(dVar.e, dVar.c(), dVar.d, dVar.b());
    }

    public static final TruncateFlag e(int i) {
        boolean z;
        for (TruncateFlag truncateFlag : TruncateFlag.values()) {
            if (truncateFlag.getValue() == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return truncateFlag;
            }
        }
        return null;
    }

    public static final String a(vf vfVar) {
        boolean z;
        Intrinsics.checkNotNullParameter(vfVar, "<this>");
        String str = vfVar.f;
        boolean z2 = false;
        if (str != null && !StringsKt__StringsKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            String str2 = vfVar.f;
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        String str3 = vfVar.j;
        if (str3 == null || StringsKt__StringsKt.isBlank(str3)) {
            z2 = true;
        }
        if (!z2) {
            String str4 = vfVar.j;
            if (str4 == null) {
                return "";
            }
            return str4;
        }
        String str5 = vfVar.a;
        if (str5 == null) {
            return "";
        }
        return str5;
    }

    public static final SecondaryInfoDataType d(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        for (SecondaryInfoDataType secondaryInfoDataType : SecondaryInfoDataType.values()) {
            if (secondaryInfoDataType.getValue() == h0.i(str, 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return secondaryInfoDataType;
            }
        }
        return null;
    }

    public static final us c(wy wyVar) {
        int value;
        Integer num;
        SecondaryInfoDataType d;
        Intrinsics.checkNotNullParameter(wyVar, "<this>");
        String str = wyVar.a;
        Boolean bool = wyVar.f;
        Boolean bool2 = wyVar.g;
        String str2 = wyVar.h;
        if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            value = RecArrowType.RightArrow.getValue();
        } else {
            value = RecArrowType.Default.getValue();
        }
        String str3 = wyVar.e;
        if (str3 != null && (d = d(str3)) != null) {
            num = Integer.valueOf(d.getValue());
        } else {
            num = null;
        }
        return new us(str, bool2, bool, num, (Integer) null, str2, (String) null, (String) null, (ts) null, (Integer) null, (String) null, (Integer) null, (String) null, Integer.valueOf(value), (sp) null, (Integer) null, (rp) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147475408, (DefaultConstructorMarker) null);
    }
}
