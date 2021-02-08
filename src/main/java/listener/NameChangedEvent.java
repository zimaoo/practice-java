package listener;

import java.util.EventObject;

public class NameChangedEvent extends EventObject {
    private Object source;

    public NameChangedEvent(Object source) {
        super(source);
        this.source = source;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
