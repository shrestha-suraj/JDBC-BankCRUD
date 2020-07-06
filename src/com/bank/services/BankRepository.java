package com.bank.services;
import com.bank.DbConnection;
import com.bank.domain.*;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    private String queryString=null;
    private ResultSet resultSet=null;
    private Integer queryResult=null;
    public BankRepository(){
        DbConnection dbConnection=new DbConnection();
        connection=dbConnection.createConnection();
    }

    public Result add(Patron patron){
        queryString="INSERT INTO Patron VALUES (?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,patron.getId());
            preparedStatement.setString(2,patron.getName());
            preparedStatement.setBlob(3,new ByteArrayInputStream(patron.getImage()));
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Result remove(Patron patron){
        queryString="DELETE FROM Patron WHERE Patron.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,patron.getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Result update(Patron patron){
        queryString="UPDATE Patron SET name=?, image=? WHERE Patron.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setString(1,patron.getName());
            preparedStatement.setBlob(2,new ByteArrayInputStream(patron.getImage()));
            preparedStatement.setInt(3,patron.getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Patron findPatron(int id){
        Patron patron=null;
        queryString="SELECT * FROM Patron WHERE Patron.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                int patronId = resultSet.getInt("id");
                String patronName = resultSet.getString("name");
                Blob patronBlob = resultSet.getBlob("image");
                byte[] patronBlobBytes = patronBlob.getBytes(1, (int) patronBlob.length());
                patron = new Patron(patronId, patronName, patronBlobBytes);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return patron;
    }
    public List<Patron> findPatron(String name){
        List<Patron> patronList=new ArrayList<Patron>();
        queryString="SELECT * FROM Patron WHERE Patron.name=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                int patronId = resultSet.getInt("id");
                String patronName = resultSet.getString("name");
                Blob patronBlob = resultSet.getBlob("image");
                byte[] patronBlobBytes = patronBlob.getBytes(1, (int) patronBlob.length());
                patronList.add(new Patron(patronId, patronName, patronBlobBytes));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return patronList;

    }
    public Result transact(Transaction transaction){
        queryString="INSERT INTO Transaction VALUES (?,?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,transaction.getId());
            preparedStatement.setInt(2,transaction.getAccount().getId());
            preparedStatement.setDouble(3,transaction.getAmount());
            preparedStatement.setString(4,transaction.getAccountType().toString());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
//    public Transaction findTransaction(int id){
//        Transaction transaction=null;
//        queryString="SELECT * FROM Transaction NATURAL JOIN Account WHERE Transaction.id=?";
//        try{
//            preparedStatement=connection.prepareStatement(queryString);
//            preparedStatement.setInt(1,id);
//            resultSet=preparedStatement.executeQuery();
//            if(resultSet!=null){
//                resultSet.next();
//                int transactionId=resultSet.getInt("id");
//                int accountId=resultSet.getInt("account_id");
//                int bankId=resultSet.getInt("bank_id");
//                int patronId=resultSet.getInt("patron_id");
//                double amount=resultSet.getDouble("amount");
//                String type=resultSet.getString("type");
//                queryString="SELECT * FROM "
//
//                transaction=new Transaction(transactionId,new Account(accountId,bankId,patronId),amount,type);
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return Result.FAILURE;
//    }

//    }
    public Result add(Bank bank){
        queryString="INSERT INTO Bank VALUES (?,?)";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,bank.getId());
            preparedStatement.setString(2,bank.getName());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Result remove(Bank bank){
        queryString="DELETE FROM Bank WHERE Bank.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,bank.getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Result update(Bank bank){
        queryString="UPDATE Bank SET name=? WHERE Bank.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setString(1,bank.getName());
            preparedStatement.setInt(2,bank.getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Bank findBank(int id){
        Bank bank=null;
        queryString="SELECT * FROM Bank WHERE Bank.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                int bankId=resultSet.getInt("id");
                String bankName=resultSet.getString("name");
                bank=new Bank(bankId,bankName);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bank;
    }
    public List<Bank> findBank(String name){
        List<Bank> bankList=new ArrayList<Bank>();
        queryString="SELECT * FROM Bank WHERE Bank.name=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int bankId=resultSet.getInt("id");
                String bankName=resultSet.getString("name");
                bankList.add(new Bank(bankId,bankName));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bankList;
    }
    public Result add(Account account){
        queryString="INSERT INTO Account VALUES (?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,account.getId());
            preparedStatement.setInt(2,account.getBank().getId());
            preparedStatement.setInt(3,account.getPatron().getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }
    public Result update(Account account){
        queryString="UPDATE Account SET Account.bank_id=?, Account.patron_id=? WHERE Account.id=?";
        try{
            preparedStatement=connection.prepareStatement(queryString);
            preparedStatement.setInt(1,account.getBank().getId());
            preparedStatement.setInt(2,account.getPatron().getId());
            preparedStatement.setInt(3,account.getId());
            queryResult=preparedStatement.executeUpdate();
            return queryResult>0?Result.SUCCESS:Result.FAILURE;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Result.FAILURE;
    }

}
