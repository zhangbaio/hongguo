package un4;

import androidx.compose.ui.graphics.e1;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final int c;
    public final e1 a;
    public final byte[] b;

    static {
        Covode.recordClassIndex(608938);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public h(e1 e1Var, byte[] bArr) {
        this.a = e1Var;
        this.b = bArr;
    }

    public /* synthetic */ h(e1 e1Var, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : e1Var, (i & 2) != 0 ? null : bArr);
    }
}
