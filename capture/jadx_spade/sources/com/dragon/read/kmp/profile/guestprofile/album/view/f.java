package com.dragon.read.kmp.profile.guestprofile.album.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.d90;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.v40;
import com.bytedance.kmp.reading.model.w40;
import com.dragon.read.kmp.utils.g0;
import com.dragon.read.kmp.utils.h0;
import com.dragon.read.kmp.utils.i0;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(608129);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(jl4.b bVar, int i, int i2, Composer composer, int i3) {
        c(bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(float f, float f2, String str, float f3, int i, int i2, Composer composer, int i3) {
        e(f, f2, str, f3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final List<e90> g(com.dragon.read.rpc.kmp.community.model.z albumData, boolean z, boolean z2) {
        String str;
        String str2;
        String str3;
        List<l1> list;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(albumData, "albumData");
        ArrayList arrayList = new ArrayList();
        if (com.dragon.read.kmp.utils.c0.a(albumData.k) && (list = albumData.k) != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (l1 l1Var : list) {
                String str4 = l1Var.b;
                Pair[] pairArr = new Pair[2];
                String str5 = l1Var.e;
                if (str5 == null) {
                    str5 = "";
                }
                pairArr[0] = TuplesKt.to("text_color", str5);
                String str6 = l1Var.f;
                if (str6 == null) {
                    str6 = "";
                }
                pairArr[1] = TuplesKt.to("dark_text_color", str6);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                arrayList2.add(new e90(str4, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (d90) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (w40) null, (Integer) null, (v40) null, (List) null, (Integer) null, (Map) null, (Integer) null, mutableMapOf, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2145386494, (DefaultConstructorMarker) null));
            }
            arrayList.addAll(arrayList2);
        }
        Long l = null;
        if (z) {
            u0 u0Var = albumData.f;
            if (u0Var != null && (str3 = u0Var.c) != null) {
                l = Long.valueOf(h0.l(str3, 0L, 1, null));
            }
            long d = g0.d(l);
            if (d > 0) {
                arrayList.add(new e90(i0.a.a(d) + "点赞", (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (d90) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (w40) null, (Integer) null, (v40) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483646, (DefaultConstructorMarker) null));
            }
        } else if (z2) {
            u0 u0Var2 = albumData.f;
            if (u0Var2 != null && (str2 = u0Var2.b) != null) {
                l = Long.valueOf(h0.l(str2, 0L, 1, null));
            }
            long d2 = g0.d(l);
            if (d2 > 0) {
                arrayList.add(new e90(i0.a.a(d2) + "收藏", (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (d90) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (w40) null, (Integer) null, (v40) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483646, (DefaultConstructorMarker) null));
            }
        } else {
            u0 u0Var3 = albumData.f;
            if (u0Var3 != null && (str = u0Var3.a) != null) {
                l = Long.valueOf(h0.l(str, 0L, 1, null));
            }
            long d3 = g0.d(l);
            if (d3 >= 5) {
                arrayList.add(new e90(i0.a.a(d3) + "人看过", (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (d90) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (w40) null, (Integer) null, (v40) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483646, (DefaultConstructorMarker) null));
            }
        }
        arrayList.add(new e90("更新至" + albumData.g + (char) 38598, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (d90) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (w40) null, (Integer) null, (v40) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483646, (DefaultConstructorMarker) null));
        return arrayList;
    }

    public static final void c(final jl4.b profileAlbumListItemModel, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(profileAlbumListItemModel, "profileAlbumListItemModel");
        Composer startRestartGroup = composer.startRestartGroup(-908289239);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(profileAlbumListItemModel)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-908289239, i3, -1, "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumListItem (AlbumListItem.kt:29)");
            }
            if (profileAlbumListItemModel.a()) {
                startRestartGroup.startReplaceGroup(-550599743);
                AlbumMultiCardItemKt.n(profileAlbumListItemModel, i, startRestartGroup, (i3 & 14) | (i3 & 112));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-550506588);
                b0.g(profileAlbumListItemModel, i, startRestartGroup, (i3 & 14) | (i3 & 112));
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d;
                    d = f.d(jl4.b.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return d;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final float r25, final float r26, final java.lang.String r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.album.view.f.e(float, float, java.lang.String, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
