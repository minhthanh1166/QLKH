package BUS;
import com.qlkhachhang.Models.KhachHang;
import DAL.connect;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qlkhachhang.Models.KhachHang;

    @WebServlet("/")
    public class KhachHangController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private com.qlkhachhang.DAO.KhachHangDAO khDAO;
        public void init() {
            khDAO = new com.qlkhachhang.DAO.KhachHangDAO();
        }
        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)

                throws ServletException, IOException {
            doGet(request, response);
            request.setCharacterEncoding("UTF-8");
        }
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response)

                throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            try {
                String action = request.getServletPath();
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        insertKhachHang(request, response);
                        break;
                    case "/delete":
                        deleteKhachHang(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/update":
                        updateKhachHang(request, response);
                        break;
                    default:
                        listKhachHang(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
        private void listKhachHang(HttpServletRequest request,
                                   HttpServletResponse response)

                throws ServletException, IOException {
// TODO Auto-generated method stub
            List<KhachHang> listKH = khDAO.selectAllKhachHang();
            request.setAttribute("listKH", listKH);
            RequestDispatcher dispatcher =

                    request.getRequestDispatcher("khachhang-list.jsp");
            dispatcher.forward(request, response);
        }
        private void updateKhachHang(HttpServletRequest request,
                                     HttpServletResponse response)

                throws SQLException, IOException {
// TODO Auto-generated method stub
            int id = Integer.parseInt(request.getParameter("id"));
            String tenkhachhang = request.getParameter("tenkhachhang");
            String ngaysinh = request.getParameter("ngaysinh");
            String cmnd = request.getParameter("cmnd");
            String quequan = request.getParameter("quequan");
            String email = request.getParameter("email");
            String sdt = request.getParameter("sdt");
            KhachHang kh = new KhachHang(id, tenkhachhang, ngaysinh, cmnd, quequan, email, sdt);

            khDAO.updateKhachHang(kh);
            response.sendRedirect("list");
        }
        private void showEditForm(HttpServletRequest request,
                                  HttpServletResponse response)

                throws ServletException, IOException {
// TODO Auto-generated method stub
            int id = Integer.parseInt(request.getParameter("id"));
            KhachHang existingKhachhang = khDAO.selectKhachHang(id);
            RequestDispatcher dispatcher =

                    request.getRequestDispatcher("khachhang-form.jsp");
            request.setAttribute("kh", existingKhachhang);
            dispatcher.forward(request, response);
        }
        private void deleteKhachHang(HttpServletRequest request,
                                     HttpServletResponse response)

                throws IOException, SQLException {
// TODO Auto-generated method stub
            int id = Integer.parseInt(request.getParameter("id"));
            khDAO.deleteKhachHang(id);
            response.sendRedirect("list");
        }
        private void insertKhachHang(HttpServletRequest request,
                                     HttpServletResponse response)

                throws SQLException, IOException {
// TODO Auto-generated method stub
            String tenkhachhang = request.getParameter("tenkhachhang");
            String ngaysinh = request.getParameter("ngaysinh");
            String cmnd = request.getParameter("cmnd");
            String quequan = request.getParameter("quequan");
            String email = request.getParameter("email");
            String sdt = request.getParameter("sdt");
            KhachHang kh = new KhachHang(tenkhachhang, ngaysinh, cmnd, quequan, email, sdt);

            khDAO.insertKhachHang(kh);
            response.sendRedirect("list");
        }
        private void showNewForm(HttpServletRequest request,
                                 HttpServletResponse response)

                throws ServletException, IOException {
// TODO Auto-generated method stub
            RequestDispatcher dispatcher =

                    request.getRequestDispatcher("khachhang-form.jsp");
            dispatcher.forward(request, response);
        }
    }

