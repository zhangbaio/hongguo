package com.dragon.read.kmp.player.base.play.data;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(607945);
    }

    public static final class a extends com.dragon.read.kmp.player.base.play.data.a {
        final /* synthetic */ AbsPlayList c;

        @Override // com.dragon.read.kmp.player.base.play.data.a
        public int b() {
            return this.c.getGenreType();
        }

        @Override // com.dragon.read.kmp.player.base.play.data.a
        public String c() {
            String listId = this.c.getListId();
            Intrinsics.checkNotNullExpressionValue(listId, "getListId(...)");
            return listId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbsPlayList absPlayList) {
            super(absPlayList);
            this.c = absPlayList;
        }
    }

    public static final d a(pk6.b bVar) {
        int mapCapacity;
        a aVar = null;
        if (bVar == null) {
            return null;
        }
        d dVar = new d();
        String playFrom = bVar.b;
        Intrinsics.checkNotNullExpressionValue(playFrom, "playFrom");
        dVar.b(playFrom);
        HashMap<String, Object> playExtraInfo = bVar.c;
        Intrinsics.checkNotNullExpressionValue(playExtraInfo, "playExtraInfo");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(playExtraInfo.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it2 = playExtraInfo.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        dVar.a(linkedHashMap);
        AbsPlayList absPlayList = bVar.a;
        if (absPlayList != null) {
            aVar = new a(absPlayList);
        }
        dVar.a = aVar;
        return dVar;
    }
}
