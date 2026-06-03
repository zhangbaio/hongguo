package oo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.a1;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final g a;

    static {
        Covode.recordClassIndex(609106);
        a = new g();
    }

    private g() {
    }

    public final void a(boolean z, String str, String str2, String str3, String str4, long j, Integer num, Throwable th, Integer num2, int i, boolean z2) {
        String str5;
        int i2;
        String str6;
        String th2;
        ym4.a aVar = new ym4.a();
        if (z) {
            str5 = "LOAD_MORE";
        } else {
            str5 = "FIRST_SCREEN";
        }
        aVar.g("scene", str5);
        aVar.g("item_id", str);
        aVar.g("sub_item_id", str2);
        aVar.g("panel_selected_item", str3);
        aVar.g("background_selected_item", str4);
        aVar.g("data_size", Integer.valueOf(i));
        int i3 = 0;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        aVar.g("view_size", Integer.valueOf(i2));
        aVar.g("duration", Long.valueOf(a1.n(a1.a, null, null, 3, null) - j));
        if (th == null || (th2 = th.toString()) == null || (str6 = StringUtilsKt.c(th2, 0, 100)) == null) {
            str6 = "";
        }
        aVar.g("error_msg", str6);
        aVar.g("network_resp_code", num2);
        aVar.g("is_kmp", Integer.valueOf(z2 ? 1 : 0));
        if (th != null) {
            i3 = 1;
        }
        aVar.g("status", Integer.valueOf(i3));
        o.a.d("short_series_rank_monitor", aVar);
    }

    public static /* synthetic */ void b(g gVar, boolean z, String str, String str2, String str3, String str4, long j, Integer num, Throwable th, Integer num2, int i, boolean z2, int i2, Object obj) {
        String str5;
        String str6;
        boolean z3;
        if ((i2 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i2 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str4;
        }
        if ((i2 & 1024) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        gVar.a(z, str, str2, str5, str6, j, num, th, num2, i, z3);
    }
}
