package ps3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public boolean a;
    public boolean b;
    public int c;
    public float d;

    static {
        Covode.recordClassIndex(599024);
    }

    public b(boolean z, boolean z2, int i, float f) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = f;
    }

    public /* synthetic */ b(boolean z, boolean z2, int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 4 : i, (i2 & 8) != 0 ? 0.0f : f);
    }
}
