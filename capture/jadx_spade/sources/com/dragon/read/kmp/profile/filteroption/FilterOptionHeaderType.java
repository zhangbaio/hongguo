package com.dragon.read.kmp.profile.filteroption;

import com.bytedance.covode.number.Covode;
import el4.b;
import java.util.NoSuchElementException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FilterOptionHeaderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FilterOptionHeaderType[] $VALUES;
    public static final a Companion;
    public static final FilterOptionHeaderType HOTTEST_TYPE;
    public static final FilterOptionHeaderType LATEST_TYPE;
    private final int value;

    private static final /* synthetic */ FilterOptionHeaderType[] $values() {
        return new FilterOptionHeaderType[]{LATEST_TYPE, HOTTEST_TYPE};
    }

    public static EnumEntries<FilterOptionHeaderType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterOptionHeaderType[] values() {
        return (FilterOptionHeaderType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608084);
        b bVar = b.a;
        LATEST_TYPE = new FilterOptionHeaderType("LATEST_TYPE", 0, bVar.b());
        HOTTEST_TYPE = new FilterOptionHeaderType("HOTTEST_TYPE", 1, bVar.a());
        FilterOptionHeaderType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static FilterOptionHeaderType valueOf(String str) {
        return (FilterOptionHeaderType) Enum.valueOf(FilterOptionHeaderType.class, str);
    }

    public static final class a {

        /* renamed from: com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0027a {
            public static final /* synthetic */ int[] a;

            static {
                Covode.recordClassIndex(608086);
                int[] iArr = new int[FilterOptionHeaderType.values().length];
                try {
                    iArr[FilterOptionHeaderType.HOTTEST_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FilterOptionHeaderType.LATEST_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        static {
            Covode.recordClassIndex(608085);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String b(FilterOptionHeaderType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = C0027a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return "new";
            }
            return "hot";
        }

        public final String c(FilterOptionHeaderType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = C0027a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return "最新";
            }
            return "最热";
        }

        public final String d(FilterOptionHeaderType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (C0027a.a[type.ordinal()] == 1) {
                return "smart_hot_desc";
            }
            return "time_desc";
        }

        public final FilterOptionHeaderType a(int i) {
            boolean z;
            for (FilterOptionHeaderType filterOptionHeaderType : FilterOptionHeaderType.getEntries()) {
                if (filterOptionHeaderType.getValue() == i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return filterOptionHeaderType;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    private FilterOptionHeaderType(String str, int i, int i2) {
        this.value = i2;
    }
}
