package com.dragon.read.component.shortvideo.album;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.AbsFragment;
import io.reactivex.Observable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsMineAlbumListFragment extends AbsFragment {
    public static final int a;

    static {
        Covode.recordClassIndex(598103);
        a = 8;
    }

    public abstract Observable<Integer> Bf();

    public abstract void Cf();
}
