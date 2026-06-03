package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.Error;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ITTVideoEngineLogger {
    void initLogger();

    void logBeginToPlay();

    void logBufferingEnd(int i);

    void logBufferingStart(int i, int i2);

    void logCompletion();

    void logError(Error error);

    void logLoopAgain();

    void logPrepareBeforePlay();

    void logPrepareEnd();

    void logPrepareStart();

    void logRetry(Error error, int i);

    void logSeek(int i);

    void logSeekCompletion();

    void logSetDataSource();

    void logSetSurface(String str);

    void logStop(int i);

    void logVideoRenderStart();

    void logVideoSizeChanged(int i, int i2);
}
