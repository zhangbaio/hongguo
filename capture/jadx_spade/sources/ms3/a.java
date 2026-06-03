package ms3;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(599006);
        a = new a();
    }

    private a() {
    }

    public final String a(int i) {
        switch (i) {
            case 1:
                return "profile_follow";
            case 2:
            case 4:
                return "video_player";
            case 3:
                return "profile_fans";
            case 5:
                return "comment";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
                return "search_result";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "message_center";
            case 9:
                return "playet_collection_card";
            case 10:
                return "playet_collection_video_player";
            case 11:
                return "video_detail_page";
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return "choose_video_panel";
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return "reserve_video_menu";
            case 14:
            case 15:
            case 16:
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
            default:
                return "";
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return "picture_post_page";
            case 18:
                return "playlist_page";
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return "actor_ranking_list_page";
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return "playlist_menu";
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return "video_player_danmu";
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return "inner_push";
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return "search_result_user_tab";
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return "video_crew_page";
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return "actor_list_page";
            case 28:
                return "video_player_menu";
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                return "starring_actor_ranking_list_page";
            case 30:
                return "starring_actor_ranking_list_page_search";
        }
    }
}
