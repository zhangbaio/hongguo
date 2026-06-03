package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = s.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookAlbumAlgoType {
    Fixed(0),
    Recommend(1),
    LongReadRecommend(2),
    NewestBook(3),
    SameAreaRecommend(4),
    SearchBookCategory(5),
    SearchRecommend(6),
    CategoryTagRecommend(7),
    SearchBookAlias(8),
    CommonRank(9),
    CommonRankDailyPick(10),
    CommonRankTopic(11),
    CommonRankHotLocation(12),
    OriginalBook(13),
    HotCarousel(14),
    GuessYouLike(15),
    VideoRecommend(16),
    SearchCategoryTag(17),
    SearchSimlarCategory(18),
    SearchBookNewCategory(19),
    SearchOffShelfCategory(20),
    FixedCategory(21),
    FixedBookList(22),
    SearchMatchBookList(23),
    SearchOffShelfBookList(24),
    PublicationRecommend(25),
    PublicationNewBookRecommend(26),
    OriginalCategoryRank(27),
    OriginalUnblockRank(28),
    SearchTag(29),
    SearchTwoCategory(30),
    RankListEnd(100),
    RankListHotRead(101),
    RankListIncr(102),
    RankListHotSearch(103),
    RankListAuthority(104),
    RankListNewBook(108),
    RankListChase(109),
    RankListHotComment(110),
    RankListRead(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    RankListHighScore(115),
    RankListEndCategory(116),
    FixedEntranceCategory(117),
    FixedEntranceTopic(118),
    FixedEntranceExclusive(119),
    CategoryTagHot(120),
    CategoryTagGaofen(121),
    RewardBookRecommend(122),
    KnowledgeRankListRecommend(123),
    KnowledgeRankListHighScore(124),
    KnowledgeRankListRead(125),
    KnowledgeRankListRaise(126),
    KnowledgeRankListMark(127),
    KnowledgeRankListSearch(128),
    PublishRankListHotRead(112),
    PublishRankListRead(113),
    PublishRankListClassics(114),
    PublishRankListMark(129),
    PublishRankListAuthority(130),
    PublishRankListNewBook(131),
    PublishRankListTop(196),
    PublishRankListRaise(197),
    AudioRankListHotRead(105),
    AudioRankListPopular(132),
    AudioRankListHighScore(133),
    AudioRankListEnd(134),
    RankListHotReadCategory(135),
    CategoryTagPublish(137),
    VideoRankListMovie(141),
    VideoRankListTelePlay(142),
    VideoRankListShortSeriesPlay(143),
    ComicHotLabel(144),
    ShortStoryHotLabel(145),
    RankListBookHunger(146),
    CategoryBatchHotNovel(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO),
    CategoryBatchCrosstalk(148),
    CategoryBatchOpera(149),
    CategoryBatchChild(150),
    CategoryBatchHumanity(151),
    CategoryBatchHistory(152),
    CategoryBatchLearn(153),
    CategoryBatchEmotionLife(154),
    CategoryBatchLiterature(155),
    CategoryBatchHorror(175),
    CategoryBatchMorning(176),
    CategoryBatchAfternoon(177),
    CategoryBatchEvening(178),
    RankListDouyin(156),
    ListeningHotLabel(157),
    PublishAuthor(158),
    ComicRankListHotRank(159),
    ComicRankListMale(160),
    ComicRankListFemale(161),
    ContentBannerEndBook(162),
    ContentBannerNewBook(163),
    ContentBannerShortBook(164),
    PublishRankListFilm(165),
    PublishRankListHighScore(166),
    UnlimitedMixedGuessYouLike(167),
    UnlimitedMixedRecommendBook(168),
    ComicRankListPopular(169),
    ComicRankListNewBook(170),
    ComicRankListFinishBook(171),
    ComicRankListChase(172),
    ComicRankListMark(173),
    PublishVip(174),
    ClassicRankListHotRead(179),
    ClassicRankListRead(180),
    ClassicRankListClassics(181),
    ClassicRankListFilm(182),
    ClassicRankListHighScore(183),
    ClassicRankListNewBook(184),
    Knowledge2RankListHotRead(185),
    Knowledge2RankListRead(186),
    Knowledge2RankListNewBook(187),
    RankListBookPariseRank(188),
    ContentBannerDigest(189),
    ContentBannerShuhuang(190),
    ContentBannerRanklist(191),
    ContentBannerBookComment(192),
    ContentBannerCategory(193),
    ContentBannerPublishAuthor(194),
    ContentBannerDianfeng(195),
    ContentBannerRanklistV645(198),
    RankListFengYun(200),
    RankListAudioHotInRecomm(201),
    ClassicRankListHotReadForRecommentTab(202),
    CategoryFemalePubMovie(203),
    RankListMuyeNewBook(204),
    AuthorRankList(205),
    FamousSceneVideoInsideFeed(206),
    RankListHighEdu(207),
    RankListBookHungerTopic(208),
    RankListBreakOut(209),
    PublishRankListHot(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES),
    PublishRankListFilmOrigin(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA),
    PublishRankListKnowledge(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH),
    PublishRankListFamousAuthor(213),
    SearchTopicRank(301),
    LastReadTimeSort(302),
    ReadProgressSort(303),
    VideoWatchProgressSort(304),
    LastReadTimeSortWithVideo(305),
    MixRankListVIPFreeHot(306),
    MixRankListAllFreeHot(307),
    ShortPlayRecommendList(500),
    ShortPlayNewList(501),
    RankListShortPlay(502),
    ShortPlayRankListHot(503),
    ShortPlayRankListHotPlay(504),
    ShortPlayRankListHotRiseRank(505),
    ShortPlayRankListNewRank(506),
    ShortPlayRankListOpHot(TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE),
    RankListDynamicComic(550),
    RankListVideoComicMixed(600),
    ShortStoryList(601),
    NovelReaderUnlimited(701),
    ShortStoryReaderUnlimited(TTVideoEngineInterface.PLAYER_OPTION_KERNAL_LOG_LEVER),
    ShortStoryPostUnlimited(703),
    MineTabUnlimieted(TTVideoEngineInterface.PLAYER_OPTION_OPERA_EVENT_REPORT_LEVEL),
    PlayerUnlimited(705),
    ReadNewBookGoldCoinTask(706),
    BookShelfUnlimited(707),
    ReadHistoryUnlimited(708),
    VipLandPageUnlimited(709),
    Test1(900),
    Test2(901),
    Mock(999);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609789);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.BookAlbumAlgoType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return s.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609790);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BookAlbumAlgoType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) BookAlbumAlgoType.$cachedSerializer$delegate.getValue();
        }
    }

    BookAlbumAlgoType(int i) {
        this.value = i;
    }
}
