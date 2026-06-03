package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GoldBoxPageData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("activity_task")
    public ActivityTaskData activityTask;

    @SerializedName("ad_free_tab")
    public AdFreeTabData adFreeTab;

    @SerializedName("arishem_task")
    public List<FeModel> arishemTask;

    @SerializedName("banner_task")
    public BannerTaskData bannerTask;

    @SerializedName("bottom_text")
    public String bottomText;

    @SerializedName("bottom_text_url")
    public String bottomTextUrl;

    @SerializedName("cash_balance")
    public long cashBalance;

    @SerializedName("cash_income_page")
    public String cashIncomePage;

    @SerializedName("comics_task")
    public ComicsTaskData comicsTask;
    public String conf;

    @SerializedName("continue_read")
    public TaskDetail continueRead;

    @SerializedName("continue_short_video")
    public TaskDetail continueShortVideo;

    @SerializedName("daily_read_challenge")
    public DailyReadChallenge dailyReadChallenge;

    @SerializedName("daily_sign_in_task")
    public CommonTaskData dailySignInTask;

    @SerializedName("daily_tasks")
    public List<TaskDetail> dailyTasks;

    @SerializedName("default_tab")
    public int defaultTab;

    @SerializedName("downgrade_conf")
    public DowngradeConf downgradeConf;

    @SerializedName("excitation_task")
    public CommonTaskData excitationTask;
    public String extra;

    @SerializedName("game_data")
    public GameData gameData;

    @SerializedName("gold_balance")
    public long goldBalance;

    @SerializedName("gold_box_page_type")
    public int goldBoxPageType;

    @SerializedName("gold_income_page")
    public String goldIncomePage;

    @SerializedName("income_area_info")
    public IncomeAreaInfo incomeAreaInfo;

    @SerializedName("is_login")
    public boolean isLogin;

    @SerializedName("listen_task")
    public ListenTaskData listenTask;

    @SerializedName("main_title")
    public String mainTitle;

    @SerializedName("mix_task")
    public MixConsumeTaskData mixTask;

    @SerializedName("new_user_task")
    public NewUserTasksData newUserTask;

    @SerializedName("notify_data")
    public NotifyData notifyData;

    @SerializedName("notify_data_list")
    public List<NotifyData> notifyDataList;

    @SerializedName("publication_read_task")
    public PublicationReadTaskData publicationReadTask;

    @SerializedName("reading_task")
    public ReadingTaskData readingTask;

    @SerializedName("role_task")
    public RoleTaskData roleTask;

    @SerializedName("show_count")
    public int showCount;

    @SerializedName("sign_in_task")
    public NewUserSignInTaskData signInTask;

    @SerializedName("take_cash_bubble")
    public TakeCashBubble takeCashBubble;

    @SerializedName("task_sort")
    public List<String> taskSort;

    @SerializedName("transfer_task")
    public TransferTaskData transferTask;

    @SerializedName("ui_style")
    public String uiStyle;

    @SerializedName("video_task")
    public VideoTaskData videoTask;

    @SerializedName("wechat_url")
    public String wechatUrl;

    @SerializedName("wechat_withdraw_title")
    public String wechatWithdrawTitle;

    @SerializedName("welfare_data")
    public WelfareData welfareData;

    @SerializedName("welfare_task")
    public WelfareTaskData welfareTask;

    @SerializedName("withdraw_entry")
    public WithdrawEntry withdrawEntry;

    @SerializedName("write_page_task")
    public TaskDetail writePageTask;

    static {
        Covode.recordClassIndex(612116);
        fieldTypeClassRef = FieldType.class;
    }
}
