package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.TagElement;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;

import java.util.ArrayList;
import java.util.List;

public class ParaTag extends ContainerElement implements BodyTagChild {
    List<BodyTagChild> children = new ArrayList<>();

    public ParaTag() {
        super("p", false, false, "<p>", "</p>");
    }

    public ParaTag(BodyTagChild child) {
        super("p", false, false, "<p>", "</p>");
        children.add(child);
    }

    @Override
    public String render() {
        List<Element> paraChildren = children.stream().map( BodyTagChild::getValue).toList();
        return renderContainerElements(paraChildren);
    }

    @Override
    public TagElement getValue() {
        return this;
    }
}
