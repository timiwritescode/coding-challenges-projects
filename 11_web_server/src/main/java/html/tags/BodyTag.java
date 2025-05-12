package html.tags;

import html.Element;

import html.structure.containerElements.ContainerElement;
import html.structure.containerElements.BodyTagChild;

import java.util.ArrayList;
import java.util.List;

public class BodyTag extends ContainerElement {
    List<BodyTagChild> children = new ArrayList<>();

    public BodyTag() {
        super("body", false, true, "<body>", "</body>");

    }

    public void addChild(BodyTagChild element) {
        children.add(element);
    }

    @Override
    public String render() {
        List<Element> bodyChildren = children.stream().map(BodyTagChild::getValue).toList();
        return renderContainerElements(bodyChildren);
    }
}
