package ir4;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b {
    public String a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public List<Object> g;
    public long h;
    public String i;
    public String j;
    public String k;

    static {
        Covode.recordClassIndex(611504);
    }

    public String toString() {
        return "ChapterStrategyInfoEntity{chapterId='" + this.a + "', chapterIndex=" + this.b + ", strategyChapterIndex=" + this.c + ", strategyIndex=" + this.d + ", expiredTime=" + this.h + ", 剩余过期秒数=" + ((this.h - SystemClock.elapsedRealtime()) / 1000) + ", showAd=" + this.e + ", hasAtAdReturn=" + this.f + ", tip=" + this.i + ", tipOptimizeFirst=" + this.j + ", tipOptimizeSecond=" + this.k + ", rangeInfoList=" + this.g + '}';
    }

    public b(String str, int i, int i2, int i3, boolean z, boolean z2, List<Object> list, long j, String str2, String str3, String str4) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = z2;
        this.g = list;
        this.h = j;
        this.i = str2;
        this.j = str3;
        this.k = str4;
    }
}
