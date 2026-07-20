import React from 'react';
// Import the CSS Module
import styles from './CohortDetails.module.css';

const CohortDetails = () => {
  // Recreated mock data based on the assignment image
  const cohorts = [
    { id: 1, name: 'INTADMDF10 -.NET FSD', start: '22-Feb-2022', status: 'Scheduled', coach: 'Aathma', trainer: 'Jojo Jose' },
    { id: 2, name: 'ADM21JF014 -Java FSD', start: '10-Sep-2021', status: 'Ongoing', coach: 'Apoorv', trainer: 'Elisa Smith' },
    { id: 3, name: 'CDBJF21025 -Java FSD', start: '24-Dec-2021', status: 'Ongoing', coach: 'Aathma', trainer: 'John Doe' }
  ];

  return (
    <div>
      <h2>Cohorts Details</h2>
      {cohorts.map(cohort => (
        /* Apply the box class to the container div */
        <div key={cohort.id} className={styles.box}>
          {/* Inline style for the h3 element based on cohort status */}
          <h3 style={{ color: cohort.status.toLowerCase() === 'ongoing' ? 'green' : 'blue' }}>
            {cohort.name}
          </h3>
          <dl>
            <dt>Started On</dt>
            <dd>{cohort.start}</dd>
            <dt>Current Status</dt>
            <dd>{cohort.status}</dd>
            <dt>Coach</dt>
            <dd>{cohort.coach}</dd>
            <dt>Trainer</dt>
            <dd>{cohort.trainer}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
};

export default CohortDetails;
