package html.tags;

import html.Element;
import html.structure.VoidElement;
import html.structure.containerElements.BodyTagChild;

public class HrTag  extends VoidElement implements BodyTagChild {

    public HrTag() {
        super("hr", true, false, "<hr>");
    }

    @Override
    public Element getValue() {
        return this;
    }
}
