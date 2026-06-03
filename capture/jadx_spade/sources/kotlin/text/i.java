package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i implements MatchResult {
    private final Matcher a;
    private final CharSequence b;
    private final MatchGroupCollection c;
    private List<String> d;

    static {
        Covode.recordClassIndex(658768);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult b() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection getGroups() {
        return this.c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.Destructured getDestructured() {
        return MatchResult.a.a(this);
    }

    public static final class a extends AbstractList<String> {
        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return i.this.b().groupCount() + 1;
        }

        a() {
        }

        public /* bridge */ boolean d(String str) {
            return super.contains(str);
        }

        public /* bridge */ int n(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int o(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return d((String) obj);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return n((String) obj);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String group = i.this.b().group(i);
            if (group == null) {
                return "";
            }
            return group;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return o((String) obj);
        }
    }

    public static final class b extends AbstractCollection<MatchGroup> implements MatchGroupCollection {
        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return i.this.b().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<MatchGroup> iterator() {
            IntRange indices;
            indices = CollectionsKt__CollectionsKt.getIndices(this);
            return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(indices), new Function1() { // from class: kotlin.text.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    MatchGroup n;
                    n = i.b.n(i.b.this, ((Integer) obj).intValue());
                    return n;
                }
            }).iterator();
        }

        b() {
        }

        public /* bridge */ boolean j(MatchGroup matchGroup) {
            return super.contains(matchGroup);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            boolean z;
            if (obj == null) {
                z = true;
            } else {
                z = obj instanceof MatchGroup;
            }
            if (!z) {
                return false;
            }
            return j((MatchGroup) obj);
        }

        @Override // kotlin.text.MatchGroupCollection
        public MatchGroup get(int i) {
            IntRange i2;
            i2 = l.i(i.this.b(), i);
            if (i2.getStart().intValue() >= 0) {
                String group = i.this.b().group(i);
                Intrinsics.checkNotNullExpressionValue(group, "group(...)");
                return new MatchGroup(group, i2);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MatchGroup n(b bVar, int i) {
            return bVar.get(i);
        }
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        IntRange h;
        h = l.h(b());
        return h;
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String group = b().group();
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return group;
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.d == null) {
            this.d = new a();
        }
        List<String> list = this.d;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int i;
        MatchResult f;
        int end = b().end();
        if (b().end() == b().start()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = end + i;
        if (i2 <= this.b.length()) {
            Matcher matcher = this.a.pattern().matcher(this.b);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            f = l.f(matcher, i2, this.b);
            return f;
        }
        return null;
    }

    public i(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.a = matcher;
        this.b = input;
        this.c = new b();
    }
}
