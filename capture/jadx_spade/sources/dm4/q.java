package dm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q implements g {
    public static final q b;
    public static final int c;
    private final /* synthetic */ g a;

    static {
        Covode.recordClassIndex(608327);
        b = new q();
        c = 8;
    }

    @Override // dm4.g
    public boolean isBasicMode() {
        return this.a.isBasicMode();
    }

    @Override // dm4.g
    public boolean isFoldDevice() {
        return this.a.isFoldDevice();
    }

    @Override // dm4.g
    public boolean isPadDevice() {
        return this.a.isPadDevice();
    }

    @Override // dm4.g
    public boolean needFitPadScreen() {
        return this.a.needFitPadScreen();
    }

    @Override // dm4.g
    public void o(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.a.o(fileName);
    }

    @Override // dm4.g
    public boolean q(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return this.a.q(fileName);
    }

    private q() {
        g P4 = xf4.d.o3.a().P4();
        if (P4 != null) {
            this.a = P4;
            return;
        }
        throw new NullPointerException("IKmpHostDepend interface must be implement");
    }
}
