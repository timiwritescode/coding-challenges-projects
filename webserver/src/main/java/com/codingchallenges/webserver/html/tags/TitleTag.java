package com.codingchallenges.webserver.html.tags;


import com.codingchallenges.webserver.html.structure.TagElement;
import com.codingchallenges.webserver.html.structure.TextRenderable;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;
import com.codingchallenges.webserver.html.structure.containerElements.HeadTagChild;

public class TitleTag
        extends ContainerElement
        implements TextRenderable, HeadTagChild {

    TextElement textElement = new TextElement("");

    public TitleTag() {
        super(
                "title",
                false,
                false,
                "<html>",
                "</html>");

    }

    public TitleTag(String text) {
        super(
                "title",
                false,
                false,
                "<title>",
                "</title>");
        this.textElement.setText(text);
    }

    @Override
    public void setText(String text) {
        textElement.setText(text);
    }

    @Override
    public String getText() {
        return textElement.getText();
    }


    @Override
    public String render() {
        return  openingTag + getText()  + closingTag + "\n";
    }

    @Override
    public TagElement getValue() {
        return this;
    }
}
