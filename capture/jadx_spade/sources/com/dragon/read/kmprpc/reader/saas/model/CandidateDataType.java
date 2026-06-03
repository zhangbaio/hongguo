package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = j0.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CandidateDataType {
    None(0),
    Cluster(1),
    Catogory(2),
    Book(3),
    Booklist(4),
    Topic(5),
    Video(6),
    BookDigest(7),
    BookComment(8),
    VideoSeries(9),
    Role(10),
    BookCommentList(12),
    ShuhuangEntrance(13),
    VideoSeriesPost(14),
    UGTaskInfo(15),
    MaterialVideo(16),
    Audio(17),
    BatchAudio(18),
    BatchComic(19),
    VideoSeriesRanklist(20),
    Ranklist(21),
    ShortStory(22),
    Ecp(23),
    HighQualityBookList(24),
    Nps(25),
    DynamicComic(26),
    PUGCVideo(27),
    BookCommentGroup(28),
    ForumPost(29),
    Forum(30),
    RankListBook(31),
    RankListTopic(32),
    SearchRelatedQuery(33),
    SearchRelatedBook(34),
    ParagraphComment(35),
    ReadHistory(36),
    RankListBanner(37),
    HotTopicEntrance(38),
    RankListAuthor(39),
    RankListShortPlay(40),
    RankListDynamicComic(41),
    VideoPost(42),
    LiveRoom(43),
    SeriesComment(44),
    SubscribeItem(45),
    StoryAlbum(46),
    AuthorTopic(47);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609871);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CandidateDataType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) CandidateDataType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609870);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.CandidateDataType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return j0.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    CandidateDataType(int i) {
        this.value = i;
    }
}
