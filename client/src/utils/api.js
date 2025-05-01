const API_URL = 'https://api.example.com'; // Replace with your actual API URL

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
    
    // Handle 401 Unauthorized
    if (response.status === 401) {
      localStorage.removeItem('token');
      window.location.href = '/login';
      return null;
    }
    
    const data = await response.json();
    
    if (!response.ok) {
      throw new Error(data.message || 'Something went wrong');
    }
    
    return data;
  } catch (error) {
    console.error('API Error:', error);
    throw error;
  }
};

// API methods
export const api = {
  // Auth
  login: (credentials) => 
    fetchApi('/auth/login', { 
      method: 'POST', 
      body: JSON.stringify(credentials) 
    }),
  
  register: (userData) => 
    fetchApi('/auth/register', { 
      method: 'POST', 
      body: JSON.stringify(userData) 
    }),
  
  logout: () => 
    fetchApi('/auth/logout', { 
      method: 'POST' 
    }),
  
  // Users
  getCurrentUser: () => 
    fetchApi('/users/me'),
  
  getUserProfile: (username) => 
    fetchApi(`/users/${username}`),
  
  updateUserProfile: (userData) => 
    fetchApi('/users/me', { 
      method: 'PUT', 
      body: JSON.stringify(userData) 
    }),
  
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
    fetchApi(`/posts/${postId}/comments`),
  
  createComment: (postId, content) => 
    fetchApi(`/posts/${postId}/comments`, { 
      method: 'POST', 
      body: JSON.stringify({ content }) 
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
