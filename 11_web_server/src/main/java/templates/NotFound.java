package templates;

import html.tags.ParaTag;
import html.tags.TextElement;

public class NotFound extends BaseTemplate {

        public NotFound constructMessage() {
        this.createBoilerPlate();
        ParaTag paragraph = new ParaTag(new TextElement("Path not found"));
        body.addChild(paragraph);
        return this;
    }

}
