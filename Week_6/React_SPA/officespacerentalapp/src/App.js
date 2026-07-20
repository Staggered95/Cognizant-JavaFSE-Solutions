import React from 'react';

function App() {
  // 1. Element for the heading
  const element = "Office Space";

  // Using a placeholder office image since the hint's {sr} variable is undefined
  const imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80";

  // 2. Attribute/Element for the image
  const jsxatt = <img src={imageUrl} width="25%" height="25%" alt="Office Space" />;

  // 3 & 4. List of objects to loop through
  const officeList = [
    { id: 1, Name: "DBS", Rent: 50000, Address: 'Chennai' },
    { id: 2, Name: "Tech Park", Rent: 75000, Address: 'Bangalore' }
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h1>{element}, at Affordable Range</h1>

      {/* Render the image element */}
      {jsxatt}

      {/* Loop through the office space items */}
      {officeList.map((item) => (
        <div key={item.id} style={{ marginTop: '30px' }}>
          <h1>Name: {item.Name}</h1>

          {/* 5. Inline CSS: Red if rent <= 60000, Green otherwise */}
          <h3 style={{ color: item.Rent <= 60000 ? 'red' : 'green' }}>
            Rent: Rs. {item.Rent}
          </h3>

          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
