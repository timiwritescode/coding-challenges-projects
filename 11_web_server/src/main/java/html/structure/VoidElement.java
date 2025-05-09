package html.structure;


public abstract class VoidElement extends TagElement{

    public VoidElement(String tagName, boolean is_self_closing, boolean is_root_element) {
        super(tagName, is_self_closing, is_root_element);
    }
}
