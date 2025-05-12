package templates;

import html.structure.containerElements.UnorderedListChild;
import html.tags.*;

import java.util.List;
import java.util.Set;

public class HomePage extends BaseTemplate{

    public HomePage constructPage(String directory, Set<String> dirListing, String rootDirectory) {
        createBoilerPlate();
        setTitle("Directory Listing for " + directory);

        ParaTag p1 = new ParaTag(new TextElement("Directory listing for " + List.of(directory.split("/")).getLast()));
        body.addChild(p1);

        UnorderedListTag ul = new UnorderedListTag();

        String parentDir = directory.equals(rootDirectory + "/") ? "" :List.of(directory.split("/")).getLast();
        for (String dir : dirListing) {
            ListTag listTag = new ListTag();

            AnchorTag anchorTag = new AnchorTag(new TextElement(dir), parentDir + "/" + dir);
            listTag.addChild(anchorTag);
            ul.addChild(listTag);
        }
        body.addChild(ul);
        return this;

    }
}
