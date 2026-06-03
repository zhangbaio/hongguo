package zj6;

import com.bytedance.covode.number.Covode;
import java.net.URL;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    public String b;
    public String e;
    private int a = 1;
    public HashMap c = null;
    private byte[] d = null;

    static {
        Covode.recordClassIndex(654850);
    }

    public d(String str, byte b) {
        this.b = str;
    }

    public final URL a() {
        try {
            return new URL(this.b);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b(String str) {
        if (str != null) {
            this.d = str.getBytes();
            this.e = str;
        }
    }

    public final String c() {
        return this.a == 1 ? "POST" : "GET";
    }
}
