package com.dragon.read.kmp.story.impl.feeds.enums;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PageShadeStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PageShadeStyle[] $VALUES;
    public static final a Companion;
    public static final PageShadeStyle Fold;
    public static final PageShadeStyle Load;
    public static final PageShadeStyle None;
    private final int value;

    public static final class a {
        static {
            Covode.recordClassIndex(609280);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ PageShadeStyle[] $values() {
        return new PageShadeStyle[]{None, Fold, Load};
    }

    public static EnumEntries<PageShadeStyle> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static PageShadeStyle[] values() {
        return (PageShadeStyle[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609279);
        None = new PageShadeStyle("None", 0, 0);
        Fold = new PageShadeStyle("Fold", 1, 1);
        Load = new PageShadeStyle("Load", 2, 2);
        PageShadeStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static PageShadeStyle valueOf(String str) {
        return (PageShadeStyle) Enum.valueOf(PageShadeStyle.class, str);
    }

    private PageShadeStyle(String str, int i, int i2) {
        this.value = i2;
    }
}
