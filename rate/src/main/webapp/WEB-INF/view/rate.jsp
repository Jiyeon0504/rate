<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일시</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="post" items="${rate}">
            <tr>
              <td>${post.result}</td>
              <td>${post.cur_unit}</td>
              <td>${post.cur_nm}</td>
              <td>${post.ten_dd_efee_r}</td>
              <td>${post.kftc_bkpr}
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
</body>
</html>