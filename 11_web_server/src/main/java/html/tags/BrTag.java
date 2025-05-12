package html.tags;

import html.Element;
import html.structure.VoidElement;
import html.structure.containerElements.BodyTagChild;

public class BrTag extends VoidElement implements BodyTagChild {

    public BrTag() {
        super("br", true, false, "<br>");
    }

    @Override
    public Element getValue() {
        return this;
    }
}
