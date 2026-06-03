package zi6;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    private static final String a;
    private static a b;

    public interface a {
        int loadLibrary(String str) throws Exception;
    }

    static {
        Covode.recordClassIndex(652858);
        a = d.class.getSimpleName();
    }

    public static void b(a aVar) {
        b = aVar;
    }

    public static int a(String str) throws Exception {
        int i;
        a aVar = b;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (aVar != null) {
                    Log.d(a, "Loading [" + str + "] with external loader " + aVar);
                    i = aVar.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                    i = 0;
                }
                return i;
            } catch (Throwable th) {
                Log.e(a, "load lib failed = " + th.getMessage());
                return -1;
            }
        }
        throw new Exception("Invalid library name.");
    }
}
