package lang.enumm;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SceneType {
    NORMAL_ROOM((byte)0, "");

    private byte id;
    private String name;

    private static final Map<Byte, SceneType> REPOSITORY = Arrays.stream(SceneType.values()).collect(Collectors.toMap(SceneType::getId, Function.identity()));

    SceneType(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SceneType getById(int id) {
        return REPOSITORY.get(id);
    }

    public static SceneType getById(byte id) {
        return REPOSITORY.get(id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
