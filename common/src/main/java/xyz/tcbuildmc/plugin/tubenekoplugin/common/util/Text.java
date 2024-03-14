package xyz.tcbuildmc.plugin.tubenekoplugin.common.util;

import java.io.Serializable;

@SuppressWarnings({"unused"})
public abstract class Text
        implements Serializable, Cloneable, Comparable<String>, CharSequence {
    private static final long serialVersionUID = 1L;

    public abstract String getText(String id, String defaultText, Object... args);

    public String getText(String id, Object... args) {
        return this.getText(id, "" , args);
    }

    public String getText(String id) {
        return this.getText(id, (Object[]) null);
    }

    public String getText(Object o) {
        return this.getText(o.toString());
    }

    
    public static Text simple() {
        return new SimpleText();
    }

    @Override
    public Text clone() {
        try {
            return (Text) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private static class SimpleText extends Text {
        private String text = "";

        @Override
        public String getText(String id, String defaultText, Object... args) {
            if (id == null || id.isEmpty()) {
                return defaultText;
            }

            if (args != null) {
                for (Object o : args) {
                    id = id.replaceFirst("%_", o.toString());
                }
            }

            this.text = id;
            return id;
        }

        @Override
        public int length() {
            return this.text.length();
        }

        @Override
        public char charAt(int index) {
            return this.text.charAt(index);
        }

        
        @Override
        public CharSequence subSequence(int start, int end) {
            return this.text.subSequence(start, end);
        }

        @Override
        public int compareTo(String o) {
            return this.text.compareTo(o);
        }
    }
}
