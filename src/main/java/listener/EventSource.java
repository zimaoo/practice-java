package listener;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EventSource {
    private String name;
    private Set<NameChangedEventListener> listenerSet;

    public EventSource() {
        this.name = "defaultName";
        this.listenerSet = new HashSet<>();
    }

    public void addHiEventListener(NameChangedEventListener listener) {
        listenerSet.add(listener);
    }

    public void notifyAllListeners() {
        Iterator<NameChangedEventListener> iterator = listenerSet.iterator();
        while (iterator.hasNext()) {
            iterator.next().nameChanged(new NameChangedEvent(this));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (!this.name.equals(newName)) {
            this.name = newName;
            notifyAllListeners();
        }
    }
}
