package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = j6.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SourcePageType {
    Reader(1),
    Detail(2),
    PersonPage(3),
    Praise(4),
    FansTitle(5),
    LatestChapterEnd(6),
    BookCircle(7),
    BookEnd(8),
    GiftPanel(9),
    ReaderCover(10),
    BookCommentList(11),
    BookCardCreatePage(12),
    FrontentActivity(13),
    CategoryDetailPage(14),
    SearchPage(15),
    PostDetailPage(16),
    InteractiveMessage(17),
    NotificationMessage(18),
    BookForumPage(19),
    ReqBookTopicPage(20),
    CategoryForumPage(21),
    ReaderCoverBookCommentList(22),
    DetailBookCommentList(23),
    BookEndBookCommentList(24),
    TopicTagFilter(25),
    Mine(26),
    BookMall(27),
    OuterShare(28),
    BookShelf(29),
    ReminderUpdate(30),
    ReqBookTopicEditorPage(31),
    ReqBookTopicListPage(32),
    ReadHistory(33),
    BookMallTopicBooklist(34),
    BookForumTopicPage(35),
    CategoryForumTopicPage(36),
    Dynamic(37),
    ChapterEnd(38),
    BookForumGoldTask(39),
    BookStoreGoldTask(40),
    ChapterEndBookCommentList(41),
    TopicComment(42),
    BookForumTagPage(43),
    ReaderActionBar(44),
    AudioBookPage(45),
    UgcPush(46),
    AudioBookCommentPage(47),
    AudioBookPlayerPage(48),
    AudioBookPlayerCommentPage(49),
    MentionUserEditor(50),
    ChapterEndMixed(51),
    ForumContentMixedEditor(52),
    ForumSquare(53),
    ForumContentEditorWithVideo(54),
    GuessWantAnswerList(55),
    ReqBookContentEditorWithVideo(56),
    ChapterEndInSwitchOff(57),
    UgcBottomTab(58),
    VisitUserHistory(59),
    ConversationListPage(60),
    FanRankTabPage(61),
    EditSearchTag(62),
    IdeaCommentList(63),
    UGGoldCoinPage(64),
    ReaderActionBarBookCommentList(65),
    Catalog(66),
    CatalogBookCommentList(67),
    BookCommentEditor(68),
    ComicReader(69),
    ComicItemCommentList(70),
    BookEndForumPage(71),
    InReaderFlashNotice(72),
    UgcStoryTabHeader(73),
    BookMallBookCommentList(74),
    QuestionStory(75),
    VideoSeriesHotList(76),
    AIGCEditorParaComment(77),
    AIGCEditorPost(78),
    SpringFestivalAct(79),
    UGCEditor(80),
    BookEndFeedBookCommentList(81),
    BookMallUnlimited(82),
    BookEndFeedForumPost(83),
    BookEndUgcProduceEntry(84),
    AIGCEditorReader(85),
    TopicCommentReplyL2(86),
    ShortStoryPullLiveDelivery(87),
    AIGCEditorStoryParaComment(88),
    ShortStoryMoreEntrance(89),
    InnerShare(90),
    VideoDetail(91),
    StoryAlbum(92);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610838);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SourcePageType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SourcePageType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610837);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SourcePageType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return j6.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SourcePageType(int i) {
        this.value = i;
    }
}
