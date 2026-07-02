-- SCENARIO 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS 
  -- no variables needed

BEGIN
    UPDATE customers
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'savings';
  
  COMMIT;
END;


-- SCENARIO 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department_id IN NUMBER,
  p_bonus_percentage IN NUMBER  
) IS 
  
  multiplier NUMBER  := p_bonus_percentage / 100.0;

BEGIN
    UPDATE employees
    SET salary = salary + (salary * multiplier)
    WHERE department_id = p_department_id;

  COMMIT;
END;


-- SCENARIO 3
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_source_customer_id IN NUMBER,
  P_sink_customer_id IN NUMBER,
  p_amount IN NUMBER
) IS 
  v_source_balance NUMBER;

BEGIN
    SELECT balance INTO v_source_balance FROM customers WHERE customer_id = p_source_customer_id;
    
    IF v_source_balance >= p_amount THEN
      UPDATE customers
      SET balance = balance - p_amount
      WHERE customer_id = p_source_customer_id;
      
      UPDATE customers
      SET balance = balance + p_amount
      WHERE customer_id = P_sink_customer_id;
    END IF;

  COMMIT;

EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;

END;
