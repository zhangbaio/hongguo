package bl6;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import lk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private String a;
    public int b;

    static {
        Covode.recordClassIndex(655899);
    }

    public a(String str) {
        this.b = 3;
        this.a = "FMLogger-New-" + (TextUtils.isEmpty(str) ? "Default-New" : str);
        this.b = 3;
    }

    public void a(String str, Object... objArr) {
        e(3, str, objArr);
    }

    public void b(String str, Object... objArr) {
        e(6, str, objArr);
    }

    public void d(String str, Object... objArr) {
        e(4, str, objArr);
    }

    public void f(String str, Object... objArr) {
        e(2, str, objArr);
    }

    public void g(String str, Object... objArr) {
        e(5, str, objArr);
    }

    public static String c(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return Arrays.toString(objArr);
        }
        if (objArr != null && objArr.length != 0) {
            try {
                return String.format(str, objArr);
            } catch (Exception unused) {
                return str;
            }
        }
        return str;
    }

    private void e(int i, String str, Object... objArr) {
        if (i >= this.b && c.a != null) {
            String c = c(str, objArr);
            lk6.b bVar = c.a;
            if (bVar.c) {
                Log.println(i, this.a, c);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            bVar.e.v(this.a, c);
                            return;
                        } else {
                            bVar.e.e(this.a, c);
                            return;
                        }
                    }
                    bVar.e.w(this.a, c);
                    return;
                }
                bVar.e.i(this.a, c);
                return;
            }
            bVar.e.d(this.a, c);
        }
    }
}
