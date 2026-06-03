package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u {
    public static final u a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(611269);
            int[] iArr = new int[ReportType.values().length];
            try {
                iArr[ReportType.Subscribe.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReportType.Follow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[FunctionItemType.values().length];
            try {
                iArr2[FunctionItemType.RESERVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FunctionItemType.FOLLOW_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FunctionItemType.OFFLINE_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(611268);
        a = new u();
    }

    private u() {
    }

    public final Map<String, Object> b() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("tab_name", "sidebar"), TuplesKt.to("module_name", "profile_bar"), TuplesKt.to("_loginFrom", "feed_sidebar"));
        return mapOf;
    }

    public final Map<String, Object> d() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("tab_name", "sidebar"), TuplesKt.to("module_name", "message_bar"), TuplesKt.to("_recorderPage", "sidebar"), TuplesKt.to("_recorderModule", "message"), TuplesKt.to("_recorderAction", "enter"));
        return mapOf;
    }

    public final Map<String, Object> c() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("slide_bar_tab_name", "feed"), TuplesKt.to("enter_from", "feed"), TuplesKt.to("launch_from", "homepage"), TuplesKt.to("location", "game_center"), TuplesKt.to("scene", "261036"), TuplesKt.to("_parentPageScope", "current"));
        return mapOf;
    }

    public final Map<String, Object> a(p itemData) {
        Map<String, Object> mapOf;
        Map<String, Object> mapOf2;
        Map<String, Object> mapOf3;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        int i = a.b[itemData.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("enter_from", "sidebar"), TuplesKt.to("tab_name", "feed"));
                    return mapOf3;
                }
                throw new NoWhenBranchMatchedException();
            }
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("enter_from", "feed_sidebar"), TuplesKt.to("module_name", itemData.b), TuplesKt.to("tab_name", "feed"));
            return mapOf2;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("enter_from", "sidebar"), TuplesKt.to("module_name", itemData.b), TuplesKt.to("tab_name", "feed"));
        return mapOf;
    }

    public final Map<String, Object> g(ReportType reportType, String str) {
        Map<String, Object> mapOf;
        Map<String, Object> mapOf2;
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        int i = a.a[reportType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                return emptyMap;
            }
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("enter_from", "feed_sidebar");
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.to("module_name", str);
            pairArr[2] = TuplesKt.to("tab_name", "feed");
            mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf2;
        }
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = TuplesKt.to("enter_from", "sidebar");
        if (str == null) {
            str = "";
        }
        pairArr2[1] = TuplesKt.to("module_name", str);
        pairArr2[2] = TuplesKt.to("tab_name", "feed");
        mapOf = MapsKt__MapsKt.mapOf(pairArr2);
        return mapOf;
    }

    public final Map<String, Object> f(k item, String str, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (str == null) {
            str = "";
        }
        return e(item, str, i);
    }

    public final Map<String, Object> e(k item, String areaTitle, int i) {
        Map<String, Object> mapOf;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("tab_name", "feed"), TuplesKt.to("module_name", areaTitle), TuplesKt.to("position", "sidebar"), TuplesKt.to("rank", Integer.valueOf(i)), TuplesKt.to("recommend_info", item.e), TuplesKt.to("recommend_group_id", item.f));
        return mapOf;
    }
}
