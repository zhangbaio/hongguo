package com.ttreader.tthtmlparser;

import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.highlight.HighLightInfo;
import com.ttreader.tthtmlparser.highlight.HighlightStyle;
import com.ttreader.tthtmlparser.position.TTPagePosition;
import com.ttreader.tthtmlparser.position.TTPosition;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ProtocolUtils {
    public static final Companion Companion;

    static {
        Covode.recordClassIndex(654720);
        Companion = new Companion(null);
    }

    public static final byte[] convertHighLightInfoToByteArray(HighLightInfo highLightInfo) {
        return Companion.convertHighLightInfoToByteArray(highLightInfo);
    }

    public static final byte[] convertHighLightInfosToByteArray(List<HighLightInfo> list) {
        return Companion.convertHighLightInfosToByteArray(list);
    }

    public static final byte[] convertHighlightStyleToByteArray(HighlightStyle highlightStyle) {
        return Companion.convertHighlightStyleToByteArray(highlightStyle);
    }

    public static final byte[] convertPagePositionToByteArray(TTPagePosition tTPagePosition) {
        return Companion.convertPagePositionToByteArray(tTPagePosition);
    }

    public static final byte[] convertPointFToByteArray(PointF pointF) {
        return Companion.convertPointFToByteArray(pointF);
    }

    public static final byte[] convertPositionToByteArray(TTPosition tTPosition) {
        return Companion.convertPositionToByteArray(tTPosition);
    }

    public static final byte[] convertRunDelegatesToByteArray(List<? extends h> list) {
        return Companion.convertRunDelegatesToByteArray(list);
    }

    public static final LineLayoutBounds parseLineLayoutBoundsFromStream(com.ttreader.tttext.a aVar) {
        return Companion.parseLineLayoutBoundsFromStream(aVar);
    }

    public static final TTPagePosition parsePagePosition(byte[] bArr) {
        return Companion.parsePagePosition(bArr);
    }

    public static final TTPagePosition parsePagePositionFromStream(com.ttreader.tttext.a aVar) {
        return Companion.parsePagePositionFromStream(aVar);
    }

    public static final TTPosition parsePosition(byte[] bArr) {
        return Companion.parsePosition(bArr);
    }

    public static final TTPosition parsePositionFromStream(com.ttreader.tttext.a aVar) {
        return Companion.parsePositionFromStream(aVar);
    }

    public static final RectF parseRectF(byte[] bArr) {
        return Companion.parseRectF(bArr);
    }

    public static final SelectionInfo parseSelectionInfo(byte[] bArr) {
        return Companion.parseSelectionInfo(bArr);
    }

    public static final String parseStringFromStream(com.ttreader.tttext.a aVar) {
        return Companion.parseStringFromStream(aVar);
    }

    public static final void writeInsertedRunDelegate(int i, h hVar, DataOutputStream dataOutputStream) throws IOException {
        Companion.writeInsertedRunDelegate(i, hVar, dataOutputStream);
    }

    public static final void writeRunDelegate(int i, IRunDelegate iRunDelegate, DataOutputStream dataOutputStream) throws IOException {
        Companion.writeRunDelegate(i, iRunDelegate, dataOutputStream);
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(654721);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String parseStringFromStream(com.ttreader.tttext.a inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            try {
                return inputStream.a();
            } catch (IOException | IllegalArgumentException unused) {
                return null;
            }
        }

        public final byte[] convertHighlightStyleToByteArray(HighlightStyle highlightStyle) {
            Intrinsics.checkNotNullParameter(highlightStyle, "highlightStyle");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            highlightStyle.convertBytes$TTHtmlParser_release(new DataOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] convertPagePositionToByteArray(TTPagePosition position) {
            Intrinsics.checkNotNullParameter(position, "position");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            position.writeStream(new DataOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] convertPointFToByteArray(PointF pointF) {
            Intrinsics.checkNotNullParameter(pointF, "pointF");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeFloat(pointF.x);
            dataOutputStream.writeFloat(pointF.y);
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] convertPositionToByteArray(TTPosition position) {
            Intrinsics.checkNotNullParameter(position, "position");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            position.convertBytes$TTHtmlParser_release(new DataOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        }

        public final TTPagePosition parsePagePositionFromStream(com.ttreader.tttext.a inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            try {
                return new TTPagePosition(inputStream.readInt(), inputStream.readFloat(), inputStream.readFloat());
            } catch (IOException | IllegalArgumentException unused) {
                return null;
            }
        }

        public final TTPosition parsePositionFromStream(com.ttreader.tttext.a inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            try {
                return new TTPosition(inputStream.readInt(), inputStream.readInt(), inputStream.readInt());
            } catch (IOException | IllegalArgumentException unused) {
                return null;
            }
        }

        public final byte[] convertHighLightInfoToByteArray(HighLightInfo highlight) {
            Intrinsics.checkNotNullParameter(highlight, "highlight");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            highlight.getStart().convertBytes$TTHtmlParser_release(dataOutputStream);
            highlight.getEnd().convertBytes$TTHtmlParser_release(dataOutputStream);
            highlight.getStyle().convertBytes$TTHtmlParser_release(dataOutputStream);
            dataOutputStream.writeBoolean(highlight.getClickable());
            dataOutputStream.writeInt(highlight.getDrawPriority());
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] convertHighLightInfosToByteArray(List<HighLightInfo> highlights) {
            Intrinsics.checkNotNullParameter(highlights, "highlights");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (highlights.isEmpty()) {
                return null;
            }
            dataOutputStream.writeInt(highlights.size());
            Iterator<HighLightInfo> it2 = highlights.iterator();
            while (it2.hasNext()) {
                byte[] convertHighLightInfoToByteArray = convertHighLightInfoToByteArray(it2.next());
                if (convertHighLightInfoToByteArray != null) {
                    dataOutputStream.write(convertHighLightInfoToByteArray);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] convertRunDelegatesToByteArray(List<? extends h> delegates) {
            Intrinsics.checkNotNullParameter(delegates, "delegates");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (delegates.isEmpty()) {
                return null;
            }
            dataOutputStream.writeInt(delegates.size());
            for (h hVar : delegates) {
                writeInsertedRunDelegate(hVar.h, hVar, dataOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final LineLayoutBounds parseLineLayoutBoundsFromStream(com.ttreader.tttext.a inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            try {
                return new LineLayoutBounds(inputStream.readInt(), inputStream.readInt(), inputStream.readFloat(), inputStream.readFloat(), inputStream.readFloat(), inputStream.readFloat());
            } catch (IOException | IllegalArgumentException unused) {
                return null;
            }
        }

        public final TTPagePosition parsePagePosition(byte[] positionByteArray) {
            Intrinsics.checkNotNullParameter(positionByteArray, "positionByteArray");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(positionByteArray);
            try {
                com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(byteArrayInputStream);
                try {
                    try {
                        TTPagePosition tTPagePosition = new TTPagePosition(aVar.readInt(), aVar.readFloat(), aVar.readFloat());
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return tTPagePosition;
                    } finally {
                    }
                } catch (Throwable unused) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(aVar, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return null;
                }
            } finally {
            }
        }

        public final TTPosition parsePosition(byte[] positionByteArray) {
            Intrinsics.checkNotNullParameter(positionByteArray, "positionByteArray");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(positionByteArray);
            try {
                com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(byteArrayInputStream);
                try {
                    try {
                        TTPosition tTPosition = new TTPosition(aVar.readInt(), aVar.readInt(), aVar.readInt());
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return tTPosition;
                    } finally {
                    }
                } catch (Throwable unused) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(aVar, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return null;
                }
            } finally {
            }
        }

        public final RectF parseRectF(byte[] rectFByteArray) {
            Intrinsics.checkNotNullParameter(rectFByteArray, "rectFByteArray");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(rectFByteArray);
            try {
                com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(byteArrayInputStream);
                try {
                    try {
                        RectF rectF = new RectF(aVar.readFloat(), aVar.readFloat(), aVar.readFloat(), aVar.readFloat());
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return rectF;
                    } catch (IOException | IllegalArgumentException unused) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return null;
                    }
                } finally {
                }
            } finally {
            }
        }

        public final SelectionInfo parseSelectionInfo(byte[] selectionInfoByteArray) {
            Intrinsics.checkNotNullParameter(selectionInfoByteArray, "selectionInfoByteArray");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectionInfoByteArray);
            try {
                com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(byteArrayInputStream);
                try {
                    try {
                        Companion companion = ProtocolUtils.Companion;
                        TTPosition parsePositionFromStream = companion.parsePositionFromStream(aVar);
                        if (parsePositionFromStream == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        TTPosition parsePositionFromStream2 = companion.parsePositionFromStream(aVar);
                        if (parsePositionFromStream2 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        LineLayoutBounds parseLineLayoutBoundsFromStream = companion.parseLineLayoutBoundsFromStream(aVar);
                        if (parseLineLayoutBoundsFromStream == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        LineLayoutBounds parseLineLayoutBoundsFromStream2 = companion.parseLineLayoutBoundsFromStream(aVar);
                        if (parseLineLayoutBoundsFromStream2 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        TTPagePosition parsePagePositionFromStream = companion.parsePagePositionFromStream(aVar);
                        if (parsePagePositionFromStream == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        LineLayoutBounds parseLineLayoutBoundsFromStream3 = companion.parseLineLayoutBoundsFromStream(aVar);
                        if (parseLineLayoutBoundsFromStream3 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        TTPagePosition parsePagePositionFromStream2 = companion.parsePagePositionFromStream(aVar);
                        if (parsePagePositionFromStream2 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        LineLayoutBounds parseLineLayoutBoundsFromStream4 = companion.parseLineLayoutBoundsFromStream(aVar);
                        if (parseLineLayoutBoundsFromStream4 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        boolean readBoolean = aVar.readBoolean();
                        String parseStringFromStream = companion.parseStringFromStream(aVar);
                        if (parseStringFromStream == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        String parseStringFromStream2 = companion.parseStringFromStream(aVar);
                        if (parseStringFromStream2 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        String parseStringFromStream3 = companion.parseStringFromStream(aVar);
                        if (parseStringFromStream3 == null) {
                            CloseableKt.closeFinally(aVar, null);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return null;
                        }
                        SelectionInfo selectionInfo = new SelectionInfo(parsePositionFromStream, parsePositionFromStream2, parseLineLayoutBoundsFromStream, parseLineLayoutBoundsFromStream2, parsePagePositionFromStream, parseLineLayoutBoundsFromStream3, parsePagePositionFromStream2, parseLineLayoutBoundsFromStream4, readBoolean, parseStringFromStream, parseStringFromStream2, parseStringFromStream3);
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return selectionInfo;
                    } catch (IOException | IllegalArgumentException unused) {
                        CloseableKt.closeFinally(aVar, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return null;
                    }
                } finally {
                }
            } finally {
            }
        }

        public final void writeInsertedRunDelegate(int i, h delegate, DataOutputStream output) throws IOException {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(output, "output");
            output.writeInt(delegate.a);
            output.writeInt(delegate.b);
            output.writeInt(delegate.c);
            output.writeByte(delegate.d & 255);
            output.writeFloat(TTEpubUtils.Px2Dp(delegate.e));
            writeRunDelegate(i, delegate, output);
        }

        public final void writeRunDelegate(int i, IRunDelegate iRunDelegate, DataOutputStream dataOutputStream) throws IOException {
            Intrinsics.checkNotNullParameter(dataOutputStream, "dataOutputStream");
            if (iRunDelegate == null) {
                dataOutputStream.writeInt(0);
                dataOutputStream.writeFloat(0.0f);
                dataOutputStream.writeFloat(0.0f);
                dataOutputStream.writeFloat(0.0f);
                dataOutputStream.writeInt(0);
                return;
            }
            dataOutputStream.writeInt(i);
            dataOutputStream.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAscent()));
            dataOutputStream.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetDescent()));
            dataOutputStream.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAdvance()));
            dataOutputStream.writeInt(iRunDelegate.GetVerticalAlign());
        }
    }
}
