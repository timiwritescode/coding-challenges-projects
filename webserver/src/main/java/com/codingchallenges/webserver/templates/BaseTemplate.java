package com.codingchallenges.webserver.templates;

import com.codingchallenges.webserver.html.tags.*;

public abstract class BaseTemplate {
    HeadTag head =  new HeadTag();
    BodyTag body = new BodyTag();
    HtmlTag htmlTag;


    BodyTag getBody() {
        return body;
    }



    protected void createBoilerPlate() {
        TitleTag title = new TitleTag("Local HTTP server");
        head.addChild(title);

        H1Tag titleHeader = new H1Tag("Simple HTTP Server");
        body.addChild(titleHeader);

        // add a strike through black line
        body.addChild(new HrTag());
        // and a blank line
        body.addChild(new BrTag());

        htmlTag = new HtmlTag(head, body);
    }

    void setTitle(String text) {
        head.setTitle(text);
    }

    public String renderTemplate() {
        // creates an html document
        String htmlVersion = "<!DOCTYPE html> \n";
        String restOfDoc = htmlTag.render();

        return htmlVersion + restOfDoc;
    }
}
