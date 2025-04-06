package models;

public class Symbol {
    private char aChar;
    private String avatarUrl;

    public Symbol(char aChar) {
        this.aChar = aChar;

    }
    public char getaChar() {

        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
