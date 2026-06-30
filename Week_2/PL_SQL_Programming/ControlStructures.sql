-- Scenario 1
BEGIN

  FOR customer_record IN (SELECT customer_id, age FROM customers) LOOP
    IF customer_record.age > 60 THEN
      UPDATE customers
      SET interest_rate = interest_rate - 1
      WHERE customer_id = customer_record.customer_id;
    END IF;
  END LOOP;

  COMMIT;

END;


-- Scenario 2
BEGIN 

  FOR customer_record IN (SELECT customer_id, balance FROM customers) LOOP
    IF customer_record.balance > 10000 THEN
      UPDATE customers
      SET IsVIP = TRUE
      WHERE customer_id = customer_record.customer_id;
    END IF;
    -- or we could: UPDATE customers SET IsVIP=TRUE WHERE balance > 10000;
  END LOOP;

  COMMIT;

END;


-- Scenario 3
BEGIN
  
    FOR customer_record IN (
        SELECT customer_id, loan_due_date 
        FROM customers
        WHERE loan_due_date BETWEEN SYSDATE AND (SYSDATE + 30)    
    ) LOOP
      
      DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || customer_record.customer_id || ', your loan is due on' || customer_record.loan_due_date);
    END LOOP;
END;
