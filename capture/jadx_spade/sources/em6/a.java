package em6;

import android.media.ExifInterface;
import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a {
    private static final String a;

    private a() {
    }

    static {
        Covode.recordClassIndex(656159);
        a = a.class.getSimpleName();
    }

    public static ExifInterface a(String str) throws IOException {
        if (str != null) {
            return new ExifInterface(str);
        }
        throw new NullPointerException("filename should not be null");
    }
}
