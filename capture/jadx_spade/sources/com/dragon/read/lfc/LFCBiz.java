package com.dragon.read.lfc;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LFCBiz {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LFCBiz[] $VALUES;
    public static final LFCBiz BindDouyin4Rights;
    public static final LFCBiz DouYinAuthErrorShowPopup;
    public static final LFCBiz MultiGoldDialogLFC;
    public static final LFCBiz PolarisTabBadge;
    public static final LFCBiz ReaderNoAdsInspireDialog;
    public static final LFCBiz TtsAudioSyncing;
    public static final LFCBiz TtsAuto2Ad;
    public static final LFCBiz TtsBackgroundReward;
    public static final LFCBiz TtsDailySign;
    public static final LFCBiz TtsEnterPageGuide;
    public static final LFCBiz TtsEntryHistoryExpose;
    public static final LFCBiz TtsEntryPlayIndicator;
    public static final LFCBiz TtsLeftTimeTip;
    public static final LFCBiz TtsLeftTimeTipExit;
    public static final LFCBiz TtsStartPlayGuide;
    public static final LFCBiz TtsStartPlayGuideExit;
    public static final LFCBiz TtsSyncingPendant;
    public static final LFCBiz WelfareTabBubble;
    private final String cacheId;
    private final String desc;

    private static final /* synthetic */ LFCBiz[] $values() {
        return new LFCBiz[]{ReaderNoAdsInspireDialog, TtsSyncingPendant, TtsLeftTimeTip, TtsLeftTimeTipExit, TtsStartPlayGuide, TtsEnterPageGuide, TtsStartPlayGuideExit, TtsAudioSyncing, TtsAuto2Ad, BindDouyin4Rights, MultiGoldDialogLFC, PolarisTabBadge, TtsDailySign, TtsEntryHistoryExpose, TtsEntryPlayIndicator, WelfareTabBubble, DouYinAuthErrorShowPopup, TtsBackgroundReward};
    }

    public static EnumEntries<LFCBiz> getEntries() {
        return $ENTRIES;
    }

    public final String getCacheId() {
        return this.cacheId;
    }

    public final String getDesc() {
        return this.desc;
    }

    public static LFCBiz[] values() {
        return (LFCBiz[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611283);
        ReaderNoAdsInspireDialog = new LFCBiz("ReaderNoAdsInspireDialog", 0, "reader_no_ads_inspire_dialog", "阅读器免广激励弹窗");
        TtsSyncingPendant = new LFCBiz("TtsSyncingPendant", 1, "tts_syncing_pendant", "边听边读激励挂件");
        TtsLeftTimeTip = new LFCBiz("TtsLeftTimeTip", 2, "tts_left_time_tip", "听书起播语音提示");
        TtsLeftTimeTipExit = new LFCBiz("TtsLeftTimeTipExit", 3, "tts_left_time_tip_exit", "听书起播语音提示退场");
        TtsStartPlayGuide = new LFCBiz("TtsStartPlayGuide", 4, "tts_start_play_guide", "听书起播弹窗");
        TtsEnterPageGuide = new LFCBiz("TtsEnterPageGuide", 5, "tts_enter_page_guide", "听书进播弹窗");
        TtsStartPlayGuideExit = new LFCBiz("TtsStartPlayGuideExit", 6, "tts_start_play_guide_exit", "听书起播弹窗退场");
        TtsAudioSyncing = new LFCBiz("TtsAudioSyncing", 7, "tts_audio_syncing", "边听边读送时长");
        TtsAuto2Ad = new LFCBiz("TtsAuto2Ad", 8, "tts_auto_2_ad", "听书自动进广告");
        BindDouyin4Rights = new LFCBiz("BindDouyin4Rights", 9, "bind_douyin_for_rights", "绑抖音免广");
        MultiGoldDialogLFC = new LFCBiz("MultiGoldDialogLFC", 10, "multi_gold_dialog", "激励金币翻倍");
        PolarisTabBadge = new LFCBiz("PolarisTabBadge", 11, "polaris_tab_commerce_badge", "福利Tab气泡/红点");
        TtsDailySign = new LFCBiz("TtsDailySign", 12, "tts_daily_sign", "听书每日签到");
        TtsEntryHistoryExpose = new LFCBiz("TtsEntryHistoryExpose", 13, "tts_entry_history_expose", "听书浏览历史引导");
        TtsEntryPlayIndicator = new LFCBiz("TtsEntryPlayIndicator", 14, "tts_entry_play_indicator", "听书悬浮按钮引导");
        WelfareTabBubble = new LFCBiz("WelfareTabBubble", 15, "welfare_tab_bubble", "福利Tab气泡");
        DouYinAuthErrorShowPopup = new LFCBiz("DouYinAuthErrorShowPopup", 16, "douyin_auth_error_show_popup", "抖音授权失败时拉起弹窗");
        TtsBackgroundReward = new LFCBiz("TtsBackgroundReward", 17, "tts_background_reward", "后台听书额外奖励");
        LFCBiz[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LFCBiz valueOf(String str) {
        return (LFCBiz) Enum.valueOf(LFCBiz.class, str);
    }

    private LFCBiz(String str, int i, String str2, String str3) {
        this.cacheId = str2;
        this.desc = str3;
    }
}
