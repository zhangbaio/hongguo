package com.dragon.read.kmp.widget.filter;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FilterSelectionKMP {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FilterSelectionKMP[] $VALUES;
    public static final a Companion;
    public static final FilterSelectionKMP Multi;
    public static final FilterSelectionKMP MultiSwitch;
    public static final FilterSelectionKMP Single;
    public static final FilterSelectionKMP Switch;
    private final int value;

    private static final /* synthetic */ FilterSelectionKMP[] $values() {
        return new FilterSelectionKMP[]{Single, Multi, Switch, MultiSwitch};
    }

    public static EnumEntries<FilterSelectionKMP> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterSelectionKMP[] values() {
        return (FilterSelectionKMP[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609687);
        Single = new FilterSelectionKMP("Single", 0, 0);
        Multi = new FilterSelectionKMP("Multi", 1, 1);
        Switch = new FilterSelectionKMP("Switch", 2, 2);
        MultiSwitch = new FilterSelectionKMP("MultiSwitch", 3, 3);
        FilterSelectionKMP[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static FilterSelectionKMP valueOf(String str) {
        return (FilterSelectionKMP) Enum.valueOf(FilterSelectionKMP.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609688);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilterSelectionKMP a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return FilterSelectionKMP.MultiSwitch;
                    }
                    return FilterSelectionKMP.Switch;
                }
                return FilterSelectionKMP.Multi;
            }
            return FilterSelectionKMP.Single;
        }
    }

    private FilterSelectionKMP(String str, int i, int i2) {
        this.value = i2;
    }
}
