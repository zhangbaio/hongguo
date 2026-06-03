package com.dragon.read.component.shortvideo.data.saas.model.videotag;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasGradientOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SaasGradientOrientation[] $VALUES;
    public static final a Companion;
    public static final SaasGradientOrientation LEFT_RIGHT;
    public static final SaasGradientOrientation TL_BR;
    public static final SaasGradientOrientation TOP_BOTTOM;
    public static final SaasGradientOrientation TR_BL;
    private final int value;

    private static final /* synthetic */ SaasGradientOrientation[] $values() {
        return new SaasGradientOrientation[]{TL_BR, TR_BL, TOP_BOTTOM, LEFT_RIGHT};
    }

    public static EnumEntries<SaasGradientOrientation> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static SaasGradientOrientation[] values() {
        return (SaasGradientOrientation[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599078);
        TL_BR = new SaasGradientOrientation("TL_BR", 0, 0);
        TR_BL = new SaasGradientOrientation("TR_BL", 1, 1);
        TOP_BOTTOM = new SaasGradientOrientation("TOP_BOTTOM", 2, 2);
        LEFT_RIGHT = new SaasGradientOrientation("LEFT_RIGHT", 3, 3);
        SaasGradientOrientation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static SaasGradientOrientation valueOf(String str) {
        return (SaasGradientOrientation) Enum.valueOf(SaasGradientOrientation.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599079);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaasGradientOrientation a(Integer num) {
            if (num != null && num.intValue() == 0) {
                return SaasGradientOrientation.TL_BR;
            }
            if (num != null && num.intValue() == 1) {
                return SaasGradientOrientation.TR_BL;
            }
            if (num != null && num.intValue() == 2) {
                return SaasGradientOrientation.TOP_BOTTOM;
            }
            if (num != null && num.intValue() == 3) {
                return SaasGradientOrientation.LEFT_RIGHT;
            }
            return null;
        }
    }

    private SaasGradientOrientation(String str, int i, int i2) {
        this.value = i2;
    }
}
