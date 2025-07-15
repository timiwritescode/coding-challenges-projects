package com.codingchallenges.webserver.html;

import com.codingchallenges.webserver.html.tags.*;

import java.util.ArrayList;
import java.util.List;

public class Document {
    List<Element> elements = new ArrayList<>();
    HeadTag headTag = new HeadTag();
    BodyTag bodyTag = new BodyTag();

    public static void main(String[] args) {
        System.out.println(new Document().renderDocument());
    }

    public String renderDocument() {
        String  typeDeclaration = "<!DOCTYPE html>\n";

        HtmlTag htmlTag = new HtmlTag(headTag, bodyTag);

        TitleTag title = new TitleTag("This is a test");
        headTag.addChild(title);

        H1Tag headline = new H1Tag("THis is my http server");
        bodyTag.addChild(headline);
        bodyTag.addChild(new HrTag());
        bodyTag.addChild(new BrTag());
        UnorderedListTag ul = new UnorderedListTag();
        ListTag listElement = new ListTag();
        ul.addChild(listElement);

        ParaTag p1 = new ParaTag(new TextElement("Click this link below: "));
        listElement.addChild(p1);

        AnchorTag link =  new AnchorTag("https://google.com/");
        listElement.addChild(link);




        bodyTag.addChild(ul);

        return typeDeclaration + htmlTag.render();
    }


}
