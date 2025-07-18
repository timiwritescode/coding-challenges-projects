package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;
import com.codingchallenges.webserver.html.structure.containerElements.UnorderedListChild;

import java.util.ArrayList;
import java.util.List;


public class UnorderedListTag extends ContainerElement implements BodyTagChild {
    List<UnorderedListChild> children = new ArrayList<>();


    public UnorderedListTag() {
        super(
                "ul",
                false,
                false,
                "<ul>",
                "</ul>");
    }

    public void addChild(UnorderedListChild child) {
        children.add(child);
    }

//    @Override
//    public String render() {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder.append("<ul>").append("\n");
//        children.forEach(child -> {
//            String innerHtmlOfChild = child.getValue().render();
//            stringBuilder.append(innerHtmlOfChild).append("\n");
//        });
//        stringBuilder.append("<\\ul>\n");
//        return stringBuilder.toString();
//    }

    @Override
    public Element getValue() {
        return this;
    }

    @Override
    public String render() {
        List<Element> ulChildren = children.stream().map(UnorderedListChild::getValue).toList();
        return this.renderContainerElements(ulChildren);
    }
}
