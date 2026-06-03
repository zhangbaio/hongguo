package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import lr4.t1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface SeriesMallDataTransformService {
    b a(VideoTabModel.VideoData videoData, Map<String, t1> map);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class StartPositionReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StartPositionReason[] $VALUES;
        public static final StartPositionReason HISTORY_PROGRESS;
        public static final StartPositionReason NONE;
        public static final StartPositionReason SKIP_OPENING;
        public static final StartPositionReason VIDEO_HIGH_LIGHT_POINT;
        public static final StartPositionReason VIDEO_HIGH_LIGHT_SEGMENT;

        private static final /* synthetic */ StartPositionReason[] $values() {
            return new StartPositionReason[]{NONE, VIDEO_HIGH_LIGHT_SEGMENT, VIDEO_HIGH_LIGHT_POINT, HISTORY_PROGRESS, SKIP_OPENING};
        }

        public static EnumEntries<StartPositionReason> getEntries() {
            return $ENTRIES;
        }

        public static StartPositionReason[] values() {
            return (StartPositionReason[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(598177);
            NONE = new StartPositionReason("NONE", 0);
            VIDEO_HIGH_LIGHT_SEGMENT = new StartPositionReason("VIDEO_HIGH_LIGHT_SEGMENT", 1);
            VIDEO_HIGH_LIGHT_POINT = new StartPositionReason("VIDEO_HIGH_LIGHT_POINT", 2);
            HISTORY_PROGRESS = new StartPositionReason("HISTORY_PROGRESS", 3);
            SKIP_OPENING = new StartPositionReason("SKIP_OPENING", 4);
            StartPositionReason[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static StartPositionReason valueOf(String str) {
            return (StartPositionReason) Enum.valueOf(StartPositionReason.class, str);
        }

        private StartPositionReason(String str, int i) {
        }
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598176);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b a(SeriesMallDataTransformService seriesMallDataTransformService, VideoTabModel.VideoData videoData, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = null;
                }
                return seriesMallDataTransformService.a(videoData, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStartPlayPosition");
        }
    }

    public static final class b {
        public static final int f;
        public final String a;
        public final long b;
        public final pr3.q c;
        public final boolean d;
        public final StartPositionReason e;

        static {
            Covode.recordClassIndex(598178);
            f = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e;
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + j.a(this.b)) * 31;
            pr3.q qVar = this.c;
            return ((((hashCode + (qVar == null ? 0 : qVar.hashCode())) * 31) + androidx.compose.animation.m.a(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "StartPositionResult(startVid=" + this.a + ", startPosition=" + this.b + ", videoHighlightModel=" + this.c + ", isUseHighlight=" + this.d + ", startPositionReason=" + this.e + ')';
        }

        public b(String startVid, long j, pr3.q qVar, boolean z, StartPositionReason startPositionReason) {
            Intrinsics.checkNotNullParameter(startVid, "startVid");
            Intrinsics.checkNotNullParameter(startPositionReason, "startPositionReason");
            this.a = startVid;
            this.b = j;
            this.c = qVar;
            this.d = z;
            this.e = startPositionReason;
        }
    }
}
