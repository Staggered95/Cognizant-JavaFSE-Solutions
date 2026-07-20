import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    // Initialize the component with a list of Post in state
    this.state = {
      posts: []
    };
  }

  // Method to fetch data from the provided URL
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        // Convert raw JSON into the Post class objects
        const postObjects = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: postObjects });
      })
      .catch(error => {
        // If the fetch fails, throw it so componentDidCatch can intercept it
        throw error;
      });
  }

  // Hook to call the fetch method when the component loads
  componentDidMount() {
    this.loadPosts();
  }

  // Hook to display alert messages if an error occurs in the component
  componentDidCatch(error, info) {
    alert("An error occurred while loading posts: " + error.message);
  }

  // Method to display the title and post in HTML using headings and paragraphs
  render() {
    return (
      <div>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: '1px solid #ccc', padding: '10px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
