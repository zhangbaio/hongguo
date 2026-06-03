package lm4;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import dm4.u;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class c implements com.dragon.read.kmp.b {
    public static final int g;
    public final com.dragon.read.kmp.i a = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("Background"));
    private int b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;

    static {
        Covode.recordClassIndex(608478);
        g = 8;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public String c(int i) {
        switch (i) {
            case -1:
                return "customized";
            case 0:
            default:
                return "主题1";
            case 1:
                return "主题2";
            case 2:
                return "主题3";
            case 3:
                return "主题4";
            case 4:
                return "主题5";
            case 5:
                return "主题6";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "主题7";
            case 7:
                return "主题8";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "主题9";
            case 9:
                return "主题10";
            case 10:
                return "主题11";
            case 11:
                return "主题12";
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return "主题13";
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return "主题14";
        }
    }

    public void d(j themeProperty) {
        Intrinsics.checkNotNullParameter(themeProperty, "themeProperty");
    }

    public int h() {
        return 0;
    }

    public boolean l() {
        return false;
    }

    public void t() {
    }

    public int e() {
        return this.b;
    }

    public boolean k() {
        return this.e;
    }

    public boolean m() {
        return this.f;
    }

    public String f() {
        return c(e());
    }

    public boolean j() {
        if (e() == -1) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        if (j()) {
            o(h());
            return true;
        }
        return false;
    }

    public void o(int i) {
        this.b = i;
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(boolean z) {
        this.d = z;
    }

    public void r(long j) {
        this.c = j;
    }

    public void s(boolean z) {
        this.f = z;
    }

    protected final String g(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key + "_0";
    }

    protected final String i(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key + '_' + u.b.b();
    }
}
