/*
1.List the customer number, the name, the phone number, and the city of customers.
*/
#select custno,custname,phone,city from customer;

/*
2.List the customer number, the name, the phone number,
 and the city of customers who reside in Colorado (State is CO).
 */
 #select custno,custname,phone,city from customer where state = 'CO';
 
 /*
 3.List all columns of the EventRequest table for events costing more than $4000.
 Order the result by the event date (DateHeld).
 */
 #select * from eventrequest where estcost>4000 order by dateheld;
 
 /*
 4.List the event number, the event date (DateHeld), and
 the estimated audience number with approved status and audience greater than 9000
 or with pending status and audience greater than 7000.
 */
 #select eventno,dateheld,estaudience from eventrequest where (status='Approved' and estaudience>9000) or (status = 'Pending' and estaudience>7000);
 
 /*
 5.List the event number, event date (DateHeld), customer number and customer name of events
 placed in January 2018 by customers from Boulder.
*/

#select eventno,dateheld,eve.custno,custname from eventrequest as eve,customer as cus where
# eve.custno = cus.custno and (dateheld between '2018-01-01' and '2018-01-31') and city = 'Boulder';



/*
6.List the average number of resources used (NumberFld) by plan number.
 Include only location number L100.
*/
#select avg(numberfld) from eventplanline where locno='L100' group by planno;

/*
7.List the average number of resources used (NumberFld) by plan number.
 Only include location number L100. Eliminate plans with less than two event lines
 containing location number L100.
 */
 #select avg(numberfld) from eventplanline where locno='L100' group by planno having count(numberfld)>1;
 
 
 