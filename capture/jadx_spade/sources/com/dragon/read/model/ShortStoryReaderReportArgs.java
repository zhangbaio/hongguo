package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortStoryReaderReportArgs implements Serializable {
    public static final int $stable = 0;
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final String forumPosition;
    private final String postPosition;

    public static final class a {
        static {
            Covode.recordClassIndex(612245);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612244);
        Companion = new a(null);
    }

    public final String getForumPosition() {
        return this.forumPosition;
    }

    public final String getPostPosition() {
        return this.postPosition;
    }

    public final Map<String, String> getReportMap() {
        HashMap hashMap = new HashMap();
        String str = this.forumPosition;
        if (str != null) {
            hashMap.put("forum_position", str);
        }
        hashMap.put("post_position", this.postPosition);
        return hashMap;
    }

    public ShortStoryReaderReportArgs(String str, String postPosition) {
        Intrinsics.checkNotNullParameter(postPosition, "postPosition");
        this.forumPosition = str;
        this.postPosition = postPosition;
    }
}
