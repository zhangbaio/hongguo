package kr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a {
    static {
        Covode.recordClassIndex(611538);
    }

    /* renamed from: kr4.a$a, reason: collision with other inner class name */
    class C0231a extends TypeToken<com.dragon.read.pages.bookshelf.booklist.b> {
        C0231a() {
        }
    }

    public static String b(com.dragon.read.pages.bookshelf.booklist.b bVar) {
        return JSONUtils.toJson(bVar);
    }

    public static com.dragon.read.pages.bookshelf.booklist.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (com.dragon.read.pages.bookshelf.booklist.b) JSONUtils.fromJson(str, new C0231a().getType());
    }
}
