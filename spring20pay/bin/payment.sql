create table payment(
payment_no number primary key,
payment_tid varchar2(20) not null,
payment_total number not null,
payment_name varchar2(90) not null,
payment_time date default sysdate not null
);
create table payment_detail(
payment_detail_no number primary key,
payment_no references payment(payment_no) on delete cascade,
payment_detail_name varchar2(90) not null,
payment_detail_quantity number default 1 not null,
payment_detail_price number not null
);
create sequence payment_seq;
create sequence payment_detail_seq;

-- 테이블에 상태 컬럼을 추가
alter table payment add(payment_status varchar2(12));
update payment set payment_status = '승인';
alter table payment modify(
		payment_status not null check(payment_status in ('승인', '부분취소', '취소')));
		
alter table payment_detail add(payment_detail_status char(6));
update payment_detail set payment_detail_status = '승인';
alter table payment_detail modify(
	payment_detail_status not null check(payment_detail_status in ('승인', '취소')));
commit;











