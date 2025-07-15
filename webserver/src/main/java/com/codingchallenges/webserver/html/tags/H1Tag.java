package com.codingchallenges.webserver.html.tags;



import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.TextRenderable;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;

import java.util.ArrayList;
import java.util.List;

public class H1Tag extends ContainerElement implements BodyTagChild, TextRenderable {
    private List<TextRenderable> children = new ArrayList<>();

    public H1Tag(String text) {
        super("h1", false, false, "<h1>", "</h1>");
        children.add(new TextElement(text));

    }

    @Override
    public String render() {
        List<Element> h1Children = children.stream().map(TextRenderable::getValue).toList();
        return this.renderContainerElements(h1Children);
    }

    @Override
    public void setText(String text) {
        children.getFirst().setText(text);
    }

    @Override
    public String getText() {
        return children.getFirst().getText();
    }

    @Override
    public Element getValue() {
        return this;
    }
}
