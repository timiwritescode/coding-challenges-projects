package html.structure;


import java.util.HashMap;
import java.util.Map;

public abstract class VoidElement extends TagElement{
    protected final String tag;
    protected Map<String, String> attributes = new HashMap<>();

    public VoidElement(String tagName, boolean is_self_closing, boolean is_root_element, String tag) {
        super(tagName, is_self_closing, is_root_element);
        this.tag = tag;
    }


    public void addAttributes(String attribute, String value) {
        this.attributes.put(attribute, value);

    }

    @Override
    public String render() {
        StringBuilder stringBuilder = new StringBuilder();;
        attributes.forEach((k, v) -> {
            stringBuilder.append(k).append("=").append("\"").append(v).append("\" ");

        });
        String elementsAttributes = stringBuilder.toString();
        if (tag.contains("/")) {
            return tag.split("/>")[0] + elementsAttributes + "/>";
        }
        return tag.split(">")[0] + elementsAttributes + ">";
    }
}
