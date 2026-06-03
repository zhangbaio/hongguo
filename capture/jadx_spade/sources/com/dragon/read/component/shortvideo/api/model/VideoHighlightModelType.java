package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoHighlightModelType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoHighlightModelType[] $VALUES;
    public static final a Companion;
    public static final VideoHighlightModelType HighLightFragment;
    public static final VideoHighlightModelType ItemHighLightPoint;
    public static final VideoHighlightModelType NO_VERIFY;
    public static final VideoHighlightModelType SkipOpening;
    private final int type;

    private static final /* synthetic */ VideoHighlightModelType[] $values() {
        return new VideoHighlightModelType[]{NO_VERIFY, HighLightFragment, SkipOpening, ItemHighLightPoint};
    }

    public static EnumEntries<VideoHighlightModelType> getEntries() {
        return $ENTRIES;
    }

    public final int getType() {
        return this.type;
    }

    public static VideoHighlightModelType[] values() {
        return (VideoHighlightModelType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598810);
        NO_VERIFY = new VideoHighlightModelType("NO_VERIFY", 0, -1);
        HighLightFragment = new VideoHighlightModelType("HighLightFragment", 1, 0);
        SkipOpening = new VideoHighlightModelType("SkipOpening", 2, 1);
        ItemHighLightPoint = new VideoHighlightModelType("ItemHighLightPoint", 3, 2);
        VideoHighlightModelType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static VideoHighlightModelType valueOf(String str) {
        return (VideoHighlightModelType) Enum.valueOf(VideoHighlightModelType.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598811);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoHighlightModelType a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return VideoHighlightModelType.NO_VERIFY;
                    }
                    return VideoHighlightModelType.ItemHighLightPoint;
                }
                return VideoHighlightModelType.SkipOpening;
            }
            return VideoHighlightModelType.HighLightFragment;
        }
    }

    private VideoHighlightModelType(String str, int i, int i2) {
        this.type = i2;
    }
}
