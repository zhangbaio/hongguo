package com.dragon.read.component.shortvideo.data.saas.model.videotag;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasVideoTagInfoType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SaasVideoTagInfoType[] $VALUES;
    public static final a Companion;

    @SerializedName("0")
    public static final SaasVideoTagInfoType Default;

    @SerializedName("1")
    public static final SaasVideoTagInfoType Update;
    private final int value;

    private static final /* synthetic */ SaasVideoTagInfoType[] $values() {
        return new SaasVideoTagInfoType[]{Default, Update};
    }

    public static EnumEntries<SaasVideoTagInfoType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static SaasVideoTagInfoType[] values() {
        return (SaasVideoTagInfoType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599082);
        Default = new SaasVideoTagInfoType("Default", 0, 0);
        Update = new SaasVideoTagInfoType("Update", 1, 1);
        SaasVideoTagInfoType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599083);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaasVideoTagInfoType a(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return SaasVideoTagInfoType.Update;
            }
            return SaasVideoTagInfoType.Default;
        }
    }

    public static SaasVideoTagInfoType valueOf(String str) {
        return (SaasVideoTagInfoType) Enum.valueOf(SaasVideoTagInfoType.class, str);
    }

    private SaasVideoTagInfoType(String str, int i, int i2) {
        this.value = i2;
    }
}
