package ht3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.feed.staggeredfeed.model.LocalInfinitePicTextPostModel;
import com.dragon.read.rpc.model.UgcPostData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int d;
    public final LocalInfinitePicTextPostModel a;
    public final UgcPostData b;
    public final String c;

    static {
        Covode.recordClassIndex(599216);
        d = 8;
    }

    public d(LocalInfinitePicTextPostModel model, UgcPostData ugcPostData, String fromTopicId) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(ugcPostData, "ugcPostData");
        Intrinsics.checkNotNullParameter(fromTopicId, "fromTopicId");
        this.a = model;
        this.b = ugcPostData;
        this.c = fromTopicId;
    }
}
