package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = w8.class)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum VideoTextExtType {
    Txt(0),
    FowardedUser(1),
    MentionUser(2),
    Image(3),
    SearchLink(4),
    ActivityScore(5),
    HighLight(6),
    Book(7),
    Item(8),
    UgcTag(9),
    Hint(10),
    JumpLink(11),
    TagTopic(12),
    HotLineData(13),
    Comment(14),
    MentionRobot(15),
    RobotGreeting(16),
    Video(17),
    AIGCEditorOption(18),
    RankListTag(19);

    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final a Companion;
    private final int value;

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611202);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VideoTextExtType> serializer() {
            return a();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) VideoTextExtType.$cachedSerializer$delegate.getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(611201);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.dragon.read.kmprpc.reader.saas.model.VideoTextExtType$Companion$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return w8.b;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    VideoTextExtType(int i) {
        this.value = i;
    }
}
