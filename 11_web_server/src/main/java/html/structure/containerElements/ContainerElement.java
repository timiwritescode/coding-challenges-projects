package html.structure.containerElements;

import html.Element;
import html.structure.TagElement;

import java.util.List;

public abstract class ContainerElement extends TagElement {
     protected String openingTag;
     protected final String closingTag;
//     protected

     public ContainerElement(String tagName, boolean is_self_closing, boolean is_root_element, String openingTag, String closingTag) {
        super(tagName, is_self_closing, is_root_element);
        this.openingTag = openingTag;
        this.closingTag = closingTag;
    }

    protected String renderContainerElements(List<Element> children) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(openingTag).append("\n");
        children.forEach(child -> {

            String childInnerHtml = child.render();

            stringBuilder.append(childInnerHtml).append("\n");


        });

        stringBuilder.append(closingTag).append("\n");
        return stringBuilder.toString();
    }

    protected void addAttribute(String attribute, String value) {
         openingTag = openingTag.split(">")[0] + " " + attribute + "=\"" + value + "\">";
    }
}
