package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = u7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcPostTypeCopy {
    Talk(1),
    Creation(2),
    VideoRecommendBook(3),
    Forward(4),
    Story(5),
    Wiki(6),
    DouyinVideo(7),
    ChapterStory(8),
    UgcBooklist(9),
    FollowStory(10),
    AddBookshelfStory(11),
    DouyinLiveStory(12),
    MuyeShortStory(13),
    MuyeUgcContent(14),
    RecommendBookVideo(15),
    ForumVideo(16),
    StoryVideo(17),
    PictureVideo(18),
    XiguaVideo(20),
    VideoSeries(22),
    FmTopic(100),
    FizzoTopic(200);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611006);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcPostTypeCopy> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcPostTypeCopy.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611005);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcPostTypeCopy$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return u7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcPostTypeCopy(int i) {
        this.value = i;
    }
}
