package kotlin.io;

import com.bytedance.covode.number.Covode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    static {
        Covode.recordClassIndex(658377);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new b();
    }

    private final class b extends kotlin.collections.b<File> {
        private final ArrayDeque<c> c;

        public /* synthetic */ class d {
            public static final /* synthetic */ int[] a;

            static {
                Covode.recordClassIndex(658383);
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        static {
            Covode.recordClassIndex(658379);
        }

        /* renamed from: kotlin.io.FileTreeWalk$b$b, reason: collision with other inner class name */
        private final class C0204b extends c {
            private boolean b;
            final /* synthetic */ b c;

            static {
                Covode.recordClassIndex(658381);
            }

            @Override // kotlin.io.FileTreeWalk.c
            public File a() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return this.a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0204b(b bVar, File rootFile) {
                super(rootFile);
                Intrinsics.checkNotNullParameter(rootFile, "rootFile");
                this.c = bVar;
            }
        }

        @Override // kotlin.collections.b
        protected void c() {
            File h = h();
            if (h != null) {
                e(h);
            } else {
                d();
            }
        }

        private final File h() {
            File a2;
            while (true) {
                c peek = this.c.peek();
                if (peek == null) {
                    return null;
                }
                a2 = peek.a();
                if (a2 == null) {
                    this.c.pop();
                } else {
                    if (Intrinsics.areEqual(a2, peek.a) || !a2.isDirectory() || this.c.size() >= FileTreeWalk.this.maxDepth) {
                        break;
                    }
                    this.c.push(g(a2));
                }
            }
            return a2;
        }

        private final class a extends a {
            private boolean b;
            private File[] c;
            private int d;
            private boolean e;
            final /* synthetic */ b f;

            static {
                Covode.recordClassIndex(658380);
            }

            @Override // kotlin.io.FileTreeWalk.c
            public File a() {
                if (!this.e && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    boolean z = false;
                    if (function1 != null && !((Boolean) function1.invoke(this.a)).booleanValue()) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    File[] listFiles = this.a.listFiles();
                    this.c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(this.a, new AccessDeniedException(this.a, null, "Cannot list files in a directory", 2, null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
                        Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.b) {
                    this.b = true;
                    return this.a;
                }
                Function1 function12 = FileTreeWalk.this.onLeave;
                if (function12 != null) {
                    function12.invoke(this.a);
                }
                return null;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.f = bVar;
            }
        }

        private final class c extends a {
            private boolean b;
            private File[] c;
            private int d;
            final /* synthetic */ b e;

            static {
                Covode.recordClassIndex(658382);
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // kotlin.io.FileTreeWalk.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File a() {
                /*
                    r10 = this;
                    boolean r0 = r10.b
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnEnter$p(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L20
                    java.io.File r4 = r10.a
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    r2 = 1
                L20:
                    if (r2 == 0) goto L23
                    return r1
                L23:
                    r10.b = r3
                    java.io.File r0 = r10.a
                    return r0
                L28:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L45
                    int r2 = r10.d
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L45
                L35:
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L44
                    java.io.File r2 = r10.a
                    r0.invoke(r2)
                L44:
                    return r1
                L45:
                    java.io.File[] r0 = r10.c
                    if (r0 != 0) goto L89
                    java.io.File r0 = r10.a
                    java.io.File[] r0 = r0.listFiles()
                    r10.c = r0
                    if (r0 != 0) goto L6f
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.access$getOnFail$p(r0)
                    if (r0 == 0) goto L6f
                    java.io.File r2 = r10.a
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r7 = 2
                    r8 = 0
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L6f:
                    java.io.File[] r0 = r10.c
                    if (r0 == 0) goto L79
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L89
                L79:
                    kotlin.io.FileTreeWalk$b r0 = r10.e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L88
                    java.io.File r2 = r10.a
                    r0.invoke(r2)
                L88:
                    return r1
                L89:
                    java.io.File[] r0 = r10.c
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r10.d
                    int r2 = r1 + 1
                    r10.d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.b.c.a():java.io.File");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.e = bVar;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.c = arrayDeque;
            if (FileTreeWalk.this.start.isDirectory()) {
                arrayDeque.push(g(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                arrayDeque.push(new C0204b(this, FileTreeWalk.this.start));
            } else {
                d();
            }
        }

        private final a g(File file) {
            int i = d.a[FileTreeWalk.this.direction.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new a(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new c(this, file);
        }
    }

    private static abstract class a extends c {
        static {
            Covode.recordClassIndex(658378);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        }
    }

    private static abstract class c {
        public final File a;

        static {
            Covode.recordClassIndex(658384);
        }

        public abstract File a();

        public c(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.a = root;
        }
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, function, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, function, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk maxDepth(int i) {
        if (i > 0) {
            return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, i);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i + '.');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function12;
        this.onFail = function2;
        this.maxDepth = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    /* synthetic */ FileTreeWalk(java.io.File r8, kotlin.io.FileWalkDirection r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function1 r11, kotlin.jvm.functions.Function2 r12, int r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 2
            if (r15 == 0) goto L6
            kotlin.io.FileWalkDirection r9 = kotlin.io.FileWalkDirection.TOP_DOWN
        L6:
            r2 = r9
            r9 = r14 & 32
            if (r9 == 0) goto L12
            r13 = 2147483647(0x7fffffff, float:NaN)
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L13
        L12:
            r6 = r13
        L13:
            r0 = r7
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.<init>(java.io.File, kotlin.io.FileWalkDirection, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
