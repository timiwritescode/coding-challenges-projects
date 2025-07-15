package com.codingchallenges.webserver.html.tags;


import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;

import java.util.ArrayList;
import java.util.List;

public class AnchorTag extends ContainerElement implements BodyTagChild {
    private final String src = "";
    private List<BodyTagChild> children = new ArrayList<>();

    public AnchorTag(String link) {
        super("p", false, false, "<a>", "</a>");
        children.add(new TextElement(link));
        this.addAttribute("href", link);
    }

    public AnchorTag(BodyTagChild child, String link) {
        super("p", false, false, "<a>", "</a>");
        children.add(child);
        this.addAttribute("href", link);
    }


    public void addChild(BodyTagChild child) {
        children.add(child);
    }

    @Override
    public String render() {
        List<Element> anchorChildren = children.stream().map(BodyTagChild::getValue).toList();
        return renderContainerElements(anchorChildren);
    }

    @Override
    public Element getValue() {
        return this;
    }
}
