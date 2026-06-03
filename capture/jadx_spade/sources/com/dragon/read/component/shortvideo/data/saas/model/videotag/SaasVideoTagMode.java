package com.dragon.read.component.shortvideo.data.saas.model.videotag;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasVideoTagMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SaasVideoTagMode[] $VALUES;
    public static final a Companion;
    public static final SaasVideoTagMode ContentTagStrengthen;
    private final int value;

    private static final /* synthetic */ SaasVideoTagMode[] $values() {
        return new SaasVideoTagMode[]{ContentTagStrengthen};
    }

    public static EnumEntries<SaasVideoTagMode> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static SaasVideoTagMode[] values() {
        return (SaasVideoTagMode[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599084);
        ContentTagStrengthen = new SaasVideoTagMode("ContentTagStrengthen", 0, 1);
        SaasVideoTagMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599085);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaasVideoTagMode a(Integer num) {
            if (num != null && num.intValue() == 1) {
                return SaasVideoTagMode.ContentTagStrengthen;
            }
            return null;
        }
    }

    public static SaasVideoTagMode valueOf(String str) {
        return (SaasVideoTagMode) Enum.valueOf(SaasVideoTagMode.class, str);
    }

    private SaasVideoTagMode(String str, int i, int i2) {
        this.value = i2;
    }
}
