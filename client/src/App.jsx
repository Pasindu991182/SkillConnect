import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Home from "./pages/Home";
import AdminDashboard from "./pages/Admin";
import Navbar from "./components/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import { ToastProvider } from "./components/ToastProvider";


const App = () => {
    return (
        <ThemeProvider>
      <AuthProvider>
      
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Register />} />
          <Route path="/home" element={<Home />} />
          
          <Route path="/notifications" element={<Notifications />} />
          <Route path="/admin" element={<Admin />} />
          
        </Routes>
       
      </AuthProvider>
    </ThemeProvider>
    );
};

export default App;
