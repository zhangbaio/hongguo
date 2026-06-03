package com.dragon.read.kmp.mine.profile;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileItemType[] $VALUES;
    public static final ProfileItemType ACCOUNTID;
    public static final ProfileItemType AVATAR;
    public static final ProfileItemType BACKGROUND;
    public static final a Companion;
    public static final ProfileItemType GENDER;
    public static final ProfileItemType NICKNAME;
    public static final ProfileItemType NOTHING;
    public static final ProfileItemType SIGNATURE;
    private final int value;

    private static final /* synthetic */ ProfileItemType[] $values() {
        return new ProfileItemType[]{NOTHING, NICKNAME, SIGNATURE, ACCOUNTID, GENDER, AVATAR, BACKGROUND};
    }

    public static EnumEntries<ProfileItemType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static ProfileItemType[] values() {
        return (ProfileItemType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607738);
        NOTHING = new ProfileItemType("NOTHING", 0, -1);
        NICKNAME = new ProfileItemType("NICKNAME", 1, 0);
        SIGNATURE = new ProfileItemType("SIGNATURE", 2, 1);
        ACCOUNTID = new ProfileItemType("ACCOUNTID", 3, 2);
        GENDER = new ProfileItemType("GENDER", 4, 3);
        AVATAR = new ProfileItemType("AVATAR", 5, 4);
        BACKGROUND = new ProfileItemType("BACKGROUND", 6, 5);
        ProfileItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static ProfileItemType valueOf(String str) {
        return (ProfileItemType) Enum.valueOf(ProfileItemType.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(607739);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileItemType a(int i) {
            boolean z;
            for (ProfileItemType profileItemType : ProfileItemType.values()) {
                if (profileItemType.getValue() == i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return profileItemType;
                }
            }
            return null;
        }
    }

    private ProfileItemType(String str, int i, int i2) {
        this.value = i2;
    }
}
