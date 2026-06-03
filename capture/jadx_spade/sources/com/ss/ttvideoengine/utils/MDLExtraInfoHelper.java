package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.model.VideoInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MDLExtraInfoHelper {
    static {
        Covode.recordClassIndex(652752);
    }

    public static String createMDLExtraInfo(VideoInfo videoInfo) {
        StringBuilder sb = new StringBuilder();
        String valueStr = videoInfo.getValueStr(28);
        String str = "";
        if (valueStr == null) {
            valueStr = "";
        }
        String valueStr2 = videoInfo.getValueStr(29);
        if (valueStr2 != null) {
            str = valueStr2;
        }
        sb.append("fileId=");
        sb.append(valueStr);
        sb.append("&bitrate=");
        sb.append(videoInfo.getValueInt(44));
        sb.append("&pcrc=");
        sb.append(TTHelper.encodeUrl(str));
        return sb.toString();
    }

    public static String addPCDNFlag(int i, String str) {
        throw new UnsupportedOperationException("toB only");
    }

    public static void addPCDNFlag(DataLoaderHelper.DataLoaderTaskItem dataLoaderTaskItem, DataLoaderHelper.DataLoaderTaskItem.TrackItem trackItem) {
        throw new UnsupportedOperationException("toB only");
    }

    public static void addTags(DataLoaderHelper.DataLoaderTaskItem dataLoaderTaskItem, DataLoaderHelper.DataLoaderTaskItem.TrackItem trackItem) {
        if (dataLoaderTaskItem.mTag != null) {
            if (trackItem.mExternalInfo == null) {
                trackItem.mExternalInfo = "tag=" + TTHelper.encodeUrl(dataLoaderTaskItem.mTag);
            } else {
                trackItem.mExternalInfo += "&tag=" + TTHelper.encodeUrl(dataLoaderTaskItem.mTag);
            }
        }
        if (dataLoaderTaskItem.mSubTag != null) {
            if (trackItem.mExternalInfo == null) {
                trackItem.mExternalInfo = "stag=" + TTHelper.encodeUrl(dataLoaderTaskItem.mSubTag);
                return;
            }
            trackItem.mExternalInfo += "&stag=" + TTHelper.encodeUrl(dataLoaderTaskItem.mSubTag);
        }
    }

    public static String createMDLExtraInfo(VideoInfo videoInfo, DataLoaderHelper.DataLoaderTaskItem dataLoaderTaskItem) {
        StringBuilder sb = new StringBuilder();
        String valueStr = videoInfo.getValueStr(28);
        String str = "";
        if (valueStr == null) {
            valueStr = "";
        }
        String valueStr2 = videoInfo.getValueStr(29);
        if (valueStr2 != null) {
            str = valueStr2;
        }
        int valueInt = videoInfo.getValueInt(44);
        sb.append("fileId=");
        sb.append(valueStr);
        sb.append("&bitrate=");
        sb.append(valueInt);
        sb.append("&pcrc=");
        sb.append(TTHelper.encodeUrl(str));
        sb.append("&tag=");
        sb.append(TTHelper.encodeUrl(dataLoaderTaskItem.mTag));
        if (!TextUtils.isEmpty(dataLoaderTaskItem.mSubTag)) {
            sb.append("&stag=");
            sb.append(TTHelper.encodeUrl(dataLoaderTaskItem.mSubTag));
        }
        return sb.toString();
    }
}
