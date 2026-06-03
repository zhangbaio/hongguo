package com.dragon.read.component.shortvideo.depend.debug;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayCoreCapability {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayCoreCapability[] $VALUES;
    public static final a Companion;
    public static final PlayCoreCapability NONE;
    public static final PlayCoreCapability PreLoad;
    public static final PlayCoreCapability PreLoadVideoDetail;
    public static final PlayCoreCapability PreLoadVideoMdl;
    public static final PlayCoreCapability PreLoadVideoModel;
    public static final PlayCoreCapability PreRender;
    private final int value;

    public static final class a {
        static {
            Covode.recordClassIndex(599184);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ PlayCoreCapability[] $values() {
        return new PlayCoreCapability[]{NONE, PreLoad, PreRender, PreLoadVideoDetail, PreLoadVideoModel, PreLoadVideoMdl};
    }

    public static EnumEntries<PlayCoreCapability> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static PlayCoreCapability[] values() {
        return (PlayCoreCapability[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599183);
        NONE = new PlayCoreCapability("NONE", 0, 0);
        PreLoad = new PlayCoreCapability("PreLoad", 1, 100);
        PreRender = new PlayCoreCapability("PreRender", 2, 101);
        PreLoadVideoDetail = new PlayCoreCapability("PreLoadVideoDetail", 3, 102);
        PreLoadVideoModel = new PlayCoreCapability("PreLoadVideoModel", 4, 103);
        PreLoadVideoMdl = new PlayCoreCapability("PreLoadVideoMdl", 5, 104);
        PlayCoreCapability[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static PlayCoreCapability valueOf(String str) {
        return (PlayCoreCapability) Enum.valueOf(PlayCoreCapability.class, str);
    }

    private PlayCoreCapability(String str, int i, int i2) {
        this.value = i2;
    }
}
