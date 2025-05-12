package templates;

import html.tags.ParaTag;
import html.tags.TextElement;

public class ServerError extends BaseTemplate{
    public ServerError constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Server error"));
        body.addChild(paragraph);
        return this;
    }
}
