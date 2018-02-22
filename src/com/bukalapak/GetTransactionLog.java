package com.bukalapak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetTransactionLog {


    public static Map<String,String> getTransactionLogById(String TrxId) throws Exception{

        // method for retrieve transaction log by transaction ID

        String tableName = "transaction_log";
        String sqlCommand = String.format("SELECT * FROM %s WHERE TRX_ID='%s';", tableName, TrxId);
        String [] keys = {"TRX_ID", "ADDRESS_SIP", "DATE_ORDERED", "SELLER_NAME", "DELIVERY_SERVICE" };
        ArrayList<String> array = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(sqlCommand);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData()

            // if the result null, means that transaction ID that displayed is not valid and not not found in database
            assert rsmd.getColumnCount() != null;

            while (result.next()){

                for (int i =1; i<=rsmd.getColumnCount(); i++){
                    array.add(result.getString(i));
                }
            }

            /// transform to Map so we can get the correct data by Key

            for (int index = 0; index <keys.length; index++){
                map.put(keys[index],array.get(index));
            }
            return map;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }


    }


}
