import React, { useState } from 'react';

// --- Sub-Components ---

function UserGreeting(props) {
  return <h1>Welcome back</h1>;
}

function GuestGreeting(props) {
  return <h1>Please sign up.</h1>;
}

// Conditionally renders the greeting based on the isLoggedIn prop
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

// Login button component
function LoginButton(props) {
  return (
    <button onClick={props.onClick} style={{ padding: '5px 15px' }}>
      Login
    </button>
  );
}

// Logout button component
function LogoutButton(props) {
  return (
    <button onClick={props.onClick} style={{ padding: '5px 15px' }}>
      Logout
    </button>
  );
}

// --- Main App Component ---

function App() {
  // State to track if the user is logged in (default is false)
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Event handlers to update the state
  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // Element variable to hold the correct button based on state
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div style={{ marginLeft: '100px', marginTop: '50px' }}>
      {/* Pass the state to the Greeting component */}
      <Greeting isLoggedIn={isLoggedIn} />

      {/* Render the button element variable */}
      {button}
    </div>
  );
}

export default App;
