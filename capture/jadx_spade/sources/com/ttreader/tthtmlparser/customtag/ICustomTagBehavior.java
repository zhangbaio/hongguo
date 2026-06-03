package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ICustomTagBehavior {
    CustomTagResult callback(ElementNode elementNode);

    MatchType getMatchType();

    String getTag();

    int priority();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MatchType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MatchType[] $VALUES;
        public static final MatchType Equal;
        public static final MatchType Prefix;

        private static final /* synthetic */ MatchType[] $values() {
            return new MatchType[]{Equal, Prefix};
        }

        public static EnumEntries<MatchType> getEntries() {
            return $ENTRIES;
        }

        public static MatchType[] values() {
            return (MatchType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(654764);
            Equal = new MatchType("Equal", 0);
            Prefix = new MatchType("Prefix", 1);
            MatchType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static MatchType valueOf(String str) {
            return (MatchType) Enum.valueOf(MatchType.class, str);
        }

        private MatchType(String str, int i) {
        }
    }

    public static final class DefaultImpls {
        static {
            Covode.recordClassIndex(654763);
        }

        public static int priority(ICustomTagBehavior iCustomTagBehavior) {
            return 1;
        }

        public static MatchType getMatchType(ICustomTagBehavior iCustomTagBehavior) {
            return MatchType.Equal;
        }
    }
}
