package listener;

import java.util.EventListener;

public class NameChangedEventListener implements EventListener {
    public void nameChanged(NameChangedEvent e) {
        EventSource source = (EventSource) e.getSource();
        System.out.println(String.format("Name changed, the new name is %s", source.getName()));
    }
}
