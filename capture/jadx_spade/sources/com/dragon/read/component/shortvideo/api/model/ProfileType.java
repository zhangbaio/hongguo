package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileType[] $VALUES;
    public static final ProfileType NONE;
    public static final ProfileType OBJECT;
    public static final ProfileType SINGLE;
    public static final ProfileType SUBJECT;
    public static final ProfileType SUBJECT_V2;

    private static final /* synthetic */ ProfileType[] $values() {
        return new ProfileType[]{NONE, OBJECT, SUBJECT, SINGLE, SUBJECT_V2};
    }

    public static EnumEntries<ProfileType> getEntries() {
        return $ENTRIES;
    }

    public static ProfileType[] values() {
        return (ProfileType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598785);
        NONE = new ProfileType("NONE", 0);
        OBJECT = new ProfileType("OBJECT", 1);
        SUBJECT = new ProfileType("SUBJECT", 2);
        SINGLE = new ProfileType("SINGLE", 3);
        SUBJECT_V2 = new ProfileType("SUBJECT_V2", 4);
        ProfileType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ProfileType valueOf(String str) {
        return (ProfileType) Enum.valueOf(ProfileType.class, str);
    }

    private ProfileType(String str, int i) {
    }
}
