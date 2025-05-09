package html.tags;

import html.Element;
import html.structure.TagElement;
import html.structure.containerElements.BodyTagChild;
import html.structure.containerElements.ContainerElement;
import html.structure.containerElements.UnorderedListChild;

import java.util.ArrayList;
import java.util.List;

public class ListElement extends ContainerElement implements UnorderedListChild {
    List<BodyTagChild> children = new ArrayList<>();
    String text;

    public ListElement() {

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
