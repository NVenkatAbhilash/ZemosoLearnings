/*
1.	List the city, state, and zip codes in the customer table. Your result should
 not have duplicates. (Hint: The DISTINCT keyword eliminates duplicates.)
*/

#select Distinct City, State, Zip from Customer;

/*
2.	List the name, department, phone number, and email address of employees
 with a phone number beginning with “3-”.
*/

#select EmpName, Department, Phone, Email from Employee where Phone like ('3-%');

/*
3.	List all columns of the resource table with a rate between $10 and $20.
 Sort the result by rate.
*/

#select * from resourcetbl where rate between 10 and 20 order by rate;

/*
4.	List the event requests with a status of “Approved” or “Denied” and
 an authorized date in July 2018. Include the event number, authorization date,
 and status in the output. (Hint: see the examples in Module 4 for date constants
 in Oracle and MySQL.)
*/

#select EventNo, DateAuth, Status from EventRequest where status IN ('Approved','Denied')
# and (DateAuth between '2018-07-01' and '2018-07-31');

/*
5.	List the location number and name of locations that are part of the “Basketball arena”.
  Your WHERE clause should not have a condition involving the facility number
  compared to a constant (“F101”). Instead, you should use a condition on the FacName column
  for the value of “Basketball arena”.
*/

#select LocNo, LocName from Location as Loc,Facility as Fac where FacName = 'Basketball arena'
# and Loc.FacNo = Fac.FacNo;

/*
6.	For each event plan, list the plan number, count of the event plan lines,
 and sum of the number of resources assigned.  For example, plan number “P100” has 4 lines
 and 7 resources assigned.  You only need to consider event plans that have at least one line.
*/

#select PlanNo,count(LineNo) as 'lines', sum(NumberFld) as 'resources assigned'  from eventplanline group by PlanNo having count(lineno)>0;
