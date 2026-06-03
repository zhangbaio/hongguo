package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasUrgeUpdateData;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoDirectoryItem;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoHighlight;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import seriessdk.com.dragon.read.saas.rpc.model.Celebrity;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeLockData;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailStyle;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SeriesStatus;
import seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UseStatus;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPayInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRecordInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRelateBook;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoUpdateInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVideoDetailModelWrapper extends SaasVideoDetailModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final f _secondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _secondaryInfoList_delegate$lambda$0;
            _secondaryInfoList_delegate$lambda$0 = SaasVideoDetailModelWrapper._secondaryInfoList_delegate$lambda$0();
            return _secondaryInfoList_delegate$lambda$0;
        }
    });
    private final f _abstractSecondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _abstractSecondaryInfoList_delegate$lambda$1;
            _abstractSecondaryInfoList_delegate$lambda$1 = SaasVideoDetailModelWrapper._abstractSecondaryInfoList_delegate$lambda$1();
            return _abstractSecondaryInfoList_delegate$lambda$1;
        }
    });
    private final h _showMaterialGuidanceAnim$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _showMaterialGuidanceAnim_delegate$lambda$2;
            _showMaterialGuidanceAnim_delegate$lambda$2 = SaasVideoDetailModelWrapper._showMaterialGuidanceAnim_delegate$lambda$2();
            return Boolean.valueOf(_showMaterialGuidanceAnim_delegate$lambda$2);
        }
    });
    private final f _relatedMaterialId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _relatedMaterialId_delegate$lambda$3;
            _relatedMaterialId_delegate$lambda$3 = SaasVideoDetailModelWrapper._relatedMaterialId_delegate$lambda$3();
            return _relatedMaterialId_delegate$lambda$3;
        }
    });
    private final f _videoContentType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoContentType _videoContentType_delegate$lambda$4;
            _videoContentType_delegate$lambda$4 = SaasVideoDetailModelWrapper._videoContentType_delegate$lambda$4();
            return _videoContentType_delegate$lambda$4;
        }
    });
    private final h _duration$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long _duration_delegate$lambda$5;
            _duration_delegate$lambda$5 = SaasVideoDetailModelWrapper._duration_delegate$lambda$5();
            return Long.valueOf(_duration_delegate$lambda$5);
        }
    });
    private final f _currentVideoData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaasVideoData _currentVideoData_delegate$lambda$6;
            _currentVideoData_delegate$lambda$6 = SaasVideoDetailModelWrapper._currentVideoData_delegate$lambda$6();
            return _currentVideoData_delegate$lambda$6;
        }
    });
    private final f _episodesTitle$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodesTitle_delegate$lambda$7;
            _episodesTitle_delegate$lambda$7 = SaasVideoDetailModelWrapper._episodesTitle_delegate$lambda$7();
            return _episodesTitle_delegate$lambda$7;
        }
    });
    private final f _episodesStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SeriesStatus _episodesStatus_delegate$lambda$8;
            _episodesStatus_delegate$lambda$8 = SaasVideoDetailModelWrapper._episodesStatus_delegate$lambda$8();
            return _episodesStatus_delegate$lambda$8;
        }
    });
    private final h _episodeCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int _episodeCnt_delegate$lambda$9;
            _episodeCnt_delegate$lambda$9 = SaasVideoDetailModelWrapper._episodeCnt_delegate$lambda$9();
            return Integer.valueOf(_episodeCnt_delegate$lambda$9);
        }
    });
    private final f _episodesId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodesId_delegate$lambda$10;
            _episodesId_delegate$lambda$10 = SaasVideoDetailModelWrapper._episodesId_delegate$lambda$10();
            return _episodesId_delegate$lambda$10;
        }
    });
    private final h _followed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _followed_delegate$lambda$11;
            _followed_delegate$lambda$11 = SaasVideoDetailModelWrapper._followed_delegate$lambda$11();
            return Boolean.valueOf(_followed_delegate$lambda$11);
        }
    });
    private final h _followedCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long _followedCnt_delegate$lambda$12;
            _followedCnt_delegate$lambda$12 = SaasVideoDetailModelWrapper._followedCnt_delegate$lambda$12();
            return Long.valueOf(_followedCnt_delegate$lambda$12);
        }
    });
    private final h _localList$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _localList_delegate$lambda$13;
            _localList_delegate$lambda$13 = SaasVideoDetailModelWrapper._localList_delegate$lambda$13();
            return Boolean.valueOf(_localList_delegate$lambda$13);
        }
    });
    private final f _episodesList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _episodesList_delegate$lambda$14;
            _episodesList_delegate$lambda$14 = SaasVideoDetailModelWrapper._episodesList_delegate$lambda$14();
            return _episodesList_delegate$lambda$14;
        }
    });
    private final f _trailerList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _trailerList_delegate$lambda$15;
            _trailerList_delegate$lambda$15 = SaasVideoDetailModelWrapper._trailerList_delegate$lambda$15();
            return _trailerList_delegate$lambda$15;
        }
    });
    private final h _seriesColorHex$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _seriesColorHex_delegate$lambda$16;
            _seriesColorHex_delegate$lambda$16 = SaasVideoDetailModelWrapper._seriesColorHex_delegate$lambda$16();
            return _seriesColorHex_delegate$lambda$16;
        }
    });
    private final h _episodesListWithTrail$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _episodesListWithTrail_delegate$lambda$17;
            _episodesListWithTrail_delegate$lambda$17 = SaasVideoDetailModelWrapper._episodesListWithTrail_delegate$lambda$17();
            return _episodesListWithTrail_delegate$lambda$17;
        }
    });
    private final f _updateTag$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _updateTag_delegate$lambda$18;
            _updateTag_delegate$lambda$18 = SaasVideoDetailModelWrapper._updateTag_delegate$lambda$18();
            return _updateTag_delegate$lambda$18;
        }
    });
    private final f _episodesCover$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodesCover_delegate$lambda$19;
            _episodesCover_delegate$lambda$19 = SaasVideoDetailModelWrapper._episodesCover_delegate$lambda$19();
            return _episodesCover_delegate$lambda$19;
        }
    });
    private final f _smallEpisodesCover$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _smallEpisodesCover_delegate$lambda$20;
            _smallEpisodesCover_delegate$lambda$20 = SaasVideoDetailModelWrapper._smallEpisodesCover_delegate$lambda$20();
            return _smallEpisodesCover_delegate$lambda$20;
        }
    });
    private final f _videoRecordInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoRecordInfo _videoRecordInfo_delegate$lambda$21;
            _videoRecordInfo_delegate$lambda$21 = SaasVideoDetailModelWrapper._videoRecordInfo_delegate$lambda$21();
            return _videoRecordInfo_delegate$lambda$21;
        }
    });
    private final h _ugcRelated$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _ugcRelated_delegate$lambda$22;
            _ugcRelated_delegate$lambda$22 = SaasVideoDetailModelWrapper._ugcRelated_delegate$lambda$22();
            return Boolean.valueOf(_ugcRelated_delegate$lambda$22);
        }
    });
    private final h _enableVisionProduct$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _enableVisionProduct_delegate$lambda$23;
            _enableVisionProduct_delegate$lambda$23 = SaasVideoDetailModelWrapper._enableVisionProduct_delegate$lambda$23();
            return Boolean.valueOf(_enableVisionProduct_delegate$lambda$23);
        }
    });
    private final h _insertAdRitType$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int _insertAdRitType_delegate$lambda$24;
            _insertAdRitType_delegate$lambda$24 = SaasVideoDetailModelWrapper._insertAdRitType_delegate$lambda$24();
            return Integer.valueOf(_insertAdRitType_delegate$lambda$24);
        }
    });
    private final f _episodesListWithTrailAfterCut$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _episodesListWithTrailAfterCut_delegate$lambda$25;
            _episodesListWithTrailAfterCut_delegate$lambda$25 = SaasVideoDetailModelWrapper._episodesListWithTrailAfterCut_delegate$lambda$25();
            return _episodesListWithTrailAfterCut_delegate$lambda$25;
        }
    });
    private final f _seriesIntro$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _seriesIntro_delegate$lambda$26;
            _seriesIntro_delegate$lambda$26 = SaasVideoDetailModelWrapper._seriesIntro_delegate$lambda$26();
            return _seriesIntro_delegate$lambda$26;
        }
    });
    private final h _episodesPlayCount$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long _episodesPlayCount_delegate$lambda$27;
            _episodesPlayCount_delegate$lambda$27 = SaasVideoDetailModelWrapper._episodesPlayCount_delegate$lambda$27();
            return Long.valueOf(_episodesPlayCount_delegate$lambda$27);
        }
    });
    private final f _episodesListCountText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodesListCountText_delegate$lambda$28;
            _episodesListCountText_delegate$lambda$28 = SaasVideoDetailModelWrapper._episodesListCountText_delegate$lambda$28();
            return _episodesListCountText_delegate$lambda$28;
        }
    });
    private final f _episodesIntroduction$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodesIntroduction_delegate$lambda$29;
            _episodesIntroduction_delegate$lambda$29 = SaasVideoDetailModelWrapper._episodesIntroduction_delegate$lambda$29();
            return _episodesIntroduction_delegate$lambda$29;
        }
    });
    private final f _videoPlatformType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoPlatformType _videoPlatformType_delegate$lambda$30;
            _videoPlatformType_delegate$lambda$30 = SaasVideoDetailModelWrapper._videoPlatformType_delegate$lambda$30();
            return _videoPlatformType_delegate$lambda$30;
        }
    });
    private final f _categorySchema$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _categorySchema_delegate$lambda$31;
            _categorySchema_delegate$lambda$31 = SaasVideoDetailModelWrapper._categorySchema_delegate$lambda$31();
            return _categorySchema_delegate$lambda$31;
        }
    });
    private final f _dirData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            EpisodeLockData _dirData_delegate$lambda$32;
            _dirData_delegate$lambda$32 = SaasVideoDetailModelWrapper._dirData_delegate$lambda$32();
            return _dirData_delegate$lambda$32;
        }
    });
    private final f _directoryItems$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _directoryItems_delegate$lambda$33;
            _directoryItems_delegate$lambda$33 = SaasVideoDetailModelWrapper._directoryItems_delegate$lambda$33();
            return _directoryItems_delegate$lambda$33;
        }
    });
    private final f _highlight$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaasVideoHighlight _highlight_delegate$lambda$34;
            _highlight_delegate$lambda$34 = SaasVideoDetailModelWrapper._highlight_delegate$lambda$34();
            return _highlight_delegate$lambda$34;
        }
    });
    private final h _disableInsertAd$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _disableInsertAd_delegate$lambda$35;
            _disableInsertAd_delegate$lambda$35 = SaasVideoDetailModelWrapper._disableInsertAd_delegate$lambda$35();
            return Boolean.valueOf(_disableInsertAd_delegate$lambda$35);
        }
    });
    private final f _recommendInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _recommendInfo_delegate$lambda$36;
            _recommendInfo_delegate$lambda$36 = SaasVideoDetailModelWrapper._recommendInfo_delegate$lambda$36();
            return _recommendInfo_delegate$lambda$36;
        }
    });
    private final f _recommendGroupId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _recommendGroupId_delegate$lambda$37;
            _recommendGroupId_delegate$lambda$37 = SaasVideoDetailModelWrapper._recommendGroupId_delegate$lambda$37();
            return _recommendGroupId_delegate$lambda$37;
        }
    });
    private final f _fromSrcMaterialId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _fromSrcMaterialId_delegate$lambda$38;
            _fromSrcMaterialId_delegate$lambda$38 = SaasVideoDetailModelWrapper._fromSrcMaterialId_delegate$lambda$38();
            return _fromSrcMaterialId_delegate$lambda$38;
        }
    });
    private final f _fromPlayListId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _fromPlayListId_delegate$lambda$39;
            _fromPlayListId_delegate$lambda$39 = SaasVideoDetailModelWrapper._fromPlayListId_delegate$lambda$39();
            return _fromPlayListId_delegate$lambda$39;
        }
    });
    private final f _fromSrcChannelId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _fromSrcChannelId_delegate$lambda$40;
            _fromSrcChannelId_delegate$lambda$40 = SaasVideoDetailModelWrapper._fromSrcChannelId_delegate$lambda$40();
            return _fromSrcChannelId_delegate$lambda$40;
        }
    });
    private final f _hasShowNextEpisodeAnim$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Boolean _hasShowNextEpisodeAnim_delegate$lambda$41;
            _hasShowNextEpisodeAnim_delegate$lambda$41 = SaasVideoDetailModelWrapper._hasShowNextEpisodeAnim_delegate$lambda$41();
            return _hasShowNextEpisodeAnim_delegate$lambda$41;
        }
    });
    private final f _payInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoPayInfo _payInfo_delegate$lambda$42;
            _payInfo_delegate$lambda$42 = SaasVideoDetailModelWrapper._payInfo_delegate$lambda$42();
            return _payInfo_delegate$lambda$42;
        }
    });
    private final h _hasHighlight$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _hasHighlight_delegate$lambda$43;
            _hasHighlight_delegate$lambda$43 = SaasVideoDetailModelWrapper._hasHighlight_delegate$lambda$43();
            return Boolean.valueOf(_hasHighlight_delegate$lambda$43);
        }
    });
    private final h _highlightSeriesId$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _highlightSeriesId_delegate$lambda$44;
            _highlightSeriesId_delegate$lambda$44 = SaasVideoDetailModelWrapper._highlightSeriesId_delegate$lambda$44();
            return _highlightSeriesId_delegate$lambda$44;
        }
    });
    private final h _highlightVid$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _highlightVid_delegate$lambda$45;
            _highlightVid_delegate$lambda$45 = SaasVideoDetailModelWrapper._highlightVid_delegate$lambda$45();
            return _highlightVid_delegate$lambda$45;
        }
    });
    private final h _canShowBackToStartBtn$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _canShowBackToStartBtn_delegate$lambda$46;
            _canShowBackToStartBtn_delegate$lambda$46 = SaasVideoDetailModelWrapper._canShowBackToStartBtn_delegate$lambda$46();
            return Boolean.valueOf(_canShowBackToStartBtn_delegate$lambda$46);
        }
    });
    private final h _showBackToStartBtnOnce$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _showBackToStartBtnOnce_delegate$lambda$47;
            _showBackToStartBtnOnce_delegate$lambda$47 = SaasVideoDetailModelWrapper._showBackToStartBtnOnce_delegate$lambda$47();
            return Boolean.valueOf(_showBackToStartBtnOnce_delegate$lambda$47);
        }
    });
    private final h _fromPrefetch$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _fromPrefetch_delegate$lambda$48;
            _fromPrefetch_delegate$lambda$48 = SaasVideoDetailModelWrapper._fromPrefetch_delegate$lambda$48();
            return Boolean.valueOf(_fromPrefetch_delegate$lambda$48);
        }
    });
    private final f _videoUpdateInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoUpdateInfo _videoUpdateInfo_delegate$lambda$49;
            _videoUpdateInfo_delegate$lambda$49 = SaasVideoDetailModelWrapper._videoUpdateInfo_delegate$lambda$49();
            return _videoUpdateInfo_delegate$lambda$49;
        }
    });
    private final h _episodeTotalCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int _episodeTotalCnt_delegate$lambda$50;
            _episodeTotalCnt_delegate$lambda$50 = SaasVideoDetailModelWrapper._episodeTotalCnt_delegate$lambda$50();
            return Integer.valueOf(_episodeTotalCnt_delegate$lambda$50);
        }
    });
    private final f _videoSelectPanelGuideText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _videoSelectPanelGuideText_delegate$lambda$51;
            _videoSelectPanelGuideText_delegate$lambda$51 = SaasVideoDetailModelWrapper._videoSelectPanelGuideText_delegate$lambda$51();
            return _videoSelectPanelGuideText_delegate$lambda$51;
        }
    });
    private final f _videoShareInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoShareInfo _videoShareInfo_delegate$lambda$52;
            _videoShareInfo_delegate$lambda$52 = SaasVideoDetailModelWrapper._videoShareInfo_delegate$lambda$52();
            return _videoShareInfo_delegate$lambda$52;
        }
    });
    private final f _celebrityList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _celebrityList_delegate$lambda$53;
            _celebrityList_delegate$lambda$53 = SaasVideoDetailModelWrapper._celebrityList_delegate$lambda$53();
            return _celebrityList_delegate$lambda$53;
        }
    });
    private final f _seriesSubTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _seriesSubTitleList_delegate$lambda$54;
            _seriesSubTitleList_delegate$lambda$54 = SaasVideoDetailModelWrapper._seriesSubTitleList_delegate$lambda$54();
            return _seriesSubTitleList_delegate$lambda$54;
        }
    });
    private final f _episodeListText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodeListText_delegate$lambda$55;
            _episodeListText_delegate$lambda$55 = SaasVideoDetailModelWrapper._episodeListText_delegate$lambda$55();
            return _episodeListText_delegate$lambda$55;
        }
    });
    private final f _episodeListBtnText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String _episodeListBtnText_delegate$lambda$56;
            _episodeListBtnText_delegate$lambda$56 = SaasVideoDetailModelWrapper._episodeListBtnText_delegate$lambda$56();
            return _episodeListBtnText_delegate$lambda$56;
        }
    });
    private final f _tabTrailerList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _tabTrailerList_delegate$lambda$57;
            _tabTrailerList_delegate$lambda$57 = SaasVideoDetailModelWrapper._tabTrailerList_delegate$lambda$57();
            return _tabTrailerList_delegate$lambda$57;
        }
    });
    private final h _hasAppendTrailer$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _hasAppendTrailer_delegate$lambda$58;
            _hasAppendTrailer_delegate$lambda$58 = SaasVideoDetailModelWrapper._hasAppendTrailer_delegate$lambda$58();
            return Boolean.valueOf(_hasAppendTrailer_delegate$lambda$58);
        }
    });
    private final h _postDataIndex$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int _postDataIndex_delegate$lambda$59;
            _postDataIndex_delegate$lambda$59 = SaasVideoDetailModelWrapper._postDataIndex_delegate$lambda$59();
            return Integer.valueOf(_postDataIndex_delegate$lambda$59);
        }
    });
    private final f _useStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UseStatus _useStatus_delegate$lambda$60;
            _useStatus_delegate$lambda$60 = SaasVideoDetailModelWrapper._useStatus_delegate$lambda$60();
            return _useStatus_delegate$lambda$60;
        }
    });
    private final h _inEpisodeEndInner$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _inEpisodeEndInner_delegate$lambda$61;
            _inEpisodeEndInner_delegate$lambda$61 = SaasVideoDetailModelWrapper._inEpisodeEndInner_delegate$lambda$61();
            return Boolean.valueOf(_inEpisodeEndInner_delegate$lambda$61);
        }
    });
    private final h _refreshFromInnerToOuter$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _refreshFromInnerToOuter_delegate$lambda$62;
            _refreshFromInnerToOuter_delegate$lambda$62 = SaasVideoDetailModelWrapper._refreshFromInnerToOuter_delegate$lambda$62();
            return Boolean.valueOf(_refreshFromInnerToOuter_delegate$lambda$62);
        }
    });
    private final h _slideToNewRecommendFeed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _slideToNewRecommendFeed_delegate$lambda$63;
            _slideToNewRecommendFeed_delegate$lambda$63 = SaasVideoDetailModelWrapper._slideToNewRecommendFeed_delegate$lambda$63();
            return Boolean.valueOf(_slideToNewRecommendFeed_delegate$lambda$63);
        }
    });
    private final f _videoTagInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaasVideoTagInfo _videoTagInfo_delegate$lambda$64;
            _videoTagInfo_delegate$lambda$64 = SaasVideoDetailModelWrapper._videoTagInfo_delegate$lambda$64();
            return _videoTagInfo_delegate$lambda$64;
        }
    });
    private final f _ugcUserInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UgcUserInfo _ugcUserInfo_delegate$lambda$65;
            _ugcUserInfo_delegate$lambda$65 = SaasVideoDetailModelWrapper._ugcUserInfo_delegate$lambda$65();
            return _ugcUserInfo_delegate$lambda$65;
        }
    });
    private final f _videoBottomBar$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaaSVideoBottomBar _videoBottomBar_delegate$lambda$66;
            _videoBottomBar_delegate$lambda$66 = SaasVideoDetailModelWrapper._videoBottomBar_delegate$lambda$66();
            return _videoBottomBar_delegate$lambda$66;
        }
    });
    private final h _relatedAlbumId$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long _relatedAlbumId_delegate$lambda$67;
            _relatedAlbumId_delegate$lambda$67 = SaasVideoDetailModelWrapper._relatedAlbumId_delegate$lambda$67();
            return Long.valueOf(_relatedAlbumId_delegate$lambda$67);
        }
    });
    private final f _bindVideoDetail$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaasVideoDetailModel _bindVideoDetail_delegate$lambda$68;
            _bindVideoDetail_delegate$lambda$68 = SaasVideoDetailModelWrapper._bindVideoDetail_delegate$lambda$68();
            return _bindVideoDetail_delegate$lambda$68;
        }
    });
    private final h _onlineSubscribed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _onlineSubscribed_delegate$lambda$69;
            _onlineSubscribed_delegate$lambda$69 = SaasVideoDetailModelWrapper._onlineSubscribed_delegate$lambda$69();
            return Boolean.valueOf(_onlineSubscribed_delegate$lambda$69);
        }
    });
    private final h _onlineTime$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long _onlineTime_delegate$lambda$70;
            _onlineTime_delegate$lambda$70 = SaasVideoDetailModelWrapper._onlineTime_delegate$lambda$70();
            return Long.valueOf(_onlineTime_delegate$lambda$70);
        }
    });
    private final f _videoRelateBook$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoRelateBook _videoRelateBook_delegate$lambda$71;
            _videoRelateBook_delegate$lambda$71 = SaasVideoDetailModelWrapper._videoRelateBook_delegate$lambda$71();
            return _videoRelateBook_delegate$lambda$71;
        }
    });
    private final h _canShowDownloadIcon$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _canShowDownloadIcon_delegate$lambda$72;
            _canShowDownloadIcon_delegate$lambda$72 = SaasVideoDetailModelWrapper._canShowDownloadIcon_delegate$lambda$72();
            return Boolean.valueOf(_canShowDownloadIcon_delegate$lambda$72);
        }
    });
    private final f _playerSerialVideoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _playerSerialVideoList_delegate$lambda$73;
            _playerSerialVideoList_delegate$lambda$73 = SaasVideoDetailModelWrapper._playerSerialVideoList_delegate$lambda$73();
            return _playerSerialVideoList_delegate$lambda$73;
        }
    });
    private final f _recTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _recTagList_delegate$lambda$74;
            _recTagList_delegate$lambda$74 = SaasVideoDetailModelWrapper._recTagList_delegate$lambda$74();
            return _recTagList_delegate$lambda$74;
        }
    });
    private final f _detailRecTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _detailRecTagList_delegate$lambda$75;
            _detailRecTagList_delegate$lambda$75 = SaasVideoDetailModelWrapper._detailRecTagList_delegate$lambda$75();
            return _detailRecTagList_delegate$lambda$75;
        }
    });
    private final f _bigImages$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _bigImages_delegate$lambda$76;
            _bigImages_delegate$lambda$76 = SaasVideoDetailModelWrapper._bigImages_delegate$lambda$76();
            return _bigImages_delegate$lambda$76;
        }
    });
    private final f _mainCreates$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _mainCreates_delegate$lambda$77;
            _mainCreates_delegate$lambda$77 = SaasVideoDetailModelWrapper._mainCreates_delegate$lambda$77();
            return _mainCreates_delegate$lambda$77;
        }
    });
    private final f _style$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaaSVideoDetailStyle _style_delegate$lambda$78;
            _style_delegate$lambda$78 = SaasVideoDetailModelWrapper._style_delegate$lambda$78();
            return _style_delegate$lambda$78;
        }
    });
    private final f _urgeUpdateData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SaasUrgeUpdateData _urgeUpdateData_delegate$lambda$79;
            _urgeUpdateData_delegate$lambda$79 = SaasVideoDetailModelWrapper._urgeUpdateData_delegate$lambda$79();
            return _urgeUpdateData_delegate$lambda$79;
        }
    });
    private final f _subTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List _subTitleList_delegate$lambda$80;
            _subTitleList_delegate$lambda$80 = SaasVideoDetailModelWrapper._subTitleList_delegate$lambda$80();
            return _subTitleList_delegate$lambda$80;
        }
    });
    private final h _supportListen$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean _supportListen_delegate$lambda$81;
            _supportListen_delegate$lambda$81 = SaasVideoDetailModelWrapper._supportListen_delegate$lambda$81();
            return Boolean.valueOf(_supportListen_delegate$lambda$81);
        }
    });
    private final f _rpcData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Serializable _rpcData_delegate$lambda$82;
            _rpcData_delegate$lambda$82 = SaasVideoDetailModelWrapper._rpcData_delegate$lambda$82();
            return _rpcData_delegate$lambda$82;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _abstractSecondaryInfoList_delegate$lambda$1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _bigImages_delegate$lambda$76() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoDetailModel _bindVideoDetail_delegate$lambda$68() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canShowBackToStartBtn_delegate$lambda$46() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canShowDownloadIcon_delegate$lambda$72() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _categorySchema_delegate$lambda$31() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _celebrityList_delegate$lambda$53() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoData _currentVideoData_delegate$lambda$6() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _detailRecTagList_delegate$lambda$75() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EpisodeLockData _dirData_delegate$lambda$32() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _directoryItems_delegate$lambda$33() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _disableInsertAd_delegate$lambda$35() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _duration_delegate$lambda$5() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _enableVisionProduct_delegate$lambda$23() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _episodeCnt_delegate$lambda$9() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodeListBtnText_delegate$lambda$56() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodeListText_delegate$lambda$55() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _episodeTotalCnt_delegate$lambda$50() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesCover_delegate$lambda$19() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesId_delegate$lambda$10() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesIntroduction_delegate$lambda$29() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesListCountText_delegate$lambda$28() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _episodesListWithTrailAfterCut_delegate$lambda$25() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _episodesList_delegate$lambda$14() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _episodesPlayCount_delegate$lambda$27() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesStatus _episodesStatus_delegate$lambda$8() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesTitle_delegate$lambda$7() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _followedCnt_delegate$lambda$12() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _followed_delegate$lambda$11() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _fromPlayListId_delegate$lambda$39() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _fromPrefetch_delegate$lambda$48() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _fromSrcChannelId_delegate$lambda$40() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _fromSrcMaterialId_delegate$lambda$38() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _hasAppendTrailer_delegate$lambda$58() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _hasHighlight_delegate$lambda$43() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean _hasShowNextEpisodeAnim_delegate$lambda$41() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _highlightSeriesId_delegate$lambda$44() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _highlightVid_delegate$lambda$45() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoHighlight _highlight_delegate$lambda$34() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _inEpisodeEndInner_delegate$lambda$61() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _insertAdRitType_delegate$lambda$24() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _localList_delegate$lambda$13() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _mainCreates_delegate$lambda$77() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _onlineSubscribed_delegate$lambda$69() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _onlineTime_delegate$lambda$70() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPayInfo _payInfo_delegate$lambda$42() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _playerSerialVideoList_delegate$lambda$73() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _postDataIndex_delegate$lambda$59() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _recTagList_delegate$lambda$74() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _recommendGroupId_delegate$lambda$37() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _recommendInfo_delegate$lambda$36() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _refreshFromInnerToOuter_delegate$lambda$62() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _relatedAlbumId_delegate$lambda$67() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _relatedMaterialId_delegate$lambda$3() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Serializable _rpcData_delegate$lambda$82() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _secondaryInfoList_delegate$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _seriesColorHex_delegate$lambda$16() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _seriesIntro_delegate$lambda$26() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _seriesSubTitleList_delegate$lambda$54() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _showBackToStartBtnOnce_delegate$lambda$47() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _showMaterialGuidanceAnim_delegate$lambda$2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _slideToNewRecommendFeed_delegate$lambda$63() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _smallEpisodesCover_delegate$lambda$20() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaaSVideoDetailStyle _style_delegate$lambda$78() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _subTitleList_delegate$lambda$80() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _supportListen_delegate$lambda$81() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _tabTrailerList_delegate$lambda$57() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _trailerList_delegate$lambda$15() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _ugcRelated_delegate$lambda$22() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UgcUserInfo _ugcUserInfo_delegate$lambda$65() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _updateTag_delegate$lambda$18() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasUrgeUpdateData _urgeUpdateData_delegate$lambda$79() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UseStatus _useStatus_delegate$lambda$60() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaaSVideoBottomBar _videoBottomBar_delegate$lambda$66() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoContentType _videoContentType_delegate$lambda$4() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlatformType _videoPlatformType_delegate$lambda$30() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoRecordInfo _videoRecordInfo_delegate$lambda$21() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoRelateBook _videoRelateBook_delegate$lambda$71() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _videoSelectPanelGuideText_delegate$lambda$51() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoShareInfo _videoShareInfo_delegate$lambda$52() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoTagInfo _videoTagInfo_delegate$lambda$64() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoUpdateInfo _videoUpdateInfo_delegate$lambda$49() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _episodesListWithTrail_delegate$lambda$17() {
        return new ArrayList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SecondaryInfo> getAbstractSecondaryInfoList() {
        return get_abstractSecondaryInfoList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<String> getBigImages() {
        return get_bigImages();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaasVideoDetailModel getBindVideoDetail() {
        return get_bindVideoDetail();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasCategorySchema> getCategorySchema() {
        return get_categorySchema();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<Celebrity> getCelebrityList() {
        return get_celebrityList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SecondaryInfo> getDetailRecTagList() {
        return get_detailRecTagList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public EpisodeLockData getDirData() {
        return get_dirData();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoDirectoryItem> getDirectoryItems() {
        return get_directoryItems();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public long getDuration() {
        return get_duration();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel, com.dragon.read.component.shortvideo.data.saas.video.b
    public int getEpisodeCnt() {
        return get_episodeCnt();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodeListBtnText() {
        return get_episodeListBtnText();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodeListText() {
        return get_episodeListText();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public int getEpisodeTotalCnt() {
        return get_episodeTotalCnt();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodesCover() {
        return get_episodesCover();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodesId() {
        return get_episodesId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodesIntroduction() {
        return get_episodesIntroduction();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoData> getEpisodesList() {
        return get_episodesList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodesListCountText() {
        return get_episodesListCountText();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoData> getEpisodesListWithTrail() {
        return get_episodesListWithTrail();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoData> getEpisodesListWithTrailAfterCut() {
        return get_episodesListWithTrailAfterCut();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public long getEpisodesPlayCount() {
        return get_episodesPlayCount();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel, com.dragon.read.component.shortvideo.data.saas.video.b
    public SeriesStatus getEpisodesStatus() {
        return get_episodesStatus();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getEpisodesTitle() {
        return get_episodesTitle();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public long getFollowedCnt() {
        return get_followedCnt();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getFromPlayListId() {
        return get_fromPlayListId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getFromSrcChannelId() {
        return get_fromSrcChannelId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getFromSrcMaterialId() {
        return get_fromSrcMaterialId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean getHasAppendTrailer() {
        return get_hasAppendTrailer();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public Boolean getHasShowNextEpisodeAnim() {
        return get_hasShowNextEpisodeAnim();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaasVideoHighlight getHighlight() {
        return get_highlight();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getHighlightSeriesId() {
        return get_highlightSeriesId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getHighlightVid() {
        return get_highlightVid();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public int getInsertAdRitType() {
        return get_insertAdRitType();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<UgcUserInfo> getMainCreates() {
        return get_mainCreates();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public long getOnlineTime() {
        return get_onlineTime();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoPayInfo getPayInfo() {
        return get_payInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoData> getPlayerSerialVideoList() {
        return get_playerSerialVideoList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public int getPostDataIndex() {
        return get_postDataIndex();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SecondaryInfo> getRecTagList() {
        return get_recTagList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getRecommendGroupId() {
        return get_recommendGroupId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getRecommendInfo() {
        return get_recommendInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean getRefreshFromInnerToOuter() {
        return get_refreshFromInnerToOuter();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public long getRelatedAlbumId() {
        return get_relatedAlbumId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getRelatedMaterialId() {
        return get_relatedMaterialId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public Serializable getRpcData() {
        return get_rpcData();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SecondaryInfo> getSecondaryInfoList() {
        return get_secondaryInfoList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getSeriesColorHex() {
        return get_seriesColorHex();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getSeriesIntro() {
        return get_seriesIntro();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<String> getSeriesSubTitleList() {
        return get_seriesSubTitleList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getSmallEpisodesCover() {
        return get_smallEpisodesCover();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaaSVideoDetailStyle getStyle() {
        return get_style();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SecondaryInfo> getSubTitleList() {
        return get_subTitleList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<Serializable> getTabTrailerList() {
        return get_tabTrailerList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public List<SaasVideoData> getTrailerList() {
        return get_trailerList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public UgcUserInfo getUgcUserInfo() {
        return get_ugcUserInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getUpdateTag() {
        return get_updateTag();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaasUrgeUpdateData getUrgeUpdateData() {
        return get_urgeUpdateData();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public UseStatus getUseStatus() {
        return get_useStatus();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaaSVideoBottomBar getVideoBottomBar() {
        return get_videoBottomBar();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel, com.dragon.read.component.shortvideo.data.saas.video.b
    public VideoContentType getVideoContentType() {
        return get_videoContentType();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoPlatformType getVideoPlatformType() {
        return get_videoPlatformType();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoRecordInfo getVideoRecordInfo() {
        return get_videoRecordInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoRelateBook getVideoRelateBook() {
        return get_videoRelateBook();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public String getVideoSelectPanelGuideText() {
        return get_videoSelectPanelGuideText();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoShareInfo getVideoShareInfo() {
        return get_videoShareInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public SaasVideoTagInfo getVideoTagInfo() {
        return get_videoTagInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public VideoUpdateInfo getVideoUpdateInfo() {
        return get_videoUpdateInfo();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isCanShowBackToStartBtn() {
        return get_canShowBackToStartBtn();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isCanShowDownloadIcon() {
        return get_canShowDownloadIcon();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isDisableInsertAd() {
        return get_disableInsertAd();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isEnableVisionProduct() {
        return get_enableVisionProduct();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isFollowed() {
        return get_followed();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isFromPrefetch() {
        return get_fromPrefetch();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isHasHighlight() {
        return get_hasHighlight();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isInEpisodeEndInner() {
        return get_inEpisodeEndInner();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isLocalList() {
        return get_localList();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isOnlineSubscribed() {
        return get_onlineSubscribed();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isShowBackToStartBtnOnce() {
        return get_showBackToStartBtnOnce();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isShowMaterialGuidanceAnim() {
        return get_showMaterialGuidanceAnim();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isSlideToNewRecommendFeed() {
        return get_slideToNewRecommendFeed();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isSupportListen() {
        return get_supportListen();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public boolean isUgcRelated() {
        return get_ugcRelated();
    }

    protected List<SecondaryInfo> get_abstractSecondaryInfoList() {
        return (List) this._abstractSecondaryInfoList$delegate.d(this, $$delegatedProperties[1]);
    }

    protected List<String> get_bigImages() {
        return (List) this._bigImages$delegate.d(this, $$delegatedProperties[76]);
    }

    protected SaasVideoDetailModel get_bindVideoDetail() {
        return (SaasVideoDetailModel) this._bindVideoDetail$delegate.d(this, $$delegatedProperties[68]);
    }

    protected List<SaasCategorySchema> get_categorySchema() {
        return (List) this._categorySchema$delegate.d(this, $$delegatedProperties[31]);
    }

    protected List<Celebrity> get_celebrityList() {
        return (List) this._celebrityList$delegate.d(this, $$delegatedProperties[53]);
    }

    protected SaasVideoData get_currentVideoData() {
        return (SaasVideoData) this._currentVideoData$delegate.d(this, $$delegatedProperties[6]);
    }

    protected List<SecondaryInfo> get_detailRecTagList() {
        return (List) this._detailRecTagList$delegate.d(this, $$delegatedProperties[75]);
    }

    protected EpisodeLockData get_dirData() {
        return (EpisodeLockData) this._dirData$delegate.d(this, $$delegatedProperties[32]);
    }

    protected List<SaasVideoDirectoryItem> get_directoryItems() {
        return (List) this._directoryItems$delegate.d(this, $$delegatedProperties[33]);
    }

    protected String get_episodeListBtnText() {
        return (String) this._episodeListBtnText$delegate.d(this, $$delegatedProperties[56]);
    }

    protected String get_episodeListText() {
        return (String) this._episodeListText$delegate.d(this, $$delegatedProperties[55]);
    }

    protected String get_episodesCover() {
        return (String) this._episodesCover$delegate.d(this, $$delegatedProperties[19]);
    }

    protected String get_episodesId() {
        return (String) this._episodesId$delegate.d(this, $$delegatedProperties[10]);
    }

    protected String get_episodesIntroduction() {
        return (String) this._episodesIntroduction$delegate.d(this, $$delegatedProperties[29]);
    }

    protected List<SaasVideoData> get_episodesList() {
        return (List) this._episodesList$delegate.d(this, $$delegatedProperties[14]);
    }

    protected String get_episodesListCountText() {
        return (String) this._episodesListCountText$delegate.d(this, $$delegatedProperties[28]);
    }

    protected List<SaasVideoData> get_episodesListWithTrail() {
        return (List) this._episodesListWithTrail$delegate.d(this, $$delegatedProperties[17]);
    }

    protected List<SaasVideoData> get_episodesListWithTrailAfterCut() {
        return (List) this._episodesListWithTrailAfterCut$delegate.d(this, $$delegatedProperties[25]);
    }

    protected SeriesStatus get_episodesStatus() {
        return (SeriesStatus) this._episodesStatus$delegate.d(this, $$delegatedProperties[8]);
    }

    protected String get_episodesTitle() {
        return (String) this._episodesTitle$delegate.d(this, $$delegatedProperties[7]);
    }

    protected String get_fromPlayListId() {
        return (String) this._fromPlayListId$delegate.d(this, $$delegatedProperties[39]);
    }

    protected String get_fromSrcChannelId() {
        return (String) this._fromSrcChannelId$delegate.d(this, $$delegatedProperties[40]);
    }

    protected String get_fromSrcMaterialId() {
        return (String) this._fromSrcMaterialId$delegate.d(this, $$delegatedProperties[38]);
    }

    protected Boolean get_hasShowNextEpisodeAnim() {
        return (Boolean) this._hasShowNextEpisodeAnim$delegate.d(this, $$delegatedProperties[41]);
    }

    protected SaasVideoHighlight get_highlight() {
        return (SaasVideoHighlight) this._highlight$delegate.d(this, $$delegatedProperties[34]);
    }

    protected String get_highlightSeriesId() {
        return (String) this._highlightSeriesId$delegate.d(this, $$delegatedProperties[44]);
    }

    protected String get_highlightVid() {
        return (String) this._highlightVid$delegate.d(this, $$delegatedProperties[45]);
    }

    protected List<UgcUserInfo> get_mainCreates() {
        return (List) this._mainCreates$delegate.d(this, $$delegatedProperties[77]);
    }

    protected VideoPayInfo get_payInfo() {
        return (VideoPayInfo) this._payInfo$delegate.d(this, $$delegatedProperties[42]);
    }

    protected List<SaasVideoData> get_playerSerialVideoList() {
        return (List) this._playerSerialVideoList$delegate.d(this, $$delegatedProperties[73]);
    }

    protected List<SecondaryInfo> get_recTagList() {
        return (List) this._recTagList$delegate.d(this, $$delegatedProperties[74]);
    }

    protected String get_recommendGroupId() {
        return (String) this._recommendGroupId$delegate.d(this, $$delegatedProperties[37]);
    }

    protected String get_recommendInfo() {
        return (String) this._recommendInfo$delegate.d(this, $$delegatedProperties[36]);
    }

    protected String get_relatedMaterialId() {
        return (String) this._relatedMaterialId$delegate.d(this, $$delegatedProperties[3]);
    }

    protected Serializable get_rpcData() {
        return (Serializable) this._rpcData$delegate.d(this, $$delegatedProperties[82]);
    }

    protected List<SecondaryInfo> get_secondaryInfoList() {
        return (List) this._secondaryInfoList$delegate.d(this, $$delegatedProperties[0]);
    }

    protected String get_seriesColorHex() {
        return (String) this._seriesColorHex$delegate.d(this, $$delegatedProperties[16]);
    }

    protected String get_seriesIntro() {
        return (String) this._seriesIntro$delegate.d(this, $$delegatedProperties[26]);
    }

    protected List<String> get_seriesSubTitleList() {
        return (List) this._seriesSubTitleList$delegate.d(this, $$delegatedProperties[54]);
    }

    protected String get_smallEpisodesCover() {
        return (String) this._smallEpisodesCover$delegate.d(this, $$delegatedProperties[20]);
    }

    protected SaaSVideoDetailStyle get_style() {
        return (SaaSVideoDetailStyle) this._style$delegate.d(this, $$delegatedProperties[78]);
    }

    protected List<SecondaryInfo> get_subTitleList() {
        return (List) this._subTitleList$delegate.d(this, $$delegatedProperties[80]);
    }

    protected List<Serializable> get_tabTrailerList() {
        return (List) this._tabTrailerList$delegate.d(this, $$delegatedProperties[57]);
    }

    protected List<SaasVideoData> get_trailerList() {
        return (List) this._trailerList$delegate.d(this, $$delegatedProperties[15]);
    }

    protected UgcUserInfo get_ugcUserInfo() {
        return (UgcUserInfo) this._ugcUserInfo$delegate.d(this, $$delegatedProperties[65]);
    }

    protected String get_updateTag() {
        return (String) this._updateTag$delegate.d(this, $$delegatedProperties[18]);
    }

    protected SaasUrgeUpdateData get_urgeUpdateData() {
        return (SaasUrgeUpdateData) this._urgeUpdateData$delegate.d(this, $$delegatedProperties[79]);
    }

    protected UseStatus get_useStatus() {
        return (UseStatus) this._useStatus$delegate.d(this, $$delegatedProperties[60]);
    }

    protected SaaSVideoBottomBar get_videoBottomBar() {
        return (SaaSVideoBottomBar) this._videoBottomBar$delegate.d(this, $$delegatedProperties[66]);
    }

    protected VideoContentType get_videoContentType() {
        return (VideoContentType) this._videoContentType$delegate.d(this, $$delegatedProperties[4]);
    }

    protected VideoPlatformType get_videoPlatformType() {
        return (VideoPlatformType) this._videoPlatformType$delegate.d(this, $$delegatedProperties[30]);
    }

    protected VideoRecordInfo get_videoRecordInfo() {
        return (VideoRecordInfo) this._videoRecordInfo$delegate.d(this, $$delegatedProperties[21]);
    }

    protected VideoRelateBook get_videoRelateBook() {
        return (VideoRelateBook) this._videoRelateBook$delegate.d(this, $$delegatedProperties[71]);
    }

    protected String get_videoSelectPanelGuideText() {
        return (String) this._videoSelectPanelGuideText$delegate.d(this, $$delegatedProperties[51]);
    }

    protected VideoShareInfo get_videoShareInfo() {
        return (VideoShareInfo) this._videoShareInfo$delegate.d(this, $$delegatedProperties[52]);
    }

    protected SaasVideoTagInfo get_videoTagInfo() {
        return (SaasVideoTagInfo) this._videoTagInfo$delegate.d(this, $$delegatedProperties[64]);
    }

    protected VideoUpdateInfo get_videoUpdateInfo() {
        return (VideoUpdateInfo) this._videoUpdateInfo$delegate.d(this, $$delegatedProperties[49]);
    }

    protected boolean get_canShowBackToStartBtn() {
        return ((Boolean) this._canShowBackToStartBtn$delegate.d(this, $$delegatedProperties[46])).booleanValue();
    }

    protected boolean get_canShowDownloadIcon() {
        return ((Boolean) this._canShowDownloadIcon$delegate.d(this, $$delegatedProperties[72])).booleanValue();
    }

    protected boolean get_disableInsertAd() {
        return ((Boolean) this._disableInsertAd$delegate.d(this, $$delegatedProperties[35])).booleanValue();
    }

    protected long get_duration() {
        return ((Number) this._duration$delegate.d(this, $$delegatedProperties[5])).longValue();
    }

    protected boolean get_enableVisionProduct() {
        return ((Boolean) this._enableVisionProduct$delegate.d(this, $$delegatedProperties[23])).booleanValue();
    }

    protected int get_episodeCnt() {
        return ((Number) this._episodeCnt$delegate.d(this, $$delegatedProperties[9])).intValue();
    }

    protected int get_episodeTotalCnt() {
        return ((Number) this._episodeTotalCnt$delegate.d(this, $$delegatedProperties[50])).intValue();
    }

    protected long get_episodesPlayCount() {
        return ((Number) this._episodesPlayCount$delegate.d(this, $$delegatedProperties[27])).longValue();
    }

    protected boolean get_followed() {
        return ((Boolean) this._followed$delegate.d(this, $$delegatedProperties[11])).booleanValue();
    }

    protected long get_followedCnt() {
        return ((Number) this._followedCnt$delegate.d(this, $$delegatedProperties[12])).longValue();
    }

    protected boolean get_fromPrefetch() {
        return ((Boolean) this._fromPrefetch$delegate.d(this, $$delegatedProperties[48])).booleanValue();
    }

    protected boolean get_hasAppendTrailer() {
        return ((Boolean) this._hasAppendTrailer$delegate.d(this, $$delegatedProperties[58])).booleanValue();
    }

    protected boolean get_hasHighlight() {
        return ((Boolean) this._hasHighlight$delegate.d(this, $$delegatedProperties[43])).booleanValue();
    }

    protected boolean get_inEpisodeEndInner() {
        return ((Boolean) this._inEpisodeEndInner$delegate.d(this, $$delegatedProperties[61])).booleanValue();
    }

    protected int get_insertAdRitType() {
        return ((Number) this._insertAdRitType$delegate.d(this, $$delegatedProperties[24])).intValue();
    }

    protected boolean get_localList() {
        return ((Boolean) this._localList$delegate.d(this, $$delegatedProperties[13])).booleanValue();
    }

    protected boolean get_onlineSubscribed() {
        return ((Boolean) this._onlineSubscribed$delegate.d(this, $$delegatedProperties[69])).booleanValue();
    }

    protected long get_onlineTime() {
        return ((Number) this._onlineTime$delegate.d(this, $$delegatedProperties[70])).longValue();
    }

    protected int get_postDataIndex() {
        return ((Number) this._postDataIndex$delegate.d(this, $$delegatedProperties[59])).intValue();
    }

    protected boolean get_refreshFromInnerToOuter() {
        return ((Boolean) this._refreshFromInnerToOuter$delegate.d(this, $$delegatedProperties[62])).booleanValue();
    }

    protected long get_relatedAlbumId() {
        return ((Number) this._relatedAlbumId$delegate.d(this, $$delegatedProperties[67])).longValue();
    }

    protected boolean get_showBackToStartBtnOnce() {
        return ((Boolean) this._showBackToStartBtnOnce$delegate.d(this, $$delegatedProperties[47])).booleanValue();
    }

    protected boolean get_showMaterialGuidanceAnim() {
        return ((Boolean) this._showMaterialGuidanceAnim$delegate.d(this, $$delegatedProperties[2])).booleanValue();
    }

    protected boolean get_slideToNewRecommendFeed() {
        return ((Boolean) this._slideToNewRecommendFeed$delegate.d(this, $$delegatedProperties[63])).booleanValue();
    }

    protected boolean get_supportListen() {
        return ((Boolean) this._supportListen$delegate.d(this, $$delegatedProperties[81])).booleanValue();
    }

    protected boolean get_ugcRelated() {
        return ((Boolean) this._ugcRelated$delegate.d(this, $$delegatedProperties[22])).booleanValue();
    }

    public final void loadVideoDataInfo() {
        for (SaasVideoData saasVideoData : get_episodesListWithTrail()) {
            saasVideoData.setVideoDetailModelVertical(Boolean.valueOf(saasVideoData.isVertical()));
        }
        List<SaasVideoData> list = get_episodesList();
        if (list != null) {
            for (SaasVideoData saasVideoData2 : list) {
                saasVideoData2.setVideoDetailModelVertical(Boolean.valueOf(saasVideoData2.isVertical()));
            }
        }
        List<SaasVideoData> list2 = get_trailerList();
        if (list2 != null) {
            for (SaasVideoData saasVideoData3 : list2) {
                saasVideoData3.setVideoDetailModelVertical(Boolean.valueOf(saasVideoData3.isVertical()));
            }
        }
    }

    static {
        Covode.recordClassIndex(599123);
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_secondaryInfoList", "get_secondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_abstractSecondaryInfoList", "get_abstractSecondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_showMaterialGuidanceAnim", "get_showMaterialGuidanceAnim()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_relatedMaterialId", "get_relatedMaterialId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoContentType", "get_videoContentType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoContentType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_duration", "get_duration()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_currentVideoData", "get_currentVideoData()Lcom/dragon/read/component/shortvideo/data/saas/video/SaasVideoData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesTitle", "get_episodesTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesStatus", "get_episodesStatus()Lseriessdk/com/dragon/read/saas/rpc/model/SeriesStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodeCnt", "get_episodeCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesId", "get_episodesId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_followed", "get_followed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_followedCnt", "get_followedCnt()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_localList", "get_localList()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesList", "get_episodesList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_trailerList", "get_trailerList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_seriesColorHex", "get_seriesColorHex()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesListWithTrail", "get_episodesListWithTrail()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_updateTag", "get_updateTag()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesCover", "get_episodesCover()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_smallEpisodesCover", "get_smallEpisodesCover()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoRecordInfo", "get_videoRecordInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoRecordInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_ugcRelated", "get_ugcRelated()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_enableVisionProduct", "get_enableVisionProduct()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_insertAdRitType", "get_insertAdRitType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesListWithTrailAfterCut", "get_episodesListWithTrailAfterCut()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_seriesIntro", "get_seriesIntro()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesPlayCount", "get_episodesPlayCount()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesListCountText", "get_episodesListCountText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodesIntroduction", "get_episodesIntroduction()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoPlatformType", "get_videoPlatformType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPlatformType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_categorySchema", "get_categorySchema()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_dirData", "get_dirData()Lseriessdk/com/dragon/read/saas/rpc/model/EpisodeLockData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_directoryItems", "get_directoryItems()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_highlight", "get_highlight()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaasVideoHighlight;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_disableInsertAd", "get_disableInsertAd()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_recommendInfo", "get_recommendInfo()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_recommendGroupId", "get_recommendGroupId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_fromSrcMaterialId", "get_fromSrcMaterialId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_fromPlayListId", "get_fromPlayListId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_fromSrcChannelId", "get_fromSrcChannelId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_hasShowNextEpisodeAnim", "get_hasShowNextEpisodeAnim()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_payInfo", "get_payInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPayInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_hasHighlight", "get_hasHighlight()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_highlightSeriesId", "get_highlightSeriesId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_highlightVid", "get_highlightVid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_canShowBackToStartBtn", "get_canShowBackToStartBtn()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_showBackToStartBtnOnce", "get_showBackToStartBtnOnce()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_fromPrefetch", "get_fromPrefetch()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoUpdateInfo", "get_videoUpdateInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoUpdateInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodeTotalCnt", "get_episodeTotalCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoSelectPanelGuideText", "get_videoSelectPanelGuideText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoShareInfo", "get_videoShareInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoShareInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_celebrityList", "get_celebrityList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_seriesSubTitleList", "get_seriesSubTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodeListText", "get_episodeListText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_episodeListBtnText", "get_episodeListBtnText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_tabTrailerList", "get_tabTrailerList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_hasAppendTrailer", "get_hasAppendTrailer()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_postDataIndex", "get_postDataIndex()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_useStatus", "get_useStatus()Lseriessdk/com/dragon/read/saas/rpc/model/UseStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_inEpisodeEndInner", "get_inEpisodeEndInner()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_refreshFromInnerToOuter", "get_refreshFromInnerToOuter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_slideToNewRecommendFeed", "get_slideToNewRecommendFeed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoTagInfo", "get_videoTagInfo()Lcom/dragon/read/component/shortvideo/data/saas/model/videotag/SaasVideoTagInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_ugcUserInfo", "get_ugcUserInfo()Lseriessdk/com/dragon/read/saas/rpc/model/UgcUserInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoBottomBar", "get_videoBottomBar()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaaSVideoBottomBar;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_relatedAlbumId", "get_relatedAlbumId()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_bindVideoDetail", "get_bindVideoDetail()Lcom/dragon/read/component/shortvideo/data/saas/video/SaasVideoDetailModel;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_onlineSubscribed", "get_onlineSubscribed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_onlineTime", "get_onlineTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_videoRelateBook", "get_videoRelateBook()Lseriessdk/com/dragon/read/saas/rpc/model/VideoRelateBook;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_canShowDownloadIcon", "get_canShowDownloadIcon()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_playerSerialVideoList", "get_playerSerialVideoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_recTagList", "get_recTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_detailRecTagList", "get_detailRecTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_bigImages", "get_bigImages()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_mainCreates", "get_mainCreates()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_style", "get_style()Lseriessdk/com/dragon/read/saas/rpc/model/SaaSVideoDetailStyle;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_urgeUpdateData", "get_urgeUpdateData()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaasUrgeUpdateData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_subTitleList", "get_subTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_supportListen", "get_supportListen()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasVideoDetailModelWrapper.class, "_rpcData", "get_rpcData()Ljava/io/Serializable;", 0))};
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setAbstractSecondaryInfoList(List<? extends SecondaryInfo> list) {
        set_abstractSecondaryInfoList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setBigImages(List<String> list) {
        set_bigImages(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setBindVideoDetail(SaasVideoDetailModel saasVideoDetailModel) {
        set_bindVideoDetail(saasVideoDetailModel);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setCanShowBackToStartBtn(boolean z) {
        set_canShowBackToStartBtn(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setCanShowDownloadIcon(boolean z) {
        set_canShowDownloadIcon(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setCategorySchema(List<? extends SaasCategorySchema> list) {
        set_categorySchema(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setCelebrityList(List<? extends Celebrity> list) {
        set_celebrityList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setDetailRecTagList(List<? extends SecondaryInfo> list) {
        set_detailRecTagList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setDirData(EpisodeLockData episodeLockData) {
        set_dirData(episodeLockData);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setDirectoryItems(List<? extends SaasVideoDirectoryItem> list) {
        set_directoryItems(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setDisableInsertAd(boolean z) {
        set_disableInsertAd(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setDuration(long j) {
        set_duration(j);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEnableVisionProduct(boolean z) {
        set_enableVisionProduct(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodeCnt(int i) {
        set_episodeCnt(i);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodeListBtnText(String str) {
        set_episodeListBtnText(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodeListText(String str) {
        set_episodeListText(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodeTotalCnt(int i) {
        set_episodeTotalCnt(i);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesCover(String str) {
        set_episodesCover(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesId(String str) {
        set_episodesId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesIntroduction(String str) {
        set_episodesIntroduction(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesListCountText(String str) {
        set_episodesListCountText(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesListWithTrailAfterCut(List<? extends SaasVideoData> list) {
        set_episodesListWithTrailAfterCut(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesPlayCount(long j) {
        set_episodesPlayCount(j);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesStatus(SeriesStatus seriesStatus) {
        set_episodesStatus(seriesStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setEpisodesTitle(String str) {
        set_episodesTitle(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFollowed(boolean z) {
        set_followed(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFollowedCnt(long j) {
        set_followedCnt(j);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFromPlayListId(String str) {
        set_fromPlayListId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFromPrefetch(boolean z) {
        set_fromPrefetch(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFromSrcChannelId(String str) {
        set_fromSrcChannelId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setFromSrcMaterialId(String str) {
        set_fromSrcMaterialId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHasAppendTrailer(boolean z) {
        set_hasAppendTrailer(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHasHighlight(boolean z) {
        set_hasHighlight(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHasShowNextEpisodeAnim(Boolean bool) {
        set_hasShowNextEpisodeAnim(bool);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHighlight(SaasVideoHighlight saasVideoHighlight) {
        set_highlight(saasVideoHighlight);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setInEpisodeEndInner(boolean z) {
        set_inEpisodeEndInner(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setInsertAdRitType(int i) {
        set_insertAdRitType(i);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setLocalList(boolean z) {
        set_localList(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setMainCreates(List<? extends UgcUserInfo> list) {
        set_mainCreates(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setOnlineSubscribed(boolean z) {
        set_onlineSubscribed(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setOnlineTime(long j) {
        set_onlineTime(j);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setPayInfo(VideoPayInfo videoPayInfo) {
        set_payInfo(videoPayInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setPlayerSerialVideoList(List<? extends SaasVideoData> list) {
        set_playerSerialVideoList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setPostDataIndex(int i) {
        set_postDataIndex(i);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRecTagList(List<? extends SecondaryInfo> list) {
        set_recTagList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRecommendGroupId(String str) {
        set_recommendGroupId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRecommendInfo(String str) {
        set_recommendInfo(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRefreshFromInnerToOuter(boolean z) {
        set_refreshFromInnerToOuter(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRelatedAlbumId(long j) {
        set_relatedAlbumId(j);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRelatedMaterialId(String str) {
        set_relatedMaterialId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setRpcData(Serializable serializable) {
        set_rpcData(serializable);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSecondaryInfoList(List<? extends SecondaryInfo> list) {
        set_secondaryInfoList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSeriesIntro(String str) {
        set_seriesIntro(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSeriesSubTitleList(List<String> list) {
        set_seriesSubTitleList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setShowBackToStartBtnOnce(boolean z) {
        set_showBackToStartBtnOnce(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setShowMaterialGuidanceAnim(boolean z) {
        set_showMaterialGuidanceAnim(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSlideToNewRecommendFeed(boolean z) {
        set_slideToNewRecommendFeed(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSmallEpisodesCover(String str) {
        set_smallEpisodesCover(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setStyle(SaaSVideoDetailStyle saaSVideoDetailStyle) {
        set_style(saaSVideoDetailStyle);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSubTitleList(List<? extends SecondaryInfo> list) {
        set_subTitleList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSupportListen(boolean z) {
        set_supportListen(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setTabTrailerList(List<? extends Serializable> list) {
        set_tabTrailerList(list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setUgcRelated(boolean z) {
        set_ugcRelated(z);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setUgcUserInfo(UgcUserInfo ugcUserInfo) {
        set_ugcUserInfo(ugcUserInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setUpdateTag(String str) {
        set_updateTag(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setUrgeUpdateData(SaasUrgeUpdateData saasUrgeUpdateData) {
        set_urgeUpdateData(saasUrgeUpdateData);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setUseStatus(UseStatus useStatus) {
        set_useStatus(useStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        set_videoBottomBar(saaSVideoBottomBar);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoContentType(VideoContentType videoContentType) {
        set_videoContentType(videoContentType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoPlatformType(VideoPlatformType videoPlatformType) {
        set_videoPlatformType(videoPlatformType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoRecordInfo(VideoRecordInfo videoRecordInfo) {
        set_videoRecordInfo(videoRecordInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoRelateBook(VideoRelateBook videoRelateBook) {
        set_videoRelateBook(videoRelateBook);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoSelectPanelGuideText(String str) {
        set_videoSelectPanelGuideText(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoShareInfo(VideoShareInfo videoShareInfo) {
        set_videoShareInfo(videoShareInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        set_videoTagInfo(saasVideoTagInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setVideoUpdateInfo(VideoUpdateInfo videoUpdateInfo) {
        set_videoUpdateInfo(videoUpdateInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHighlightSeriesId(String str) {
        if (str == null) {
            str = "";
        }
        set_highlightSeriesId(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setHighlightVid(String str) {
        if (str == null) {
            str = "";
        }
        set_highlightVid(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public void setSeriesColorHex(String str) {
        if (str == null) {
            str = "";
        }
        set_seriesColorHex(str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public final void setEpisodesList(List<? extends SaasVideoData> list) {
        set_episodesList(list);
        if (list != null) {
            get_episodesListWithTrail().addAll(list);
        }
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public final void setTrailerList(List<? extends SaasVideoData> list) {
        set_trailerList(list);
        if (list != null) {
            get_episodesListWithTrail().addAll(0, list);
        }
    }

    protected void set_abstractSecondaryInfoList(List<? extends SecondaryInfo> list) {
        this._abstractSecondaryInfoList$delegate.e(this, $$delegatedProperties[1], list);
    }

    protected void set_bigImages(List<String> list) {
        this._bigImages$delegate.e(this, $$delegatedProperties[76], list);
    }

    protected void set_bindVideoDetail(SaasVideoDetailModel saasVideoDetailModel) {
        this._bindVideoDetail$delegate.e(this, $$delegatedProperties[68], saasVideoDetailModel);
    }

    protected void set_canShowBackToStartBtn(boolean z) {
        this._canShowBackToStartBtn$delegate.e(this, $$delegatedProperties[46], Boolean.valueOf(z));
    }

    protected void set_canShowDownloadIcon(boolean z) {
        this._canShowDownloadIcon$delegate.e(this, $$delegatedProperties[72], Boolean.valueOf(z));
    }

    protected void set_categorySchema(List<? extends SaasCategorySchema> list) {
        this._categorySchema$delegate.e(this, $$delegatedProperties[31], list);
    }

    protected void set_celebrityList(List<? extends Celebrity> list) {
        this._celebrityList$delegate.e(this, $$delegatedProperties[53], list);
    }

    protected void set_currentVideoData(SaasVideoData saasVideoData) {
        this._currentVideoData$delegate.e(this, $$delegatedProperties[6], saasVideoData);
    }

    protected void set_detailRecTagList(List<? extends SecondaryInfo> list) {
        this._detailRecTagList$delegate.e(this, $$delegatedProperties[75], list);
    }

    protected void set_dirData(EpisodeLockData episodeLockData) {
        this._dirData$delegate.e(this, $$delegatedProperties[32], episodeLockData);
    }

    protected void set_directoryItems(List<? extends SaasVideoDirectoryItem> list) {
        this._directoryItems$delegate.e(this, $$delegatedProperties[33], list);
    }

    protected void set_disableInsertAd(boolean z) {
        this._disableInsertAd$delegate.e(this, $$delegatedProperties[35], Boolean.valueOf(z));
    }

    protected void set_duration(long j) {
        this._duration$delegate.e(this, $$delegatedProperties[5], Long.valueOf(j));
    }

    protected void set_enableVisionProduct(boolean z) {
        this._enableVisionProduct$delegate.e(this, $$delegatedProperties[23], Boolean.valueOf(z));
    }

    protected void set_episodeCnt(int i) {
        this._episodeCnt$delegate.e(this, $$delegatedProperties[9], Integer.valueOf(i));
    }

    protected void set_episodeListBtnText(String str) {
        this._episodeListBtnText$delegate.e(this, $$delegatedProperties[56], str);
    }

    protected void set_episodeListText(String str) {
        this._episodeListText$delegate.e(this, $$delegatedProperties[55], str);
    }

    protected void set_episodeTotalCnt(int i) {
        this._episodeTotalCnt$delegate.e(this, $$delegatedProperties[50], Integer.valueOf(i));
    }

    protected void set_episodesCover(String str) {
        this._episodesCover$delegate.e(this, $$delegatedProperties[19], str);
    }

    protected void set_episodesId(String str) {
        this._episodesId$delegate.e(this, $$delegatedProperties[10], str);
    }

    protected void set_episodesIntroduction(String str) {
        this._episodesIntroduction$delegate.e(this, $$delegatedProperties[29], str);
    }

    protected void set_episodesList(List<? extends SaasVideoData> list) {
        this._episodesList$delegate.e(this, $$delegatedProperties[14], list);
    }

    protected void set_episodesListCountText(String str) {
        this._episodesListCountText$delegate.e(this, $$delegatedProperties[28], str);
    }

    protected void set_episodesListWithTrailAfterCut(List<? extends SaasVideoData> list) {
        this._episodesListWithTrailAfterCut$delegate.e(this, $$delegatedProperties[25], list);
    }

    protected void set_episodesPlayCount(long j) {
        this._episodesPlayCount$delegate.e(this, $$delegatedProperties[27], Long.valueOf(j));
    }

    protected void set_episodesStatus(SeriesStatus seriesStatus) {
        this._episodesStatus$delegate.e(this, $$delegatedProperties[8], seriesStatus);
    }

    protected void set_episodesTitle(String str) {
        this._episodesTitle$delegate.e(this, $$delegatedProperties[7], str);
    }

    protected void set_followed(boolean z) {
        this._followed$delegate.e(this, $$delegatedProperties[11], Boolean.valueOf(z));
    }

    protected void set_followedCnt(long j) {
        this._followedCnt$delegate.e(this, $$delegatedProperties[12], Long.valueOf(j));
    }

    protected void set_fromPlayListId(String str) {
        this._fromPlayListId$delegate.e(this, $$delegatedProperties[39], str);
    }

    protected void set_fromPrefetch(boolean z) {
        this._fromPrefetch$delegate.e(this, $$delegatedProperties[48], Boolean.valueOf(z));
    }

    protected void set_fromSrcChannelId(String str) {
        this._fromSrcChannelId$delegate.e(this, $$delegatedProperties[40], str);
    }

    protected void set_fromSrcMaterialId(String str) {
        this._fromSrcMaterialId$delegate.e(this, $$delegatedProperties[38], str);
    }

    protected void set_hasAppendTrailer(boolean z) {
        this._hasAppendTrailer$delegate.e(this, $$delegatedProperties[58], Boolean.valueOf(z));
    }

    protected void set_hasHighlight(boolean z) {
        this._hasHighlight$delegate.e(this, $$delegatedProperties[43], Boolean.valueOf(z));
    }

    protected void set_hasShowNextEpisodeAnim(Boolean bool) {
        this._hasShowNextEpisodeAnim$delegate.e(this, $$delegatedProperties[41], bool);
    }

    protected void set_highlight(SaasVideoHighlight saasVideoHighlight) {
        this._highlight$delegate.e(this, $$delegatedProperties[34], saasVideoHighlight);
    }

    protected void set_inEpisodeEndInner(boolean z) {
        this._inEpisodeEndInner$delegate.e(this, $$delegatedProperties[61], Boolean.valueOf(z));
    }

    protected void set_insertAdRitType(int i) {
        this._insertAdRitType$delegate.e(this, $$delegatedProperties[24], Integer.valueOf(i));
    }

    protected void set_localList(boolean z) {
        this._localList$delegate.e(this, $$delegatedProperties[13], Boolean.valueOf(z));
    }

    protected void set_mainCreates(List<? extends UgcUserInfo> list) {
        this._mainCreates$delegate.e(this, $$delegatedProperties[77], list);
    }

    protected void set_onlineSubscribed(boolean z) {
        this._onlineSubscribed$delegate.e(this, $$delegatedProperties[69], Boolean.valueOf(z));
    }

    protected void set_onlineTime(long j) {
        this._onlineTime$delegate.e(this, $$delegatedProperties[70], Long.valueOf(j));
    }

    protected void set_payInfo(VideoPayInfo videoPayInfo) {
        this._payInfo$delegate.e(this, $$delegatedProperties[42], videoPayInfo);
    }

    protected void set_playerSerialVideoList(List<? extends SaasVideoData> list) {
        this._playerSerialVideoList$delegate.e(this, $$delegatedProperties[73], list);
    }

    protected void set_postDataIndex(int i) {
        this._postDataIndex$delegate.e(this, $$delegatedProperties[59], Integer.valueOf(i));
    }

    protected void set_recTagList(List<? extends SecondaryInfo> list) {
        this._recTagList$delegate.e(this, $$delegatedProperties[74], list);
    }

    protected void set_recommendGroupId(String str) {
        this._recommendGroupId$delegate.e(this, $$delegatedProperties[37], str);
    }

    protected void set_recommendInfo(String str) {
        this._recommendInfo$delegate.e(this, $$delegatedProperties[36], str);
    }

    protected void set_refreshFromInnerToOuter(boolean z) {
        this._refreshFromInnerToOuter$delegate.e(this, $$delegatedProperties[62], Boolean.valueOf(z));
    }

    protected void set_relatedAlbumId(long j) {
        this._relatedAlbumId$delegate.e(this, $$delegatedProperties[67], Long.valueOf(j));
    }

    protected void set_relatedMaterialId(String str) {
        this._relatedMaterialId$delegate.e(this, $$delegatedProperties[3], str);
    }

    protected void set_rpcData(Serializable serializable) {
        this._rpcData$delegate.e(this, $$delegatedProperties[82], serializable);
    }

    protected void set_secondaryInfoList(List<? extends SecondaryInfo> list) {
        this._secondaryInfoList$delegate.e(this, $$delegatedProperties[0], list);
    }

    protected void set_seriesIntro(String str) {
        this._seriesIntro$delegate.e(this, $$delegatedProperties[26], str);
    }

    protected void set_seriesSubTitleList(List<String> list) {
        this._seriesSubTitleList$delegate.e(this, $$delegatedProperties[54], list);
    }

    protected void set_showBackToStartBtnOnce(boolean z) {
        this._showBackToStartBtnOnce$delegate.e(this, $$delegatedProperties[47], Boolean.valueOf(z));
    }

    protected void set_showMaterialGuidanceAnim(boolean z) {
        this._showMaterialGuidanceAnim$delegate.e(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    protected void set_slideToNewRecommendFeed(boolean z) {
        this._slideToNewRecommendFeed$delegate.e(this, $$delegatedProperties[63], Boolean.valueOf(z));
    }

    protected void set_smallEpisodesCover(String str) {
        this._smallEpisodesCover$delegate.e(this, $$delegatedProperties[20], str);
    }

    protected void set_style(SaaSVideoDetailStyle saaSVideoDetailStyle) {
        this._style$delegate.e(this, $$delegatedProperties[78], saaSVideoDetailStyle);
    }

    protected void set_subTitleList(List<? extends SecondaryInfo> list) {
        this._subTitleList$delegate.e(this, $$delegatedProperties[80], list);
    }

    protected void set_supportListen(boolean z) {
        this._supportListen$delegate.e(this, $$delegatedProperties[81], Boolean.valueOf(z));
    }

    protected void set_tabTrailerList(List<? extends Serializable> list) {
        this._tabTrailerList$delegate.e(this, $$delegatedProperties[57], list);
    }

    protected void set_trailerList(List<? extends SaasVideoData> list) {
        this._trailerList$delegate.e(this, $$delegatedProperties[15], list);
    }

    protected void set_ugcRelated(boolean z) {
        this._ugcRelated$delegate.e(this, $$delegatedProperties[22], Boolean.valueOf(z));
    }

    protected void set_ugcUserInfo(UgcUserInfo ugcUserInfo) {
        this._ugcUserInfo$delegate.e(this, $$delegatedProperties[65], ugcUserInfo);
    }

    protected void set_updateTag(String str) {
        this._updateTag$delegate.e(this, $$delegatedProperties[18], str);
    }

    protected void set_urgeUpdateData(SaasUrgeUpdateData saasUrgeUpdateData) {
        this._urgeUpdateData$delegate.e(this, $$delegatedProperties[79], saasUrgeUpdateData);
    }

    protected void set_useStatus(UseStatus useStatus) {
        this._useStatus$delegate.e(this, $$delegatedProperties[60], useStatus);
    }

    protected void set_videoBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this._videoBottomBar$delegate.e(this, $$delegatedProperties[66], saaSVideoBottomBar);
    }

    protected void set_videoContentType(VideoContentType videoContentType) {
        this._videoContentType$delegate.e(this, $$delegatedProperties[4], videoContentType);
    }

    protected void set_videoPlatformType(VideoPlatformType videoPlatformType) {
        this._videoPlatformType$delegate.e(this, $$delegatedProperties[30], videoPlatformType);
    }

    protected void set_videoRecordInfo(VideoRecordInfo videoRecordInfo) {
        this._videoRecordInfo$delegate.e(this, $$delegatedProperties[21], videoRecordInfo);
    }

    protected void set_videoRelateBook(VideoRelateBook videoRelateBook) {
        this._videoRelateBook$delegate.e(this, $$delegatedProperties[71], videoRelateBook);
    }

    protected void set_videoSelectPanelGuideText(String str) {
        this._videoSelectPanelGuideText$delegate.e(this, $$delegatedProperties[51], str);
    }

    protected void set_videoShareInfo(VideoShareInfo videoShareInfo) {
        this._videoShareInfo$delegate.e(this, $$delegatedProperties[52], videoShareInfo);
    }

    protected void set_videoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        this._videoTagInfo$delegate.e(this, $$delegatedProperties[64], saasVideoTagInfo);
    }

    protected void set_videoUpdateInfo(VideoUpdateInfo videoUpdateInfo) {
        this._videoUpdateInfo$delegate.e(this, $$delegatedProperties[49], videoUpdateInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public final void setEpisodesListWithTrail(List<? extends SaasVideoData> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            set_episodesListWithTrail(new ArrayList());
        } else {
            get_episodesListWithTrail().addAll(list);
        }
    }

    protected void set_episodesListWithTrail(List<SaasVideoData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this._episodesListWithTrail$delegate.e(this, $$delegatedProperties[17], list);
    }

    protected void set_highlightSeriesId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._highlightSeriesId$delegate.e(this, $$delegatedProperties[44], str);
    }

    protected void set_highlightVid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._highlightVid$delegate.e(this, $$delegatedProperties[45], str);
    }

    protected void set_seriesColorHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._seriesColorHex$delegate.e(this, $$delegatedProperties[16], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel
    public final void setUrgeUpdateData(boolean z, boolean z2, long j) {
        SaasUrgeUpdateData saasUrgeUpdateData = get_urgeUpdateData();
        if (saasUrgeUpdateData != null) {
            saasUrgeUpdateData.setShowUrgeButton(z);
            saasUrgeUpdateData.setUserUrged(z2);
            saasUrgeUpdateData.setTotalCnt(j);
            return;
        }
        set_urgeUpdateData(new SaasUrgeUpdateData(z, z2, j));
    }
}
