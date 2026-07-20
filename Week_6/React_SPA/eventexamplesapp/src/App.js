import React, { useState } from 'react';
import { CurrencyConvertor } from './CurrencyConvertor';

function App() {
  // Initialize counter at 5 to match the screenshot
  const [count, setCount] = useState(5);

  // Increment increases the counter AND shows the static alert
  const handleIncrement = () => {
    setCount(count + 1);
    alert("Hello! Member1");
  };

  // Decrement just decreases the counter
  const handleDecrement = () => {
    setCount(count - 1);
  };

  // Accepts "welcome" as an argument
  const handleWelcome = (message) => {
    alert(message);
  };

  // Handles the synthetic event
  const handleSyntheticEvent = (e) => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: '20px' }}>
      <p>{count}</p>

      <div style={{ display: 'flex', flexDirection: 'column', width: '120px', gap: '5px' }}>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>

        {/* Arrow function used here to pass the argument safely */}
        <button onClick={() => handleWelcome('welcome')}>Say welcome</button>

        <button onClick={handleSyntheticEvent}>Click on me</button>
      </div>

      {/* Render the form component below the buttons */}
      <CurrencyConvertor />
    </div>
  );
}

export default App;
