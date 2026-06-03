package lr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.ListUtils;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class m1 {
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public boolean l;
    public int m;
    public com.dragon.read.pages.bookshelf.booklist.b n;
    public String o;
    public boolean p;
    public long q;
    public String r;
    public String s;
    public String t;
    public long u;
    public String v;
    public boolean w;

    static {
        Covode.recordClassIndex(611622);
    }

    public List<String> a() {
        if (TextUtils.isEmpty(this.v)) {
            return new ArrayList();
        }
        return (List) JSONUtils.fromJson(this.v, new a().getType());
    }

    public String toString() {
        return "UgcBookList{bookListId='" + this.a + "', topicId='" + this.b + "', topicTitle='" + this.c + "', topicStatus=" + this.d + ", topicSchemes='" + this.e + "', bookCount=" + this.f + ", subscribeTime=" + this.g + ", clickTime=" + this.h + ", operateTime=" + this.i + ", deleteTime=" + this.j + ", isSync=" + this.k + ", isDelete=" + this.l + ", authorName=" + this.r + ", authorAbstract=" + this.s + ", authorAvatar=" + this.t + ", authorId=" + this.u + '}';
    }

    class a extends TypeToken<List<String>> {
        a() {
        }
    }

    public m1(String str) {
        this.a = str;
    }

    public void b(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            this.v = JSONUtils.toJson(list);
        } else {
            this.v = "";
        }
    }
}
