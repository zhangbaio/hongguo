package zj6;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private SSLContext a = null;
    private String b;

    static {
        Covode.recordClassIndex(654847);
    }

    public a(String str) {
        this.b = str;
    }

    private static SSLContext b(String str) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new b(str)}, null);
            return sSLContext;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public final SSLContext a() {
        if (this.a == null) {
            this.a = b(this.b);
        }
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(a.class);
    }

    public int hashCode() {
        return a.class.hashCode();
    }
}
