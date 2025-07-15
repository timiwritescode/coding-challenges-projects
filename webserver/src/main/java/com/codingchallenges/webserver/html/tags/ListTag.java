package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.TagElement;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;
import com.codingchallenges.webserver.html.structure.containerElements.UnorderedListChild;

import java.util.ArrayList;
import java.util.List;

public class ListTag extends ContainerElement implements UnorderedListChild {
    List<BodyTagChild> children = new ArrayList<>();
    String text;

    public ListTag() {

        super(
                "li",
                false,
                false,
                "<li>",
                "</li>");
    }


    public void addChild(BodyTagChild element) {
        children.add(element);
    }


    @Override
    public String render() {
        List<Element> listChildren = children.stream().map(BodyTagChild::getValue).toList();
        return renderContainerElements(listChildren);
    }


    @Override
    public TagElement getValue() {
        return this;
    }
}
