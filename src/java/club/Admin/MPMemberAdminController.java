package club.Admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MPMemberAdminController", urlPatterns = {"/MPMemberAdmin"})
public class MPMemberAdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MPMemberAdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MPMemberAdminController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("displayMembers")) {
            List<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
            getServletContext().getRequestDispatcher("/MPDisplayMembers.jsp").forward(request, response);
        } else if (action.equals("addMember")) {
            getServletContext().getRequestDispatcher("/MPAddMember.jsp").forward(request, response);
        } else if (action.equals("editMember")) {
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            request.setAttribute("member", member);
            getServletContext().getRequestDispatcher("/MPEditMember.jsp").forward(request, response);
        } else if (action.equals("removeMember")) {
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            request.setAttribute("member", member);
            getServletContext().getRequestDispatcher("/MPRemoveMember.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("saveMember")) {
            String url = saveMember(request, response);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("deleteMember")) {
            Member member = MemberDB.selectMember(request.getParameter("email"));
            MemberDB.delete(member);
            response.sendRedirect("MPMemberAdmin?action=displayMembers");
        }
    }

    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String programName = request.getParameter("programName");
        int yearLevel = Integer.parseInt(request.getParameter("yearLevel"));

        Member member = new Member(fullName, email);

        member.setPhoneNumber(phoneNumber);
        member.setYearLevel(yearLevel);
        member.setProgramName(programName);

        if (!member.isValid()) {
            request.setAttribute("message", "Cannot insert a new record. Please provide a valid name/or email!");

            if (MemberDB.emailExists(email)) {
                request.setAttribute("member", member);
                return "/MPEditMember.jsp";
            }

            return "/MPAddMember.jsp";
        } else if (member.getPhoneNumber() == null || member.getPhoneNumber() == "") {
            request.setAttribute("message", "Cannot insert a new record. Please provide a Phone number!");

            if (MemberDB.emailExists(email)) {
                request.setAttribute("member", member);
                return "/MPEditMember.jsp";
            }

            return "/MPAddMember.jsp";
        }

        if (MemberDB.emailExists(email)) {
            MemberDB.update(member);
        } else {
            MemberDB.insert(member);
        }
        List<Member> members = MemberDB.selectMembers();
        request.setAttribute("members", members);
        return "/MPDisplayMembers.jsp";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
