package html.tags;

import html.Element;
import html.structure.containerElements.ContainerElement;
import html.structure.containerElements.HeadTagChild;
import html.structure.RootElement;

import java.util.ArrayList;
import java.util.List;

public class HeadTag extends ContainerElement implements RootElement {
    private List<HeadTagChild> children = new ArrayList<>();

    public HeadTag() {
        super("head", false, false, "<head>", "</head>");
    }

    public void addChild(HeadTagChild child) {
        children.add(child);
    }


    public void setTitle(String text) {
        TitleTag title = (TitleTag) children
                            .stream()
                            .filter(child -> (TitleTag) child.getValue() != null)
                            .toList()
                            .getFirst()
                            .getValue();
        title.setText(text);
    }

    @Override
    public String render() {
        List<Element> headChildren = children.stream().map(HeadTagChild::getValue).toList();
        return renderContainerElements(headChildren);
    }
}
