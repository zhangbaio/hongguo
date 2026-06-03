package ep4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import com.dragon.read.kmp.story.impl.feeds.data.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements com.dragon.read.kmp.story.impl.album.base.a {
    public static final int d;
    public final e a;
    public String b;
    public List<us> c;

    static {
        Covode.recordClassIndex(609216);
        d = 8;
    }

    @Override // com.dragon.read.kmp.story.impl.album.base.a
    public String b() {
        return this.a.a;
    }

    @Override // com.dragon.read.kmp.story.impl.album.base.a
    public com.dragon.read.kmp.story.impl.album.base.a copy() {
        b bVar = new b(this.a);
        bVar.b = this.b;
        bVar.c = this.c;
        return bVar;
    }

    public b(e storyData) {
        Intrinsics.checkNotNullParameter(storyData, "storyData");
        this.a = storyData;
    }
}
