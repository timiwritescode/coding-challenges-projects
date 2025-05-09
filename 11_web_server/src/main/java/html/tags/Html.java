package html.tags;

import html.Element;
import html.structure.RootElement;
import html.structure.TagElement;
import html.structure.containerElements.ContainerElement;

import java.util.List;

public class Html  extends ContainerElement implements RootElement {
    private final Head  headTag;
    private final Body bodyTag;

    public Html(Head headTag, Body bodyTag) {
        super(
                "html",
                false,
                true,
                "<html>",
                "</html>");

        this.headTag = headTag;
        this.bodyTag = bodyTag;
    }


    @Override
    public String render() {
        List<Element> children = List.of(headTag, bodyTag);
        return renderContainerElements(children);
    }
}
