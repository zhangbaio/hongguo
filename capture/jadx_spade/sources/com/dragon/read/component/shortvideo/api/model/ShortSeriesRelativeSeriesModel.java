package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasShowType;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.List;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesRelativeSeriesModel extends ShortSeriesRelativeCellModel {
    private long cellId;
    private String cellName;
    private String cellOperationTypeText;
    private String cellUrl;
    private List<SeriesEndRecData> recDataList;
    private List<? extends SecondaryInfo> recommendReasonList;
    private String sessionId;
    private SaasShowType showType;
    private List<? extends SaasVideoData> videoData;
    private boolean withFavoriteButton;

    static {
        Covode.recordClassIndex(598804);
    }

    public final long getCellId() {
        return this.cellId;
    }

    public final String getCellName() {
        return this.cellName;
    }

    public final String getCellOperationTypeText() {
        return this.cellOperationTypeText;
    }

    public final String getCellUrl() {
        return this.cellUrl;
    }

    public final List<SeriesEndRecData> getRecDataList() {
        return this.recDataList;
    }

    public final List<SecondaryInfo> getRecommendReasonList() {
        return this.recommendReasonList;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final SaasShowType getShowType() {
        return this.showType;
    }

    public final List<SaasVideoData> getVideoData() {
        return this.videoData;
    }

    public final boolean getWithFavoriteButton() {
        return this.withFavoriteButton;
    }

    public final void setCellId(long j) {
        this.cellId = j;
    }

    public final void setCellName(String str) {
        this.cellName = str;
    }

    public final void setCellOperationTypeText(String str) {
        this.cellOperationTypeText = str;
    }

    public final void setCellUrl(String str) {
        this.cellUrl = str;
    }

    public final void setRecDataList(List<SeriesEndRecData> list) {
        this.recDataList = list;
    }

    public final void setRecommendReasonList(List<? extends SecondaryInfo> list) {
        this.recommendReasonList = list;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final void setShowType(SaasShowType saasShowType) {
        this.showType = saasShowType;
    }

    public final void setVideoData(List<? extends SaasVideoData> list) {
        this.videoData = list;
    }

    public final void setWithFavoriteButton(boolean z) {
        this.withFavoriteButton = z;
    }
}
