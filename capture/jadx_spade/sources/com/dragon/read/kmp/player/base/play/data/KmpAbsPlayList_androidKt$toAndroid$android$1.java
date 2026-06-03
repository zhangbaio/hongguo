package com.dragon.read.kmp.player.base.play.data;

import com.xs.fm.player.base.play.data.AbsPlayList;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpAbsPlayList_androidKt$toAndroid$android$1 extends AbsPlayList {
    final /* synthetic */ a $this_toAndroid;

    @Override // com.xs.fm.player.base.play.data.AbsPlayList
    public int getGenreType() {
        return this.$this_toAndroid.b();
    }

    @Override // com.xs.fm.player.base.play.data.AbsPlayList
    public String getListId() {
        return this.$this_toAndroid.c();
    }

    KmpAbsPlayList_androidKt$toAndroid$android$1(a aVar) {
        this.$this_toAndroid = aVar;
        Map<String, Object> c = tk4.a.a.c(aVar.a());
        if (c != null) {
            this.extras.putAll(c);
        }
    }
}
