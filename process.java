 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class ProcessForm extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		String name = request.getParameter("fname");
		String address = request.getParameter("addr");
		String skills = request.getParameter("skills");
		String education = request.getParameter("edu");
		String experience = request.getParameter("exp");
		String projects = request.getParameter("projects");
		long number = request.getParameter("num");

	 	try{
	 		response.setContentType("application/pdf");

	 		Document doc = new Document();
	 		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 		PdfWriter.getInstance(doc, baos);
	 		doc.open();

	 		Paragraph title = new Paragraph("Resume");
	 		Paragraph fname = new Paragraph(fname);
	 		Paragraph addrr = new Paragraph(addr+ " "+ num);
	 		Paragraph head1 = new Paragraph("SKILLS");
	 		Paragraph skill = new Paragraph(skills);
	 		Paragraph head2 = new Paragraph("EDUCATION");
	 		Paragraph edu = new Paragraph(education);
	 		Paragraph head3 = new Paragraph("EXPERIENCE");
	 		Paragraph exp = new Paragraph(experience);
	 		Paragraph head4 = new Paragraph("PROJECTS");
	 		Paragraph proj = new Paragraph(projects);

	 		doc.add(title);
	 		doc.add(fname);
	 		doc.add(addrr);
	 		doc.add(skill);
	 		doc.add(edu);
	 		doc.add(exp);
	 		doc.add(proj);

	 		doc.close();

	 		ServletOutputStream out = response.getOutputStream();
	 		baos.writeTo(out);
	 		out.flush();

	 	}
	 	catch(Exception e){
	 		System.out.println(e.getMessage());
	 	}

	 } 
}
