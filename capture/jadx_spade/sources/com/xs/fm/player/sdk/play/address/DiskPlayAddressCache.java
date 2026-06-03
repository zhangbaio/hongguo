package com.xs.fm.player.sdk.play.address;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DiskPlayAddressCache implements Serializable {
    private final int bgNoiseId;
    private final String bookId;
    private final int genreType;
    private final boolean isMusic;
    private final String itemId;
    private final String key;
    private final String mdlCachePath;
    private final PlayAddress playAddress;
    private final int playTone;
    private final String tag;

    static {
        Covode.recordClassIndex(655918);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component10() {
        return this.mdlCachePath;
    }

    public final String component2() {
        return this.bookId;
    }

    public final int component3() {
        return this.genreType;
    }

    public final int component4() {
        return this.playTone;
    }

    public final int component5() {
        return this.bgNoiseId;
    }

    public final String component6() {
        return this.key;
    }

    public final PlayAddress component7() {
        return this.playAddress;
    }

    public final String component8() {
        return this.tag;
    }

    public final boolean component9() {
        return this.isMusic;
    }

    public final DiskPlayAddressCache copy(String str, String str2, int i, int i2, int i3, String str3, PlayAddress playAddress, String str4, boolean z, String str5) {
        return new DiskPlayAddressCache(str, str2, i, i2, i3, str3, playAddress, str4, z, str5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DiskPlayAddressCache) {
                DiskPlayAddressCache diskPlayAddressCache = (DiskPlayAddressCache) obj;
                if (Intrinsics.areEqual(this.itemId, diskPlayAddressCache.itemId) && Intrinsics.areEqual(this.bookId, diskPlayAddressCache.bookId)) {
                    if (this.genreType == diskPlayAddressCache.genreType) {
                        if (this.playTone == diskPlayAddressCache.playTone) {
                            if ((this.bgNoiseId == diskPlayAddressCache.bgNoiseId) && Intrinsics.areEqual(this.key, diskPlayAddressCache.key) && Intrinsics.areEqual(this.playAddress, diskPlayAddressCache.playAddress) && Intrinsics.areEqual(this.tag, diskPlayAddressCache.tag)) {
                                if (!(this.isMusic == diskPlayAddressCache.isMusic) || !Intrinsics.areEqual(this.mdlCachePath, diskPlayAddressCache.mdlCachePath)) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.itemId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bookId;
        int hashCode2 = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.genreType) * 31) + this.playTone) * 31) + this.bgNoiseId) * 31;
        String str3 = this.key;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PlayAddress playAddress = this.playAddress;
        int hashCode4 = (hashCode3 + (playAddress != null ? playAddress.hashCode() : 0)) * 31;
        String str4 = this.tag;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.isMusic;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode5 + i) * 31;
        String str5 = this.mdlCachePath;
        return i2 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DiskPlayAddressCache(itemId=" + this.itemId + ", bookId=" + this.bookId + ", genreType=" + this.genreType + ", playTone=" + this.playTone + ", bgNoiseId=" + this.bgNoiseId + ", key=" + this.key + ", playAddress=" + this.playAddress + ", tag=" + this.tag + ", isMusic=" + this.isMusic + ", mdlCachePath=" + this.mdlCachePath + ")";
    }

    public final int getBgNoiseId() {
        return this.bgNoiseId;
    }

    public final String getBookId() {
        return this.bookId;
    }

    public final int getGenreType() {
        return this.genreType;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMdlCachePath() {
        return this.mdlCachePath;
    }

    public final PlayAddress getPlayAddress() {
        return this.playAddress;
    }

    public final int getPlayTone() {
        return this.playTone;
    }

    public final String getTag() {
        return this.tag;
    }

    public final boolean isMusic() {
        return this.isMusic;
    }

    public DiskPlayAddressCache(String str, String str2, int i, int i2, int i3, String str3, PlayAddress playAddress, String str4, boolean z, String str5) {
        this.itemId = str;
        this.bookId = str2;
        this.genreType = i;
        this.playTone = i2;
        this.bgNoiseId = i3;
        this.key = str3;
        this.playAddress = playAddress;
        this.tag = str4;
        this.isMusic = z;
        this.mdlCachePath = str5;
    }
}
