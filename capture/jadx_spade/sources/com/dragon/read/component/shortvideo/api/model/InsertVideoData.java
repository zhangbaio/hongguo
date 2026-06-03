package com.dragon.read.component.shortvideo.api.model;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class InsertVideoData implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final VideoInsertPosition insertPosition;
    private final boolean isPlayNextVideo;
    private final d videoData;

    public static final class a {
        static {
            Covode.recordClassIndex(598772);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598771);
        Companion = new a(null);
    }

    public static /* synthetic */ InsertVideoData copy$default(InsertVideoData insertVideoData, d dVar, VideoInsertPosition videoInsertPosition, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = insertVideoData.videoData;
        }
        if ((i & 2) != 0) {
            videoInsertPosition = insertVideoData.insertPosition;
        }
        if ((i & 4) != 0) {
            z = insertVideoData.isPlayNextVideo;
        }
        return insertVideoData.copy(dVar, videoInsertPosition, z);
    }

    public final d component1() {
        return this.videoData;
    }

    public final VideoInsertPosition component2() {
        return this.insertPosition;
    }

    public final boolean component3() {
        return this.isPlayNextVideo;
    }

    public final InsertVideoData copy(d videoData, VideoInsertPosition insertPosition, boolean z) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(insertPosition, "insertPosition");
        return new InsertVideoData(videoData, insertPosition, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertVideoData)) {
            return false;
        }
        InsertVideoData insertVideoData = (InsertVideoData) obj;
        return Intrinsics.areEqual(this.videoData, insertVideoData.videoData) && this.insertPosition == insertVideoData.insertPosition && this.isPlayNextVideo == insertVideoData.isPlayNextVideo;
    }

    public int hashCode() {
        return (((this.videoData.hashCode() * 31) + this.insertPosition.hashCode()) * 31) + m.a(this.isPlayNextVideo);
    }

    public String toString() {
        return "InsertVideoData(videoData=" + this.videoData + ", insertPosition=" + this.insertPosition + ", isPlayNextVideo=" + this.isPlayNextVideo + ')';
    }

    public final VideoInsertPosition getInsertPosition() {
        return this.insertPosition;
    }

    public final d getVideoData() {
        return this.videoData;
    }

    public final boolean isPlayNextVideo() {
        return this.isPlayNextVideo;
    }

    public InsertVideoData(d videoData, VideoInsertPosition insertPosition, boolean z) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(insertPosition, "insertPosition");
        this.videoData = videoData;
        this.insertPosition = insertPosition;
        this.isPlayNextVideo = z;
    }
}
