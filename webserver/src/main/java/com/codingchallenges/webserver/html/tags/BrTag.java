package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.VoidElement;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;


public class BrTag extends VoidElement implements BodyTagChild {

    public BrTag() {
        super("br", true, false, "<br>");
    }

    @Override
    public Element getValue() {
        return this;
    }
}
