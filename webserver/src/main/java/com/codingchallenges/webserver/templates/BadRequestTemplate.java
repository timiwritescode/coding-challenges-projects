package com.codingchallenges.webserver.templates;

import com.codingchallenges.webserver.html.tags.ParaTag;
import com.codingchallenges.webserver.html.tags.TextElement;

public class BadRequestTemplate extends BaseTemplate{
    public BadRequestTemplate constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Bad request"));
        body.addChild(paragraph);
        return this;
    }
}
