package com.dragon.read.kmp.network;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RequestMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RequestMethod[] $VALUES;
    public static final RequestMethod GET;
    public static final RequestMethod POST;

    private static final /* synthetic */ RequestMethod[] $values() {
        return new RequestMethod[]{GET, POST};
    }

    public static EnumEntries<RequestMethod> getEntries() {
        return $ENTRIES;
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607865);
        GET = new RequestMethod("GET", 0);
        POST = new RequestMethod("POST", 1);
        RequestMethod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RequestMethod valueOf(String str) {
        return (RequestMethod) Enum.valueOf(RequestMethod.class, str);
    }

    private RequestMethod(String str, int i) {
    }
}
