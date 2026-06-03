package pk6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    public AbsPlayList a;
    public String b;
    public int c;
    public int e;
    public int d = 100;
    public long f = 0;
    public long g = 0;
    public boolean h = true;
    public boolean i = false;
    public boolean j = true;
    public String k = "unKnow";
    public HashMap<String, Object> l = new HashMap<>();

    static {
        Covode.recordClassIndex(655822);
    }

    public String toString() {
        return "PlayParam{playList=" + this.a + ", playItem='" + this.b + "', playTone=" + this.c + ", playSpeed=" + this.d + ", playPosition=" + this.f + ", playDuration=" + this.g + ", needStartPlay=" + this.h + ", invalidatePreviewInterceptor=" + this.i + ", extras=" + this.l + '}';
    }

    public boolean a(c cVar) {
        AbsPlayList absPlayList;
        if (cVar != null && (absPlayList = this.a) != null && cVar.a != null && absPlayList.getListId().equals(cVar.a.getListId()) && this.a.getGenreType() == cVar.a.getGenreType() && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && this.h == cVar.h && this.i == cVar.i && this.k.equals(cVar.k)) {
            return true;
        }
        return false;
    }
}
