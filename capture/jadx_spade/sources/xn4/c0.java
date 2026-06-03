package xn4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.e1;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    public static final c0 a;

    static {
        Covode.recordClassIndex(608961);
        a = new c0();
    }

    private c0() {
    }

    public final e1 a(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if (decodeByteArray != null) {
            return androidx.compose.ui.graphics.j.c(decodeByteArray);
        }
        throw new IllegalStateException("decode image bytes failed".toString());
    }
}
