package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.fl;
import com.xiaomi.push.fp;
import com.xiaomi.push.fr;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fv {
    private static XmlPullParser a;

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    static {
        Covode.recordClassIndex(655540);
        a = null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fq m445a(XmlPullParser xmlPullParser) {
        fq fqVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fqVar = new fq(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return fqVar;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m447a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fp m444a(XmlPullParser xmlPullParser) {
        fp.b bVar = fp.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fp.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fp fpVar = new fp(bVar);
        fpVar.m(xmlPullParser.getAttributeValue("", "to"));
        fpVar.n(xmlPullParser.getAttributeValue("", "from"));
        fpVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fpVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fpVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fpVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fpVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fpVar.a(fp.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fpVar.a(m446a(xmlPullParser));
                } else {
                    fpVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fpVar;
    }

    public static fn a(XmlPullParser xmlPullParser) {
        String str;
        boolean z;
        boolean z2 = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            am.b a2 = com.xiaomi.push.service.am.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = com.xiaomi.push.service.am.a().a(attributeValue, attributeValue3);
            }
            if (a2 != null) {
                fn fnVar = null;
                while (!z2) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if ("s".equals(xmlPullParser.getName())) {
                            if (xmlPullParser.next() == 4) {
                                String text = xmlPullParser.getText();
                                if (!"5".equals(attributeValue) && !"6".equals(attributeValue)) {
                                    a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(a2.h, attributeValue2), text));
                                    a.next();
                                    fnVar = a(a);
                                } else {
                                    fm fmVar = new fm();
                                    fmVar.l(attributeValue);
                                    fmVar.b(true);
                                    fmVar.n(attributeValue3);
                                    fmVar.m(attributeValue4);
                                    fmVar.k(attributeValue2);
                                    fmVar.f(attributeValue5);
                                    fk fkVar = new fk("s", null, null, null);
                                    fkVar.m433a(text);
                                    fmVar.a(fkVar);
                                    return fmVar;
                                }
                            } else {
                                throw new fh("error while receiving a encrypted message with wrong format");
                            }
                        } else {
                            throw new fh("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z2 = true;
                    }
                }
                if (fnVar != null) {
                    return fnVar;
                }
                throw new fh("error while receiving a encrypted message with wrong format");
            }
            throw new fh("the channel id is wrong while receiving a encrypted message");
        }
        fm fmVar2 = new fm();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fmVar2.k(attributeValue6);
        fmVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fmVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fmVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fmVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fmVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fmVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fmVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fmVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true")) {
            z = true;
        } else {
            z = false;
        }
        fmVar2.a(z);
        fmVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b != null && !"".equals(b.trim())) {
            fmVar2.j(b);
        } else {
            fn.q();
        }
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    fmVar2.g(m447a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m447a = m447a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        fmVar2.a(m447a, attributeValue11);
                    } else {
                        fmVar2.h(m447a);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fmVar2.a(m446a(xmlPullParser));
                } else {
                    fmVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z2 = true;
            }
        }
        fmVar2.i(str2);
        return fmVar2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fr m446a(XmlPullParser xmlPullParser) {
        String str;
        ArrayList arrayList = new ArrayList();
        String str2 = "-1";
        boolean z = false;
        String str3 = null;
        String str4 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str2 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str4 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str3 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str5 = null;
        String str6 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str6 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str5 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str6 = xmlPullParser.getText();
            }
        }
        if (str4 == null) {
            str = "cancel";
        } else {
            str = str4;
        }
        return new fr(Integer.parseInt(str2), str, str3, str5, str6, arrayList);
    }

    public static fl a(XmlPullParser xmlPullParser, ez ezVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fl.a a2 = fl.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fl flVar = null;
        fr frVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    frVar = m446a(xmlPullParser);
                } else {
                    flVar = new fl();
                    flVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (flVar == null) {
            if (fl.a.a != a2 && fl.a.b != a2) {
                flVar = new fl() { // from class: com.xiaomi.push.fv.2
                    @Override // com.xiaomi.push.fl
                    public String b() {
                        return null;
                    }
                };
            } else {
                fl flVar2 = new fl() { // from class: com.xiaomi.push.fv.1
                    @Override // com.xiaomi.push.fl
                    public String b() {
                        return null;
                    }
                };
                flVar2.k(attributeValue);
                flVar2.m(attributeValue3);
                flVar2.n(attributeValue2);
                flVar2.a(fl.a.d);
                flVar2.l(attributeValue4);
                flVar2.a(new fr(fr.a.e));
                ezVar.a(flVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        flVar.k(attributeValue);
        flVar.m(attributeValue2);
        flVar.l(attributeValue4);
        flVar.n(attributeValue3);
        flVar.a(a2);
        flVar.a(frVar);
        flVar.a(hashMap);
        return flVar;
    }

    public static fk a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m442a = fu.a().m442a("all", "xm:chat");
        if (m442a != null && (m442a instanceof com.xiaomi.push.service.i)) {
            return ((com.xiaomi.push.service.i) m442a).b(xmlPullParser);
        }
        return null;
    }
}
