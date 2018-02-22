# validate transaction data that displayed in the UI compare with database data

The idea is to have separate package to communicate with database.
This package will store Classes that each class have specific area and class method have specific function.

after retrieving the data from database, use the data as assertion parameter (compare what that displayed in the UI and actual data)

steps :
1. Get transaction ID that displayed in the UI
2. Use this data as parameter for method that perform query in 'transaction table'
3. If the method return Null means that the transaction ID is not valid because not stored in the database
4. We can instantly flag this test as failed test
5. If data not Null, get all correspond data that related to that transaction ID (Seller, Address, Delivery Services , etc)
4. Verify each element in the UI have the same data (display correctly) as what stored in the database
