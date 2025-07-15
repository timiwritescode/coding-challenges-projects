package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.RootElement;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;
import com.codingchallenges.webserver.html.structure.containerElements.HeadTagChild;

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
