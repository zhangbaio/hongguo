package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    static {
        Covode.recordClassIndex(608635);
    }

    public static final void a(v vVar, cm4.i reader) {
        cm4.l lVar;
        cm4.h hVar;
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        List<sm4.h> list = vVar.g;
        list.add(new BottomInfoItem(reader));
        list.add(new r(reader));
        list.add(new PhoneStatusItem(reader));
        list.add(new h(reader));
        list.add(new m(reader));
        list.add(new d0(reader));
        list.add(new z(reader));
        list.add(new LockTimeItem(reader));
        if (reader instanceof cm4.l) {
            lVar = (cm4.l) reader;
        } else {
            lVar = null;
        }
        if (lVar != null && (hVar = lVar.g) != null) {
            sm4.k a = hVar.a.a(reader);
            if (a != null) {
                list.add(a);
            }
            sm4.k b = hVar.b.b(reader);
            if (b != null) {
                list.add(b);
            }
            sm4.k a2 = hVar.b.a(reader);
            if (a2 != null) {
                list.add(a2);
            }
            sm4.h a3 = hVar.c.a(reader);
            if (a3 != null) {
                list.add(a3);
            }
            sm4.k a4 = hVar.d.a(reader);
            if (a4 != null) {
                list.add(a4);
            }
        }
    }
}
