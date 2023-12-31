package address.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import address.domain.AddressBookVO;
import address.model.AddressDAO;
import address.model.AddressDAO_imple;
import common.controller.AbstractController;
 
/*
 * 작성자 윤예인
 * 계정설정-주소록 Controller
 */
public class AddressBookEditViewAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		String method=req.getMethod(); //"GET" 또는 "POST"
		if("POST".equalsIgnoreCase(method)) {
			
			
			String addressbookid =req.getParameter("addressbookid");
			 
			
			AddressDAO dao= new AddressDAO_imple();
			
			AddressBookVO editAvo= dao.selectEditAddrView(addressbookid);
			 
			
			if(editAvo != null ) {
				
				
				req.setAttribute("editAvo", editAvo);
				
				
				
				super.setRedirect(false);
				super.setViewPage("/jsp/member/addressBook/EditAddressBook.jsp");
				 
			
			}
			
		}
		else {
			//POST 방식이 아니라면
			
			String message = "비정상적인 경로로 들어왔습니다.";
		      String loc = "javascript:history.back()";
		      
		      req.setAttribute("message", message);
		      req.setAttribute("loc", loc);
		      
		   //   super.setRedirect(false);
		      super.setViewPage("/jsp/common/msg.jsp");
	    }
		
	}

}
