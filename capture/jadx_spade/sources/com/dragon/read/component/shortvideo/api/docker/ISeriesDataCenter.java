package com.dragon.read.component.shortvideo.api.docker;

import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface ISeriesDataCenter<T> extends Serializable {
    T getFirstLoadedData();

    T getMoreLoadedData();

    T getNewData();

    T getPreDataLoaded();

    T getRecommendDataLoaded();

    void loadData();

    void loadMore();

    void loadPre();

    void loadTarget(String str);

    void release();
}
