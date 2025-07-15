package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;
import com.codingchallenges.webserver.html.structure.VoidElement;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;

public class HrTag  extends VoidElement implements BodyTagChild {

    public HrTag() {
        super("hr", true, false, "<hr>");
    }

    @Override
    public Element getValue() {
        return this;
    }
}
