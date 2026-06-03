package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = p5.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SecondaryInfoDataType {
    RecommendReason(1),
    RankScore(2),
    CategoryV2(3),
    Score(4),
    SameAuthor(5),
    SameAuthorNew(6),
    ReadRecommend(7),
    AuthorName(8),
    Tags(9),
    WordNum(10),
    CreationStatus(11),
    UpdateStatus(12),
    SerialCount(13),
    EndTimeDesc(14),
    HotTags(15),
    ReadingCnt(16),
    EstimateReadingTime(17),
    ChapterListenDuration(18),
    ChapterListen14UV(19),
    ChapterListenOrder(20),
    RecommendReasonRanklist(21),
    TopicRecommendBook(22),
    Actor(23),
    Intro(24),
    BriefIntro(25),
    Duration(26),
    VideoPopularity(27),
    RelateBook(28),
    RelateVideo(29),
    RelateIp(30),
    BookName(31),
    Genre(32),
    TwoActor(33),
    Comment(34),
    CotTag(35),
    Topic(36),
    UgcRanklist(37),
    PushMaterial(38);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610740);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SecondaryInfoDataType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SecondaryInfoDataType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610739);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SecondaryInfoDataType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return p5.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SecondaryInfoDataType(int i) {
        this.value = i;
    }
}
