package com.xs.fm.player.base.play.player.audio.segment.controller;

import com.xs.fm.player.base.play.player.audio.segment.model.PlaySegmentInfo;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ISegmentDownloader<T> {

    public interface Callback<T> {
        void onDownloaderInitFailed(String str);

        void onSegmentDownloadFailed(String str, int i, int i2, String str2);

        void onSegmentDownloaded(String str, boolean z);

        void onStartSegmentDownload(String str);
    }

    void a(List<PlaySegmentInfo<T>> list, int i);

    void b(Callback<T> callback);

    String c(PlaySegmentInfo<T> playSegmentInfo);

    void clearCache();

    void d(List<PlaySegmentInfo<T>> list);

    void prepare();

    void release();

    void stop();
}
