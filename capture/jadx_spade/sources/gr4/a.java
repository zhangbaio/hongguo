package gr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static transient String J;
    public static transient String K;
    public boolean B;
    public String C;
    public String D;
    public String E;
    public final String a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public List<String> m;
    public JSONObject n;
    public List<String> o;
    public String p;
    public String q;
    public Map<String, String> r;
    public JSONObject s;
    public int t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public String z;
    public transient boolean F = false;
    public transient boolean G = false;
    public transient boolean H = false;
    public transient long I = 0;
    public long y = System.currentTimeMillis();
    public long A = -1;

    static {
        Covode.recordClassIndex(611492);
        J = "default";
        K = "gamecp";
    }

    public boolean a() {
        if (K.equals(this.C) && !TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(this.E)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AdDownloadEntity{downloadUrl='" + this.a + "', adId=" + this.b + ", isAd=" + this.d + ", appName='" + this.p + "', appIconUrl='" + this.h + "', successInstallTimeMillis=" + this.A + "', shownAfterDownloadFinished=" + this.B + ", source=" + this.C + '}';
    }

    public a(String str) {
        this.a = str;
    }
}
