package com.dragon.read.kmp.network;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NetworkType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkType[] $VALUES;
    public static final NetworkType MOBILE;
    public static final NetworkType MOBILE_2G;
    public static final NetworkType MOBILE_3G;
    public static final NetworkType MOBILE_3G_H;
    public static final NetworkType MOBILE_3G_HP;
    public static final NetworkType MOBILE_4G;
    public static final NetworkType MOBILE_5G;
    public static final NetworkType NONE;
    public static final NetworkType UNKNOWN;
    public static final NetworkType WIFI;
    public static final NetworkType WIFI_24GHZ;
    public static final NetworkType WIFI_5GHZ;

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{UNKNOWN, NONE, MOBILE, MOBILE_2G, MOBILE_3G, MOBILE_3G_H, MOBILE_3G_HP, MOBILE_4G, MOBILE_5G, WIFI, WIFI_24GHZ, WIFI_5GHZ};
    }

    public static EnumEntries<NetworkType> getEntries() {
        return $ENTRIES;
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607859);
        UNKNOWN = new NetworkType("UNKNOWN", 0);
        NONE = new NetworkType("NONE", 1);
        MOBILE = new NetworkType("MOBILE", 2);
        MOBILE_2G = new NetworkType("MOBILE_2G", 3);
        MOBILE_3G = new NetworkType("MOBILE_3G", 4);
        MOBILE_3G_H = new NetworkType("MOBILE_3G_H", 5);
        MOBILE_3G_HP = new NetworkType("MOBILE_3G_HP", 6);
        MOBILE_4G = new NetworkType("MOBILE_4G", 7);
        MOBILE_5G = new NetworkType("MOBILE_5G", 8);
        WIFI = new NetworkType("WIFI", 9);
        WIFI_24GHZ = new NetworkType("WIFI_24GHZ", 10);
        WIFI_5GHZ = new NetworkType("WIFI_5GHZ", 11);
        NetworkType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    private NetworkType(String str, int i) {
    }
}
