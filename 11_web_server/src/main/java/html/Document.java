package html;

import html.tags.*;

import java.util.ArrayList;
import java.util.List;

public class Document {
    List<Element> elements = new ArrayList<>();
    Head headTag = new Head();
    Body bodyTag = new Body();

    public static void main(String[] args) {
        System.out.println(new Document().renderDocument());
    }

    public String renderDocument() {
        String  typeDeclaration = "<!DOCTYPE html>\n";

        Html htmlTag = new Html(headTag, bodyTag);

        Title title = new Title("This is a test");
        headTag.addChild(title);

        H1 headline = new H1("THis is my http server");
        bodyTag.addChild(headline);
        UnorderedList ul = new UnorderedList();
        ListElement listElement = new ListElement();
        ul.addChild(listElement);

        ParaElement p1 = new ParaElement(new TextElement("Click this link below: "));
        listElement.addChild(p1);

        AnchorTag link =  new AnchorTag("https://google.com/");
        listElement.addChild(link);




        bodyTag.addChild(ul);

        return typeDeclaration + htmlTag.render();
    }


}
