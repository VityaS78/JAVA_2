package lesson_7;

import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private class Entry {
        private String nick;

        public Entry(String nick) {
            this.nick = nick;
        }
    }

    private List<Entry> entryList;

    public AuthService() {
        entryList = new ArrayList<>();
        entryList.add(new Entry("nick1"));
        entryList.add(new Entry("nick2"));
        entryList.add(new Entry("nick3"));
        entryList.add(new Entry("nick4"));
    }

    public String getNick(String nick) {
        for (Entry en: entryList) {
            if (nick.equalsIgnoreCase(en.nick)) return en.nick;
        }
        return null;
    }
}
