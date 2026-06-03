package pk6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public AbsPlayList a;
    public String b = "unKnow";
    public HashMap<String, Object> c = new HashMap<>();

    static {
        Covode.recordClassIndex(655820);
    }

    public String toString() {
        return "PlayParam{playList=" + this.a + ", playFrom='" + this.b + "', playExtraInfo=" + this.c + '}';
    }
}
