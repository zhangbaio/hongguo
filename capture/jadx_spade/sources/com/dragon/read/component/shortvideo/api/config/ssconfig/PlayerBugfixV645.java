package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerBugfixV645 {
    public static final a a;
    private static final Lazy<PlayerBugfixV645> b;

    @SerializedName("fix_add_video_detail_model_set_lock")
    public final boolean addVideoDetailModelSetLock;

    @SerializedName("fix_album_history_video_index")
    public final boolean fixAlbumHistoryVideoIndex;

    @SerializedName("fix_auto_next_when_error")
    public final boolean fixAutoNextWhenError;

    @SerializedName("fix_back_from_full_screen_video_size_issue")
    public final boolean fixBackFromFullScreenVideoSizeIssue;

    @SerializedName("fix_collection_anim_collapse_issue")
    public final boolean fixCollectionAnimCollapseIssue;

    @SerializedName("fix_data_center_load_only_video_model_failed")
    public final boolean fixDataCenterLoadOnlyVideoModelFailed;

    @SerializedName("fix_dialog_anim_surface_view")
    public final boolean fixDialogAnimSurfaceView;

    @SerializedName("fix_dialog_size")
    public final boolean fixDialogSize;

    @SerializedName("fix_digg_view_animate")
    public final boolean fixDiggViewAnimate;

    @SerializedName("fix_do_exit")
    public final boolean fixDoExit;

    @SerializedName("fix_exit_landscapeAd")
    public final boolean fixExitLandscapeAd;

    @SerializedName("fix_floating_window_holder")
    public final boolean fixFloatingWindowHolder;

    @SerializedName("fix_floating_window_leak")
    public final boolean fixFloatingWindowLeak;

    @SerializedName("fix_force_play_view_opt_3")
    public final boolean fixForcePlayViewOpt3;

    @SerializedName("fix_force_play_view_pugc")
    public final boolean fixForcePlayViewPugc;

    @SerializedName("fix_full_screen_video_width")
    public final boolean fixFullScreenVideoWidth;

    @SerializedName("fix_go_single_feed")
    public final boolean fixGoSingleFeed;

    @SerializedName("fix_leak_problems_v691")
    public final boolean fixLeakProblemsV691;

    @SerializedName("fix_like_page_right_slide")
    public final boolean fixLikePageRightSlide;

    @SerializedName("fix_create_next_player_when_hit_prepare")
    public final boolean fixNoCreateNextPlayerWhenHitPrepareIssue;

    @SerializedName("fix_over_close_more_panel")
    public final boolean fixOverCloseMorePanel;

    @SerializedName("fix_pause_button")
    public final boolean fixPauseButton;

    @SerializedName("fix_play_url_route_failed")
    public final boolean fixPlayUrlRouteFailed;

    @SerializedName("fix_player_playing")
    public final boolean fixPlayerPlaying;

    @SerializedName("fix_pre_play_hit_video_detail_event")
    public final boolean fixPrePlayHitVideoDetailEvent;

    @SerializedName("fix_rec_feed_go_to_single_issue")
    public final boolean fixRecFeedGoToSingleIssue;

    @SerializedName("fix_recycler_client_illegal_state")
    public final boolean fixRecyclerClientIllegalStateException;

    @SerializedName("fix_release_no_hit_share_player")
    public final boolean fixReleaseNoHitSharePlayer;

    @SerializedName("fix_remove_current_error")
    public final boolean fixRemoveCurrentItemError;

    @SerializedName("fix_remove_video_page")
    public final boolean fixRemoveVideoPage;

    @SerializedName("fix_remove_view_log")
    public final boolean fixRemoveViewLog;

    @SerializedName("fix_report_no_hit_share_player")
    public final boolean fixReportNoHitSharePlayer;

    @SerializedName("fix_reset_all_video_view_size_when_screen_change")
    public final boolean fixResetAllVideoViewSizeWhenScreenChange;

    @SerializedName("fix_series_mall_visible_report")
    public final boolean fixSeriesMallVisibleReport;

    @SerializedName("fix_share_player_release")
    public final boolean fixSharePlayerRelease;

    @SerializedName("fix_single_adapter_album_rec_event_issue")
    public final boolean fixSingleAdapterAlbumRecEventIssue;

    @SerializedName("fix_surface_share_check_available")
    public final boolean fixSurfaceShareCheckAvailable;

    @SerializedName("fix_surface_size")
    public final boolean fixSurfaceSize;

    @SerializedName("fix_tab_fragment_do_visible_post")
    public final boolean fixTabFragmentDoVisiblePost;

    @SerializedName("fix_tab_fragment_out_of_index")
    public final boolean fixTabFragmentOutOfIndex;

    @SerializedName("fix_textureview_reuse")
    public final boolean fixTextureViewReuse;

    @SerializedName("fix_unbind_next_player_clear_surface")
    public final boolean fixUnbindNextPlayerClearSurfaceIssue;

    @SerializedName("fix_update_current_holder")
    public final boolean fixUpdateCurrentHolder;

    @SerializedName("fix_video_floating_window_adapter_leak")
    public final boolean fixVideoFloatingWindowAdapterLeak;

    @SerializedName("fix_video_model_pugc")
    public final boolean fixVideoModelPugc;

    @SerializedName("fix_view_is_not_child")
    public final boolean fixViewIsNotChild;

    @SerializedName("opt_report_play_monitor_node_duration")
    public final boolean optReportPlayMonitorNodeDuration;

    @SerializedName("support_pugc_in_end_rec")
    public final boolean supportPugcInEndRec;

    public PlayerBugfixV645() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, 65535, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598405);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerBugfixV645 a() {
            return (PlayerBugfixV645) PlayerBugfixV645.b.getValue();
        }
    }

    static {
        Lazy<PlayerBugfixV645> lazy;
        Covode.recordClassIndex(598404);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerBugfixV645 c;
                c = PlayerBugfixV645.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerBugfixV645 c() {
        boolean z = false;
        return (PlayerBugfixV645) qq3.a.c("player_bugfix_v645", new PlayerBugfixV645(false, false, false, false, false, false, false, false, false, false, false, false, false, false, z, z, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, 65535, null), false, 4, null);
    }

    public PlayerBugfixV645(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, boolean z29, boolean z30, boolean z31, boolean z32, boolean z33, boolean z34, boolean z35, boolean z36, boolean z37, boolean z38, boolean z39, boolean z40, boolean z41, boolean z42, boolean z43, boolean z44, boolean z45, boolean z46, boolean z47, boolean z48) {
        this.fixPauseButton = z;
        this.fixOverCloseMorePanel = z2;
        this.addVideoDetailModelSetLock = z3;
        this.fixPlayerPlaying = z4;
        this.fixSharePlayerRelease = z5;
        this.fixSurfaceSize = z6;
        this.fixRemoveCurrentItemError = z7;
        this.fixLikePageRightSlide = z8;
        this.fixForcePlayViewPugc = z9;
        this.fixForcePlayViewOpt3 = z10;
        this.fixVideoModelPugc = z11;
        this.fixDoExit = z12;
        this.fixTabFragmentDoVisiblePost = z13;
        this.fixUpdateCurrentHolder = z14;
        this.fixGoSingleFeed = z15;
        this.fixDialogAnimSurfaceView = z16;
        this.fixDialogSize = z17;
        this.fixPlayUrlRouteFailed = z18;
        this.fixFloatingWindowLeak = z19;
        this.fixRemoveVideoPage = z20;
        this.fixFloatingWindowHolder = z21;
        this.fixLeakProblemsV691 = z22;
        this.fixAutoNextWhenError = z23;
        this.fixRemoveViewLog = z24;
        this.fixVideoFloatingWindowAdapterLeak = z25;
        this.fixPrePlayHitVideoDetailEvent = z26;
        this.supportPugcInEndRec = z27;
        this.fixSingleAdapterAlbumRecEventIssue = z28;
        this.fixCollectionAnimCollapseIssue = z29;
        this.fixRecFeedGoToSingleIssue = z30;
        this.fixBackFromFullScreenVideoSizeIssue = z31;
        this.fixSurfaceShareCheckAvailable = z32;
        this.fixReleaseNoHitSharePlayer = z33;
        this.fixReportNoHitSharePlayer = z34;
        this.fixNoCreateNextPlayerWhenHitPrepareIssue = z35;
        this.fixUnbindNextPlayerClearSurfaceIssue = z36;
        this.fixAlbumHistoryVideoIndex = z37;
        this.optReportPlayMonitorNodeDuration = z38;
        this.fixFullScreenVideoWidth = z39;
        this.fixViewIsNotChild = z40;
        this.fixTabFragmentOutOfIndex = z41;
        this.fixDiggViewAnimate = z42;
        this.fixExitLandscapeAd = z43;
        this.fixDataCenterLoadOnlyVideoModelFailed = z44;
        this.fixSeriesMallVisibleReport = z45;
        this.fixTextureViewReuse = z46;
        this.fixResetAllVideoViewSizeWhenScreenChange = z47;
        this.fixRecyclerClientIllegalStateException = z48;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PlayerBugfixV645(boolean r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, boolean r59, boolean r60, boolean r61, boolean r62, boolean r63, boolean r64, boolean r65, boolean r66, boolean r67, boolean r68, boolean r69, boolean r70, boolean r71, boolean r72, boolean r73, boolean r74, boolean r75, boolean r76, boolean r77, boolean r78, boolean r79, boolean r80, boolean r81, boolean r82, boolean r83, boolean r84, boolean r85, boolean r86, boolean r87, boolean r88, boolean r89, boolean r90, boolean r91, boolean r92, boolean r93, boolean r94, boolean r95, boolean r96, int r97, int r98, kotlin.jvm.internal.DefaultConstructorMarker r99) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.PlayerBugfixV645.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
