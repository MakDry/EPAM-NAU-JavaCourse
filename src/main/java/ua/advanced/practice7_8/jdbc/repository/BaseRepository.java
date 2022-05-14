package ua.advanced.practice7_8.jdbc.repository;

import ua.advanced.practice7_8.jdbc.connections.ConnectionSetter;

public abstract class BaseRepository {
    protected ConnectionSetter connectionSetter = new ConnectionSetter();
}
