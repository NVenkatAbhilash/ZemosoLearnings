
 /*
 Database Modification Problems
1.	Insert a new row into the Facility table with facility name “Swimming Pool”.
*/
 
 #Insert into Facility Values ('539','Swimming Pool');
 
 /*
2.Insert a new row in the Location table related to the Facility row in modification
 problem 1. The new row should have “Door” for the location name.
*/
 
 #Insert into Location Values ('L539','539','Door');
 
 /*
3.	Insert a new row in the Location table related to the Facility row in modification
 problem 1. The new row should have “Locker Room” for the location name.
*/
 
# Insert into Location Values ('L566','539','Locker Room');
 
 /*
 4.	Change the location name of “Door” to “Gate” for the row inserted in modification problem 2. In MySQL, you need to place the UPDATE statement between two SET statements.
SET SQL_SAFE_UPDATES = 0;
UPDATE statement
       SET SQL_SAFE_UPDATES = 1;
*/
 
 /*
SET SQL_SAFE_UPDATES = 0;
UPDATE Location Set LocName = 'Gate' where LocName = 'Door';
SET SQL_SAFE_UPDATES = 1; 
 */ 
 
 /*
 5.	Delete the row inserted in modification problem 3.
 */
 
 #Delete from Location where LocNo = 'L566';