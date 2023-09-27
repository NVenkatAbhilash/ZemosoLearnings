create table customer (
	custno varchar(8) not null,
    custname varchar(30) not null,
    address varchar(50) not null,
    internal char(1) not null,
    contact varchar(35) not null,
    phone varchar(11) not null,
    city varchar(30) not null, 
    state varchar(10) not null,
    zip char(5) not null,
    constraint PK_customer primary key (custno),
    constraint CHECK_Internal check (internal in('Y','N'))
    );
    
    create table facility(
		facno varchar(8) not null,
        facname varchar(30)  not null,
        constraint PK_facility primary key (facno),
        constraint UNIQUE_facname unique (facname)
    );
    
    create table location(
		locno char(4) not null,
        facno char(4) not null,
        locname varchar(20) not null,
        constraint PK_location primary key (locno),
        constraint FK_facno foreign key (facno) references facility(facno)
	);
    
    create table eventrequest(
		eventno varchar(8) not null,
        dateheld date not null,
        datereq date not null,
        custno varchar(8) not null,
        facno varchar(8) not null,
        dateauth date,
        status varchar(10) not null,
        estcost int not null,
        estaudience int not null,
        budno varchar(8),
        constraint PK_enentrequest primary key (eventno),
        constraint FK_event_facno foreign key (facno) references facility(facno),
        constraint FK_event_custno foreign key (custno) references customer(custno),
        constraint CHECK_status CHECK (status in('Pending','Denied','Approved')) ,
        constraint CHECK_estaudience CHECK (estaudience>0)
    );
    
    create table employee(
		empno varchar(8) not null,
        empname varchar(20) not null,
        department varchar(20) not null,
        email varchar(30)  not null unique,
        phone varchar(11) not null, 
        constraint PK_employee primary key(empno)
	);
    
   create table eventplan(
		planno varchar(8) not null,
        eventno varchar(8) not null,
        workdate date not null,
        notes varchar(30),
        activity varchar(20) not null,
        empno varchar(8),
        constraint PK_eventplan primary key (planno),
        constraint FK_eventno foreign key (eventno) references eventrequest(eventno),
        constraint FK_empno foreign key (empno) references employee(empno)
   );
   
   create table resourcetbl(
		resno varchar(8) not null,
        resname varchar(20) not null,
        rate decimal not null,
        constraint PK_resno primary key (resno),
        constraint CHECK_rate CHECK (rate>0)
   );
    
    create table eventplanline(
		planno varchar(8) not null,
        lineno int not null,
        timestart datetime not null,
        timeend datetime not null,
        numberfld int not null,
        locno varchar(8) not null,
        resno varchar(8) not null,
        constraint FK_planno foreign key (planno) references eventplan(planno),
        constraint FK_locno foreign key (locno) references location(locno),
        constraint FK_resno foreign key (resno) references resourcetbl(resno),
        constraint  PK_eventplainline primary key (planno,lineno),
        check (timestart<timeend)
    );