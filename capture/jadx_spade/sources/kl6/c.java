package kl6;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c extends a {
    static {
        Covode.recordClassIndex(655932);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "DefaultPlayEntrance{playEntrance=" + this.a + ", extras=" + this.b + '}';
    }

    public c(String str, HashMap<String, Object> hashMap) {
        super(str, hashMap);
    }

    public /* synthetic */ c(String str, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_play_entrance" : str, (i & 2) != 0 ? null : hashMap);
    }
}
