package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubLayoutConfig;
import com.ttreader.tthtmlparser.customtag.ICustomTagBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CustomTagHandler {
    private final TTEpubLayoutConfig config;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Covode.recordClassIndex(654757);
            int[] iArr = new int[ICustomTagBehavior.MatchType.values().length];
            try {
                iArr[ICustomTagBehavior.MatchType.Prefix.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ICustomTagBehavior.MatchType.Equal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Covode.recordClassIndex(654756);
    }

    public CustomTagHandler(TTEpubLayoutConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final CustomTagResult getResult(ElementNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        ICustomTagBehavior behavior = getBehavior(node.getTag());
        if (behavior == null) {
            return null;
        }
        return behavior.callback(node);
    }

    private final ICustomTagBehavior getBehavior(String str) {
        boolean startsWith$default;
        List<ICustomTagBehavior> behaviorList = this.config.customTagConfig.getBehaviorList();
        if (behaviorList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : behaviorList) {
            ICustomTagBehavior iCustomTagBehavior = (ICustomTagBehavior) obj;
            int i = WhenMappings.$EnumSwitchMapping$0[iCustomTagBehavior.getMatchType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    startsWith$default = Intrinsics.areEqual(str, iCustomTagBehavior.getTag());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, iCustomTagBehavior.getTag(), false, 2, null);
            }
            if (startsWith$default) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            if (it2.hasNext()) {
                int priority = ((ICustomTagBehavior) next).priority();
                do {
                    Object next2 = it2.next();
                    int priority2 = ((ICustomTagBehavior) next2).priority();
                    if (priority < priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it2.hasNext());
            }
            return (ICustomTagBehavior) next;
        }
        throw new NoSuchElementException();
    }
}
