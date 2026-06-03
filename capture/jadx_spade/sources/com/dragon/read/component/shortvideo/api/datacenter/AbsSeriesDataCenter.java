package com.dragon.read.component.shortvideo.api.datacenter;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsSeriesDataCenter<T> implements ISeriesDataCenter<T> {
    private final LogHelper log = new LogHelper("ShortSeries-AbsSeriesDataCenter");
    private final List<WeakReference<a>> mListeners = new ArrayList();
    private boolean mHasMore = true;

    static {
        Covode.recordClassIndex(598622);
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public T getNewData() {
        return null;
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public T getPreDataLoaded() {
        return null;
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public T getRecommendDataLoaded() {
        return null;
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public void loadPre() {
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public void loadTarget(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
    }

    protected void notifyFirstDataLoadedSyncIfNeed(SaasVideoDetailModel saasVideoDetailModel, boolean z) {
        Intrinsics.checkNotNullParameter(saasVideoDetailModel, "saasVideoDetailModel");
    }

    public void onPageSelected(d dVar, int i, int i2) {
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public void release() {
    }

    protected final boolean getMHasMore() {
        return this.mHasMore;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    @Override // com.dragon.read.component.shortvideo.api.docker.ISeriesDataCenter
    public void loadData() {
        qr3.a.a(ShortSeriesApi.Companion.c().getPlayChainTraceMonitor(), "video_detail_request_start", null, 2, null);
    }

    public final void notifyDataSetChanged() {
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.onDataSetChanged();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void notifyMoreDataLoaded() {
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.N6();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void notifyPreDataLoaded() {
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.y9();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public void notifyRecommendDataLoaded() {
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.Ne();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void notifySyncRemoteDataToPrefetch() {
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.xd();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    protected final void setMHasMore(boolean z) {
        this.mHasMore = z;
    }

    public final void addListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                if (it2.next().get() == listener) {
                    return;
                }
            }
            this.mListeners.add(new WeakReference<>(listener));
        }
    }

    public final void removeListener(a listener) {
        WeakReference<a> weakReference;
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (true) {
                if (it2.hasNext()) {
                    weakReference = it2.next();
                    if (weakReference.get() == listener) {
                        break;
                    }
                } else {
                    weakReference = null;
                    break;
                }
            }
            if (weakReference != null) {
                this.mListeners.remove(weakReference);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyLoadMoreFailed(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.ma(throwable);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute load more listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void notifyFailed(Throwable throwable, Map<String, ? extends Serializable> map) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        qr3.a.a(ShortSeriesApi.Companion.c().getPlayChainTraceMonitor(), "video_detail_request_end", null, 2, null);
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.Mb(throwable);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void notifyFirstDataLoaded(boolean z, Map<String, ? extends Serializable> map) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("hit_video_detail_cache", Boolean.valueOf(z));
        ShortSeriesApi.a aVar = ShortSeriesApi.Companion;
        aVar.c().getPlayChainTraceMonitor().c("hit_video_detail_cache", hashMap);
        aVar.c().getPlayChainTraceMonitor().c("video_detail_request_end", map);
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar2 = it2.next().get();
                    if (aVar2 != null) {
                        aVar2.Ie();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    protected final void notifySyncRemoteDataToPrefetchFail(String seriesId, int i) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        synchronized (this.mListeners) {
            Iterator<WeakReference<a>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                try {
                    a aVar = it2.next().get();
                    if (aVar != null) {
                        aVar.B4(seriesId, i);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.log.e("fail to execute listening callback , error =%s ", new Object[]{Log.getStackTraceString(e)});
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void notifyFailed$default(AbsSeriesDataCenter absSeriesDataCenter, Throwable th, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                map = null;
            }
            absSeriesDataCenter.notifyFailed(th, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyFailed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void notifyFirstDataLoaded$default(AbsSeriesDataCenter absSeriesDataCenter, boolean z, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                map = null;
            }
            absSeriesDataCenter.notifyFirstDataLoaded(z, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyFirstDataLoaded");
    }
}
