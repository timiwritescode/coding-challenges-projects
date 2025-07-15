package com.codingchallenges.webserver.templates;

import com.codingchallenges.webserver.html.tags.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage extends BaseTemplate{

    public HomePage constructPage(String directory, Set<String> dirListing, String rootDirectory) {
        createBoilerPlate();
//        setTitle("Directory Listing for " + getParentDir(directory, rootDirectory));

        ParaTag p1 = new ParaTag(new TextElement("Directory listing for " + List.of(directory.split("/")).getLast()));
        body.addChild(p1);

        UnorderedListTag ul = new UnorderedListTag();


        String parentDir = directory.equals(rootDirectory + "/") ? "" :List.of(directory.split("/")).getLast();

        addDirectoryPath(ul, "/", ".");

        if (!directory.equals(rootDirectory + "/")) {
            String oneLevelUp = getParentDir(directory, rootDirectory);
            addDirectoryPath(ul, oneLevelUp, "..");
        }


        for (String dir : dirListing) {
            addDirectoryPath(ul, parentDir + "/" + dir, dir);

        }
        body.addChild(ul);
        return this;
    }

    private String getParentDir(String directory, String rootDir) {
        String cut = directory.replace(rootDir + "/", " ").strip();
        List<String> dirList = new ArrayList <>(List.of(cut.split("/")));

        dirList.removeLast();

        return "/" + String.join("/", dirList);
    }

    private void addDirectoryPath(UnorderedListTag unorderedListTag, String dir, String text) {
        // create the elements
        ListTag listTag = new ListTag();
        AnchorTag anchorTag = new AnchorTag(new TextElement(text), dir);
        listTag.addChild(anchorTag);
        unorderedListTag.addChild(listTag);
    }
}
