package vq4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k92.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    ConcurrentHashMap<String, yy1.d> a();

    ArrayList<yy1.d> b();

    ArrayList<yy1.d> c();

    boolean d(String str);

    Drawable e(String str, int i, float f);

    boolean f();

    ConcurrentHashMap<String, String> g();

    void h(EditText editText, String str);

    void i(EditText editText, CharSequence charSequence, int i);

    String j(String str);

    List<yy1.d> k(int i);

    SpannableStringBuilder l(Context context, SpannableStringBuilder spannableStringBuilder, float f, float f2, HashSet<String> hashSet);

    public static final class a {
        static {
            Covode.recordClassIndex(611332);
        }

        public static /* synthetic */ Drawable a(b bVar, String str, int i, float f, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    f = 1.0f;
                }
                return bVar.e(str, i, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmojiDrawable");
        }

        public static /* synthetic */ void c(b bVar, EditText editText, CharSequence charSequence, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = -1;
                }
                bVar.i(editText, charSequence, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: strToEmoji");
        }

        public static /* synthetic */ SpannableStringBuilder b(b bVar, Context context, SpannableStringBuilder spannableStringBuilder, float f, float f2, HashSet hashSet, int i, Object obj) {
            float f3;
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = o.z(16);
                }
                float f4 = f;
                if ((i & 8) != 0) {
                    f3 = 1.0f;
                } else {
                    f3 = f2;
                }
                if ((i & 16) != 0) {
                    hashSet = null;
                }
                return bVar.l(context, spannableStringBuilder, f4, f3, hashSet);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEmoSpan");
        }
    }
}
