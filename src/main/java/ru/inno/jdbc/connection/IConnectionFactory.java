package ru.inno.jdbc.connection;

import java.sql.Connection;

public interface IConnectionFactory {
    Connection getConnection();
}