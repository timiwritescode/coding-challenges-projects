package html.tags;

import html.Element;
import html.structure.TagElement;
import html.structure.containerElements.BodyTagChild;
import html.structure.containerElements.ContainerElement;

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
