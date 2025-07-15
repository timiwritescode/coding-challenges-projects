package com.codingchallenges.webserver.templates;

import com.codingchallenges.webserver.html.tags.ParaTag;
import com.codingchallenges.webserver.html.tags.TextElement;

public class NotFound extends BaseTemplate {

        public NotFound constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Path not found"));
        body.addChild(paragraph);
        return this;
    }

}
