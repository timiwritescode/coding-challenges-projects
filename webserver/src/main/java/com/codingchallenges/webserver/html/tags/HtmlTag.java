package com.codingchallenges.webserver.html.tags;


import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.RootElement;
import com.codingchallenges.webserver.html.structure.containerElements.ContainerElement;

import java.util.List;

public class HtmlTag extends ContainerElement implements RootElement {
    private final HeadTag headTag;
    private final BodyTag bodyTag;

    public HtmlTag(HeadTag headTag, BodyTag bodyTag) {
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
