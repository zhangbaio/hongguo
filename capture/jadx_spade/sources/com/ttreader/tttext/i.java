package com.ttreader.tttext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttreader.tttext.TTTextDefinition;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i {
    private Canvas a;
    private j b;
    private JavaDrawerCallback c;
    private final Paint d;
    private boolean e;
    private boolean f;
    private int g;
    private final JavaFontManager h;

    static {
        Covode.recordClassIndex(654793);
    }

    private void D() throws IOException {
    }

    private static double I(double d) {
        double d2 = d % 6.283185307179586d;
        return d2 < 0.0d ? d2 + 6.283185307179586d : d2;
    }

    private void a() {
    }

    private void u() throws IOException {
    }

    private void A() {
        this.a.save();
    }

    private void y() {
        this.a.restore();
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[TTTextDefinition.PathType.values().length];
            c = iArr;
            try {
                iArr[TTTextDefinition.PathType.kLines.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[TTTextDefinition.PathType.kArc.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[TTTextDefinition.PathType.kBezier.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[TTTextDefinition.PathType.kMoveTo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[TTTextDefinition.PathType.kMultiPath.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[TTTextDefinition.PaintOp.values().length];
            b = iArr2;
            try {
                iArr2[TTTextDefinition.PaintOp.kFillStyle.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[TTTextDefinition.PaintOp.kStrokeWidth.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[TTTextDefinition.PaintOp.kColor.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[TTTextDefinition.PaintOp.kTextSize.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[TTTextDefinition.PaintOp.kBold.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[TTTextDefinition.PaintOp.kItalic.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[TTTextDefinition.PaintOp.kFont.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[TTTextDefinition.CanvasOp.values().length];
            a = iArr3;
            try {
                iArr3[TTTextDefinition.CanvasOp.kStartPaint.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kEndPaint.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kSave.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kRestore.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kClear.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kTranslate.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kScale.ordinal()] = 7;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kRotate.ordinal()] = 8;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kSkew.ordinal()] = 9;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kClipRect.ordinal()] = 10;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kClearRect.ordinal()] = 11;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kFillRect.ordinal()] = 12;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawArc.ordinal()] = 13;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawLine.ordinal()] = 14;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawOval.ordinal()] = 15;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawPath.ordinal()] = 16;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawRect.ordinal()] = 17;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawText.ordinal()] = 18;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawArcTo.ordinal()] = 19;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawColor.ordinal()] = 20;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawImage.ordinal()] = 21;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawCircle.ordinal()] = 22;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawGlyphs.ordinal()] = 23;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawImageRect.ordinal()] = 24;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawRunDelegate.ordinal()] = 25;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawBackgroundDelegate.ordinal()] = 26;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawHighlight.ordinal()] = 27;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                a[TTTextDefinition.CanvasOp.kDrawTextContent.ordinal()] = 28;
            } catch (NoSuchFieldError unused40) {
            }
        }
    }

    private void i(com.ttreader.tttext.a aVar) throws IOException {
        aVar.readInt();
    }

    private void B(com.ttreader.tttext.a aVar) throws IOException {
        this.a.scale(aVar.readFloat(), aVar.readFloat());
    }

    private void z(com.ttreader.tttext.a aVar) throws IOException {
        this.a.rotate(aVar.readFloat());
    }

    private void C(com.ttreader.tttext.a aVar) throws IOException {
        this.a.skew(s.a(aVar.readFloat()), s.a(aVar.readFloat()));
    }

    private void E(com.ttreader.tttext.a aVar) throws IOException {
        this.a.translate(s.a(aVar.readFloat()), s.a(aVar.readFloat()));
    }

    private void b(com.ttreader.tttext.a aVar) throws IOException {
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
    }

    private void p(com.ttreader.tttext.a aVar) throws IOException {
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        w(aVar);
    }

    private void q(com.ttreader.tttext.a aVar) throws IOException {
        Path path = new Path();
        x(path, aVar);
        path.close();
        this.a.drawPath(path, w(aVar));
    }

    private void t(com.ttreader.tttext.a aVar) throws IOException {
        this.a.drawText(aVar.a(), s.a(aVar.readFloat()), s.a(aVar.readFloat()), w(aVar));
    }

    private void G(com.ttreader.tttext.a aVar) throws IOException {
        int d;
        boolean z;
        float f = 0.0f;
        String str = null;
        do {
            d = aVar.d();
            if ((d & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                aVar.skipBytes(d >>> 2);
            } else {
                String a2 = aVar.a();
                str = a2;
                f = s.a(aVar.readFloat());
            }
        } while ((d & 1) != 0);
        float a3 = s.a(aVar.readFloat());
        Paint w = w(aVar);
        if (str != null) {
            this.a.drawText(str, f, a3, w);
        }
    }

    private void c(com.ttreader.tttext.a aVar) throws IOException {
        this.a.clipRect(s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()));
    }

    private void d(com.ttreader.tttext.a aVar) throws IOException {
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        aVar.readInt();
        w(aVar);
    }

    private void e(com.ttreader.tttext.a aVar) throws IOException {
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        s.a(aVar.readFloat());
        w(aVar);
    }

    private void h(com.ttreader.tttext.a aVar) throws IOException {
        this.a.drawCircle(s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), w(aVar));
    }

    private void k(com.ttreader.tttext.a aVar) throws IOException {
        String a2 = aVar.a();
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        float a6 = s.a(aVar.readFloat());
        Paint w = w(aVar);
        JavaDrawerCallback javaDrawerCallback = this.c;
        if (javaDrawerCallback == null) {
            return;
        }
        javaDrawerCallback.DrawHighlight(this.a, a2, a3, a4, a5, a6, w);
    }

    private void n(com.ttreader.tttext.a aVar) throws IOException {
        this.a.drawLine(s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), w(aVar));
    }

    private void r(com.ttreader.tttext.a aVar) throws IOException {
        this.a.drawRect(s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), s.a(aVar.readFloat()), w(aVar));
    }

    private void v(com.ttreader.tttext.a aVar) throws IOException {
        int readInt = aVar.readInt();
        float a2 = s.a(aVar.readFloat());
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        Paint paint = new Paint();
        paint.setColor(readInt);
        paint.setStyle(Paint.Style.FILL);
        this.a.drawRect(a2, a3, a4, a5, paint);
    }

    private void f(com.ttreader.tttext.a aVar) throws IOException {
        int readInt = aVar.readInt();
        float a2 = s.a(aVar.readFloat());
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        w(aVar);
        JavaDrawerCallback javaDrawerCallback = this.c;
        if (javaDrawerCallback == null) {
            return;
        }
        javaDrawerCallback.DrawBackgroundDelegate(this.b.h(readInt), new Rect((int) a2, (int) a3, (int) (a2 + a4), (int) (a3 + a5)));
    }

    private void j(com.ttreader.tttext.a aVar) throws IOException {
        TTTextDefinition.FontWeight fontWeight;
        TTTextDefinition.FontStyle fontStyle;
        long readLong = aVar.readLong();
        int readInt = aVar.readInt();
        int[] iArr = new int[readInt];
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = aVar.readInt();
            fArr[i] = s.a(aVar.readFloat());
        }
        s.a(aVar.readFloat());
        Paint w = w(aVar);
        JavaFontManager javaFontManager = this.h;
        int i2 = (int) readLong;
        if (this.e) {
            fontWeight = TTTextDefinition.FontWeight.kBold_700;
        } else {
            fontWeight = TTTextDefinition.FontWeight.kNormal_400;
        }
        if (this.f) {
            fontStyle = TTTextDefinition.FontStyle.kItalic;
        } else {
            fontStyle = TTTextDefinition.FontStyle.kNormal;
        }
        javaFontManager.ApplyFont(w, i2, fontWeight, fontStyle);
    }

    private void l(com.ttreader.tttext.a aVar) throws IOException {
        int readInt = aVar.readInt();
        byte[] bArr = new byte[readInt];
        aVar.read(bArr, 0, readInt);
        float a2 = s.a(aVar.readFloat());
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        Paint w = w(aVar);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, readInt);
        this.a.drawBitmap(decodeByteArray, new Rect(0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight()), new Rect((int) a2, (int) a3, (int) a4, (int) a5), w);
    }

    private void m(com.ttreader.tttext.a aVar) throws IOException {
        int readInt = aVar.readInt();
        byte[] bArr = new byte[readInt];
        aVar.read(bArr, 0, readInt);
        float a2 = s.a(aVar.readFloat());
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        float a6 = s.a(aVar.readFloat());
        float a7 = s.a(aVar.readFloat());
        float a8 = s.a(aVar.readFloat());
        float a9 = s.a(aVar.readFloat());
        Paint w = w(aVar);
        this.a.drawBitmap(BitmapFactory.decodeByteArray(bArr, 0, readInt), new Rect((int) a2, (int) a3, (int) a4, (int) a5), new Rect((int) a6, (int) a7, (int) a8, (int) a9), w);
    }

    private void s(com.ttreader.tttext.a aVar) throws IOException {
        int readInt = aVar.readInt();
        float a2 = s.a(aVar.readFloat());
        float a3 = s.a(aVar.readFloat());
        float a4 = s.a(aVar.readFloat());
        float a5 = s.a(aVar.readFloat());
        aVar.readInt();
        w(aVar);
        JavaDrawerCallback javaDrawerCallback = this.c;
        if (javaDrawerCallback == null) {
            return;
        }
        javaDrawerCallback.DrawRunDelegate(this.a, this.b.h(readInt), new Rect((int) a2, (int) a3, (int) a4, (int) a5));
    }

    public void g(byte[] bArr) {
        this.c.OnPreDrawBuffer(bArr);
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        try {
            int readInt = aVar.readInt();
            if (readInt != 2) {
                this.c.HandleDrawException(new IllegalStateException("指令版本：" + readInt + "，当前版本：2"));
                return;
            }
            aVar.skipBytes(aVar.readInt() - 8);
            while (aVar.available() > 0) {
                o(aVar);
            }
        } catch (Throwable th) {
            this.c.HandleDrawException(th);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0002 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0008  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H(com.ttreader.tttext.a r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            int r2 = r7.available()
            if (r2 <= 0) goto L9b
            int r2 = r7.c()
            com.ttreader.tttext.TTTextDefinition$PaintOp r2 = com.ttreader.tttext.TTTextDefinition.e(r2)
            com.ttreader.tttext.TTTextDefinition$PaintOp r3 = com.ttreader.tttext.TTTextDefinition.PaintOp.kEnd
            if (r2 != r3) goto L16
            goto L9b
        L16:
            int[] r3 = com.ttreader.tttext.i.a.b
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 1
            switch(r2) {
                case 1: goto L78;
                case 2: goto L6a;
                case 3: goto L60;
                case 4: goto L52;
                case 5: goto L4a;
                case 6: goto L43;
                case 7: goto L23;
                default: goto L22;
            }
        L22:
            goto L2
        L23:
            int r1 = r7.readInt()
            r6.g = r1
            com.ttreader.tttext.JavaFontManager r2 = r6.h
            android.graphics.Paint r3 = r6.d
            boolean r4 = r6.e
            if (r4 == 0) goto L34
            com.ttreader.tttext.TTTextDefinition$FontWeight r4 = com.ttreader.tttext.TTTextDefinition.FontWeight.kBold_700
            goto L36
        L34:
            com.ttreader.tttext.TTTextDefinition$FontWeight r4 = com.ttreader.tttext.TTTextDefinition.FontWeight.kNormal_400
        L36:
            boolean r5 = r6.f
            if (r5 == 0) goto L3d
            com.ttreader.tttext.TTTextDefinition$FontStyle r5 = com.ttreader.tttext.TTTextDefinition.FontStyle.kItalic
            goto L3f
        L3d:
            com.ttreader.tttext.TTTextDefinition$FontStyle r5 = com.ttreader.tttext.TTTextDefinition.FontStyle.kNormal
        L3f:
            r2.ApplyFont(r3, r1, r4, r5)
            goto L1
        L43:
            boolean r1 = r7.readBoolean()
            r6.f = r1
            goto L50
        L4a:
            boolean r1 = r7.readBoolean()
            r6.e = r1
        L50:
            r1 = 1
            goto L2
        L52:
            float r2 = r7.readFloat()
            float r2 = com.ttreader.tttext.s.a(r2)
            android.graphics.Paint r3 = r6.d
            r3.setTextSize(r2)
            goto L2
        L60:
            int r2 = r7.readInt()
            android.graphics.Paint r3 = r6.d
            r3.setColor(r2)
            goto L2
        L6a:
            android.graphics.Paint r2 = r6.d
            float r3 = r7.readFloat()
            float r3 = com.ttreader.tttext.s.a(r3)
            r2.setStrokeWidth(r3)
            goto L2
        L78:
            int r2 = r7.readInt()
            if (r2 == 0) goto L92
            if (r2 == r3) goto L89
            android.graphics.Paint r2 = r6.d
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL_AND_STROKE
            r2.setStyle(r3)
            goto L2
        L89:
            android.graphics.Paint r2 = r6.d
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            goto L2
        L92:
            android.graphics.Paint r2 = r6.d
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r2.setStyle(r3)
            goto L2
        L9b:
            if (r1 == 0) goto Lb8
            com.ttreader.tttext.JavaFontManager r7 = r6.h
            android.graphics.Paint r0 = r6.d
            int r1 = r6.g
            boolean r2 = r6.e
            if (r2 == 0) goto Laa
            com.ttreader.tttext.TTTextDefinition$FontWeight r2 = com.ttreader.tttext.TTTextDefinition.FontWeight.kBold_700
            goto Lac
        Laa:
            com.ttreader.tttext.TTTextDefinition$FontWeight r2 = com.ttreader.tttext.TTTextDefinition.FontWeight.kNormal_400
        Lac:
            boolean r3 = r6.f
            if (r3 == 0) goto Lb3
            com.ttreader.tttext.TTTextDefinition$FontStyle r3 = com.ttreader.tttext.TTTextDefinition.FontStyle.kItalic
            goto Lb5
        Lb3:
            com.ttreader.tttext.TTTextDefinition$FontStyle r3 = com.ttreader.tttext.TTTextDefinition.FontStyle.kNormal
        Lb5:
            r7.ApplyFont(r0, r1, r2, r3)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttreader.tttext.i.H(com.ttreader.tttext.a):void");
    }

    private void o(com.ttreader.tttext.a aVar) throws IOException {
        switch (a.a[TTTextDefinition.a(aVar.c()).ordinal()]) {
            case 1:
                D();
                break;
            case 2:
                u();
                break;
            case 3:
                A();
                break;
            case 4:
                y();
                break;
            case 5:
                a();
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                E(aVar);
                break;
            case 7:
                B(aVar);
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                z(aVar);
                break;
            case 9:
                C(aVar);
                break;
            case 10:
                c(aVar);
                break;
            case 11:
                b(aVar);
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                v(aVar);
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                d(aVar);
                break;
            case 14:
                n(aVar);
                break;
            case 15:
                p(aVar);
                break;
            case 16:
                q(aVar);
                break;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                r(aVar);
                break;
            case 18:
                t(aVar);
                break;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                e(aVar);
                break;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                i(aVar);
                break;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                l(aVar);
                break;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                h(aVar);
                break;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                j(aVar);
                break;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                m(aVar);
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                s(aVar);
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                f(aVar);
                break;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                k(aVar);
                break;
            case 28:
                G(aVar);
                break;
        }
    }

    private Paint w(com.ttreader.tttext.a aVar) throws IOException {
        boolean z;
        TTTextDefinition.FontWeight fontWeight;
        TTTextDefinition.FontStyle fontStyle;
        if (TTTextDefinition.e(aVar.c()) == TTTextDefinition.PaintOp.kStartIncremental) {
            H(aVar);
        } else {
            int readInt = aVar.readInt();
            boolean z2 = true;
            if (readInt != 0) {
                if (readInt != 1) {
                    this.d.setStyle(Paint.Style.FILL_AND_STROKE);
                } else {
                    this.d.setStyle(Paint.Style.STROKE);
                }
            } else {
                this.d.setStyle(Paint.Style.FILL);
            }
            this.d.setStrokeWidth(s.a(aVar.readFloat()));
            this.d.setColor(aVar.readInt());
            this.d.setTextSize(s.a(aVar.readFloat()));
            if (aVar.c() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.e = z;
            if (aVar.c() == 0) {
                z2 = false;
            }
            this.f = z2;
            int readInt2 = aVar.readInt();
            JavaFontManager javaFontManager = this.h;
            Paint paint = this.d;
            if (this.e) {
                fontWeight = TTTextDefinition.FontWeight.kBold_700;
            } else {
                fontWeight = TTTextDefinition.FontWeight.kNormal_400;
            }
            if (this.f) {
                fontStyle = TTTextDefinition.FontStyle.kItalic;
            } else {
                fontStyle = TTTextDefinition.FontStyle.kNormal;
            }
            javaFontManager.ApplyFont(paint, readInt2, fontWeight, fontStyle);
            aVar.c();
        }
        return this.d;
    }

    private void x(Path path, com.ttreader.tttext.a aVar) throws IOException {
        int i = a.c[TTTextDefinition.f(aVar.c()).ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            int readInt = aVar.readInt();
                            while (i2 < readInt) {
                                x(path, aVar);
                                i2++;
                            }
                            return;
                        }
                        return;
                    }
                    path.moveTo(s.a(aVar.readFloat()), s.a(aVar.readFloat()));
                    return;
                }
                int readInt2 = aVar.readInt();
                PointF[] pointFArr = new PointF[readInt2];
                for (int i3 = 0; i3 < readInt2; i3++) {
                    pointFArr[i3] = new PointF(s.a(aVar.readFloat()), s.a(aVar.readFloat()));
                }
                if (readInt2 == 2) {
                    PointF pointF = pointFArr[0];
                    float f = pointF.x;
                    float f2 = pointF.y;
                    PointF pointF2 = pointFArr[1];
                    path.quadTo(f, f2, pointF2.x, pointF2.y);
                    return;
                }
                if (readInt2 >= 3) {
                    PointF pointF3 = pointFArr[0];
                    float f3 = pointF3.x;
                    float f4 = pointF3.y;
                    PointF pointF4 = pointFArr[1];
                    float f5 = pointF4.x;
                    float f6 = pointF4.y;
                    PointF pointF5 = pointFArr[2];
                    path.cubicTo(f3, f4, f5, f6, pointF5.x, pointF5.y);
                    return;
                }
                return;
            }
            float a2 = s.a(aVar.readFloat());
            float a3 = s.a(aVar.readFloat());
            float a4 = s.a(aVar.readFloat());
            float a5 = s.a(aVar.readFloat());
            float a6 = s.a(aVar.readFloat());
            float a7 = s.a(aVar.readFloat());
            float a8 = s.a(aVar.readFloat());
            double atan2 = Math.atan2(a3 - a5, a2 - a4);
            double F = F(a2, a3, a4, a5, a6, a7, a8);
            path.lineTo(a2, a3);
            path.addArc(new RectF(a4, a5, a6, a7), (float) atan2, (float) F);
            return;
        }
        int readInt3 = aVar.readInt();
        while (i2 < readInt3) {
            path.lineTo(s.a(aVar.readFloat()), s.a(aVar.readFloat()));
            i2++;
        }
    }

    public i(Canvas canvas, j jVar, JavaDrawerCallback javaDrawerCallback) {
        this(canvas, jVar, javaDrawerCallback, JavaFontManager.GetInstance());
    }

    public i(Canvas canvas, j jVar, JavaDrawerCallback javaDrawerCallback, JavaFontManager javaFontManager) {
        Paint paint = new Paint();
        this.d = paint;
        this.a = canvas;
        this.b = jVar;
        this.c = javaDrawerCallback;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        paint.setColor(0);
        paint.setTextSize(0.0f);
        this.e = false;
        this.f = false;
        paint.setAntiAlias(true);
        this.h = javaFontManager;
    }

    private double F(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        double atan2 = Math.atan2(f2 - f4, f - f3);
        double I = I(Math.atan2(f6 - f4, f5 - f3)) - I(atan2);
        if (I > 3.141592653589793d) {
            I -= 6.283185307179586d;
        } else if (I < -3.141592653589793d) {
            I += 6.283185307179586d;
        }
        return I * 57.29577951308232d;
    }
}
