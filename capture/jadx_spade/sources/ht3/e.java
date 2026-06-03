package ht3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.feed.staggeredfeed.model.LocalInfinitePicTextPostModel;
import com.dragon.read.rpc.model.UgcPostData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final int e;
    public final LocalInfinitePicTextPostModel a;
    public final UgcPostData b;
    public final String c;
    public final String d;

    static {
        Covode.recordClassIndex(599217);
        e = 8;
    }

    public e(LocalInfinitePicTextPostModel model, UgcPostData ugcPostData, String fromTopicId, String str) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(ugcPostData, "ugcPostData");
        Intrinsics.checkNotNullParameter(fromTopicId, "fromTopicId");
        this.a = model;
        this.b = ugcPostData;
        this.c = fromTopicId;
        this.d = str;
    }
}
