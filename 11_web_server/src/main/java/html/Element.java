package html;

public abstract class Element {
    protected final boolean isSelfClosing;
    protected final boolean isRootElement;

    public Element(
            boolean is_self_closing,
            boolean is_root_element) {
        this.isSelfClosing = is_self_closing;
        this.isRootElement = is_root_element;

    }


    public abstract String render();

//    public static String getBoilerplate() {};
}
