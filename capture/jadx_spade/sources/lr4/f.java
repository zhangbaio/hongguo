package lr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f {
    public String a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    static {
        Covode.recordClassIndex(611554);
    }

    public String a() {
        String str = this.b;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int hashCode() {
        return Objects.hash(this.a, a(), Integer.valueOf(this.c), Integer.valueOf(this.d), Boolean.valueOf(this.e));
    }

    public f(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.c == fVar.c && this.d == fVar.d && this.e == fVar.e && this.a.equals(fVar.a) && Objects.equals(a(), fVar.a())) {
            return true;
        }
        return false;
    }

    public f(String str, String str2, int i, int i2, boolean z) {
        this.a = str;
        this.d = i2;
        this.e = z;
        this.c = i;
        if (!TextUtils.isEmpty(str2)) {
            this.b = str2.substring(0, Math.min(str2.length(), 100));
        }
    }
}
