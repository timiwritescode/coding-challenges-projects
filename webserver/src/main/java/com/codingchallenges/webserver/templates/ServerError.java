package com.codingchallenges.webserver.templates;

import com.codingchallenges.webserver.html.tags.ParaTag;
import com.codingchallenges.webserver.html.tags.TextElement;

public class ServerError extends BaseTemplate{
    public ServerError constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Server error"));
        body.addChild(paragraph);
        return this;
    }
}
