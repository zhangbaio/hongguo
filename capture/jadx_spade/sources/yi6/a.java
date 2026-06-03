package yi6;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    public String a;
    public String b;
    public Map<String, Object> c;
    public Map<String, Object> d;
    public float[] e;
    public byte[] f;
    public Object g;
    public int h;

    static {
        Covode.recordClassIndex(652814);
    }

    public a() {
        this(0, 1, null);
    }

    public final Map<String, Object> a() {
        Map<String, Object> map = this.c;
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap(this.h);
        this.c = hashMap;
        return hashMap;
    }

    public String toString() {
        int i;
        Integer num;
        Integer num2;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (this.a != null) {
            sb.append("runKey:" + this.a);
        }
        if (this.b != null) {
            sb.append(", enterType:" + this.b + '}');
        }
        String str = null;
        if (this.e != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", inputFloatArray.size:");
            float[] fArr = this.e;
            if (fArr != null) {
                num2 = Integer.valueOf(fArr.length);
            } else {
                num2 = null;
            }
            sb2.append(num2);
            sb.append(sb2.toString());
        }
        if (this.f != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", inputByteArray.size:");
            byte[] bArr = this.f;
            if (bArr != null) {
                num = Integer.valueOf(bArr.length);
            } else {
                num = null;
            }
            sb3.append(num);
            sb.append(sb3.toString());
        }
        if (this.g != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", inputExtObj:");
            Object obj = this.g;
            if (obj != null) {
                str = obj.getClass().getSimpleName();
            }
            sb4.append(str);
            sb.append(sb4.toString());
        }
        int i2 = 0;
        if (this.d != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(", importantExtFeaturesMap:");
            Map<String, Object> map = this.d;
            if (map != null) {
                i = map.size();
            } else {
                i = 0;
            }
            sb5.append(i);
            sb5.append('-');
            sb5.append(this.d);
            sb.append(sb5.toString());
        }
        if (this.c != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(", inputFeaturesMap:");
            Map<String, Object> map2 = this.c;
            if (map2 != null) {
                i2 = map2.size();
            }
            sb6.append(i2);
            sb6.append('-');
            sb6.append(this.c);
            sb.append(sb6.toString());
        }
        sb.append("}");
        String sb7 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    public a(int i) {
        this.h = i;
    }

    public /* synthetic */ a(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 128 : i);
    }
}
