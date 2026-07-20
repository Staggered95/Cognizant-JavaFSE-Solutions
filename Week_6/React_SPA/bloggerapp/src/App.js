import React from 'react';
import './App.css';

// 1. Course Details Component (Conditional Rendering using if/else)
const CourseDetails = ({ courses }) => {
  if (!courses || courses.length === 0) {
    return <div className="mystyle1">No courses available.</div>;
  }

  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {courses.map(course => (
        <div key={course.id}>
          <h2>{course.cname}</h2>
          <p><b>{course.date}</b></p>
        </div>
      ))}
    </div>
  );
};

// 2. Book Details Component (Conditional Rendering using && operator)
const BookDetails = (props) => {
  // Variable holding the mapped JSX, matching the provided hint
  const bookdet = (
    <ul>
      {props.books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  return (
    <div className="st2">
      <h1>Book Details</h1>
      {/* Renders bookdet only if the array has items */}
      {props.books.length > 0 && bookdet}
    </div>
  );
};

// 3. Blog Details Component (Conditional Rendering using Ternary operator)
const BlogDetails = ({ blogs }) => {
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {/* If blogs exist, render them, otherwise render a loading message */}
      {blogs ? (
        blogs.map(blog => (
          <div key={blog.id}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.content}</p>
          </div>
        ))
      ) : (
        <p>Loading blogs...</p>
      )}
    </div>
  );
};

// --- Main App Component ---
function App() {
  // Data from the assignment hints
  const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 },
  ];

  // Recreated mock data from the screenshot
  const courses = [
    { id: 1, cname: 'Angular', date: '4/5/2021' },
    { id: 2, cname: 'React', date: '6/3/20201' }
  ];

  const blogs = [
    { id: 1, title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
    { id: 2, title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' }
  ];

  return (
    <div className="container">
      <CourseDetails courses={courses} />
      <BookDetails books={books} />
      <BlogDetails blogs={blogs} />
    </div>
  );
}

export default App;
