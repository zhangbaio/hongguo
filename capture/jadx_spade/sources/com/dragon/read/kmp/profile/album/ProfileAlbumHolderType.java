package com.dragon.read.kmp.profile.album;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileAlbumHolderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileAlbumHolderType[] $VALUES;
    public static final ProfileAlbumHolderType CreateAlbum;
    public static final ProfileAlbumHolderType MoreAlbum;
    public static final ProfileAlbumHolderType NormalAlbum;

    private static final /* synthetic */ ProfileAlbumHolderType[] $values() {
        return new ProfileAlbumHolderType[]{NormalAlbum, CreateAlbum, MoreAlbum};
    }

    public static EnumEntries<ProfileAlbumHolderType> getEntries() {
        return $ENTRIES;
    }

    public static ProfileAlbumHolderType[] values() {
        return (ProfileAlbumHolderType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608028);
        NormalAlbum = new ProfileAlbumHolderType("NormalAlbum", 0);
        CreateAlbum = new ProfileAlbumHolderType("CreateAlbum", 1);
        MoreAlbum = new ProfileAlbumHolderType("MoreAlbum", 2);
        ProfileAlbumHolderType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ProfileAlbumHolderType valueOf(String str) {
        return (ProfileAlbumHolderType) Enum.valueOf(ProfileAlbumHolderType.class, str);
    }

    private ProfileAlbumHolderType(String str, int i) {
    }
}
