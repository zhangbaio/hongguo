package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DownloadStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DownloadStatus[] $VALUES;
    public static final DownloadStatus STATUS_DOWNLOADED;
    public static final DownloadStatus STATUS_DOWNLOADING;
    public static final DownloadStatus STATUS_NORMAL;
    private final int value;

    private static final /* synthetic */ DownloadStatus[] $values() {
        return new DownloadStatus[]{STATUS_NORMAL, STATUS_DOWNLOADING, STATUS_DOWNLOADED};
    }

    public static EnumEntries<DownloadStatus> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static DownloadStatus[] values() {
        return (DownloadStatus[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608427);
        STATUS_NORMAL = new DownloadStatus("STATUS_NORMAL", 0, 0);
        STATUS_DOWNLOADING = new DownloadStatus("STATUS_DOWNLOADING", 1, 1);
        STATUS_DOWNLOADED = new DownloadStatus("STATUS_DOWNLOADED", 2, 2);
        DownloadStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DownloadStatus valueOf(String str) {
        return (DownloadStatus) Enum.valueOf(DownloadStatus.class, str);
    }

    private DownloadStatus(String str, int i, int i2) {
        this.value = i2;
    }
}
