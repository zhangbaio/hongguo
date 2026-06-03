package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = n1.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DynamicCardType {
    None(0),
    PreferenceSetting(1),
    Banner(2),
    Shuhuang(3),
    AudioAggregation(4),
    ComicAggregation(5),
    GenderPreference(6),
    VideoSeriesRanklist(7),
    ShortPlay(8),
    VoiceBook(9),
    Ecp(10),
    RankList(11),
    Nps(12),
    CategoryNewBook(13),
    CategoryEndBook(14),
    RankListClassicRecommend(15),
    RankListDianfeng(16),
    ShortStoryRanklist(17),
    CategoryFemalePubMovie(18),
    HqBookList(19),
    BookComment(20),
    RealBook(21),
    MultiRealBook(22),
    ForumPost(23),
    Forum(24),
    SearchRelatedQuery(25),
    SearchRelatedBook(26),
    BookCommentInvite(27),
    ParagraphComment(28),
    ReadHistory(29),
    HotTopic(30),
    SearchAiEntranceCard(31),
    ActivityPost(32),
    AuthorTopic(33);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610059);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DynamicCardType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) DynamicCardType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610058);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.DynamicCardType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return n1.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    DynamicCardType(int i) {
        this.value = i;
    }
}
