package com.ss.ttvideoengine;

import android.content.Context;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTVideoEnginePool {
    private static volatile TTVideoEnginePool instance;
    public final int CORE_POOL_SIZE_UPPER_LIMIT = 0;
    private AtomicInteger corePoolSizeUpperLimit = new AtomicInteger(2);
    private Queue<TTVideoEngine> corePool = new LinkedBlockingQueue();
    private Set<TTVideoEngine> resetingEngines = new HashSet();
    private int refreshingEnginesCount = 0;
    private WeakHashMap<TTVideoEngine, Integer> weakHashOfEngineInUse = new WeakHashMap<>();

    static {
        Covode.recordClassIndex(652366);
    }

    public void releaseCoreEnginesAndCodecAsync() {
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.n
            @Override // java.lang.Runnable
            public final void run() {
                TTVideoEnginePool.this.doReleaseCoreEnginesAndCodecAsync();
            }
        });
    }

    private TTVideoEnginePool() {
    }

    public static TTVideoEnginePool getInstance() {
        if (instance == null) {
            synchronized (TTVideoEnginePool.class) {
                if (instance == null) {
                    instance = new TTVideoEnginePool();
                    TTVideoEngineLog.i("TTVideoEnginePool", "Construct TTVideoEnginePool");
                }
            }
        }
        return instance;
    }

    public void releaseCoreEngines() {
        synchronized (this) {
            int size = this.corePool.size();
            while (!this.corePool.isEmpty()) {
                TTVideoEngine poll = this.corePool.poll();
                if (poll != null) {
                    poll.release();
                }
            }
            TTVideoEngineLog.i("TTVideoEnginePool", "releaseCoreEngines finished, corePool.size:" + size + " -> 0");
        }
    }

    public synchronized void doReleaseCoreEnginesAndCodecAsync() {
        while (true) {
            if (this.resetingEngines.isEmpty() && this.refreshingEnginesCount == 0) {
                break;
            }
            try {
                TTVideoEngineLog.i("TTVideoEnginePool", "releaseCoreEnginesAndCodecAsync thread enters wait mode. Current resetingEngines.size = " + this.resetingEngines.size() + ", refreshingEnginesCount = " + this.refreshingEnginesCount);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int size = this.corePool.size();
        String str = "";
        if (this.corePool.isEmpty()) {
            str = "can not close codecpool because corePool is null";
        } else {
            while (!this.corePool.isEmpty()) {
                TTVideoEngine poll = this.corePool.poll();
                if (this.corePool.isEmpty()) {
                    if (!this.weakHashOfEngineInUse.isEmpty()) {
                        str = "do not close codecpool because weakHashOfEngineInUse is not Empty!";
                    } else if (poll != null) {
                        poll.setIntOption(985, 1);
                        str = "do close codecpool!";
                    }
                }
                if (poll != null) {
                    poll.release();
                }
            }
        }
        TTVideoEngineLog.i("TTVideoEnginePool", "releaseCoreEnginesAndCodecAsync finished, corePool.size:" + size + " -> 0, " + str);
    }

    public int getIntStatus(int i) {
        if (i != 0) {
            return 0;
        }
        return this.corePoolSizeUpperLimit.get();
    }

    public void setCorePoolSizeUpperLimit(int i) {
        this.corePoolSizeUpperLimit.set(i);
        TTVideoEngineLog.i("TTVideoEnginePool", "setCorePoolSizeUpperLimit, size:" + i);
    }

    public void giveBackEngine(TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine == null) {
            return;
        }
        if (!tTVideoEngine.isPlayerType(0)) {
            TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine , Engine:" + tTVideoEngine + " released directly, do not manage in Enginepool! ");
            tTVideoEngine.release();
            this.weakHashOfEngineInUse.remove(tTVideoEngine);
            return;
        }
        TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine Enter， Engine:" + tTVideoEngine);
        synchronized (this) {
            if (!this.resetingEngines.contains(tTVideoEngine) && !this.corePool.contains(tTVideoEngine) && 5 != tTVideoEngine.getIntOption(57)) {
                this.resetingEngines.add(tTVideoEngine);
                TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine，before engine.resetByPoolEngine:" + tTVideoEngine);
                return;
            }
            TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine got canceled! because the engine has already been giveback before! Engine:" + tTVideoEngine);
        }
    }

    public void resetFinish(TTVideoEngine tTVideoEngine) {
        boolean z;
        int size;
        TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine resetFinish Enter, Engine:" + tTVideoEngine + ", curLooper:" + Looper.myLooper() + ", corePool.size = " + this.corePool.size());
        synchronized (this) {
            z = true;
            if (this.corePool.size() < this.corePoolSizeUpperLimit.get()) {
                if (this.corePool.offer(tTVideoEngine)) {
                    TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine Engine:" + tTVideoEngine + " give back to corePool");
                    z = false;
                } else {
                    TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine Engine:" + tTVideoEngine + " , Warning:give back to corePool failed!");
                }
            }
        }
        if (z) {
            TTVideoEngineLog.d("TTVideoEnginePool", "giveBackEngine Engine:" + tTVideoEngine + " need release");
            tTVideoEngine.release();
            TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine Engine:" + tTVideoEngine + " released by TTVideoEnginePool");
        }
        synchronized (this) {
            TTVideoEngineLog.d("TTVideoEnginePool", "giveBackEngine Engine:" + tTVideoEngine + " remove...");
            this.weakHashOfEngineInUse.remove(tTVideoEngine);
            size = this.weakHashOfEngineInUse.size();
            this.resetingEngines.remove(tTVideoEngine);
            notify();
        }
        TTVideoEngineLog.i("TTVideoEnginePool", "giveBackEngine resetFinish End, Engine:" + tTVideoEngine + ", corePool.size = " + this.corePool.size() + ", countOfEngineInUse:" + size);
    }

    public TTVideoEngine getEngine(Context context, int i) {
        return getEngine(context, i, null);
    }

    public TTVideoEngine getEngine(Context context, int i, Map map) {
        int size;
        TTVideoEngine poll;
        String str;
        int size2;
        if (i != 0) {
            TTVideoEngine tTVideoEngine = new TTVideoEngine(context, i, map);
            TTVideoEngineLog.i("TTVideoEnginePool", "getEngine finished, Engine:" + tTVideoEngine + " ,Type is :" + i + " , do not manage in Enginepool! ");
            return tTVideoEngine;
        }
        String str2 = "params is null, ";
        if (map != null) {
            str2 = "params is not null, ";
        }
        synchronized (this) {
            size = this.corePool.size();
            poll = this.corePool.poll();
            this.refreshingEnginesCount++;
        }
        if (poll != null) {
            poll.setStringOption(1205, "get existing from EnginePool");
            str = "get an existing Engine from corePool";
        } else {
            poll = new TTVideoEngine(context, i, map);
            poll.setStringOption(1205, "new by EnginePool");
            str = "create a new Engine by TTVideoEnginePool";
        }
        synchronized (this) {
            this.weakHashOfEngineInUse.put(poll, 0);
            size2 = this.weakHashOfEngineInUse.size();
            this.refreshingEnginesCount--;
            notify();
        }
        poll.setIntOption(1206, this.corePoolSizeUpperLimit.get());
        poll.setIntOption(1207, size);
        poll.setIntOption(1208, size2);
        TTVideoEngineLog.i("TTVideoEnginePool", "getEngine finished, " + str2 + str + ", Engine:  " + poll + ", corePool.size = " + this.corePool.size() + ", countOfEngineInUse:" + size2);
        return poll;
    }
}
