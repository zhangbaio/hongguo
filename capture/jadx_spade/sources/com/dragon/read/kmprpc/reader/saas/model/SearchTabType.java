package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = m5.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SearchTabType {
    None(0),
    Common(1),
    Voice(2),
    Book(3),
    Topic(4),
    Content(5),
    User(6),
    ECommerce(7),
    Comic(8),
    Bookshelf(9),
    BookComment(10),
    ShortPlay(11),
    ShortPlaySingle(12),
    ECommerceBook(13),
    ShortPlayOnly(14),
    HistorySearch(15),
    VisionCommon(16),
    VisionProduct(17),
    ShortStory(18),
    DynamicComic(19),
    ShortPlaySubRelated(20),
    LongVideo(21),
    Community(22),
    MyHistory(23),
    MyFavorite(24),
    MyLike(25),
    MyPost(26),
    HgUser(27);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610723);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SearchTabType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SearchTabType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610722);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SearchTabType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return m5.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SearchTabType(int i) {
        this.value = i;
    }
}
