/*
1.List the event number, date held, customer number, customer name, facility number, and
 facility name of 2018 events placed by Boulder customers.
*/

/*
select eventNo,dateHeld,cus.CustNo,custName,fac.facNo, facName 
from Facility as fac, EventRequest as eve, Customer as cus 
where eve.CustNo = cus.CustNo 
	AND eve.FacNo = fac.FacNo 
    and dateHeld between (01-01-2018 and 31-12-2018)
	and city = 'Boulder';
*/

/*
2.List the customer number, customer name, event number, date held, facility number,
 facility name, and estimated audience cost per person (EstCost / EstAudience) for
 events held on 2018, in which the estimated cost per person is less than $0.2
*/

/*
select cus.CustNo,custName,eventNo,dateHeld,fac.facNo, facName 
from Facility as fac, EventRequest as eve, Customer as cus 
where eve.CustNo = cus.CustNo 
	AND eve.FacNo = fac.FacNo 
    and  dateHeld between (01-01-2018 and 31-12-2018) 
    and estcost/estAudience<0.2 ;
*/

/*
3.List the customer number, customer name, and total estimated costs for Approved events.
 The total amount of events is the sum of the estimated cost for each event.
 Group the results by customer number and customer name.
*/

/*
select customer.custno, custname, sum(estcost) from eventRequest, Customer
 where status = 'Approved' and Customer.custno = EventRequest.custNo
 group by Customer.custno,custname;
*/

/*
4.Insert yourself as a new row in the Customer table.
*/

#Insert into Customer values ('539','Football','Box 352200','Y','No Manager','6859900','Vizag','AP','83019');

/*
5.Increase the rate by 10 percent of resource names equal to nurse.
 In MySQL, you need to place the UPDATE statement between two SET statements.
SET SQL_SAFE_UPDATES = 0;
UPDATE statement
*/
/*
SET SQL_SAFE_UPDATES = 0;
update ResourceTbl SET rate = rate*1.1 where ResName = 'nurse';
*/

/*
6.SET SQL_SAFE_UPDATES = 1;
*/

#SET SQL_SAFE_UPDATES = 1;

/*
7.Delete the new row added to the Customer table.
*/

#delete from Customer where custNo = '539';