//this app need not to be web app to talk with producer app that is in another location (Another workspace)
/*OUTPUT=>
 *       Status code :: 200
 *       Status Info :: OK
 *       Entity :: WELCOME TO FIRST JERSEY APPLICATION
 *       Some Exception will be come due to some jaxb issue but ignore that as a first app*/

package com.nt.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ClientTest {
	private static final String URI="http://localhost:8383/JerseyFirstApp/";  //uri is fixed so better to take it as a constant
	private static String path="rest/employee/msg";  //there is a chance to change the path at runtime time to time so better not to take final

	public static void main(String[] args) {
		try {
			//1. create one client object
			Client client=ClientBuilder.newClient();
			//2. add uri and path to create web target (means the location details of the producer app)
			WebTarget target=client.target(URI).path(path);
			//3. convert to request builder object
			Builder builder=target.request();
			//4. provide header,body .....etc as per our current app nothing required to pass we will see it later
			
			//5. Execute request with type(GET,POST,PUT .....etc) and read the Response as the get() returning Response
			Response res=builder.get();
			
			//6. Read response or print details
			System.out.println("Status code :: "+res.getStatus());
			System.out.println("Status Info :: "+res.getStatusInfo());
			System.out.println("Entity :: "+res.readEntity(String.class));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
