package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = d6.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ServerTopicTag {
    Default(0),
    PushBook(1),
    ReadDiscussion(2),
    InteractiveChat(3),
    Tanbi(4),
    ColdStart(5),
    Activity(6),
    RecommendIncExposure(7),
    AdminProduce(8),
    UgcProduce(9),
    UgcProduceElderlyTopic(10),
    InviteRecommendCandidate(11),
    GoldCoinTask(100),
    GoldCoinTaskV2(1001),
    GoldCoinTaskClose(1002),
    HasRewardedGoldCoinComment(101),
    LaoBaiOne(102),
    LaoBaiTwo(103),
    LaoBaiThree(104),
    LaoBaiBookMoreThanSix(105),
    FemaleLaoBaiBookMoreThanSix(106),
    PublishRelatedTopic(107),
    PublishRelatedTopicKeyword(1071),
    PublishRelatedTopicCategory(1072),
    PublishRelatedTopicBookRate(1073),
    PublishRelatedTopicIntention(1074),
    PublishRelatedTopicVagueIntention(1075),
    AudioRelatedTopic(108),
    AudioRelatedTopicKeyword(1081),
    AudioRelatedTopicCategory(1082),
    AudioRelatedTopicBookRate(1083),
    AudioRelatedTopicIntention(1084),
    AudioRelatedTopicVagueIntention(1085),
    ComicsRelatedTopic(109),
    ComicsRelatedTopicKeyword(1091),
    ComicsRelatedTopicCategory(1092),
    ComicsRelatedTopicBookRate(1093),
    ComicsRelatedTopicIntention(1094),
    ComicsRelatedTopicVagueIntention(1095),
    NoCoverBookTopic(110),
    ConteRelatedTopic(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    ConteRelatedTopicBookRate(1111),
    ConteRelatedTopicIntention(1112),
    ConteRelatedTopicVagueIntention(1113),
    StoryRelatedTopic(112),
    StoryRelatedTopicBookRate(1121),
    StoryRelatedTopicIntention(1122),
    StoryRelatedTopicVagueIntention(1123),
    ProduceActivity1(6401),
    ProduceActivity2(6402),
    BookRecDiffContent(650),
    BookRecActivity(6501),
    BookRecActivityOut(6502),
    BookRecDiffContentFilter(6503),
    BookRecDiffContentNew(6504),
    HighConvertContent(6505),
    BookRelevantScore(660),
    BookTitleScoreMoreThan30Percent(6601),
    BookAbstractScoreMoreThan50Percent(6602),
    DoubleMaleTopic(670),
    BookCotTag(680),
    BookCharacter(6801),
    DoubleColPostActivity(6802),
    DoubleColUGCIntention(6803),
    DoubleColIPTag(6804);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610806);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ServerTopicTag> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) ServerTopicTag.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610805);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.ServerTopicTag$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return d6.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    ServerTopicTag(int i) {
        this.value = i;
    }
}
