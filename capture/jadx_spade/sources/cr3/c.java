package cr3;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class c {
    static {
        int i = d.X0;
    }

    public static void a(d dVar, boolean z) {
    }

    public static void b(d dVar, boolean z) {
    }

    public static /* synthetic */ void c(d dVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            dVar.hide(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
    }

    public static /* synthetic */ void d(d dVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            dVar.d(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }
}
