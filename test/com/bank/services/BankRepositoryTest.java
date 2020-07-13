package com.bank.services;
import com.bank.DbConnection;
import com.bank.domain.Patron;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BankRepositoryTest {
    @InjectMocks private DbConnection dbConnection;
    @Mock private Connection connection;
    @Mock private PreparedStatement preparedStatement;
    @Mock private ResultSet resultSet;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        Mockito.when(connection.prepareStatement(Mockito.any())).thenReturn(preparedStatement);
        Mockito.when(connection.prepareStatement(Mockito.any()).executeQuery()).thenReturn(resultSet);

//        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
//        when(dataSource.getConnection()).thenReturn(connection);
//        when(preparedStatement.executeQuery()).thenReturn(resultSet);
//        System.out.println("End Before Each");
    }


    @Test
    @DisplayName("First Mock")
    public void createPatron() throws SQLException {
//        Patron p=new Patron(1,"Suraj","myimage.png".getBytes());
//        BankRepository bankRepository=new BankRepository(dataSource.getConnection());
//        System.out.println(bankRepository.add(p));
    }
}
