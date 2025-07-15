package com.codingchallenges.webserver.html.tags;

import com.codingchallenges.webserver.html.Element;

import com.codingchallenges.webserver.html.structure.TextRenderable;
import com.codingchallenges.webserver.html.structure.containerElements.BodyTagChild;


public class TextElement extends Element implements BodyTagChild, TextRenderable {
  private String text;

    public TextElement(String text) {
        super(false, false);
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Element getValue() {
        return  this;
    }
}
