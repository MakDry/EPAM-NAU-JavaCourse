package ua.advanced.practice6;

import ua.advanced.practice6.customAnnotations.NotNull;

public interface Named {
    @NotNull
    String name();
}