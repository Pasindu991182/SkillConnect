<<<<<<< HEAD
<<<<<<< HEAD
const API_URL = 'http://localhost:8080/api'; // Replace with your actual API URL
=======
const API_URL = 'https://api.example.com'; // Replace with your actual API URL
>>>>>>> origin/Member02
=======
const API_URL = 'https://api.example.com'; // Replace with your actual API URL
>>>>>>> origin/Member04

// Helper function for making API requests
const fetchApi = async (endpoint, options = {}) => {
  const headers = {
    'Content-Type': 'application/json',
    ...options.headers,
  };

  // Add auth token if available
  const token = localStorage.getItem('token');
  if (token) {
    headers.Authorization = `Bearer ${token}`;
  }

  const config = {
    ...options,
    headers,
  };

  try {
    const response = await fetch(`${API_URL}${endpoint}`, config);
<<<<<<< HEAD
<<<<<<< HEAD
    console.log('API Request:', { endpoint, options });
    console.log('API Response:', response);

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
    // Handle 401 Unauthorized
    if (response.status === 401) {
      localStorage.removeItem('token');
      window.location.href = '/login';
      return null;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    // Check if the response has content before trying to parse JSON
    const contentType = response.headers.get('content-type');
    if (contentType && contentType.includes('application/json')) {
      // Only try to parse JSON if there's content and it's JSON type
      const text = await response.text();
      const data = text ? JSON.parse(text) : {};
      
      if (!response.ok) {
        throw new Error(data.message || 'Something went wrong');
      }
      
      return data;
    } else {
      // Handle non-JSON responses
      if (!response.ok) {
        throw new Error('Something went wrong');
      }
      
      return { success: true };
    }
=======
=======
>>>>>>> origin/Member04
    const data = await response.json();
    
    if (!response.ok) {
      throw new Error(data.message || 'Something went wrong');
    }
    
    return data;
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
  } catch (error) {
    console.error('API Error:', error);
    throw error;
  }
};

// API methods
export const api = {
  // Auth
  login: (credentials) => 
<<<<<<< HEAD
<<<<<<< HEAD
    fetchApi('/users/login', { 
=======
    fetchApi('/auth/login', { 
>>>>>>> origin/Member02
=======
    fetchApi('/auth/login', { 
>>>>>>> origin/Member04
      method: 'POST', 
      body: JSON.stringify(credentials) 
    }),
  
  register: (userData) => 
<<<<<<< HEAD
<<<<<<< HEAD
    fetchApi('/users/register', { 
=======
    fetchApi('/auth/register', { 
>>>>>>> origin/Member02
=======
    fetchApi('/auth/register', { 
>>>>>>> origin/Member04
      method: 'POST', 
      body: JSON.stringify(userData) 
    }),
  
  logout: () => 
    fetchApi('/auth/logout', { 
      method: 'POST' 
    }),
  
  // Users
<<<<<<< HEAD
<<<<<<< HEAD
  getCurrentUser: (email) => 
    fetchApi(`/users/email/${email}`),
=======
  getCurrentUser: () => 
    fetchApi('/users/me'),
>>>>>>> origin/Member02
=======
  getCurrentUser: () => 
    fetchApi('/users/me'),
>>>>>>> origin/Member04
  
  getUserProfile: (username) => 
    fetchApi(`/users/${username}`),
  
<<<<<<< HEAD
<<<<<<< HEAD
 // Update this method in your api.js file
  updateUserProfile: (userData) => 
    fetchApi(`/users/${userData.userId}/update`, { 
      method: 'PUT', 
      body: JSON.stringify(userData) 
    }),

=======
=======
>>>>>>> origin/Member04
  updateUserProfile: (userData) => 
    fetchApi('/users/me', { 
      method: 'PUT', 
      body: JSON.stringify(userData) 
    }),
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
  
  followUser: (userId) => 
    fetchApi(`/users/${userId}/follow`, { 
      method: 'POST' 
    }),
  
  unfollowUser: (userId) => 
    fetchApi(`/users/${userId}/unfollow`, { 
      method: 'POST' 
    }),
  
  // Posts
  getPosts: (page = 1, limit = 10) => 
    fetchApi(`/posts?page=${page}&limit=${limit}`),
  
  getPostById: (postId) => 
    fetchApi(`/posts/${postId}`),
  
  createPost: (postData) => 
    fetchApi('/posts', { 
      method: 'POST', 
      body: JSON.stringify(postData) 
    }),
<<<<<<< HEAD
<<<<<<< HEAD

  // Add this method to your api.js file
  getUserPosts: (userId) => 
    fetchApi(`/posts/user/${userId}`),

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
  
  updatePost: (postId, postData) => 
    fetchApi(`/posts/${postId}`, { 
      method: 'PUT', 
      body: JSON.stringify(postData) 
    }),
  
  deletePost: (postId) => 
    fetchApi(`/posts/${postId}`, { 
      method: 'DELETE' 
    }),
  
  likePost: (postId) => 
    fetchApi(`/posts/${postId}/like`, { 
      method: 'POST' 
    }),
  
  unlikePost: (postId) => 
    fetchApi(`/posts/${postId}/unlike`, { 
      method: 'POST' 
    }),
  
  // Comments
  getComments: (postId) => 
<<<<<<< HEAD
<<<<<<< HEAD
    fetchApi(`/comments/post/${postId}`),

  createComment: (commentData) => 
    fetchApi('/comments', { 
      method: 'POST', 
      body: JSON.stringify({
        content: commentData.content,
        user: { userId: commentData.user.userId },
        post: { postId: commentData.post.postId }
      }) 
    }),
  

  updateComment: (commentData) => 
    fetchApi('/comments', { 
      method: 'PUT', 
      body: JSON.stringify(commentData) 
    }),

  deleteComment: (commentId) => 
    fetchApi(`/comments/${commentId}`, { 
      method: 'DELETE' 
    }),

  // Likes
  getLikes: (postId) => 
    fetchApi(`/likes/${postId}`),

  likePost: (postId, userId) => 
    fetchApi(`/likes/${postId}/user/${userId}`, { 
      method: 'POST' 
    }),

  unlikePost: (postId, userId) => 
    fetchApi(`/likes/${postId}/user/${userId}`, { 
      method: 'DELETE' 
=======
=======
>>>>>>> origin/Member04
    fetchApi(`/posts/${postId}/comments`),
  
  createComment: (postId, content) => 
    fetchApi(`/posts/${postId}/comments`, { 
      method: 'POST', 
      body: JSON.stringify({ content }) 
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    }),
  
  // Learning Plans
  getLearningPlans: () => 
    fetchApi('/learning-plans'),
  
  getLearningPlanById: (planId) => 
    fetchApi(`/learning-plans/${planId}`),
  
  createLearningPlan: (planData) => 
    fetchApi('/learning-plans', { 
      method: 'POST', 
      body: JSON.stringify(planData) 
    }),
  
  updateLearningPlan: (planId, planData) => 
    fetchApi(`/learning-plans/${planId}`, { 
      method: 'PUT', 
      body: JSON.stringify(planData) 
    }),
  
  // Progress
  getProgress: () => 
    fetchApi('/progress'),
  
  updateProgress: (progressData) => 
    fetchApi('/progress', { 
      method: 'PUT', 
      body: JSON.stringify(progressData) 
    }),
  
  // Notifications
  getNotifications: () => 
    fetchApi('/notifications'),
  
  markNotificationAsRead: (notificationId) => 
    fetchApi(`/notifications/${notificationId}/read`, { 
      method: 'PUT' 
    }),
  
  // Admin
  getUsers: (page = 1, limit = 10) => 
    fetchApi(`/admin/users?page=${page}&limit=${limit}`),
  
  updateUserRole: (userId, role) => 
    fetchApi(`/admin/users/${userId}/role`, { 
      method: 'PUT', 
      body: JSON.stringify({ role }) 
    }),
  
  sendBroadcast: (message) => 
    fetchApi('/admin/broadcast', { 
      method: 'POST', 
      body: JSON.stringify({ message }) 
    }),
};

export default api;
