package er4;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.depend.NsBaseDatabaseDependImpl;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class i0 {
    private static i0 a;

    static {
        Covode.recordClassIndex(611485);
    }

    private i0() {
    }

    public static synchronized i0 b() {
        i0 i0Var;
        synchronized (i0.class) {
            if (a == null) {
                a = new i0();
            }
            i0Var = a;
        }
        return i0Var;
    }

    public File a(String str, String str2) {
        return new PolarisFileWrapper(NsBaseDatabaseDependImpl.INSTANCE.getUserCacheDir(str), str2);
    }
}
