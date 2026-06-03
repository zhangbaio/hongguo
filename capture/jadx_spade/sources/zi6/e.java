package zi6;

import android.os.Looper;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e {

    public interface a extends b {
    }

    public interface b {
    }

    public interface c extends b {
    }

    public interface d extends b {
        JSONObject a(int i, JSONObject jSONObject);
    }

    /* renamed from: zi6.e$e, reason: collision with other inner class name */
    public interface InterfaceC0303e extends b {
    }

    static {
        Covode.recordClassIndex(652860);
    }

    public abstract long a(int i);

    public abstract long b(String str, int i);

    public abstract String c(int i);

    public abstract String d(String str, int i);

    public abstract boolean e();

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2);

    public abstract void h(String str, String str2);

    public abstract void i(String str, String str2);

    public abstract void j(int i, String str);

    public abstract void k(int i, String str, long j);

    public abstract void l(int i, int i2);

    public abstract void m(int i, b bVar);

    public abstract void n(int i, long j);

    public abstract void o(int i, String str);

    public abstract int p(Looper looper);

    public abstract void q(String str, String str2);
}
