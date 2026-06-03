package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = q7.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCoverType {
    DefaultCover(0),
    AuthorUpload(1),
    ActUpload(2),
    ExternalPurchase(3),
    ServerGenerate(4),
    BookCoverCollection(5),
    HandWrittenBookTitles(6),
    MemoStytle(7),
    RealWorldScene(8),
    RealWorldSceneGrouping(9),
    MemoStytleWithBookname(10),
    AIGCCover(11),
    AIGCCoverWithTmpl(12),
    Carousel(13),
    StoryTopic(14),
    Grid(15),
    UnderlineRandomText(16),
    UnderlineTitle(17),
    TextGenImage(18),
    Dynamic(50);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(610990);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UgcCoverType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) UgcCoverType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(610989);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.UgcCoverType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return q7.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    UgcCoverType(int i) {
        this.value = i;
    }
}
