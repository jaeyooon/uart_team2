/*
 * package com.multi.controller;
 * 
 * import java.util.Date;
 * 
 * import javax.inject.Inject; import javax.servlet.http.Cookie; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * com.multi.dto.AdminDTO; import com.multi.service.AdminService;
 * 
 * @Controller public class UserController {
 * 
 * @Inject // byType으로 자동 주입 AdminService service;
 * 
 * // 로그인 폼을 띄우는 부분
 * 
 * @RequestMapping(value="/login",method=RequestMethod.GET) public String
 * loginForm(){ return "login/loginForm"; // /login/loginForm.jsp를 띄움. }// end
 * of loginForm
 * 
 * // 로그인 처리하는 부분
 * 
 * @RequestMapping(value="/loginProcess",method=RequestMethod.POST) public
 * String loginProcess(HttpSession session,AdminDTO dto, HttpServletResponse
 * response, int amount){ String returnURL = ""; if (
 * session.getAttribute("login") != null ){ // 기존에 login이란 세션 값이 존재한다면
 * session.removeAttribute("login"); // 기존값을 제거해 준다. }
 * 
 * // 로그인이 성공하면 UserVO 객체를 반환함. AdminDTO vo = service.login(dto);
 * 
 * if ( vo != null ){ // 로그인 성공 session.setAttribute("login", vo); // 세션에
 * login인이란 이름으로 UserVO 객체를 저장해 놈. returnURL = "redirect:/board/listPage"; //
 * 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
 * 
 * 
 * [ 세션 추가되는 부분 ]
 * 
 * // 1. 로그인이 성공하면, 그 다음으로 로그인 폼에서 쿠키가 체크된 상태로 로그인 요청이 왔는지를 확인한다. if (
 * dto.isUseCookie() ){ // dto 클래스 안에 useCookie 항목에 폼에서 넘어온 쿠키사용 여부(true/false)가
 * 들어있을 것임 // 쿠키 사용한다는게 체크되어 있으면... // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에
 * 저장한다. Cookie cookie = new Cookie("loginCookie", session.getId()); // 쿠키를 찾을
 * 경로를 컨텍스트 경로로 변경해 주고... cookie.setPath("/"); cookie.setMaxAge(60*60*24*7); //
 * 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다. // 쿠키를 적용해 준다. response.addCookie(cookie);
 * 
 * // currentTimeMills()가 1/1000초 단위임으로 1000곱해서 더해야함 Date sessionLimit = new
 * Date(System.currentTimeMillis() + (1000*amount)); // 현재 세션 id와 유효시간을 사용자 테이블에
 * 저장한다. service.keepLogin(vo.getUserId(), session.getId(), sessionLimit); }
 * }else { // 로그인에 실패한 경우 returnURL = "redirect:/login"; // 로그인 폼으로 다시 가도록 함 }
 * 
 * return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴 }
 * 
 * // 로그아웃 하는 부분
 * 
 * @RequestMapping(value="/logout") public String logout(HttpSession session) {
 * session.invalidate(); // 세션 전체를 날려버림 // session.removeAttribute("login"); //
 * 하나씩 하려면 이렇게 해도 됨. return "redirect:/board/listPage"; // 로그아웃 후 게시글 목록으로
 * 이동하도록...함 } } // end of controller
 */