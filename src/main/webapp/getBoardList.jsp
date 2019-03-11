<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.springbook.biz.impl.BoardDAO" %>
<%@ page import = "com.springbook.biz.board.BoardVO" %>
<%@ page import ="java.util.*" %>    


<%
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
</head>
<body>
<h1>글 목록</h1>
</body>
</html>