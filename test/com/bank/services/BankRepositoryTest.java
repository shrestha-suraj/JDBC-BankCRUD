package com.bank.services;

import com.bank.domain.Patron;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
public class BankRepositoryTest {
    @Mock private DataSource dataSource;
    @Mock private Connection connection;
    @Mock private PreparedStatement preparedStatement;
    @Mock private ResultSet resultSet;

    @BeforeEach
    public void setUp() throws Exception{
        System.out.println(dataSource);
        assertNotNull(dataSource);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(dataSource.getConnection()).thenReturn(connection);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }


    @Test
    public void createPatron() throws SQLException {
        Patron p=new Patron(1,"Suraj","myimage.png".getBytes());
        BankRepository bankRepository=new BankRepository(dataSource.getConnection());
        System.out.println(bankRepository.add(p));
    }
}
