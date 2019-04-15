package mobile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/mobileService")
public class mobileService {

	mobilrDao mDao = new mobilrDao();
	private static final String SUCCESS_RESULT = "<result>Done Sucessfully !</result>";
	private static final String FAILURE_RESULT = "<result>Error !</result>";

	@GET
	@Path("/mob")
	@Produces(MediaType.APPLICATION_XML)
	public List<mobileModel> getMobile() throws ClassNotFoundException, SQLException {
		return mDao.getAllItems();
	}

	@GET
	@Path("/mob/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public mobileModel getMobile(@PathParam("id") int userid) throws ClassNotFoundException, SQLException {
		return mDao.getMobiles(userid);
	}
	
	@DELETE
	@Path("/mob/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("id") int userid) throws ClassNotFoundException, SQLException {
		int result = mDao.deleteMobile(userid);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@POST
	@Path("/mob")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createMobile(@FormParam("id") int id, @FormParam("name") String name, @FormParam("price") int price,
			@FormParam("description") String description, @Context HttpServletResponse servletResponse)
			throws ClassNotFoundException, SQLException {
		mobileModel mm = new mobileModel(id, name, price, description);
		int result = mDao.addMobile(mm);
		if (result > 0) {
			return "Success";
		} else {
			return "FAILED";
		}
	}

	@PUT
	@Path("/mob")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("price") int price,
			@FormParam("description") String description, @Context HttpServletResponse servletResponse)
			throws IOException, ClassNotFoundException, SQLException {
		mobileModel mm = new mobileModel(id, name, price, description);
		int result = mDao.updateMobiles(mm);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}



}