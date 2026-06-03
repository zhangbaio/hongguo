package jm4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.ReaderLightTipConfig;
import com.dragon.read.kmp.reader.ui.menu.moresettings.model.j;
import kotlin.jvm.internal.Intrinsics;
import sm4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608471);
    }

    public final k a(i reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReaderLightTipConfig.a aVar = ReaderLightTipConfig.a;
        if (!aVar.b().enableDay && !aVar.b().enableNight) {
            return null;
        }
        return new j(reader);
    }
}
