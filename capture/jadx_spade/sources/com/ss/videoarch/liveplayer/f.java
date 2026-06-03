package com.ss.videoarch.liveplayer;

import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f implements InvocationHandler {
    private final WeakReference<VideoLiveManager> a;

    static {
        Covode.recordClassIndex(652925);
    }

    public f(VideoLiveManager videoLiveManager) {
        this.a = new WeakReference<>(videoLiveManager);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        VideoLiveManager videoLiveManager = this.a.get();
        if (videoLiveManager == null) {
            return null;
        }
        if (method.getName().equals("updateFrameTerminatedDTS") && objArr.length >= 3) {
            videoLiveManager.updateFrameTerminatedDTS(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
        } else if (method.getName().equals("frameDTSNotify") && objArr.length >= 3) {
            videoLiveManager.frameDTSNotify(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
        } else if (method.getName().equals("receiveBinarySei") && objArr.length >= 1) {
            videoLiveManager.receiveBinarySei((ByteBuffer) objArr[0]);
        } else if (method.getName().equals("onAbrDecisionInfo") && objArr.length >= 2) {
            videoLiveManager.onAbrDecisionInfo(((Long) objArr[0]).longValue(), (String) objArr[1]);
        } else {
            if (method.getName().equals("getStrategyParams") && objArr.length >= 1) {
                return videoLiveManager.getStrategyParams((String) objArr[0]);
            }
            if (method.getName().equals("didReceivePacket") && objArr.length >= 3) {
                videoLiveManager.didReceivePacket(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (Map) objArr[3]);
            } else if (method.getName().equals("willRenderFrame") && objArr.length >= 4) {
                videoLiveManager.willRenderFrame(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (String) objArr[3]);
            } else if (method.getName().equals("onFrameAboutToBeRendered") && objArr.length >= 3) {
                videoLiveManager.onFrameAboutToBeRendered(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (Map) objArr[3]);
            }
        }
        return null;
    }
}
