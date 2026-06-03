package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.properties.PropertyName;
import com.dragon.read.kmp.utils.AppUtils;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends h {
    public static final m j;
    private static final gj4.a k;
    public static final int l;

    private m() {
    }

    static {
        Covode.recordClassIndex(608489);
        m mVar = new m();
        j = mVar;
        gj4.a c = com.dragon.read.kmp.local.a.a.c(AppUtils.a.a(), "reader_lib_config_cache");
        k = c;
        Map<PropertyName, com.dragon.read.kmp.b> map = mVar.a;
        map.put(PropertyName.Theme, new t(c));
        map.put(PropertyName.Background, new a(c));
        map.put(PropertyName.PageTurnMode, new n(c));
        map.put(PropertyName.LineSpacing, new l(c));
        map.put(PropertyName.Font, new b(c));
        map.put(PropertyName.Setting, new s(c));
        l = 8;
    }

    @Override // lm4.h
    public void update(pm4.h hVar) {
        pm4.n readerConfig;
        if (hVar != null && (readerConfig = hVar.getReaderConfig()) != null) {
            readerConfig.update(h());
        }
    }

    @Override // lm4.h
    public void update(cm4.i iVar) {
        pm4.j e;
        pm4.n readerConfig;
        if (iVar != null && (e = iVar.e()) != null && (readerConfig = e.getReaderConfig()) != null) {
            readerConfig.update(h());
        }
    }
}
