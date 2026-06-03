package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = l5.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SearchIpCardContentType {
    Book(0),
    Audio(1),
    ShortPlay(2),
    DynamicComic(3),
    Video(4),
    Comic(5),
    IconicScene(6),
    BookComment(7),
    Collection(8),
    PostVideo(9),
    ForumPost(10),
    TalkV2(11),
    Topic(12),
    TopicComment(13),
    SubscribeVideo(14),
    TalkV2Picture(15),
    ForumEntrance(16);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610714);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SearchIpCardContentType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) SearchIpCardContentType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610713);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.SearchIpCardContentType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return l5.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    SearchIpCardContentType(int i) {
        this.value = i;
    }
}
