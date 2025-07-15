package com.codingchallenges.webserver.html.structure;

import com.codingchallenges.webserver.html.Element;


public abstract class TagElement extends Element {
    private final String tagName;

    public TagElement(String tagName, boolean is_self_closing, boolean is_root_element) {
        super(is_self_closing, is_root_element);
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }



}
