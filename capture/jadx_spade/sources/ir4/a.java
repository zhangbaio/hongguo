package ir4;

import com.bytedance.admetaversesdk.adbase.entity.banner.AdModel;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a {
    public String a;
    public int b;
    public long c;
    public AdModel d;

    static {
        Covode.recordClassIndex(611503);
    }

    public String toString() {
        return "ChapterPageAdEntity{chapterId='" + this.a + "', chapterPageIndex=" + this.b + ", adModel=" + this.d + '}';
    }

    public a(String str, int i, long j, AdModel adModel) {
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = adModel;
    }
}
