const API_URL = 'http://localhost:8080/api'; // Replace with your actual API URL

// Helper function for making API requests
const fetchApi = async (endpoint, options = {}) => {
  const headers = {
    'Content-Type': 'application/json',
    ...options.headers,
  };

  // Add auth token if available
  const token = localStorage.getItem('token');
  console.log('Token:', token);
  if (token) {
    headers.Authorization = `Bearer ${token}`;
  }

  const config = {
    ...options,
    headers,
  };

  try {
    const response = await fetch(`${API_URL}${endpoint}`, config);
    // console.log('API Request:', { endpoint, options });
    // console.log('API Response:', response);

    // Handle 401 Unauthorized
    if (response.status === 401) {
      localStorage.removeItem('token');
      window.location.href = '/login';
      return null;
    }
    
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
  } catch (error) {
    console.error('API Error:', error);
    throw error;
  }
};

// API methods
export const api = {
  // Auth
  login: (credentials) => 
    fetchApi('/users/login', { 
      method: 'POST', 
      body: JSON.stringify(credentials) 
    }),
  
  register: (userData) => 
    fetchApi('/users/register', { 
      method: 'POST', 
      body: JSON.stringify(userData) 
    }),
  
  logout: () => 
    fetchApi('/auth/logout', { 
      method: 'POST' 
    }),
  
  // Users
  getCurrentUser: (email) => 
    fetchApi(`/users/email/${email}`),
  
  getUserProfile: (username) => 
    fetchApi(`/users/${username}`),
  
 // Update this method in your api.js file
  updateUserProfile: (userData) => 
    fetchApi(`/users/${userData.userId}/update`, { 
      method: 'PUT', 
      body: JSON.stringify(userData) 
    }),

  searchUsers: (query) => 
    fetchApi(`/users/search/${encodeURIComponent(query)}`),

  // Add this to the api object in api.js
  getUserById: (userId) => 
    fetchApi(`/users/${userId}`),


  
  // Followers/Following
  getFollowerCount: (userId) =>
    fetchApi(`/follow/${userId}/followers/count`),
  
  getFollowingCount: (userId) =>
    fetchApi(`/follow/${userId}/following/count`),
  
  followUser: (followerId, userId) =>
    fetchApi(`/follow`, {
      method: 'POST',
      body: JSON.stringify({
        follower: { userId: followerId },
        user: { userId: userId }
      })
    }),
  
  unfollowUser: (followerId, userId) =>
    fetchApi(`/follow`, {
      method: 'DELETE',
      body: JSON.stringify({
        follower: { userId: followerId },
        user: { userId: userId }
      })
    }),
  
  isFollowing: (followerId, userId) =>
    fetchApi(`/follow/check?followerId=${followerId}&followingId=${userId}`),
  
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

  // Add this method to your api.js file
  getUserPosts: (userId) => 
    fetchApi(`/posts/user/${userId}`),

  
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

  // Add this to the api object in api.js
  loadFeed: (userId) => 
    fetchApi(`/posts/loadfeed/${userId}`),

  
  // Comments
  getComments: (postId) => 
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
    }),
  
  // Learning Plans
  getLearningPlans: (userId) => 
    fetchApi(`/learning-plans/user/${userId}`),

  getLearningPlanById: (planId) => 
    fetchApi(`/learning-plans/${planId}`),

  createLearningPlan: (planData) => 
    fetchApi('/learning-plans', { 
      method: 'POST', 
      body: JSON.stringify(planData) 
    }),

  updateLearningPlan: (planId, planData) => 
    fetchApi(`/learning-plans`, { 
      method: 'PUT', 
      body: JSON.stringify(planData) 
    }),

  deleteLearningPlan: (planId) => 
    fetchApi(`/learning-plans/${planId}`, { 
      method: 'DELETE' 
    }),

  // Learning Plan Items
  getLearningPlanItems: (planId) => 
    fetchApi(`/learning-plan-items/plan/${planId}`),

  createLearningPlanItem: (itemData) => 
    fetchApi('/learning-plan-items', { 
      method: 'POST', 
      body: JSON.stringify(itemData) 
    }),

  updateLearningPlanItem: (itemData) => 
    fetchApi('/learning-plan-items', { 
      method: 'PUT', 
      body: JSON.stringify(itemData) 
    }),

  deleteLearningPlanItem: (itemId) => 
    fetchApi(`/learning-plan-items/${itemId}`, { 
      method: 'DELETE' 
    }),

  markItemAsCompleted: (itemId) => 
    fetchApi(`/learning-plan-items/${itemId}/complete`, { 
      method: 'PUT' 
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
