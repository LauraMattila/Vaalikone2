package rest;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class UploadService {
	@POST
	@Path("/fileupload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData, @Context ServletContext sc) 
            		throws Exception
	{
		String UPLOAD_PATH=sc.getRealPath("/");
	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + "../images/"+fileMetaData.getFileName()));
	        while ((read = fileInputStream.read(bytes)) != -1) 
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	        
	    } 
	    catch (IOException e){
	        throw new WebApplicationException("Error while uploading file. Please try again !!");
	    }
	    return Response.ok("Data uploaded successfully !!").build();
	}
}