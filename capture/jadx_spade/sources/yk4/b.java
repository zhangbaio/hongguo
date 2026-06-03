package yk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.utils.p;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static long b;
    private static long c;
    public static final int d;

    static {
        Covode.recordClassIndex(608018);
        a = new b();
        d = 8;
    }

    private b() {
    }

    public final long a() {
        return b;
    }

    public final void b() {
        c = p.a();
        b = p.a();
    }

    public final void c(boolean z) {
        String str;
        if (c <= 0) {
            return;
        }
        long a2 = p.a() - c;
        c = 0L;
        if (a2 > 3000) {
            c = 0L;
            return;
        }
        ym4.a aVar = new ym4.a();
        if (z) {
            str = "first_frame_kmp";
        } else {
            str = "first_frame";
        }
        aVar.g("type", str);
        aVar.g("duration", Long.valueOf(a2));
        o.a.d("series_guest_profile_monitor", aVar);
        j.a.d("SeriesGuestProfileTrace", "reportFirstFrameLoad duration: " + a2);
    }

    public final void g(Integer num, String str, long j) {
        int i;
        ym4.a aVar = new ym4.a();
        aVar.g("type", "get_tab_list");
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        aVar.g("code", Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        aVar.g("msg", str);
        aVar.g("duration", Long.valueOf(j));
        o.a.d("series_guest_profile_monitor", aVar);
    }

    public final void h(Integer num, String str, long j) {
        int i;
        ym4.a aVar = new ym4.a();
        aVar.g("type", "get_userinfo");
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        aVar.g("code", Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        aVar.g("msg", str);
        aVar.g("duration", Long.valueOf(j));
        o.a.d("series_guest_profile_monitor", aVar);
    }

    public static /* synthetic */ void d(b bVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        bVar.c(z);
    }

    public final void e(Integer num, String str, long j, Integer num2) {
        int i;
        if (b <= 0) {
            return;
        }
        ym4.a aVar = new ym4.a();
        aVar.g("type", "first_screen");
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        aVar.g("code", Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        aVar.g("msg", str);
        aVar.g("duration", Long.valueOf(j));
        aVar.g("sub_type", num2);
        o.a.d("series_guest_profile_monitor", aVar);
        b = 0L;
    }

    public final void f(Integer num, String str, long j, Integer num2, boolean z) {
        int i;
        ym4.a aVar = new ym4.a();
        aVar.g("type", "get_tab_content_list");
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        aVar.g("code", Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        aVar.g("msg", str);
        aVar.g("duration", Long.valueOf(j));
        aVar.g("sub_type", num2);
        aVar.g("is_load_more", Boolean.valueOf(z));
        o.a.d("series_guest_profile_monitor", aVar);
    }
}
