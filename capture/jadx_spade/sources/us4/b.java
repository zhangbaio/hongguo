package us4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.video.VisibleType;
import com.dragon.read.video.t;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b implements ct5.b {
    private static volatile b d;
    private final SharedPreferences a = KvCacheMgr.getPublic(App.context(), "video_chapter");
    private final SharedPreferences b = KvCacheMgr.getPublic(App.context(), "series_toast_time");
    private SharedPreferences c = null;

    static {
        Covode.recordClassIndex(612508);
    }

    public boolean h() {
        if (this.c != null) {
            return true;
        }
        return false;
    }

    public static b e() {
        if (d == null) {
            synchronized (b.class) {
                d = new b();
            }
        }
        return d;
    }

    public void j() {
        if (this.c == null) {
            this.c = KvCacheMgr.getPublic(App.context(), "series_consumed_rate");
        }
    }

    public String d(String str) {
        return this.a.getString(str, "");
    }

    public float f(String str) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            return 0.0f;
        }
        return sharedPreferences.getFloat(str, 0.0f);
    }

    public long g(String str) {
        return this.b.getLong(str, -1L);
    }

    public boolean a(SimpleMediaView simpleMediaView) {
        if ("position_book_mall_stagger".equals(i.d(simpleMediaView, ""))) {
            return false;
        }
        return true;
    }

    public void l(String str) {
        this.b.edit().putLong(str, System.currentTimeMillis()).apply();
    }

    public boolean b(SimpleMediaView simpleMediaView) {
        if (simpleMediaView != null && !NetworkUtils.isNetworkAvailable(simpleMediaView.getContext())) {
            return false;
        }
        String d2 = i.d(simpleMediaView, "");
        if ("position_book_detail".equals(d2)) {
            return true;
        }
        if ("position_short_series".equals(d2)) {
            return false;
        }
        if (!"position_book_mall".equals(d2)) {
            return true;
        }
        return !com.dragon.read.video.d.b().j(t.j(simpleMediaView));
    }

    public void c(SimpleMediaView simpleMediaView) {
        if (e.e(simpleMediaView)) {
            com.dragon.read.video.d b = com.dragon.read.video.d.b();
            String j = t.j(simpleMediaView);
            if ((b.i(j) || b.j(j)) && t.b(simpleMediaView).getValue() <= VisibleType.ALMOST_INVISIBLE.getValue()) {
                b.k(j);
                simpleMediaView.release();
            }
        }
    }

    public void i(String str, String str2) {
        this.a.edit().putString(str, str2).apply();
    }

    public void k(String str, float f) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(str, f).apply();
        }
    }
}
