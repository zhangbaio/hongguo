package com.ss.ttvideoengine.preload;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadConfig {
    public int mMaxSceneCount = 10;
    public String mCurrentSceneId = null;

    static {
        Covode.recordClassIndex(652628);
    }

    private static class SingleBuilder {
        private static PreloadConfig single;

        private SingleBuilder() {
        }

        static {
            Covode.recordClassIndex(652629);
            single = new PreloadConfig();
        }
    }

    public String getCurrentSceneId() {
        return this.mCurrentSceneId;
    }

    public static PreloadConfig share() {
        return SingleBuilder.single;
    }

    public void createScene(PreloadScene preloadScene) {
        TTVideoEngineLog.i("PreloadConfig", "create scene " + preloadScene.mSceneId);
        if (TextUtils.isEmpty(preloadScene.mSceneId)) {
            return;
        }
        DataLoaderHelper.getDataLoader().createScene(preloadScene);
    }

    public void destroyScene(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TTVideoEngineLog.i("PreloadConfig", "destroy scene " + str);
        DataLoaderHelper.getDataLoader().destroyScene(str);
        String str2 = this.mCurrentSceneId;
        if (str2 != null && str2.equals(str)) {
            this.mCurrentSceneId = null;
        }
    }

    public boolean moveToScene(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TTVideoEngineLog.i("PreloadConfig", "move to scene " + str);
        String str2 = this.mCurrentSceneId;
        if (str2 != null && str2.equals(str)) {
            return true;
        }
        this.mCurrentSceneId = str;
        DataLoaderHelper.getDataLoader().moveToScene(str);
        return true;
    }
}
