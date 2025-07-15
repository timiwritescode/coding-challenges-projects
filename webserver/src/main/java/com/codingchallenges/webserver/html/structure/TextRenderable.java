package com.codingchallenges.webserver.html.structure;

import com.codingchallenges.webserver.html.Element;

public interface TextRenderable {

    public void setText(String text);

    public String getText();

    public Element getValue();
}
