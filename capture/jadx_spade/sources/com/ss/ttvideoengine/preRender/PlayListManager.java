package com.ss.ttvideoengine.preRender;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayListManager {
    private int mCurPlayIndex;
    private int mCurPrerenderIndex;
    private EngineFactory mEngineFactory;
    private HashMap<String, TTVideoEngine> mEngineHashMap;
    private final ReentrantReadWriteLock mLock = new ReentrantReadWriteLock(false);
    private PreRenderController mPreRenderController;
    private PreRenderListener mPreRenderListener;
    private int mSize;
    private ArrayList<Source> mSources;

    static {
        Covode.recordClassIndex(652615);
    }

    public Source getCurrentSource() {
        Source source;
        int i;
        this.mLock.readLock().lock();
        ArrayList<Source> arrayList = this.mSources;
        if (arrayList != null && (i = this.mCurPlayIndex) < this.mSize) {
            source = arrayList.get(i);
        } else {
            source = null;
        }
        this.mLock.readLock().unlock();
        return source;
    }

    public Source getNextSource() {
        Source source;
        this.mLock.readLock().lock();
        ArrayList<Source> arrayList = this.mSources;
        if (arrayList != null) {
            int i = this.mCurPlayIndex;
            if (i + 1 < this.mSize) {
                source = arrayList.get(i + 1);
                this.mLock.readLock().unlock();
                return source;
            }
        }
        source = null;
        this.mLock.readLock().unlock();
        return source;
    }

    public void clear() {
        this.mLock.writeLock().lock();
        this.mSources = null;
        this.mSize = 0;
        this.mCurPlayIndex = 0;
        this.mCurPrerenderIndex = 0;
        Iterator<String> it2 = this.mEngineHashMap.keySet().iterator();
        while (it2.hasNext()) {
            TTVideoEngine tTVideoEngine = this.mEngineHashMap.get(it2.next());
            if (tTVideoEngine != null) {
                tTVideoEngine.releaseAsync();
            }
        }
        this.mEngineHashMap.clear();
        this.mLock.writeLock().unlock();
    }

    public TTVideoEngine getCurrentEngine() {
        TTVideoEngine tTVideoEngine;
        ArrayList<Source> arrayList;
        this.mLock.readLock().lock();
        ArrayList<Source> arrayList2 = this.mSources;
        if (arrayList2 != null) {
            tTVideoEngine = this.mEngineHashMap.remove(arrayList2.get(this.mCurPlayIndex).vid());
            if (tTVideoEngine != null) {
                TTVideoEngineLog.i("PlayListManager", "get engine from prerender map, engine = " + tTVideoEngine);
            }
        } else {
            tTVideoEngine = null;
        }
        this.mLock.readLock().unlock();
        if (tTVideoEngine == null && (arrayList = this.mSources) != null) {
            TTVideoEngine createEngine = this.mEngineFactory.createEngine(arrayList.get(this.mCurPlayIndex));
            TTVideoEngineLog.i("PlayListManager", "get engine from factory, engine = " + createEngine);
            return createEngine;
        }
        return tTVideoEngine;
    }

    private class MyPrerenderListener implements PreRenderListener {
        static {
            Covode.recordClassIndex(652616);
        }

        public MyPrerenderListener() {
        }

        @Override // com.ss.ttvideoengine.preRender.PreRenderListener
        public boolean onPreRenderPause(TTVideoEngine tTVideoEngine, Source source) {
            if (source == null) {
                return false;
            }
            TTVideoEngineLog.d("PlayListManager", "onPreRenderPause, engine = " + tTVideoEngine + ", vid = " + source.vid());
            return false;
        }

        @Override // com.ss.ttvideoengine.preRender.PreRenderListener
        public void onPreRenderStart(TTVideoEngine tTVideoEngine, Source source) {
            if (source == null) {
                return;
            }
            TTVideoEngineLog.d("PlayListManager", "onPrerenderStart, engine = " + tTVideoEngine + ", vid = " + source.vid());
        }

        @Override // com.ss.ttvideoengine.preRender.PreRenderListener
        public void onPreRenderSuccess(TTVideoEngine tTVideoEngine, Source source) {
            if (source == null) {
                return;
            }
            TTVideoEngineLog.i("PlayListManager", "onPreRenderSuccess, engine = " + tTVideoEngine + ", vid = " + source.vid());
            PlayListManager.this.mLock.readLock().lock();
            if (PlayListManager.this.mSources != null && PlayListManager.this.findIndexOfSource(source) == PlayListManager.this.mCurPrerenderIndex) {
                PlayListManager.this.mEngineHashMap.put(source.vid(), tTVideoEngine);
                PlayListManager.this.mPreRenderController.stop();
            }
            PlayListManager.this.mLock.readLock().unlock();
        }

        @Override // com.ss.ttvideoengine.preRender.PreRenderListener
        public void onPreRenderError(TTVideoEngine tTVideoEngine, Source source, int i, Error error) {
            TTVideoEngineLog.e("PlayListManager", "onPreRenderError, engine = " + tTVideoEngine + ", errorType = " + i + ", error = " + error);
            PlayListManager.this.mLock.writeLock().lock();
            if (tTVideoEngine != null) {
                tTVideoEngine.releaseAsync();
            }
            if (PlayListManager.this.mSources != null && source != null && PlayListManager.this.findIndexOfSource(source) == PlayListManager.this.mCurPrerenderIndex) {
                PlayListManager.this.mPreRenderController.stop();
            }
            if (i == 3 && source != null) {
                PlayListManager.this.mEngineHashMap.remove(source.vid());
            }
            PlayListManager.this.mLock.writeLock().unlock();
        }
    }

    public PlayListManager(EngineFactory engineFactory) {
        init(engineFactory, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findIndexOfSource(Source source) {
        int i = -1;
        if (source == null) {
            return -1;
        }
        this.mLock.readLock().lock();
        if (this.mSources != null) {
            String vid = source.vid();
            int i2 = 0;
            while (true) {
                if (i2 >= this.mSources.size()) {
                    break;
                }
                if (this.mSources.get(i2).vid().equals(vid)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        this.mLock.readLock().unlock();
        return i;
    }

    public void addList(ArrayList<Source> arrayList) {
        this.mLock.writeLock().lock();
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<Source> arrayList2 = this.mSources;
            if (arrayList2 == null) {
                this.mSources = arrayList;
            } else {
                arrayList2.addAll(arrayList);
            }
            this.mSize = this.mSources.size();
        }
        this.mLock.writeLock().unlock();
    }

    public void setList(ArrayList<Source> arrayList) {
        int size;
        this.mLock.writeLock().lock();
        this.mSources = arrayList;
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        this.mSize = size;
        this.mCurPlayIndex = 0;
        this.mCurPrerenderIndex = 0;
        this.mLock.writeLock().unlock();
    }

    public void setCurrentSource(Source source) {
        String vid;
        StringBuilder sb = new StringBuilder();
        sb.append("set current source, vid = ");
        if (source == null) {
            vid = "null";
        } else {
            vid = source.vid();
        }
        sb.append(vid);
        TTVideoEngineLog.i("PlayListManager", sb.toString());
        this.mPreRenderController.stop();
        this.mLock.writeLock().lock();
        boolean z = false;
        if (this.mSources != null) {
            if (source != null) {
                int findIndexOfSource = findIndexOfSource(source);
                if (findIndexOfSource >= 0) {
                    this.mCurPlayIndex = findIndexOfSource;
                    this.mCurPrerenderIndex = findIndexOfSource + 1;
                }
            } else {
                this.mCurPlayIndex = 0;
                this.mCurPrerenderIndex = 0;
            }
            int i = this.mCurPrerenderIndex;
            if (i < this.mSize) {
                Source source2 = this.mSources.get(i);
                if (!this.mEngineHashMap.containsKey(source2.vid())) {
                    this.mPreRenderController.setSource(source2);
                    z = true;
                }
            }
        }
        this.mLock.writeLock().unlock();
        if (z) {
            this.mPreRenderController.start();
        }
    }

    public PlayListManager(EngineFactory engineFactory, PreRenderAlgorithm preRenderAlgorithm) {
        init(engineFactory, preRenderAlgorithm);
    }

    private void init(EngineFactory engineFactory, PreRenderAlgorithm preRenderAlgorithm) {
        this.mEngineFactory = engineFactory;
        if (preRenderAlgorithm == null) {
            this.mPreRenderController = new PreRenderController(this.mEngineFactory);
        } else {
            this.mPreRenderController = new PreRenderController(this.mEngineFactory, preRenderAlgorithm);
        }
        this.mEngineHashMap = new HashMap<>();
        MyPrerenderListener myPrerenderListener = new MyPrerenderListener();
        this.mPreRenderListener = myPrerenderListener;
        this.mPreRenderController.setListener(myPrerenderListener);
    }
}
