package bs3;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class c {
    static {
        int i = d.a;
    }

    public static /* synthetic */ void a(d dVar, float f, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        boolean z5;
        boolean z6;
        boolean z7;
        if (obj == null) {
            if ((i & 4) != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if ((i & 8) != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if ((i & 16) != 0) {
                z7 = true;
            } else {
                z7 = z4;
            }
            dVar.S1(f, z, z5, z6, z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSpeedEvent");
    }
}
