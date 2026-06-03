package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasShowType {
    MultiPicture(100),
    SubjectReview(101),
    HorizontalMix(102),
    HorizontalTwo(103),
    VerticalOne(104),
    RankList(105),
    SubjectBookList(106),
    VerticalTwo(107),
    HotVideo(108),
    SinglePicture(109),
    SearchOneBook(110),
    CategoryItem(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    HorizontalOne(112),
    BookList(113),
    SingleOneBook(114),
    CategoryTag(115),
    HotCategoryTag(116),
    NewRankList(117),
    RowOneFour(118),
    RowFourFour(119),
    Task(120),
    Privilege(121),
    SingleBooksPage(122),
    RankCategory(124),
    UnlimitedBook(125),
    EditorRecommendNewBook(127),
    NewBookPromotion(128),
    NewBookDebut(129),
    NewBookTask(130),
    HotSearchWord(131),
    Author(132),
    SearchCategory(133),
    ComprehensiveSearch(134),
    AdVideo(135),
    TopicSearch(136),
    BaikeSearch(137),
    SearchTag(138),
    HotTopic(139),
    BaikeTags(140),
    BaikeTopics(141),
    RankList30400(142),
    RowFourFour30400(143),
    SearchOneBookEnhanced(144),
    FixedEntrance30600(145),
    CategoryTag30600(146),
    HotTopic30600(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO),
    SearchTopHint(148),
    SearchHistory(149),
    SearchHotCategory(150),
    SearchPrecise(151),
    SearchTopicCell(152),
    SearchTopicCellSingle(153),
    SearchTopicRecommend(154),
    DoubleColVideo(155),
    WideRankList(156),
    HotStory(157),
    SearchTopicCellWithBookList(158),
    SearchTopicBookList(159),
    DetailRelatedVideo(160),
    RankListGroup(161),
    GroupRankListBook(162),
    GroupRankListCategory(163),
    GroupRankListTopic(164),
    WideListCell(165),
    WideCategoryCell(166),
    RuyiSearchCategory(167),
    RuyiSearchRecommend(168),
    RankListWithCategory(169),
    GroupRankListTopicHotTopic(170),
    SearchTopicCellSingleNew(171),
    BookGroupWithBookName(172),
    BookGroupWithOutBookName(173),
    RankListWithVideo(174),
    HotTopicGuide(175),
    HotTopicPostExposure(176),
    ClickToggleRankListGroup(177),
    ClickToggleGroupRankListBook(178),
    ClickToggleGroupRankListCategory(179),
    ClickToggleGroupRankListTopic(180),
    SearchRuyiSingleVideo(181),
    SearchMultiVideo(182),
    SearchSingleVideo(183),
    SearchSubSingleVideo(184),
    HotComic(185),
    RankListComic(186),
    ComicRecFeed(187),
    ComicHotLabel(188),
    SearchBookWithTopic(189),
    ShortStoryHotLabel(190),
    SearchActivityLynx(191),
    MixedUnlimited(192),
    BookListInUnlimited(193),
    PostStoryInUnlimited(194),
    ShortSeriesPlay(195),
    VideoCategory(196),
    CategoryBatch(197),
    SearchAccessToutiaoResult(198),
    InterestExplore(199),
    FmRankList(200),
    FmMultiPicture(201),
    FmRowFourTwo(202),
    FmUnlimitedBook(203),
    FmSearchOneBook(204),
    FmSearchCategory(205),
    FmRowTwoThree(206),
    FmRowOneThree(207),
    FmRowOneN(208),
    FmRowThreeTwo(209),
    FmVerticalOne(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES),
    FmSearchVeriticalOne(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA),
    FmSearchRowFourOne(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH),
    FmSearchHotWord(213),
    FmSearchComprehensive(214),
    FmSearchHotRank(225),
    FmGoldenLine(231),
    FmNewsRankList(232),
    FmUnlimitedNews(233),
    FmGoldenLineV2(234),
    FederationHint(235),
    SearchBookShelf(236),
    FmRankListV2(241),
    FmGoldenLineV4(254),
    SearchGuessYourInclination(300),
    UgcVideoRecommendBook(301),
    RowNColumnTwo(302),
    RowNColumnTwoWithTags(303),
    ECommerceGoodsFeed(304),
    ECommerceBanner(305),
    SearchForumTopic(306),
    SearchForumPost(307),
    UgcCellData(308),
    UgcCellViewHot(309),
    UgcCellViewFavor(310),
    UgcCellViewFeed(TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE),
    UgcCellViewFavorUser(312),
    SearchContent(313),
    RowUpToFour(314),
    GenreTypeWithCategory(315),
    RowOneThree(316),
    RowThreeThree(317),
    PublishAuthor(318),
    RankListComicV2(319),
    SearchSelectedEmpty(320),
    SearchTongrenCell(321),
    SearchUserDisplay(322),
    SearchUserDisplayRecommend(323),
    SearchOneBookAggregation(324),
    SearchOneBookAggregationWithTopic(325),
    AudioDetailAlbumRecommend(326),
    ECommerceSearchGoodCell(327),
    UgcCellViewForumsByCate(328),
    ECommerceHotSearch(329),
    UgcCellViewInviteCandidate(330),
    ContentEntranceBanner(331),
    ClickToggleGroupRankListComic(332),
    BookDigestCell(333),
    SearchComicDisplay(334),
    SearchComicDisplayRecommend(335),
    SstimorRankList(336),
    MultiTabMixedUnlimited(337),
    DoubleRowMixedUnlimited(338),
    MixedDataInUnlimited(339),
    UgcCellViewUser(340),
    LiveCellHotLiveStreamer(341),
    LiveCellHotLiveRoom(342),
    SearchShortStoryBanner(343),
    BookDigestCellWithLandingPage(344),
    SstimorRecFeed(345),
    ComicReadHistory(346),
    ListenHighLightChapter(347),
    SearchTopBookList(348),
    SearchTopForum(349),
    SearchBookCommentCell(350),
    CategoryBatchWithCarousel(351),
    SimilarUgcBookListCell(352),
    BookDigestCellWithLandingPageV2(353),
    BookCommentCell(354),
    RankCellWithExchangeV1(355),
    RankCellWithExchangeV2(356),
    ListenHotCategoryNew(357),
    RowFourFourNew(358),
    ListenSimilarCellV1(359),
    ListenSimilarCellV2(360),
    BookStoreSpecialCell(361),
    AuthorBookList(362),
    RelatedBookList(363),
    HotSearchWordV2(364),
    PressBookList(365),
    VideoPlayHistory(366),
    ReadingDayPublicCell(367),
    PreferenceSetting(368),
    SearchShortPlay(369),
    VideoAutoPlayCell(370),
    ListenHighLightChapterV2(371),
    SearchShortPlayRecommend(372),
    IdolRecommendCell(373),
    SearchBookList(374),
    VideoSeriesInnerRecommend(375),
    DirectorySameNameRecommend(376),
    DirectorySimilarRecommend(377),
    QuitRetainSameNameRecommend(378),
    QuitRetainSimilarRecommend(379),
    LastPageSameNameRecommend(380),
    RecommendRankCellWithExchangeV1(381),
    RecommendRankCellWithExchangeV2(382),
    VideoSeriesCommonRecommend(383),
    MultiTabMixedUnlimitedV2(384),
    DoubleRowMixedUnlimitedWithFilter(385),
    SearchCueWord(386),
    CategoryBatchWithDoubleRow(387),
    GroupRankListShortPlay(388),
    SearchGuessLikeHint(389),
    ContentEntranceBannerV2(390),
    AdPlaceHolderBanner(391),
    SearchDoubleColBook(392),
    SearchDoubleColRs(393),
    NPSResearch(394),
    GroupRankListShortPlayCategory(395),
    VideoSeriesMixedUnlimitedTwoCol(400),
    VideoSeriesMixedUnlimitedThreeCol(401),
    VideoSeriesMixedUnlimitedData(402),
    VideoSeriesMixedUnlimitedAutoPlay(403),
    VideoSeriesMixedUnlimitedHorizontal(404),
    SearchShortPlayAgg(405),
    SearchGoCommonHint(406),
    VideoSeriesVideoFeedRecommend(407),
    SearchShortPlayNoCover(408),
    SearchShortPlayNoCoverItem(409),
    SearchShortPlayNoCoverLanding(410),
    SearchShortPlayNoCoverLandingItem(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL),
    SearchShortPlaySingleCol(TTVideoEngineInterface.PLAYER_OPTION_USE_AJ_MEDIACODEC),
    SearchShortPlayNoCoverSingleCol(TTVideoEngineInterface.PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO),
    SearchShortPlayRecommendSingleCol(TTVideoEngineInterface.PLAYER_OPTION_DEFAULT_RENDER_TYPE),
    HgRankListGroupV2(415),
    HgRankListGroupV3(416),
    GroupRankListMovie(417),
    GroupRankListTelePlay(TTVideoEngineInterface.PLAYER_OPTION_FORBID_P2P_WHEN_SEEK),
    HgRankListGroupV4(419),
    SearchOneBookShortPlaySingle(420),
    HgRankListGroupV5(421),
    LongVideoCategoryCell(422),
    VideoSeriesHalfScreenAutoPlay(423),
    GenderPreferenceCard(424),
    BatchAudioPage(425),
    BatchComicPage(426),
    SearchShortPlayRuyi(427),
    SearchShortPlayAggAutoPlay(428),
    SearchCommonProductRelated(429),
    SearchCommonProductRecommend(430),
    GroupRankListPublication(431),
    GroupRankListAudioBook(432),
    VideoSeriesLongVideoMixedUnlimitedData(433),
    LongVideoCategoryCellThreeCol(434),
    PremiumVideoSeries(435),
    SearchRecBookRobot(436),
    HotVideoSeriesPost(437),
    SearchBookListAlias(438),
    EcomSearchSelectInfo(439),
    ECommerceSearchGuideSearch(440),
    ECommerceSearchGoodCellNew(441),
    ECommerceSearchLiveCellNew(442),
    ECommerceSearchHistory(443),
    EcommerceSearchHotSearchNew(444),
    VideoSeriesRanklist(445),
    SearchShortplayAggDoubleCol(446),
    SearchShortplayAggTripleCol(447),
    SearchShortStoryComment(448),
    SearchShortStoryPGC(449),
    EcommerceSearchEmptyRes(450),
    VideoHistoryEntrance(451),
    GroupRankListNewShortPlay(452),
    HgRankListGroupV6(453),
    GuessYouSearch(454),
    HighQualityBookList(455),
    PublishVipActivity(456),
    PublishVipBooklist(457),
    StoryFeedDoubleCol(458),
    SingleSeriesDistributionCard(464),
    SingleSeriesMoreHotSeries(466),
    SecKillActivity(10000),
    TopProductArea(10001),
    HotSellRank(10002),
    ActivityBanner(10003),
    MultiTabFeed(10004),
    SimpleFeed(10005),
    CategoryArea(10006),
    CouponUrgeBar(10007),
    BookOneOff(10008),
    CouponCell(10009),
    EcomMixedDataInUnlimited(10010),
    MultiBookRank(10011),
    KolRecommendBookVideo(10012),
    BookRankAggregation(10013),
    BookAllowanceModuleCell(10014),
    MultiTabSortFeed(10015);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(599104);
    }

    public static SaasShowType findByValue(int i) {
        if (i != 124) {
            if (i != 125) {
                if (i != 225) {
                    if (i != 241) {
                        if (i != 254) {
                            if (i != 464) {
                                if (i != 466) {
                                    switch (i) {
                                        case 100:
                                            return MultiPicture;
                                        case 101:
                                            return SubjectReview;
                                        case 102:
                                            return HorizontalMix;
                                        case 103:
                                            return HorizontalTwo;
                                        case 104:
                                            return VerticalOne;
                                        case 105:
                                            return RankList;
                                        case 106:
                                            return SubjectBookList;
                                        case 107:
                                            return VerticalTwo;
                                        case 108:
                                            return HotVideo;
                                        case 109:
                                            return SinglePicture;
                                        case 110:
                                            return SearchOneBook;
                                        case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                            return CategoryItem;
                                        case 112:
                                            return HorizontalOne;
                                        case 113:
                                            return BookList;
                                        case 114:
                                            return SingleOneBook;
                                        case 115:
                                            return CategoryTag;
                                        case 116:
                                            return HotCategoryTag;
                                        case 117:
                                            return NewRankList;
                                        case 118:
                                            return RowOneFour;
                                        case 119:
                                            return RowFourFour;
                                        case 120:
                                            return Task;
                                        case 121:
                                            return Privilege;
                                        case 122:
                                            return SingleBooksPage;
                                        default:
                                            switch (i) {
                                                case 127:
                                                    return EditorRecommendNewBook;
                                                case 128:
                                                    return NewBookPromotion;
                                                case 129:
                                                    return NewBookDebut;
                                                case 130:
                                                    return NewBookTask;
                                                case 131:
                                                    return HotSearchWord;
                                                case 132:
                                                    return Author;
                                                case 133:
                                                    return SearchCategory;
                                                case 134:
                                                    return ComprehensiveSearch;
                                                case 135:
                                                    return AdVideo;
                                                case 136:
                                                    return TopicSearch;
                                                case 137:
                                                    return BaikeSearch;
                                                case 138:
                                                    return SearchTag;
                                                case 139:
                                                    return HotTopic;
                                                case 140:
                                                    return BaikeTags;
                                                case 141:
                                                    return BaikeTopics;
                                                case 142:
                                                    return RankList30400;
                                                case 143:
                                                    return RowFourFour30400;
                                                case 144:
                                                    return SearchOneBookEnhanced;
                                                case 145:
                                                    return FixedEntrance30600;
                                                case 146:
                                                    return CategoryTag30600;
                                                case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO /* 147 */:
                                                    return HotTopic30600;
                                                case 148:
                                                    return SearchTopHint;
                                                case 149:
                                                    return SearchHistory;
                                                case 150:
                                                    return SearchHotCategory;
                                                case 151:
                                                    return SearchPrecise;
                                                case 152:
                                                    return SearchTopicCell;
                                                case 153:
                                                    return SearchTopicCellSingle;
                                                case 154:
                                                    return SearchTopicRecommend;
                                                case 155:
                                                    return DoubleColVideo;
                                                case 156:
                                                    return WideRankList;
                                                case 157:
                                                    return HotStory;
                                                case 158:
                                                    return SearchTopicCellWithBookList;
                                                case 159:
                                                    return SearchTopicBookList;
                                                case 160:
                                                    return DetailRelatedVideo;
                                                case 161:
                                                    return RankListGroup;
                                                case 162:
                                                    return GroupRankListBook;
                                                case 163:
                                                    return GroupRankListCategory;
                                                case 164:
                                                    return GroupRankListTopic;
                                                case 165:
                                                    return WideListCell;
                                                case 166:
                                                    return WideCategoryCell;
                                                case 167:
                                                    return RuyiSearchCategory;
                                                case 168:
                                                    return RuyiSearchRecommend;
                                                case 169:
                                                    return RankListWithCategory;
                                                case 170:
                                                    return GroupRankListTopicHotTopic;
                                                case 171:
                                                    return SearchTopicCellSingleNew;
                                                case 172:
                                                    return BookGroupWithBookName;
                                                case 173:
                                                    return BookGroupWithOutBookName;
                                                case 174:
                                                    return RankListWithVideo;
                                                case 175:
                                                    return HotTopicGuide;
                                                case 176:
                                                    return HotTopicPostExposure;
                                                case 177:
                                                    return ClickToggleRankListGroup;
                                                case 178:
                                                    return ClickToggleGroupRankListBook;
                                                case 179:
                                                    return ClickToggleGroupRankListCategory;
                                                case 180:
                                                    return ClickToggleGroupRankListTopic;
                                                case 181:
                                                    return SearchRuyiSingleVideo;
                                                case 182:
                                                    return SearchMultiVideo;
                                                case 183:
                                                    return SearchSingleVideo;
                                                case 184:
                                                    return SearchSubSingleVideo;
                                                case 185:
                                                    return HotComic;
                                                case 186:
                                                    return RankListComic;
                                                case 187:
                                                    return ComicRecFeed;
                                                case 188:
                                                    return ComicHotLabel;
                                                case 189:
                                                    return SearchBookWithTopic;
                                                case 190:
                                                    return ShortStoryHotLabel;
                                                case 191:
                                                    return SearchActivityLynx;
                                                case 192:
                                                    return MixedUnlimited;
                                                case 193:
                                                    return BookListInUnlimited;
                                                case 194:
                                                    return PostStoryInUnlimited;
                                                case 195:
                                                    return ShortSeriesPlay;
                                                case 196:
                                                    return VideoCategory;
                                                case 197:
                                                    return CategoryBatch;
                                                case 198:
                                                    return SearchAccessToutiaoResult;
                                                case 199:
                                                    return InterestExplore;
                                                case 200:
                                                    return FmRankList;
                                                case 201:
                                                    return FmMultiPicture;
                                                case 202:
                                                    return FmRowFourTwo;
                                                case 203:
                                                    return FmUnlimitedBook;
                                                case 204:
                                                    return FmSearchOneBook;
                                                case 205:
                                                    return FmSearchCategory;
                                                case 206:
                                                    return FmRowTwoThree;
                                                case 207:
                                                    return FmRowOneThree;
                                                case 208:
                                                    return FmRowOneN;
                                                case 209:
                                                    return FmRowThreeTwo;
                                                case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES /* 210 */:
                                                    return FmVerticalOne;
                                                case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA /* 211 */:
                                                    return FmSearchVeriticalOne;
                                                case TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH /* 212 */:
                                                    return FmSearchRowFourOne;
                                                case 213:
                                                    return FmSearchHotWord;
                                                case 214:
                                                    return FmSearchComprehensive;
                                                default:
                                                    switch (i) {
                                                        case 231:
                                                            return FmGoldenLine;
                                                        case 232:
                                                            return FmNewsRankList;
                                                        case 233:
                                                            return FmUnlimitedNews;
                                                        case 234:
                                                            return FmGoldenLineV2;
                                                        case 235:
                                                            return FederationHint;
                                                        case 236:
                                                            return SearchBookShelf;
                                                        default:
                                                            switch (i) {
                                                                case 300:
                                                                    return SearchGuessYourInclination;
                                                                case 301:
                                                                    return UgcVideoRecommendBook;
                                                                case 302:
                                                                    return RowNColumnTwo;
                                                                case 303:
                                                                    return RowNColumnTwoWithTags;
                                                                case 304:
                                                                    return ECommerceGoodsFeed;
                                                                case 305:
                                                                    return ECommerceBanner;
                                                                case 306:
                                                                    return SearchForumTopic;
                                                                case 307:
                                                                    return SearchForumPost;
                                                                case 308:
                                                                    return UgcCellData;
                                                                case 309:
                                                                    return UgcCellViewHot;
                                                                case 310:
                                                                    return UgcCellViewFavor;
                                                                case TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE /* 311 */:
                                                                    return UgcCellViewFeed;
                                                                case 312:
                                                                    return UgcCellViewFavorUser;
                                                                case 313:
                                                                    return SearchContent;
                                                                case 314:
                                                                    return RowUpToFour;
                                                                case 315:
                                                                    return GenreTypeWithCategory;
                                                                case 316:
                                                                    return RowOneThree;
                                                                case 317:
                                                                    return RowThreeThree;
                                                                case 318:
                                                                    return PublishAuthor;
                                                                case 319:
                                                                    return RankListComicV2;
                                                                case 320:
                                                                    return SearchSelectedEmpty;
                                                                case 321:
                                                                    return SearchTongrenCell;
                                                                case 322:
                                                                    return SearchUserDisplay;
                                                                case 323:
                                                                    return SearchUserDisplayRecommend;
                                                                case 324:
                                                                    return SearchOneBookAggregation;
                                                                case 325:
                                                                    return SearchOneBookAggregationWithTopic;
                                                                case 326:
                                                                    return AudioDetailAlbumRecommend;
                                                                case 327:
                                                                    return ECommerceSearchGoodCell;
                                                                case 328:
                                                                    return UgcCellViewForumsByCate;
                                                                case 329:
                                                                    return ECommerceHotSearch;
                                                                case 330:
                                                                    return UgcCellViewInviteCandidate;
                                                                case 331:
                                                                    return ContentEntranceBanner;
                                                                case 332:
                                                                    return ClickToggleGroupRankListComic;
                                                                case 333:
                                                                    return BookDigestCell;
                                                                case 334:
                                                                    return SearchComicDisplay;
                                                                case 335:
                                                                    return SearchComicDisplayRecommend;
                                                                case 336:
                                                                    return SstimorRankList;
                                                                case 337:
                                                                    return MultiTabMixedUnlimited;
                                                                case 338:
                                                                    return DoubleRowMixedUnlimited;
                                                                case 339:
                                                                    return MixedDataInUnlimited;
                                                                case 340:
                                                                    return UgcCellViewUser;
                                                                case 341:
                                                                    return LiveCellHotLiveStreamer;
                                                                case 342:
                                                                    return LiveCellHotLiveRoom;
                                                                case 343:
                                                                    return SearchShortStoryBanner;
                                                                case 344:
                                                                    return BookDigestCellWithLandingPage;
                                                                case 345:
                                                                    return SstimorRecFeed;
                                                                case 346:
                                                                    return ComicReadHistory;
                                                                case 347:
                                                                    return ListenHighLightChapter;
                                                                case 348:
                                                                    return SearchTopBookList;
                                                                case 349:
                                                                    return SearchTopForum;
                                                                case 350:
                                                                    return SearchBookCommentCell;
                                                                case 351:
                                                                    return CategoryBatchWithCarousel;
                                                                case 352:
                                                                    return SimilarUgcBookListCell;
                                                                case 353:
                                                                    return BookDigestCellWithLandingPageV2;
                                                                case 354:
                                                                    return BookCommentCell;
                                                                case 355:
                                                                    return RankCellWithExchangeV1;
                                                                case 356:
                                                                    return RankCellWithExchangeV2;
                                                                case 357:
                                                                    return ListenHotCategoryNew;
                                                                case 358:
                                                                    return RowFourFourNew;
                                                                case 359:
                                                                    return ListenSimilarCellV1;
                                                                case 360:
                                                                    return ListenSimilarCellV2;
                                                                case 361:
                                                                    return BookStoreSpecialCell;
                                                                case 362:
                                                                    return AuthorBookList;
                                                                case 363:
                                                                    return RelatedBookList;
                                                                case 364:
                                                                    return HotSearchWordV2;
                                                                case 365:
                                                                    return PressBookList;
                                                                case 366:
                                                                    return VideoPlayHistory;
                                                                case 367:
                                                                    return ReadingDayPublicCell;
                                                                case 368:
                                                                    return PreferenceSetting;
                                                                case 369:
                                                                    return SearchShortPlay;
                                                                case 370:
                                                                    return VideoAutoPlayCell;
                                                                case 371:
                                                                    return ListenHighLightChapterV2;
                                                                case 372:
                                                                    return SearchShortPlayRecommend;
                                                                case 373:
                                                                    return IdolRecommendCell;
                                                                case 374:
                                                                    return SearchBookList;
                                                                case 375:
                                                                    return VideoSeriesInnerRecommend;
                                                                case 376:
                                                                    return DirectorySameNameRecommend;
                                                                case 377:
                                                                    return DirectorySimilarRecommend;
                                                                case 378:
                                                                    return QuitRetainSameNameRecommend;
                                                                case 379:
                                                                    return QuitRetainSimilarRecommend;
                                                                case 380:
                                                                    return LastPageSameNameRecommend;
                                                                case 381:
                                                                    return RecommendRankCellWithExchangeV1;
                                                                case 382:
                                                                    return RecommendRankCellWithExchangeV2;
                                                                case 383:
                                                                    return VideoSeriesCommonRecommend;
                                                                case 384:
                                                                    return MultiTabMixedUnlimitedV2;
                                                                case 385:
                                                                    return DoubleRowMixedUnlimitedWithFilter;
                                                                case 386:
                                                                    return SearchCueWord;
                                                                case 387:
                                                                    return CategoryBatchWithDoubleRow;
                                                                case 388:
                                                                    return GroupRankListShortPlay;
                                                                case 389:
                                                                    return SearchGuessLikeHint;
                                                                case 390:
                                                                    return ContentEntranceBannerV2;
                                                                case 391:
                                                                    return AdPlaceHolderBanner;
                                                                case 392:
                                                                    return SearchDoubleColBook;
                                                                case 393:
                                                                    return SearchDoubleColRs;
                                                                case 394:
                                                                    return NPSResearch;
                                                                case 395:
                                                                    return GroupRankListShortPlayCategory;
                                                                default:
                                                                    switch (i) {
                                                                        case 400:
                                                                            return VideoSeriesMixedUnlimitedTwoCol;
                                                                        case 401:
                                                                            return VideoSeriesMixedUnlimitedThreeCol;
                                                                        case 402:
                                                                            return VideoSeriesMixedUnlimitedData;
                                                                        case 403:
                                                                            return VideoSeriesMixedUnlimitedAutoPlay;
                                                                        case 404:
                                                                            return VideoSeriesMixedUnlimitedHorizontal;
                                                                        case 405:
                                                                            return SearchShortPlayAgg;
                                                                        case 406:
                                                                            return SearchGoCommonHint;
                                                                        case 407:
                                                                            return VideoSeriesVideoFeedRecommend;
                                                                        case 408:
                                                                            return SearchShortPlayNoCover;
                                                                        case 409:
                                                                            return SearchShortPlayNoCoverItem;
                                                                        case 410:
                                                                            return SearchShortPlayNoCoverLanding;
                                                                        case TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL /* 411 */:
                                                                            return SearchShortPlayNoCoverLandingItem;
                                                                        case TTVideoEngineInterface.PLAYER_OPTION_USE_AJ_MEDIACODEC /* 412 */:
                                                                            return SearchShortPlaySingleCol;
                                                                        case TTVideoEngineInterface.PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO /* 413 */:
                                                                            return SearchShortPlayNoCoverSingleCol;
                                                                        case TTVideoEngineInterface.PLAYER_OPTION_DEFAULT_RENDER_TYPE /* 414 */:
                                                                            return SearchShortPlayRecommendSingleCol;
                                                                        case 415:
                                                                            return HgRankListGroupV2;
                                                                        case 416:
                                                                            return HgRankListGroupV3;
                                                                        case 417:
                                                                            return GroupRankListMovie;
                                                                        case TTVideoEngineInterface.PLAYER_OPTION_FORBID_P2P_WHEN_SEEK /* 418 */:
                                                                            return GroupRankListTelePlay;
                                                                        case 419:
                                                                            return HgRankListGroupV4;
                                                                        case 420:
                                                                            return SearchOneBookShortPlaySingle;
                                                                        case 421:
                                                                            return HgRankListGroupV5;
                                                                        case 422:
                                                                            return LongVideoCategoryCell;
                                                                        case 423:
                                                                            return VideoSeriesHalfScreenAutoPlay;
                                                                        case 424:
                                                                            return GenderPreferenceCard;
                                                                        case 425:
                                                                            return BatchAudioPage;
                                                                        case 426:
                                                                            return BatchComicPage;
                                                                        case 427:
                                                                            return SearchShortPlayRuyi;
                                                                        case 428:
                                                                            return SearchShortPlayAggAutoPlay;
                                                                        case 429:
                                                                            return SearchCommonProductRelated;
                                                                        case 430:
                                                                            return SearchCommonProductRecommend;
                                                                        case 431:
                                                                            return GroupRankListPublication;
                                                                        case 432:
                                                                            return GroupRankListAudioBook;
                                                                        case 433:
                                                                            return VideoSeriesLongVideoMixedUnlimitedData;
                                                                        case 434:
                                                                            return LongVideoCategoryCellThreeCol;
                                                                        case 435:
                                                                            return PremiumVideoSeries;
                                                                        case 436:
                                                                            return SearchRecBookRobot;
                                                                        case 437:
                                                                            return HotVideoSeriesPost;
                                                                        case 438:
                                                                            return SearchBookListAlias;
                                                                        case 439:
                                                                            return EcomSearchSelectInfo;
                                                                        case 440:
                                                                            return ECommerceSearchGuideSearch;
                                                                        case 441:
                                                                            return ECommerceSearchGoodCellNew;
                                                                        case 442:
                                                                            return ECommerceSearchLiveCellNew;
                                                                        case 443:
                                                                            return ECommerceSearchHistory;
                                                                        case 444:
                                                                            return EcommerceSearchHotSearchNew;
                                                                        case 445:
                                                                            return VideoSeriesRanklist;
                                                                        case 446:
                                                                            return SearchShortplayAggDoubleCol;
                                                                        case 447:
                                                                            return SearchShortplayAggTripleCol;
                                                                        case 448:
                                                                            return SearchShortStoryComment;
                                                                        case 449:
                                                                            return SearchShortStoryPGC;
                                                                        case 450:
                                                                            return EcommerceSearchEmptyRes;
                                                                        case 451:
                                                                            return VideoHistoryEntrance;
                                                                        case 452:
                                                                            return GroupRankListNewShortPlay;
                                                                        case 453:
                                                                            return HgRankListGroupV6;
                                                                        case 454:
                                                                            return GuessYouSearch;
                                                                        case 455:
                                                                            return HighQualityBookList;
                                                                        case 456:
                                                                            return PublishVipActivity;
                                                                        case 457:
                                                                            return PublishVipBooklist;
                                                                        case 458:
                                                                            return StoryFeedDoubleCol;
                                                                        default:
                                                                            switch (i) {
                                                                                case 10000:
                                                                                    return SecKillActivity;
                                                                                case 10001:
                                                                                    return TopProductArea;
                                                                                case 10002:
                                                                                    return HotSellRank;
                                                                                case 10003:
                                                                                    return ActivityBanner;
                                                                                case 10004:
                                                                                    return MultiTabFeed;
                                                                                case 10005:
                                                                                    return SimpleFeed;
                                                                                case 10006:
                                                                                    return CategoryArea;
                                                                                case 10007:
                                                                                    return CouponUrgeBar;
                                                                                case 10008:
                                                                                    return BookOneOff;
                                                                                case 10009:
                                                                                    return CouponCell;
                                                                                case 10010:
                                                                                    return EcomMixedDataInUnlimited;
                                                                                case 10011:
                                                                                    return MultiBookRank;
                                                                                case 10012:
                                                                                    return KolRecommendBookVideo;
                                                                                case 10013:
                                                                                    return BookRankAggregation;
                                                                                case 10014:
                                                                                    return BookAllowanceModuleCell;
                                                                                case 10015:
                                                                                    return MultiTabSortFeed;
                                                                                default:
                                                                                    return null;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return SingleSeriesMoreHotSeries;
                            }
                            return SingleSeriesDistributionCard;
                        }
                        return FmGoldenLineV4;
                    }
                    return FmRankListV2;
                }
                return FmSearchHotRank;
            }
            return UnlimitedBook;
        }
        return RankCategory;
    }

    SaasShowType(int i) {
        this.value = i;
    }
}
