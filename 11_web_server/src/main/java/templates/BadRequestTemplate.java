package templates;

import html.tags.ParaTag;
import html.tags.TextElement;

public class BadRequestTemplate extends BaseTemplate{
    public BadRequestTemplate constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Bad request"));
        body.addChild(paragraph);
        return this;
    }
}
